# Variables
JAVAC = javac
JAVA = java
SRC_DIR = src
TEST_DIR = test
BIN_DIR = bin

# Targets
all: compile

compile:
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(SRC_DIR)/*.java $(TEST_DIR)/*.java

run: compile
	$(JAVA) -cp $(BIN_DIR) TamagotchiTest 
	$(JAVA) -cp $(BIN_DIR) PlaygroundTest 

clean:
	rm -rf $(BIN_DIR)
