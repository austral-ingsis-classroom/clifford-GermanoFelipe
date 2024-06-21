package edu.austral.ingsis.clifford.Cli;

import java.util.ArrayList;
import java.util.List;

public class CommandLine {
  public String command;
  public List<String> flags;
  public List<String> arguments;

  public CommandLine(String command, List<String> flags, List<String> arguments) {
    this.command = command;
    this.flags = flags;
    this.arguments = arguments;
  }

  public CommandLine build(String[] arguments) {
    flags = arguments.length > 2 ?
            new ArrayList<>(List.of(arguments[1])) :
            List.of(arguments[arguments.length -1]);
    return new
            CommandLine(arguments[0], flags, new ArrayList<>(List.of(arguments[arguments.length -1])));
  }
}
