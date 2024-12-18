import java.util.ArrayList;

public class MapsLaberintos {

    private final Character[][] laberinto1 = {
            {'█','█','█','█','█'},
            {'█','░','░','░','░'},
            {'█','░','█','█','█'},
            {'P','░','░','░','E'},
            {'█','█','█','█','█'}
    };

    private final Character[][] laberinto2 = {
            {'░','░','░','█','P','█','█','█','█','█'},
            {'░','█','░','█','░','░','█','░','░','░'},
            {'░','░','█','█','█','░','█','░','█','█'},
            {'█','░','█','█','░','░','░','░','░','░'},
            {'░','░','░','░','░','█','█','█','█','░'},
            {'░','█','█','█','█','░','░','░','░','░'},
            {'░','█','█','█','█','░','█','░','█','░'},
            {'░','░','░','░','░','█','█','░','░','░'},
            {'█','█','█','█','░','█','█','█','░','█'},
            {'░','░','░','░','E','█','█','█','█','█'}
    };

    private final Character[][] laberinto3 = {
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█'},
            {'█','░','░','░','█','░','░','░','█','█','░','█','█','░','░','░','░','░','█','░','░','P'},
            {'E','░','█','░','░','░','█','░','░','░','░','░','░','░','█','█','█','░','█','░','█','█'},
            {'█','░','█','░','█','░','░','█','█','░','░','█','█','█','█','░','░','░','█','░','█','█'},
            {'█','█','█','░','█','█','█','█','█','█','░','░','░','░','█','█','█','░','█','░','░','█'},
            {'█','░','░','░','░','░','░','░','░','░','░','█','█','░','░','█','█','░','░','░','░','█'},
            {'█','█','█','█','█','░','█','█','█','█','█','█','░','░','░','█','█','█','█','█','░','█'},
            {'█','░','░','░','░','░','█','░','░','░','█','█','█','█','█','█','█','░','░','█','░','█'},
            {'█','░','█','█','█','█','█','█','█','░','░','░','░','░','░','░','░','█','░','░','░','█'},
            {'█','░','░','░','░','░','░','░','░','░','░','░','░','░','░','░','░','█','░','█','█','█'},
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█'}
    };

    private final Character[][] laberinto4 = {
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█'},
            {'P','░','░','█','░','░','░','░','░','░','░','█','░','░','░','░','░','█','█'},
            {'█','░','░','█','█','█','░','█','█','█','░','█','░','█','█','█','░','█','█'},
            {'█','░','░','░','░','█','░','█','░','░','░','█','░','░','░','░','░','█','█'},
            {'█','█','█','░','█','░','█','░','█','█','█','█','█','░','█','█','█','░','█'},
            {'█','░','░','░','█','░','░','░','█','░','░','░','░','░','█','░','█','░','█'},
            {'█','░','█','█','█','░','█','█','█','░','█','█','█','░','█','░','█','░','█'},
            {'█','░','░','░','░','░','█','░','░','░','░','░','█','░','░','░','█','░','█'},
            {'█','█','█','█','█','░','█','█','█','█','█','░','█','█','█','█','█','█','█'},
            {'█','░','░','░','░','░','░','░','█','░','░','░','░','░','░','░','░','░','█'},
            {'█','█','█','░','█','█','█','█','█','░','█','█','█','█','█','█','█','░','█'},
            {'█','░','░','░','█','░','░','░','░','░','█','░','░','░','░','░','█','░','█'},
            {'█','░','█','░','█','█','█','░','█','█','█','░','█','█','█','░','█','░','█'},
            {'█','░','█','░','░','░','█','░','░','░','█','░','░','░','█','░','░','░','█'},
            {'█','░','█','█','█','░','█','█','█','░','█','█','█','░','█','█','█','░','█'},
            {'█','░','░','░','█','░','░','░','░','░','█','░','░','░','░','░','░','░','█'},
            {'█','░','█','█','█','░','█','█','█','░','█','█','█','█','█','░','█','█','█'},
            {'█','░','░','░','░','░','█','░','░','░','░','░','░','░','█','░','░','░','E'},
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█'}
    };

    private final Character[][] laberinto5 = {
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█'},
            {'█','░','█','░','░','░','█','░','█','░','░','░','█','░','█','░','░','░','█','░','░','░','░','░','░','E'},
            {'█','░','░','░','█','█','█','░','█','█','█','░','█','░','█','█','█','░','█','█','█','░','█','█','█','█'},
            {'█','█','█','░','█','░','█','░','█','░','░','░','░','░','░','░','░','░','█','░','░','░','░','█','░','█'},
            {'█','░','░','░','░','░','░','░','█','░','█','█','█','█','█','█','█','█','█','█','█','█','░','░','░','█'},
            {'█','░','█','░','█','░','█','█','█','░','█','░','█','░','█','░','░','░','░','█','░','░','░','█','░','█'},
            {'█','░','█','░','█','░','░','░','█','░','█','░','░','░','█','░','█','█','░','█','░','█','░','█','█','█'},
            {'█','░','█','░','█','░','█','█','█','░','█','░','█','░','█','░','░','█','░','█','░','█','░','█','░','█'},
            {'█','░','█','░','█','░','░','░','█','░','█','░','█','░','░','█','░','█','░','█','░','█','░','█','░','█'},
            {'█','░','█','█','█','█','█','░','█','░','█','░','░','█','░','█','░','█','░','█','░','█','░','█','░','█'},
            {'█','░','█','░','░','░','░','░','█','░','█','█','█','█','░','█','░','█','░','█','█','█','░','░','░','█'},
            {'█','░','█','█','█','█','█','░','░','░','░','░','░','░','░','░','░','█','░','█','█','█','░','█','█','█'},
            {'█','░','░','░','░','░','█','░','█','█','█','█','█','█','█','█','█','█','░','█','█','█','░','░','░','█'},
            {'█','█','█','░','█','█','█','░','░','█','░','░','░','░','░','░','░','░','░','░','░','█','░','░','░','█'},
            {'█','░','█','░','█','░','█','█','█','█','█','█','█','█','░','░','█','█','█','█','░','█','░','░','░','█'},
            {'█','░','░','░','░','░','█','░','░','░','░','░','░','░','░','█','█','░','░','░','░','█','█','█','░','█'},
            {'█','█','█','█','█','░','█','░','█','█','█','█','█','█','█','█','█','█','█','█','█','█','░','░','░','█'},
            {'█','░','░','░','█','░','█','░','░','░','░','░','░','░','░','░','░','░','░','░','░','░','░','█','█','█'},
            {'█','░','░','░','░','░','█','█','█','█','█','█','█','█','█','█','█','█','░','█','█','█','█','█','░','█'},
            {'P','░','█','░','█','░','░','░','░','░','░','░','░','░','░','█','░','░','░','░','░','░','░','░','░','█'},
            {'█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█','█'}
    };

    private final ArrayList<Character[][]> laberintoList = new ArrayList<>();

    public MapsLaberintos() {
        this.laberintoList.add(laberinto1);
        this.laberintoList.add(laberinto2);
        this.laberintoList.add(laberinto3);
        this.laberintoList.add(laberinto4);
        this.laberintoList.add(laberinto5);
    }

    public Character[][] getLaberinto(int num) {
        return laberintoList.get(num);
    }

    public int getLaberintoSize() {
        return laberintoList.size();
    }

}
