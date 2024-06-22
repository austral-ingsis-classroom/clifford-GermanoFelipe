package edu.austral.ingsis.clifford.Cli;

import edu.austral.ingsis.clifford.FileSystem.Directory;
import edu.austral.ingsis.clifford.FileSystem.FileComparator;
import edu.austral.ingsis.clifford.FileSystem.FileSystem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ls implements Command {
  public Cli cli;

  public Ls(Cli cli) {
    this.cli = cli;
  }

  @Override
  public String execute(List<String> flag, List<String> arguments) {
    Directory directory = cli.currentDirectory;
    List<FileSystem> children = directory.getChildrenFile();

    List<String> childrenNames =
        new ArrayList<>(children.stream().map(FileSystem::getName).toList());

    return outPut(childrenNames, flag);
  }

  public String outPut(List<String> childrenNames, List<String> flag) {
    if (childrenNames.isEmpty()) return "";

    if (flag.isEmpty() || invalidFlag(flag)) {
      Comparator<String> fileSystemComparator = new FileComparator(cli);
      childrenNames.sort(fileSystemComparator);
      return getString(childrenNames);
    }
    Comparator<String> sort = getComparator(flag);
    childrenNames.sort(sort);
    return getString(childrenNames);
  }

  public String getString(List<String> childrenNames) {
    StringBuilder stringBuilder = new StringBuilder();

    childrenNames.forEach(name -> stringBuilder.append(name).append(" "));

    if (stringBuilder.toString().charAt(stringBuilder.length() - 1) == ' ') {
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
    return stringBuilder.toString();
  }

  public boolean invalidFlag(List<String> flag) {
    return !(flag.contains("--ord=desc")) || !(flag.contains("--ord=asc"));
  }

  public Comparator<String> getComparator(List<String> flag) {
    if (flag.get(0).equals("--ord=asc")) {
      return Comparator.naturalOrder();
    } else {
      return Comparator.reverseOrder();
    }
  }
}
