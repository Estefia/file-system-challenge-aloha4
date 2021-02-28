package file.system.exercise.command;

import file.system.exercise.model.File;
import file.system.exercise.model.Node;

public class TouchCommand implements ICommand {

	public Object execute(String arg[], Node node) {
		if (arg != null && arg.length > 1 && arg[0].length() > 100) {
			return "File name invalid";
		} else {
			if (arg == null || arg.length <= 1) {
				new InvalidCommand().execute(arg, node);
			}
			File newFile = new File(arg[1]);
			if (!node.addFile(newFile)) {
				return "File already exists";
			}
		}
		return "";
	}
}
