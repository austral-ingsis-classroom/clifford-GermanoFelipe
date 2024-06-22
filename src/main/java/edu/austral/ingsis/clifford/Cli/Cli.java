package edu.austral.ingsis.clifford.Cli;

import edu.austral.ingsis.clifford.FileSystem.Directory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cli {

  public Directory root;
  public Directory currentDirectory;
  private final Map<String, Command> commands;

  public Cli(Directory root) {
    this.root = root;
    this.currentDirectory = root;
    this.commands =
            Map.of(
        "ls",     new Ls(this),
        "cd",     new Cd(this),
        "mkdir",  new Mkdir(this),
        "pwd",    new Pwd(this),
        "touch",  new Touch(this),
        "rm",     new Rm(this)
    );
  }

  public String executeCommand(String command) {
    String[] commandParts = command.split(" ");
    CommandLine commandLine = build(commandParts);
    if (!commands.containsKey(commandLine.command)) {
      return "Not command found";
    }
    return commands.get(commandLine.command).execute(commandLine.flags, commandLine.arguments);
  }


  private CommandLine build(String[] arguments) {
    List<String> flags = arguments.length > 2 ?
            new ArrayList<>(List.of(arguments[1])) :
            List.of(arguments[arguments.length -1]);
    return new
            CommandLine(arguments[0], flags, new ArrayList<>(List.of(arguments[arguments.length -1])));
  }
}
