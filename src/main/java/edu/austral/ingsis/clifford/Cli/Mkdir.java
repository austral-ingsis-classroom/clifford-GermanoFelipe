package edu.austral.ingsis.clifford.Cli;

import edu.austral.ingsis.clifford.FileSystem.Directory;

import java.util.List;

public class Mkdir implements Command{

  public Cli cli;

  public Mkdir(Cli cli) {
    this.cli = cli;
  }

  @Override
  public String execute(List<String> flag, List<String> arguments) {
    String name = arguments.get(0);
    Directory directory = new Directory(name);
    directory.parentDirectory = cli.currentDirectory;
    cli.currentDirectory.addChild(directory);
    return "'" + name + "' directory created";
  }
}
