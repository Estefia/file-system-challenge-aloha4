package file.system.exercise.command;

import file.system.exercise.model.Node;

public interface ICommand {
	
	public Object execute(String arg[], Node node);

}
