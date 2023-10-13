# TP Tamagotchi

> Authors : BENICHOU Yaniv & BONNEFOY Nicolas.

## Architecture

The tp architecture is made up of 3 folders:

> - **src/** : All .Java files containing definitions of classes, interfaces, etc.
> - **test/** : The set of test files for testing the methods implemented in the src/ folder. There are two files here, one containing all the **unit tests** and another which is a Playground where we can test as we wish.
> - **bin/** : The set of .class files generated during compilation and which can be deleted.
>

The **src/** folder  contains the implementation of :

- **Tamagotchi** : It's the main class which represents the virtual pet. It has attributes like happiness level and methods to feed, play, and change its state.
- **Dog and LonelyCat**: Subclasses of Tamagotchi representing specific types of pets with their unique behaviors.
- **State** : Interface that defines the possible states of a Tamagotchi.
- **HappyState, SadState, HungryState**: Classes that implement the State interface, representing the respective emotional states of a Tamagotchi.

## Makefile : How to execute

> The Makefile is included to simplify the compilation and execution of the project. It contains predefined commands for these tasks.

### Commands :

- **compile**: Compiles all Java files of the project.
- **run**: Executes the main program.
- **clean**: Deletes all compiled files, leaving the directory clean.


### Usage:

To compile the project:

```
make compile
```

To run the project:

```
make run
```

To clean up the directory:

```
make clean
```

## Result of execution : 
[img_src](./result.png)