package file.system.exercise.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import file.system.exercise.command.CdCommand;
import file.system.exercise.command.CommandManager;
import file.system.exercise.command.ICommand;
import file.system.exercise.command.LsCommand;
import file.system.exercise.command.MkdirCommand;
import file.system.exercise.command.NotFoundCommand;
import file.system.exercise.command.PwdCommand;
import file.system.exercise.command.QuitCommand;
import file.system.exercise.command.TouchCommand;

public class CommandManagerTest {
	private CommandManager commandManager;
	private Map<String, Class<? extends ICommand>> COMMAND_LIST = new HashMap<String, Class<? extends ICommand>>();

	@BeforeEach
	public void beforeTest() {
		commandManager = CommandManager.getIntance();

		COMMAND_LIST.put("quit", QuitCommand.class);
		COMMAND_LIST.put("pwd", PwdCommand.class);
		COMMAND_LIST.put("ls", LsCommand.class);
		COMMAND_LIST.put("mkdir", MkdirCommand.class);
		COMMAND_LIST.put("cd", CdCommand.class);
		COMMAND_LIST.put("touch", TouchCommand.class);

	}

	@Test
	public void commandManagerTestOK() {
		for (String commandName : COMMAND_LIST.keySet()) {
			ICommand commandFound = commandManager.getCommand(commandName);
			Assert.assertEquals(COMMAND_LIST.get(commandName), commandFound.getClass());
		}
	}
	@Test
	public void commandManagerTestNoOK() {
			Assert.assertEquals(NotFoundCommand.class, commandManager.getCommand("fake").getClass());
	}
}
