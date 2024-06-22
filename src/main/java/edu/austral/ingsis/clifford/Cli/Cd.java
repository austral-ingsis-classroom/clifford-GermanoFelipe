package edu.austral.ingsis.clifford.Cli;

import java.util.List;

public class Cd implements Command{

  public Cli cli;

  public Cd (Cli cli){
    this.cli = cli;
  }

  @Override
  public String execute(List<String> flag, List<String> arguments) {
    return null;
  }
}
