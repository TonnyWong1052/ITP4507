# ITP4507 - Contemporary Topics in Software Engineering

> ITP114105 Software engineering (Tuen Mun) Year2 2022/11
> programming language - JAVA

## Features
- Create a building record (Apartment, House or any new kind of Building in the coming future).
- Modify a building record (Apartment, House or any new kind of Building in the coming future)
- Display Building details (such as building id, corresponding attributes and rooms) by a given
building id (input building id=* to display all building records)
- Add, update or delete rooms in a building record
- Undo last command
- Redo the last undone command
- Show undo/redo list

## Design patterns for the new system
- Command pattern to provide the “add building”, “display buildings”, “modify building”, “add
room”, "delete room", "modify room", “undo”, “redo” and “list undo/redo list” functions
- Factory pattern or Abstract Factory Pattern to create different kinds of Command objects
and different kinds of Building objects (e.g. Apartment object, House object, etc.)
- Memento pattern to provide “Undo” and “Redo” functions on "modify building" and "modify
room".


## Installation
> Suggestion tool - visual studio code


```
Javac *.java
```

```
Java BuildingSys.java
```
