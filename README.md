# TicTacToe

Proyecto de prueba creado para retomar el aprendizaje de Java.

TicTacToe es un juego de Tres en Raya para consola donde un jugador humano se enfrenta a una IA en un tablero de 3x3.

## Requisitos

- Java JDK 22 o superior
- IntelliJ IDEA (recomendado)

## Estructura del proyecto

```
src/com/canrossoft/tictactoe/
├── TicTacToe.java       — Punto de entrada principal
├── model/
│   ├── Board.java       — Logica del tablero 3x3
│   └── Player.java      — Modelo del jugador
├── ai/
│   └── IA.java          — Jugador controlado por la IA
└── ui/
    ├── ConsoleUI.java   — Interfaz de consola
    └── Teletype.java    — Salida de texto con efecto maquina de escribir
```

## Como jugar

1. Abre el proyecto en IntelliJ IDEA.
2. Ejecuta `TicTacToe.java`.
3. Ingresa tu nombre cuando se te pida.
4. En cada turno, introduce las coordenadas X e Y (valores entre 0 y 2) para marcar tu posicion en el tablero.
5. La IA respondera con su movimiento automaticamente.
6. Gana el primero en alinear tres marcas en fila, columna o diagonal.

## Tablero

```
  ---0------1------2---
0 |  .  |  .  |  .  |
1 |  .  |  .  |  .  |
2 |  .  |  .  |  .  |
  ---------------------
```

- `H` — marca del jugador humano
- `M` — marca de la IA (Robotnik)
- `.` — casilla vacia

## Estado actual

Version `0.1` — proyecto en desarrollo activo. Consulta el [CHANGELOG.md](CHANGELOG.md) para ver el historial de cambios y los issues conocidos.
