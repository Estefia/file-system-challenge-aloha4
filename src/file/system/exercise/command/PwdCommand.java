package file.system.exercise.command;

import file.system.exercise.model.Node;

public class PwdCommand implements ICommand {
	
	public String execute(String arg[], Node node) {
		return this.getPath(node);
	}

	private String getPath(Node node) {
		if (node.getPrevious() == null) {
			return node.getName();
		} else {
			return this.getPath(node.getPrevious()) + "//" + node.getName();
		}
	}
}
