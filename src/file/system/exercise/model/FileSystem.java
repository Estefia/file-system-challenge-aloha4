package file.system.exercise.model;

import file.system.exercise.command.CommandManager;
import file.system.exercise.command.ICommand;

public class FileSystem {
	
	private Node currentDir;
	private CommandManager commandManager;

	public FileSystem() {
		Node node = new Node("root");
		this.currentDir = node;
		commandManager = CommandManager.getIntance();
	}
	
	public void execute(String input) {
		String[] commandArgs = input.split(" ");
		ICommand command = commandManager.getCommand(commandArgs[0]);
		Object result = command.execute(commandArgs, this.currentDir);
		if (result instanceof Node) {
			this.currentDir = (Node) result;
		} else if (result instanceof String) {
			System.out.println(result);
		}
	}
	
	public Node getCurrentDir() {
		return currentDir;
	}
}
