package edu.austral.ingsis.clifford.FileSystem;

public interface FileSystem {
  public String getName();

  public Directory getParent();

  public void setParent(Directory parent);
}
