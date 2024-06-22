package edu.austral.ingsis.clifford.FileSystem;

public class File implements FileSystem {
  private final String name;

  public Directory parent;

  public File(String name) {
    this.name = name;
  }

  protected File(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Directory getParentDirectory() {
    return parent;
  }

  @Override
  public void setParentDirectory(Directory parentDirectory) {
    this.parent = parentDirectory;
  }
}
