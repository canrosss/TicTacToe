# New Features

## Sistema de guardado de partidas (Score System)

### Descripcion
Implementar un sistema que guarde el historial de partidas en un archivo `scores.json` en la raiz del proyecto.

### Estructura del JSON

```json
[
  {
    "partida": 1,
    "fecha": "02/03/2026 14:35",
    "ganador": "Charlie",
    "totalTurnos": 7,
    "empate": false
  }
]
```

### Campos por partida

| Campo        | Tipo    | Descripcion                              |
|--------------|---------|------------------------------------------|
| partida      | int     | Numero incremental de la partida         |
| fecha        | String  | Fecha y hora de fin de partida           |
| ganador      | String  | Nombre del jugador o IA que gano         |
| totalTurnos  | int     | Cantidad de movimientos en la partida    |
| empate       | boolean | true si la partida termino en empate     |

### Dependencia requerida

- **Gson 2.10.1** — libreria de Google para manejo de JSON en Java.
- Descarga: https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar
- Agregar en IntelliJ: `File → Project Structure → Libraries → + → Java`

### Archivos a crear/modificar

| Archivo | Accion | Descripcion |
|---------|--------|-------------|
| `src/com/canrossoft/tictactoe/score/ScoreManager.java` | Crear | Clase que lee y escribe el JSON |
| `src/com/canrossoft/tictactoe/TicTacToe.java` | Modificar | Llamar a ScoreManager al terminar cada partida |

### Implementacion — ScoreManager.java

```java
package com.canrossoft.tictactoe.score;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ScoreManager {

    private static final String FILE_PATH = "scores.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveResult(String winner, int totalTurns, boolean isDraw) {
        List<GameRecord> records = loadRecords();

        GameRecord record = new GameRecord();
        record.partida = records.size() + 1;
        record.fecha = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        record.ganador = isDraw ? "Empate" : winner;
        record.totalTurnos = totalTurns;
        record.empate = isDraw;

        records.add(record);

        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(records, writer);
            System.out.println("Partida guardada en scores.json");
        } catch (IOException e) {
            System.out.println("Error al guardar la partida: " + e.getMessage());
        }
    }

    private static List<GameRecord> loadRecords() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<GameRecord>>(){}.getType();
            List<GameRecord> records = gson.fromJson(reader, listType);
            return records != null ? records : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    static class GameRecord {
        int partida;
        String fecha;
        String ganador;
        int totalTurnos;
        boolean empate;
    }
}
```

### Cambios en TicTacToe.java

Agregar contador de turnos antes del `while`:

```java
int turnos = 0;
```

Al final de cada iteracion del `while`, incrementar:

```java
turnos++;
```

Llamar a `ScoreManager` cuando termina la partida:

```java
if (board.isPlaying == false) {
    ScoreManager.saveResult(p.getName(), turnos, false);
    break;
}
```

### Branch

Esta feature se desarrolla en la rama `feature/score-system`.
Una vez completada, hacer merge a `main` mediante Pull Request.
