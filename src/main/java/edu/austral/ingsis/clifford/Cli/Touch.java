package edu.austral.ingsis.clifford.Cli;

import edu.austral.ingsis.clifford.FileSystem.File;

import java.util.List;

public class Touch implements Command{
  public Cli cli;

  public Touch (Cli cli){
    this.cli = cli;
  }
  @Override
  public String execute(List<String> flag, List<String> arguments) {
    String fileName = arguments.get(0);

    if (fileName.contains("/") || fileName.contains(" ")){
      return "Invalid file name";
    }

    if (cli.currentDirectory.notContains(fileName)){
      File file = new File(fileName);
      file.parent = cli.currentDirectory;
      cli.currentDirectory.addChild(file);
    }
    return "'" + fileName + "' file created";
  }
}
