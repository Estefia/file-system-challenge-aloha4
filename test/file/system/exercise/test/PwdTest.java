package file.system.exercise.test;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import file.system.exercise.command.PwdCommand;
import file.system.exercise.model.FileSystem;

public class PwdTest {

	
	private PwdCommand pwdCommand; 
	private FileSystem fileSystem; 

	@BeforeEach
	public void beforeTest() {

		pwdCommand = new PwdCommand();
		fileSystem = new FileSystem();
	}
	
	@Test
	public void pwdGetRootTestOK() {
		Assert.assertEquals(pwdCommand.execute(null, fileSystem.getCurrentDir()), "root");
	}
	
}
