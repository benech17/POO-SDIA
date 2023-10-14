# Variables
JCC = javac
JVM = java
JFLAGS = -g
BIN = bin
SRC = src
TEST = test

# Default rule
default: compile

# Rule for compiling the classes
compile: 
	$(JCC) $(JFLAGS) $(SRC)/*.java -d $(BIN)
	$(JCC) $(JFLAGS) -cp $(BIN) $(TEST)/*.java -d $(BIN)

# Rule for running the tests
run: compile
	$(JVM) -cp $(BIN) PlaygroundTest
	$(JVM) -cp $(BIN) CombatTest

# Rule for cleaning up the output
clean:
	$(RM) $(BIN)/*.class