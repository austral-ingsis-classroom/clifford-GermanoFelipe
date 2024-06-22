package edu.austral.ingsis.clifford.FileSystem;

import edu.austral.ingsis.clifford.Cli.Cli;
import java.util.Comparator;

public class FileComparator implements Comparator<String> {

  public Cli cli;

  public FileComparator(Cli cli) {
    this.cli = cli;
  }
  @Override
  public int compare(String o1, String o2) {
    if (Directory(o1) && Directory (o2)) {
      return index(o1) - index(o2);
    }
    else if (Directory(o1) && !Directory(o2)) {
      return -1;
    }
    else if (!Directory(o1) && Directory(o2)) {
      return 1;
    }
    else {
      return (o1).compareTo(o2);
    }
  }

  public boolean Directory(String name){
    return cli.currentDirectory.getChild(name) instanceof Directory;
  }

  public int index(String name1){
    return cli.currentDirectory.getChildrenFile().indexOf(cli.currentDirectory.getChild(name1));
  }
}
