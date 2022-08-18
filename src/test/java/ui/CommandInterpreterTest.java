package ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandInterpreterTest {
    @Test
    void InputToCommand_Test() {
        String data = " TEST ";
        String result = CommandInterpreter.InputToCommand(data);
        assertEquals("test", result);
    }

}
