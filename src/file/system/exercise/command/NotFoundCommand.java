package file.system.exercise.command;

import file.system.exercise.model.Node;

public class NotFoundCommand implements ICommand {
	
	public String execute(String arg[], Node node) {
		return "Unrecognized command error";
	}
}
