package edu.austral.ingsis.clifford.Cli;

import edu.austral.ingsis.clifford.FileSystem.Directory;

import java.util.Map;

public class Cli {

  public Directory root;
  public Directory currentDirectory;
  private Map<String, Command> commands;

  public Cli(Directory root, Map<String, Command> commands) {
    this.root = root;
    this.currentDirectory = root;
    this.commands = Map.of(
        "ls",     new Ls(this),
        "cd",     new Cd(this),
        "mkdir",  new Mkdir(this),
        "pwd",    new Pwd(this),
        "touch",  new Touch(this),
        "rm",     new Rm()
    );
  }

  public String executeCommand(String command) {
    String[] commandParts = command.split(" ");
    CommandLine commandLine = new CommandLine(commandParts[0], null, null).build(commandParts);
    if (!commands.containsKey(commandLine.command)) {
      return "Command not found";
    }
    return commands.get(commandLine.command).execute(commandLine.flags, commandLine.arguments);
  }
}
