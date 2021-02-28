package file.system.exercise.test;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import file.system.exercise.command.MkdirCommand;
import file.system.exercise.model.FileSystem;

public class MkdirTest {
	
	private MkdirCommand mkdirCommand; 
	private FileSystem fileSystem; 

	@BeforeEach
	public void beforeTest() {

		mkdirCommand = new MkdirCommand();
		fileSystem = new FileSystem();
	}

	@Test
	public void mkdirTestOK() {
		String commandLine = "mkdir a1";
		String[] commandArgs = commandLine.split(" ");
		mkdirCommand.execute(commandArgs, fileSystem.getCurrentDir());
		commandLine = "mkdir a2";
		commandArgs = commandLine.split(" ");
		Assert.assertEquals(mkdirCommand.execute(commandArgs, fileSystem.getCurrentDir()), null);
	}
	
	@Test
	public void mkdirTestDirectoryAlreadyExists() {
		String commandLine = "mkdir a1";
		String[] commandArgs = commandLine.split(" ");
		mkdirCommand.execute(commandArgs, fileSystem.getCurrentDir());
		commandLine = "mkdir a1";
		commandArgs = commandLine.split(" ");
		Assert.assertEquals(mkdirCommand.execute(commandArgs, fileSystem.getCurrentDir()), "Directory already exists");
	}
	
	@Test
	public void mkdirTestInvalidName() {
		String commandLine = "mkdir aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String[] commandArgs = commandLine.split(" ");
		Assert.assertEquals(mkdirCommand.execute(commandArgs, fileSystem.getCurrentDir()), "Directory name invalid");
	}

	@Test
	public void mkdirTestInvalidCommand() {
		String commandLine = "mkdir";
		String[] commandArgs = commandLine.split(" ");
		Assert.assertEquals(mkdirCommand.execute(commandArgs, fileSystem.getCurrentDir()), "Invalid command error");
	}

}
