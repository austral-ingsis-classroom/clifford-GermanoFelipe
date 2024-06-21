package edu.austral.ingsis.clifford.FileSystem;

public class File implements FileSystem{
  private String name;

  private Directory parent = null;

  public File(String name) {
    this.name = name;
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
