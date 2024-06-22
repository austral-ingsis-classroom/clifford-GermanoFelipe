package edu.austral.ingsis.clifford.Cli;

import edu.austral.ingsis.clifford.FileSystem.Directory;

import java.util.List;

public class Pwd implements Command{

  public Cli cli;

  public Pwd (Cli cli){
    this.cli = cli;
  }

  @Override
  public String execute(List<String> flag, List<String> arguments) {
    return path(cli.currentDirectory);
  }


  public String path(Directory directory){
    if (directory.parentDirectory == null){
      return directory.name;
    }
    return path(directory.parentDirectory) + "/" + directory.name;
  }
}
