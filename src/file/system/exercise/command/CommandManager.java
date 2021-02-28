package file.system.exercise.command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

	private static CommandManager commandManager;

	private Map<String, Class<? extends ICommand>> COMMAND_LIST = new HashMap<String, Class<? extends ICommand>>();


    private CommandManager() {
    	COMMAND_LIST.put("quit", QuitCommand.class);
		COMMAND_LIST.put("pwd", PwdCommand.class);
		COMMAND_LIST.put("ls", LsCommand.class);
		COMMAND_LIST.put("mkdir", MkdirCommand.class);
		COMMAND_LIST.put("cd", CdCommand.class);
		COMMAND_LIST.put("touch", TouchCommand.class);
		COMMAND_LIST.put("nfc", NotFoundCommand.class);
		COMMAND_LIST.put("ic", InvalidCommand.class);
    }

    public static synchronized CommandManager getIntance() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        }
        return commandManager;
    }

    public ICommand getCommand(String commandName) {
        if (COMMAND_LIST.containsKey(commandName)) {
            try {
                return COMMAND_LIST.get(commandName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return new InvalidCommand();
            }
        } else {
            return new NotFoundCommand();
        }
    }

}