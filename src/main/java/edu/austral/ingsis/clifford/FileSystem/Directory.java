package edu.austral.ingsis.clifford.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
  public String name;

  public List<FileSystem> childrenFile;

  public Directory parent;

  public Directory(String name) {
    this.name = name;
    this.childrenFile = new ArrayList<>();
  }

  private Directory(String name, Directory parent, List<FileSystem> childrenFile) {
    this.name = name;
    this.parent = parent;
    this.childrenFile = childrenFile;
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
    this.childrenFile.add(file);
    file.setParent(this);
  }

  public void removeFile(String name){
    for (FileSystem file : this.childrenFile) {
      if (file.getName().equals(name)) {
        this.childrenFile.remove(file);
        return;
      }
    }
  }

  public List<FileSystem> getChildrenFile() {
    return childrenFile;
  }

  public void addChild (FileSystem file){
    FileSystem copyFile = file;
    if (file instanceof Directory directory){
      copyFile = new Directory(directory.getName(), directory.parent, directory.getChildrenFile());
    }
    else if (file instanceof File file1){
      copyFile = new File(file1.getName(), file1.parent);
    }
    childrenFile.add(copyFile);
  }

  public FileSystem getChild(String name){
    return childrenFile.stream().filter(file -> file.getName().equals(name)).findFirst().orElse(null);
  }

  public void removeChild(String file){
    childrenFile.removeIf(file1 -> file1.getName().equals(file));
  }

  public boolean notContains(String name){
    return childrenFile.stream().noneMatch(file -> file.getName().equals(name));
  }

}
