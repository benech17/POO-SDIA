
# Variables
JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin
TEST_DIR = test
SOURCES = $(wildcard $(SRC_DIR)/*.java)
TEST_SOURCES = $(wildcard $(TEST_DIR)/*.java)
CLASSES = $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class) $(TEST_SOURCES:$(TEST_DIR)/%.java=$(BIN_DIR)/%.class)

# Rules
all: $(CLASSES)

$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) -d $(BIN_DIR) -sourcepath $(SRC_DIR) $<

$(BIN_DIR)/%.class: $(TEST_DIR)/%.java
	$(JAVAC) -d $(BIN_DIR) -sourcepath $(SRC_DIR):$(TEST_DIR) $<

run: $(CLASSES)
	$(JAVA) -cp $(BIN_DIR) Main

clean:
	rm -f $(BIN_DIR)/*.class

.PHONY: all run clean
