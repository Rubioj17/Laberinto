import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    //Remplazar por estos ^ v > < * y ejecutarlo en cmd
    static final char DIRECTION_TOP = 'ᗋ';//^ ᗋ
    static final char DIRECTION_BOT = 'ᗊ';//v ᗊ
    static final char DIRECTION_RIGHT = 'ᗌ';//> ᗌ
    static final char DIRECTION_LEFT = 'ᗏ';//< ᗏ

    static final char ESPACIO_LIBRE = '◦'; //◦ *
    static final char ESPACIO_NIEBLA = '░';
    static final char ESPACIO_BLOQUEADO = '█';

    public static void main(String[] args) {

        MapsLaberintos laberintoMap = new MapsLaberintos();
        int cantidadTotalMapas = laberintoMap.getLaberintoSize();
        int numLaberinto = 0;

        mensajeBienvenida();

        while (numLaberinto <= cantidadTotalMapas - 1) {
            startMap(laberintoMap, numLaberinto);
            numLaberinto++;
        }
    }

    public static void startMap(MapsLaberintos laberintoMap, int numLaberinto) {
        Character[][] laberinto = laberintoMap.getLaberinto(numLaberinto);
        int endRowLocation = getEndRowLocation(laberinto);
        int endColLocation = getColEndLocation(laberinto);
        int personajeRowLocation = getPersonajeRowLocation(laberinto);
        int personajeColLocation = getPersonajeColLocation(laberinto);
        int contadorMovimientos = 0;

        mensajeLaberintoActual(laberinto, numLaberinto);
        if (checkMap(laberinto) == false) {
            System.exit(0);
        }

        while (personajeRowLocation != endRowLocation || personajeColLocation != endColLocation){
            personajeRowLocation = getPersonajeRowLocation(laberinto);
            personajeColLocation = getPersonajeColLocation(laberinto);
            dibujarMapa(laberinto);
            laberinto = moverPersonaje(laberinto, endRowLocation, endColLocation);
            contadorMovimientos++;
            pausa();
        }
        System.out.println("Laberinto Superado en " + contadorMovimientos + " Pasos");
    }
    //Recorre la Matriz y la dibuja
    public static void dibujarMapa(Character[][] laberinto) {
        for (int row = 0; row < laberinto.length; row++){
            for (int col = 0; col < laberinto[row].length; col++) {
                System.out.print(laberinto[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
    //Dependiendo de la direccion en la que se dirige hace el cambio en la matriz
    public static Character[][] moverPersonaje(Character[][] laberinto, int endRowLocation, int endColLocation) {
        checkAroundEnd(laberinto);
        int personajeRow = getPersonajeRowLocation(laberinto);
        int personajeCol = getPersonajeColLocation(laberinto);

        if (personajeRow != endRowLocation || personajeCol != endColLocation){
            char nextPosition = nextDirection(laberinto, personajeRow, personajeCol);
            if(nextPosition == DIRECTION_RIGHT){
                laberinto = moveRight(laberinto, personajeRow, personajeCol);
            }else if (nextPosition == DIRECTION_BOT){
                laberinto = moveBot(laberinto, personajeRow, personajeCol);
            }else if (nextPosition == DIRECTION_LEFT) {
                laberinto = moveLeft(laberinto,personajeRow, personajeCol);
            }else {
                laberinto = moveTop(laberinto,personajeRow, personajeCol);
            }
        }
        return laberinto;
    }
    //Cambia el icono de la posicion actual y nueva de la Matriz
    public static Character[][] moveRight(Character[][] laberinto, int personajeRow, int personajeCol) {
        laberinto[personajeRow][personajeCol] = ESPACIO_LIBRE;
        laberinto[personajeRow][personajeCol+1] = DIRECTION_RIGHT;
        return laberinto;
    }
    //Cambia el icono de la posicion actual y nueva de la Matriz
    public static Character[][] moveLeft(Character[][] laberinto, int personajeRow, int personajeCol) {
        laberinto[personajeRow][personajeCol] = ESPACIO_LIBRE;
        laberinto[personajeRow][personajeCol-1] = DIRECTION_LEFT;
        return laberinto;
    }
    //Cambia el icono de la posicion actual y nueva de la Matriz
    public static Character[][] moveBot(Character[][] laberinto, int personajeRow, int personajeCol) {
        laberinto[personajeRow][personajeCol] = ESPACIO_LIBRE;
        laberinto[personajeRow+1][personajeCol] = DIRECTION_BOT;
        return laberinto;
    }
    //Cambia el icono de la posicion actual y nueva de la Matriz
    public static Character[][] moveTop(Character[][] laberinto, int personajeRow, int personajeCol) {
        laberinto[personajeRow][personajeCol] = ESPACIO_LIBRE;
        laberinto[personajeRow-1][personajeCol] = DIRECTION_TOP;
        return laberinto;
    }
    //Comprueba si es la primera vez y tambien hacia donde se dirige
    public static char nextDirection(Character[][] laberinto, int personajeRow, int personajeCol) {
        char nextDirection;
        char directionPersonaje = laberinto[personajeRow][personajeCol];
        if (directionPersonaje == 'P') {
            directionPersonaje = directionInitial(laberinto, personajeRow, personajeCol);
        }

        if (directionPersonaje == DIRECTION_RIGHT) {
            nextDirection = nextDirectionRight(laberinto, personajeRow, personajeCol);
        }else if (directionPersonaje == DIRECTION_BOT) {
            nextDirection = nextDirectionBot(laberinto, personajeRow, personajeCol);
        }else if (directionPersonaje == DIRECTION_LEFT) {
            nextDirection = nextDirectionLeft(laberinto, personajeRow, personajeCol);
        }else {
            nextDirection = nextDirectionTop(laberinto, personajeRow, personajeCol);
        }
        return nextDirection;
    }
    //Dependiendo de la posicion en donde este es que se movera
    public static char directionInitial(Character[][] laberinto, int personajeRow, int personajeCol) {
        char directionInitial;
        if (personajeCol == 0) {
            directionInitial = DIRECTION_RIGHT;
        }else if (personajeCol == laberinto[0].length-1) {
            directionInitial = DIRECTION_LEFT;
        }else if (personajeRow == 0) {
            directionInitial = DIRECTION_BOT;
        }else {
            directionInitial = DIRECTION_TOP;
        }
        return directionInitial;
    }
    //Comprueba si hay espacio libre para moverse en esta direccion
    public static char nextDirectionRight(Character[][] laberinto, int personajeRow, int personajeCol) {
        char nextDirection;
        if (! isBorderBot(laberinto, personajeRow)) {
            if (laberinto[personajeRow+1][personajeCol] == ESPACIO_NIEBLA || laberinto[personajeRow+1][personajeCol] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_BOT;
                return nextDirection;
            }
        }
        if (! isBorderRight(laberinto, personajeCol)) {
            if (laberinto[personajeRow][personajeCol+1] == ESPACIO_NIEBLA || laberinto[personajeRow][personajeCol+1] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_RIGHT;
                return nextDirection;
            }
        }
        if (! isBorderTop(personajeRow)) {
            if (laberinto[personajeRow-1][personajeCol] == ESPACIO_NIEBLA || laberinto[personajeRow-1][personajeCol] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_TOP;
                return nextDirection;
            }
        }
        nextDirection = DIRECTION_LEFT;
        return nextDirection;
    }
    //Comprueba si hay espacio libre para moverse en esta direccion
    public static char nextDirectionBot(Character[][] laberinto, int personajeRow, int personajeCol) {
        char nextDirection;
        if (! isBorderLeft(personajeCol)) {
            if (laberinto[personajeRow][personajeCol - 1] == ESPACIO_NIEBLA || laberinto[personajeRow][personajeCol - 1] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_LEFT;
                return nextDirection;
            }
        }
        if (! isBorderBot(laberinto, personajeRow)) {
            if (laberinto[personajeRow+1][personajeCol] == ESPACIO_NIEBLA || laberinto[personajeRow+1][personajeCol] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_BOT;
                return nextDirection;
            }
        }
        if (! isBorderRight(laberinto, personajeCol)) {
            if (laberinto[personajeRow][personajeCol+1] == ESPACIO_NIEBLA || laberinto[personajeRow][personajeCol+1] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_RIGHT;
                return nextDirection;
            }
        }
        nextDirection = DIRECTION_TOP;
        return nextDirection;
    }
    //Comprueba si hay espacio libre para moverse en esta direccion
    public static char nextDirectionLeft(Character[][] laberinto, int personajeRow, int personajeCol) {
        char nextDirection;
        if (! isBorderTop(personajeRow)) {
            if (laberinto[personajeRow-1][personajeCol] == ESPACIO_NIEBLA || laberinto[personajeRow-1][personajeCol] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_TOP;
                return nextDirection;
            }
        }
        if (! isBorderLeft(personajeCol)) {
            if (laberinto[personajeRow][personajeCol-1] == ESPACIO_NIEBLA || laberinto[personajeRow][personajeCol-1] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_LEFT;
                return nextDirection;
            }
        }
        if (! isBorderBot(laberinto, personajeRow)) {
            if (laberinto[personajeRow+1][personajeCol] == ESPACIO_NIEBLA || laberinto[personajeRow+1][personajeCol] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_BOT;
                return nextDirection;
            }
        }
        nextDirection = DIRECTION_RIGHT;
        return nextDirection;
    }
    //Comprueba si hay espacio libre para moverse en esta direccion
    public static char nextDirectionTop(Character[][] laberinto, int personajeRow, int personajeCol) {
        char nextDirection;
        if (! isBorderRight(laberinto, personajeCol)){
            if (laberinto[personajeRow][personajeCol+1] == ESPACIO_NIEBLA || laberinto[personajeRow][personajeCol+1] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_RIGHT;
                return nextDirection;
            }
        }
        if (! isBorderTop(personajeRow)) {
            if (laberinto[personajeRow-1][personajeCol] == ESPACIO_NIEBLA || laberinto[personajeRow-1][personajeCol] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_TOP;
                return nextDirection;
            }
        }
        if (! isBorderLeft(personajeCol)) {
            if (laberinto[personajeRow][personajeCol-1] == ESPACIO_NIEBLA || laberinto[personajeRow][personajeCol-1] == ESPACIO_LIBRE) {
                nextDirection = DIRECTION_LEFT;
                return nextDirection;
            }
        }
        nextDirection = DIRECTION_BOT;
        return nextDirection;
    }
    //Comprueba que no este en el borde
    public static boolean isBorderRight(Character[][] laberinto, int personajeCol) {
        int borderRight = getSizeColLaberinto(laberinto);
        if (personajeCol == borderRight) {
            return true;
        }
        return false;
    }
    //Comprueba que no este en el borde
    public static boolean isBorderBot(Character[][] laberinto, int personajeRow) {
        int borderBot = getSizeRowLaberinto(laberinto);
        if (personajeRow == borderBot) {
            return true;
        }
        return false;
    }
    //Comprueba que no este en el borde
    public static boolean isBorderLeft(int personajeCol) {
        int borderLeft = 0;
        if (personajeCol == borderLeft) {
            return true;
        }
        return false;
    }
    //Comprueba que no este en el borde
    public static boolean isBorderTop(int personajeRow) {
        int borderTop = 0;
        if (personajeRow == borderTop) {
            return true;
        }
        return false;
    }
    //Comprueba si el final esta cerca
    public static void checkAroundEnd(Character[][] laberinto) {
        int personajeRow = getPersonajeRowLocation(laberinto);
        int personajeCol = getPersonajeColLocation(laberinto);

        if (! isBorderBot(laberinto, personajeRow)) {
            checkEndBot(laberinto, personajeRow, personajeCol);
        }
        if (! isBorderRight(laberinto, personajeCol)) {
            checkEndRight(laberinto, personajeRow, personajeCol);
        }
        if (! isBorderTop(personajeRow)) {
            checkEndTop(laberinto, personajeRow, personajeCol);
        }
        if (! isBorderLeft(personajeCol)) {
            checkEndLeft(laberinto, personajeRow, personajeCol);
        }
    }
    //Comprueba si el final esta en una posicion mas
    public static void checkEndBot(Character[][] laberinto, int personajeRow, int personajeCol) {
        if (laberinto[personajeRow+1][personajeCol] == 'E') {
            moveBot(laberinto, personajeRow, personajeCol);
        }
    }
    //Comprueba si el final esta en una posicion mas
    public static void checkEndRight(Character[][] laberinto, int personajeRow, int personajeCol) {
        if (laberinto[personajeRow][personajeCol+1] == 'E') {
            moveRight(laberinto, personajeRow, personajeCol);
        }
    }
    //Comprueba si el final esta en una posicion mas
    public static void checkEndTop(Character[][] laberinto, int personajeRow, int personajeCol) {
        if (laberinto[personajeRow-1][personajeCol] == 'E') {
            moveTop(laberinto, personajeRow, personajeCol);
        }
    }
    //Comprueba si el final esta en una posicion mas
    public static void checkEndLeft(Character[][] laberinto, int personajeRow, int personajeCol) {
        if (laberinto[personajeRow][personajeCol-1] == 'E') {
            moveLeft(laberinto, personajeRow, personajeCol);
        }
    }
    //Obtiene la posicion del personaje en las Columnas
    public static int getPersonajeColLocation(Character[][] laberinto) {
        int personajeCol = -1;
        seachLoop:for (Character[] i : laberinto) {
            for (int j = 0; j < i.length; j++) {
                if (i[j] == 'P' || i[j] == DIRECTION_RIGHT || i[j] == DIRECTION_LEFT || i[j] == DIRECTION_BOT || i[j] == DIRECTION_TOP) {
                    personajeCol = j;
                    break seachLoop;
                }
            }
        }
        return personajeCol;
    }
    //Obtiene la posicion del personaje en las Filas
    public static int getPersonajeRowLocation(Character[][] laberinto) {
        int personajeRow = -1;
        seachLoop:for (int i = 0; i < laberinto.length; i++) {
            for (char j : laberinto[i]) {
                if (j == 'P' || j == DIRECTION_RIGHT || j == DIRECTION_LEFT || j == DIRECTION_BOT || j == DIRECTION_TOP) {
                    personajeRow = i;
                    break seachLoop;
                }
            }
        }
        return personajeRow;
    }
    //Obtiene la posicion del Final en las Filas
    public static int getEndRowLocation(Character[][] laberinto) {
        int endRow = -1;
        searchLoop:for (int i = 0; i < laberinto.length; i++) {
            for (char j : laberinto[i]) {
                if (j == 'E') {
                    endRow = i;
                    break searchLoop;
                }
            }
        }
        return endRow;
    }
    //Obtiene la posicion del Final en las Columnas
    public static int getColEndLocation(Character[][] laberinto) {
        int endCol = -1;
        searchLoop:for (Character[] i : laberinto){
            for (int j = 0; j < i.length; j++) {
                if (i[j] == 'E') {
                    endCol = j;
                    break searchLoop;
                }
            }
        }
        return endCol;
    }
    //Obtiene el tamaño del Laberinto en la fila
    public static int getSizeRowLaberinto(Character[][] laberinto) {
        return laberinto.length-1;
    }
    //Obtiene el tamaño del Laberinto en las columnas
    public static int getSizeColLaberinto(Character[][] laberinto) {
        return laberinto[0].length-1;
    }


    //*** DESDE ACA CODIGO EXTRA (MENSAJE DE INICIO, ETC) ***
    public static void mensajeBienvenida() {
        System.out.println("    ┌──────────┐");
        System.out.println("    │BIENVENIDO│");
        System.out.println("┌───┴──────────┴──────┐");
        System.out.println("│Hola Soy Computin 'ᗋ'│");
    }

    public static void mensajeLaberintoActual(Character[][] laberinto, int num) {
        int sizeRow = getSizeRowLaberinto(laberinto)+1;
        int sizeCol = getSizeColLaberinto(laberinto)+1;
        String espacioFinalMensaje;

        System.out.println("┌────────────────────────────────────────┐");
        System.out.println("│Veamos Que Laberinto Me Tienes Preparado│");
        if (sizeRow <= 5 || sizeCol <= 5) {
            System.out.print("│¡Que Facil!");
            espacioFinalMensaje = "         │";
        } else if (sizeRow <= 10 || sizeCol <= 10) {
            System.out.print("│Interesante");
            espacioFinalMensaje = "       │";
        } else {
            System.out.print("│¡Que Malvado!");
            espacioFinalMensaje = "     │";
        }
        System.out.println(" Un Laberinto de " + sizeRow + "X" + sizeCol + espacioFinalMensaje);
        System.out.println("└────────────────────────────────────────┘");
        System.out.println("Presiona Enter para Empezar...");
        System.out.println("┌────────────┐");
        System.out.println("│Laberinto N" + (num+1) + "│");
        System.out.println("└────────────┘");
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
    }
    //Comprueba si en el laberinto hay un punto de partida y uno de salida
    public static boolean checkMap(Character[][] laberinto) {
        if (getEndRowLocation(laberinto) == -1 || getColEndLocation(laberinto) == -1) {
            System.out.println("Por Favor Recuerde Colocar Una 'E' Para La Salida");
            return false;
        }
        if (getPersonajeRowLocation(laberinto) == -1 || getPersonajeColLocation(laberinto) == -1) {
            System.out.println("Por Favor Recuerde Colocar Una 'P' Para El Inicio");
            return false;
        }
        return true;
    }

    //Codigo sacado de Internet No es Mio
    public static void limpiarPantalla(){
        try {
            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando= new ArrayList<String>();
            if(sistemaOperativo.contains("Windows")){
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");
            }else{
                comando.add("clear"); //UNIX => MAC, LINUX
            }
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso =pb.inheritIO().start();
            iniciarProceso.waitFor();

        } catch (Exception e) {
            System.err.println("Error al limpiar la pantalla"+e.getMessage());
        }

    }

    //Codigo sacado de Internet No es Mio
    public static void pausa(){
        try {
            Thread.sleep(1000);
            //limpiarPantalla();  //Habilitar el llamado si lo ejecutas en CMD
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}