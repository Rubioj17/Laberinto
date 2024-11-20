# Ejercicio de Laberinto

Algoritmo que intenta encontrar la salida de distintos Laberintos.
-  Son 5 Laberintos y cada laberinto están formados por una matriz donde hay espacios libres y espacios llenos que representan paredes.
- El algoritmo va desde un punto de partida **'P'** recorriendo los espacios vacios hasta encontrar el punto final **'E'**.
- Siempre trata de ir hacia la derecha dependiendo de la dirección en la que se este dirigiendo y si hay un obstáculo cambia la dirección.
- Si lo quieres ejecutar en la consola recuerda cambiar los Simbolos.
- También en la línea 447 hay una llamada a una función la cual esta como comentario, quítalo si lo quieres ejecutar en la consola (Windows, Linux) y que se vea mejor

## Laberintos Cargados
### Laberinto 1
```
█████
█░░░░ 
█░███
P░░░E 
█████
```
---

### Laberinto 2
```
░░░█P█████ 
░█░█░░█░░░ 
░░███░█░██ 
█░██░░░░░░ 
░░░░░████░
░████░░░░░ 
░████░█░█░ 
░░░░░██░░░ 
████░███░█ 
░░░░E█████
```
---

### Laberinto 3
```
██████████████████████
█░░░█░░░██░██░░░░░█░░P
E░█░░░█░░░░░░░███░█░██
█░█░█░░██░░████░░░█░██
███░██████░░░░███░█░░█
█░░░░░░░░░░██░░██░░░░█
█████░██████░░░█████░█
█░░░░░█░░░███████░░█░█
█░███████░░░░░░░░█░░░█
█░░░░░░░░░░░░░░░░█░███
██████████████████████
```
---

### Laberinto 4
```
███████████████████
P░░█░░░░░░░█░░░░░██
█░░███░███░█░███░██
█░░░░█░█░░░█░░░░░██
███░█░█░█████░███░█
█░░░█░░░█░░░░░█░█░█
█░███░███░███░█░█░█
█░░░░░█░░░░░█░░░█░█
█████░█████░███████
█░░░░░░░█░░░░░░░░░█
███░█████░███████░█
█░░░█░░░░░█░░░░░█░█
█░█░███░███░███░█░█
█░█░░░█░░░█░░░█░░░█
█░███░███░███░███░█
█░░░█░░░░░█░░░░░░░█
█░███░███░█████░███
█░░░░░█░░░░░░░█░░░E
███████████████████
```
---

### Laberinto 5
```
██████████████████████████
█░█░░░█░█░░░█░█░░░█░░░░░░E
█░░░███░███░█░███░███░████
███░█░█░█░░░░░░░░░█░░░░█░█
█░░░░░░░█░████████████░░░█
█░█░█░███░█░█░█░░░░█░░░█░█
█░█░█░░░█░█░░░█░██░█░█░███
█░█░█░███░█░█░█░░█░█░█░█░█
█░█░█░░░█░█░█░░█░█░█░█░█░█
█░█████░█░█░░█░█░█░█░█░█░█
█░█░░░░░█░████░█░█░███░░░█
█░█████░░░░░░░░░░█░███░███
█░░░░░█░██████████░███░░░█
███░███░░█░░░░░░░░░░░█░░░█
█░█░█░████████░░████░█░░░█
█░░░░░█░░░░░░░░██░░░░███░█
█████░█░██████████████░░░█
█░░░█░█░░░░░░░░░░░░░░░░███
█░░░░░████████████░█████░█
P░█░█░░░░░░░░░░█░░░░░░░░░█
██████████████████████████
```
---

[Laberintos de Pruebas](Laberintos.txt)
