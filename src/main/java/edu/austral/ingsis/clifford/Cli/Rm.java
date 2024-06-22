package edu.austral.ingsis.clifford.Cli;

import edu.austral.ingsis.clifford.FileSystem.File;
import edu.austral.ingsis.clifford.FileSystem.Type;
import java.util.List;

public class Rm implements Command {

  public Cli cli;

  public Rm(Cli cli) {
    this.cli = cli;
  }

  @Override
  public String execute(List<String> flag, List<String> arguments) {
    String name = arguments.get(0);
    Type type = isFile(name) ? Type.FILE : Type.DIRECTORY;
    String msg = "";
    if (type.equals(Type.DIRECTORY)) {
      msg = removeDir(name, flag);
    }
    if (type.equals(Type.FILE)) {
      msg = removeFile(name);
    }

    return msg;
  }

  public boolean isFile(String name) {
    return cli.currentDirectory.getChild(name) instanceof File;
  }

  public String removeFile(String name) {
    cli.currentDirectory.removeChild(name);
    return "'" + name + "' removed";
  }

  public boolean notvalidFlag(List<String> flag) {
    return !flag.contains("--recursive");
  }

  public String removeDir(String name, List<String> flag) {
    if (!cli.currentDirectory.getChildrenFile().isEmpty()) {
      if (flag.isEmpty() || notvalidFlag(flag)) {
        return "cannot remove '" + name + "', is directory";
      }
      cli.currentDirectory.removeChild(name);
    } else {
      cli.currentDirectory.removeChild(name);
    }
    return "'" + name + "' removed";
  }
}
