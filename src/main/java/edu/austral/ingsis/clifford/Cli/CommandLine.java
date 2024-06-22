package edu.austral.ingsis.clifford.Cli;

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
}