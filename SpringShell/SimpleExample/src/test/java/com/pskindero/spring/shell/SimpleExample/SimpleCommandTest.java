package com.pskindero.spring.shell.SimpleExample;

import org.springframework.expression.ParseException;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.CommandResult;
import org.springframework.shell.core.JLineShellComponent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleCommandTest {
	private static JLineShellComponent shell;
	
	@BeforeClass
	public static void startUp() throws InterruptedException {
		Bootstrap bootstrap = new Bootstrap();		
		shell = bootstrap.getJLineShellComponent();
	}
	
	@AfterClass
	public static void shutdown() {
		shell.stop();
	}
	
	@Test
	public void dateTest() throws ParseException {
		CommandResult cr = getShell().executeCommand("simplecmd --message work");
		System.out.println(cr.getResult().toString());		
	}

	public static JLineShellComponent getShell() {
		return shell;
	}
		
}
