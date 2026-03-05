# Changelog

Todos los cambios notables de este proyecto seran documentados en este archivo.

El formato esta basado en [Keep a Changelog](https://keepachangelog.com/es/1.0.0/).

---

## [Unreleased]

### Fixed
- `Board.java` — Corregidos indices fuera de rango (`ArrayIndexOutOfBoundsException`) en `checkBoard()`:
  - `positions[1][3]` corregido a `positions[1][1]` para verificar la segunda fila completa.
  - `positions[0][3]` corregido — la condicion ahora verifica la diagonal principal (`positions[0][0]`, `positions[1][1]`, `positions[2][2]`).

### Known Issues
- `checkBoard()` solo cubre 2 de las 8 combinaciones ganadoras posibles (faltan filas 2 y 3, las 3 columnas y la diagonal inversa).
- La IA puede sobreescribir posiciones ya ocupadas (sin verificacion de colision).
- El juego crashea si el jugador ingresa texto en lugar de un numero entero (`Scanner.nextInt()`).
- No hay deteccion de empate cuando el tablero esta lleno.
- La condicion en `Player.markPos()` verifica la misma condicion dos veces (logica redundante).

---

## [0.1.0] — 2025-03-25

### Added
- Tablero de juego 3x3 con visualizacion en consola (`Board.java`).
- Modelo de jugador con marca configurable y verificacion basica de posicion (`Player.java`).
- Jugador IA basico con movimientos aleatorios (`IA.java`).
- Interfaz de consola con efecto de texto tipo maquina de escribir (`ConsoleUI.java`, `Teletype.java`).
- Flujo de juego principal: turno del jugador humano seguido del turno de la IA (`TicTacToe.java`).
- Deteccion parcial de victoria para la IA (primera fila) y el jugador humano (primera fila).
- Solicitud del nombre del jugador al inicio de la partida.

---

## [0.0.1] — 2025-03-25

### Added
- Commit inicial del proyecto con estructura base de paquetes (`model`, `ai`, `ui`).
