package file.system.exercise.command;

import file.system.exercise.model.Node;

public class LsCommand implements ICommand {

	public String execute(String arg[], Node node) {
		StringBuilder sb = new StringBuilder();
		node.getChildren().forEach((val) -> sb.append(val + "\n"));
		node.getFiles().forEach((val) -> sb.append(val + "\n"));
		return sb.toString();
	}
}
