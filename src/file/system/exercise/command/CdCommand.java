package file.system.exercise.command;

import java.util.Optional;
import java.util.Set;

import file.system.exercise.model.Node;

public class CdCommand implements ICommand {
	
	public Node execute(String arg[], Node node) {
		if (arg != null && arg[1] != null && arg[1].equals(".."))
			return getUpDir(node);
		else {
			return getDir(arg, node);
		}
	}

	private Node getDir(String[] args, Node node) {
		String[] pathParam = args[1].split("/");
		Node directory = node;
		if (pathParam.length == 1) {
			Optional<Node> subdirectory = containsName(node.getChildren(), pathParam[0]);
			if (!subdirectory.isPresent()) {
				System.out.println("Directory not found");
				directory=node;
			} else {
				directory = subdirectory.get();
			}
		} else {
			Set<Node> directoryRoot = node.getRoot(node).getChildren();
			for (String string : pathParam) {
				Optional<Node> subdirFound = containsName(directoryRoot, string);
				if (!subdirFound.isPresent()) {
					directory = node;
					break;
				} else {
					directory = subdirFound.get();
					directoryRoot = directory.getChildren();
				}
			}
		}
		return directory;
	}

	public Optional<Node> containsName(Set<Node> set, String name) {
		return set.stream().filter(o -> o.getName().equals(name)).findFirst();
	}

	private Node getUpDir(Node currentNode) {
		if (currentNode.getPrevious() == null) {
			return currentNode;
		} else
			return currentNode.getPrevious();
	}

}
