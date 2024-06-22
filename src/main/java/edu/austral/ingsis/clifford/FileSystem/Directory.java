package edu.austral.ingsis.clifford.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
  public String name;

  public List<FileSystem> childrenFile;

  public Directory parentDirectory;

  public Directory(String name) {
    this.name = name;
    this.childrenFile = new ArrayList<>();
  }

  private Directory(String name, Directory parentDirectory, List<FileSystem> childrenFile) {
    this.name = name;
    this.parentDirectory = parentDirectory;
    this.childrenFile = childrenFile;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Directory getParentDirectory() {
    return parentDirectory;
  }

  @Override
  public void setParentDirectory(Directory parentDirectory) {
    this.parentDirectory = parentDirectory;
  }

  public void addFile(FileSystem file) {
    this.childrenFile.add(file);
    file.setParentDirectory(this);
  }

  public void removeFile(String name) {
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

  public void addChild(FileSystem file) {
    FileSystem copyFile = file;
    if (file instanceof Directory directory) {
      copyFile =
          new Directory(directory.getName(), directory.parentDirectory, directory.childrenFile);
    } else if (file instanceof File file1) {
      copyFile = new File(file1.getName(), file1.parent);
    }
    childrenFile.add(copyFile);
  }

  public FileSystem getChild(String name) {
    return childrenFile.stream()
        .filter(child -> child.getName().equals(name))
        .findFirst()
        .orElse(null);
  }

  public void removeChild(String file) {
    childrenFile.removeIf(fileToRemove -> fileToRemove.getName().equals(file));
  }

  public boolean notContains(String name, Type type) {
    return getChildrenFile().stream()
        .noneMatch(file -> file.getName().equals(name) && equalType(type, file));
  }

  public boolean equalType(Type type, FileSystem child) {
    return type == Type.DIRECTORY ? child instanceof Directory : child instanceof File;
  }
}
