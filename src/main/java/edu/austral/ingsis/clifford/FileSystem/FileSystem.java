package edu.austral.ingsis.clifford.FileSystem;

public interface FileSystem {
  public String getName();

  public Directory getParentDirectory();

  public void setParentDirectory(Directory parentDirectory);
}
