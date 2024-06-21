package edu.austral.ingsis.clifford.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
  private String name;

  private ArrayList<FileSystem> file;

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

  public void addFile(FileSystem file) {
    this.file.add(file);
    file.setParent(this);
  }

  public void removeFile(String name){
    for (FileSystem file : this.file) {
      if (file.getName().equals(name)) {
        this.file.remove(file);
        return;
      }
    }
  }

  public ArrayList<FileSystem> getFiles(){
    return file;
  }
  public FileSystem getFile(String name){
    for (FileSystem file : this.file) {
      if (file.getName().equals(name)) {
        return file;
      }
    }
    return null;
  }

}
