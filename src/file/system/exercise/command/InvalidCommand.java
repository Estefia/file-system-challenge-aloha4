package file.system.exercise.command;

import file.system.exercise.model.Node;

public class InvalidCommand implements ICommand {
	
	public Object execute(String arg[], Node node) {
		return "Invalid command error";
	}
}
