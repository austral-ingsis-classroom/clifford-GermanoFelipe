package edu.austral.ingsis.clifford.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
  private String name;

  private List<FileSystem> file;

  private Directory parent;

  public Directory(String name, List<FileSystem> file) {
    this.name = name;
    this.file = new ArrayList<>();
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
