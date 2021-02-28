package file.system.exercise.command;

import file.system.exercise.model.Node;

public class QuitCommand implements ICommand {
	
	public Object execute(String arg[], Node node) {
		System.exit(0);
		return null;
	}
}
