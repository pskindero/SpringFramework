package com.pskindero.spring.shell.SimpleExample;

import java.util.logging.Logger;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;

public class SimpleCommand implements CommandMarker {

	protected final Logger LOG = Logger.getLogger(getClass().getName());

	/**
	 * Method returns a boolean value and indicates if a particular command can
	 * be presented in the shell. This decision is usually based on the history
	 * of commands that have been executed previously. It prevents extraneous
	 * commands being presented until some preconditions are met, for example
	 * the execution of a 'configuration' command.
	 * 
	 * @return
	 */
	@CliAvailabilityIndicator({ "simplecmd" })
	public boolean isAvailable() {
		return true;
	}

	@CliCommand(value = "simplecmd", help = "Example of Spring Shell usage.")
	public String simple(
			@CliOption(key = {"message"}, mandatory = true, help = "Introduce message") final String message,
			@CliOption(key = {"optarg"}, mandatory = false, help = "Optional argument") final String arg) {
		
		//Some buisness logic
		
		return "Message = [" + message + "] Location = [" + arg + "]";
	}
}
