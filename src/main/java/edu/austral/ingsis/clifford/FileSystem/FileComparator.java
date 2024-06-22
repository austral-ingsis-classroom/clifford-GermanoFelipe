package edu.austral.ingsis.clifford.FileSystem;

import edu.austral.ingsis.clifford.Cli.Cli;
import java.util.Comparator;

public class FileComparator implements java.util.Comparator {

  public Cli cli;

  public FileComparator(Cli cli) {
    this.cli = cli;
  }
  @Override
  public int compare(Object o1, Object o2) {
    if (Directory((String) o1) && Directory((String) o2)) {
      return index((String) o1) - index((String) o2);
    }
    else if (Directory((String) o1) && !Directory((String) o2)) {
      return -1;
    }
    else if (!Directory((String) o1) && Directory((String) o2)) {
      return 1;
    }
    else {
      return ((String) o1).compareTo((String) o2);
    }
  }

  public int index(String name1){
    return cli.currentDirectory.getChildrenFile().indexOf(cli.currentDirectory.getChild(name1));
  }

  public boolean Directory(String name){
    return cli.currentDirectory.getChild(name) instanceof Directory;
  }
}
