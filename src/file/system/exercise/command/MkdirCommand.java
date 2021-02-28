package file.system.exercise.command;

import file.system.exercise.model.Node;

public class MkdirCommand implements ICommand {

	public Object execute(String arg[], Node node) {
		if (arg != null && arg.length > 1 && arg[1].length() > 100) {
			return "Directory name invalid";
		} else {
			if (arg == null || arg.length <= 1) {
				return new InvalidCommand().execute(arg, node);
			}
			Node newNode = new Node(arg[1]);
			if (!node.addChild(newNode)) {
				return "Directory already exists";
			}
		}
		return null;
	}
}
