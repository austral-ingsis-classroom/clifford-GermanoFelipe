package edu.austral.ingsis.clifford.Cli;

import edu.austral.ingsis.clifford.FileSystem.Directory;
import edu.austral.ingsis.clifford.FileSystem.Type;

import java.util.List;

public class Cd implements Command{

  public Cli cli;

  public Cd (Cli cli){
    this.cli = cli;
  }

  @Override
  public String execute(List<String> flag, List<String> arguments) {
    String dirName = arguments.get(0);
    if (dirName.equals("/") || (dirName.equals("..") && cli.currentDirectory.parentDirectory == null)) {
      dirName = "/";
      return "moved to directory '" + dirName + "'";
    }
    if (dirName.equals("..")){
      cli.currentDirectory = cli.currentDirectory.parentDirectory;
      return "moved to directory " + "'/'";
    }
    return pathDir(dirName);
  }


  public String pathDir(String dirName){
    String[] directories = dirName.split("/");
    for (String path : directories) {
      if (cli.currentDirectory.notContains(path, Type.DIRECTORY)) {
        return "'" + dirName + "' directory does not exist";
      }
      cli.currentDirectory = (Directory) cli.currentDirectory.getChild(path);
    }
    return "moved to directory '" + cli.currentDirectory.getName() + "'";
  }
}
