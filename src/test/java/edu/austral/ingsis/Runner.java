package edu.austral.ingsis;

import edu.austral.ingsis.clifford.Cli.Cli;

import java.util.List;

public class Runner implements FileSystemRunner {

  public Cli cli;

  public Runner(Cli cli) {
    this.cli = cli;
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    return commands.stream().map(cli::executeCommand).toList();
  }
}
