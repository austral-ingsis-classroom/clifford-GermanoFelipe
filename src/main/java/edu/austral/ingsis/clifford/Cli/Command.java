package edu.austral.ingsis.clifford.Cli;

import java.util.List;

public interface Command {
  String execute(List<String> arguments);
}
