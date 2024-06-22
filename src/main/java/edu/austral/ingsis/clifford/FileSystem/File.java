package edu.austral.ingsis.clifford.FileSystem;

public class File implements FileSystem{
  private String name;

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
  public Directory getParent() {
    return parent;
  }

  @Override
  public void setParent(Directory parent) {
    this.parent = parent;
  }
}
