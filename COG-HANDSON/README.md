This workspace contains two days of Java exercises:

- Day_01_Design_Patterns_and_Principles (11 exercises)
- Day_02_Algorithms_and_Data_Structures (7 exercises)

Each exercise includes a `Main.java` that runs a hardcoded demonstration.

To compile all Java files (Windows), run:

```bat
javac -d out $(for /R %f in (*.java) do @echo %f)
```

Or compile and run a specific exercise, for example:

```bat
javac -d out Day_01_Design_Patterns_and_Principles\Exercise_01_SingletonPatternExample\*.java
java -cp out day01.exercise01.Main
```
