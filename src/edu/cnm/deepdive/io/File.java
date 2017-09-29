package edu.cnm.deepdive.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class File {

  private static final String FILENAME ="largest-product-data.txt";

  public static String[] getLines(String filename)
      throws FileNotFoundException, IOException {

    try (
        FileInputStream inStream = new FileInputStream(filename);
        InputStreamReader reader = new InputStreamReader(inStream);
        BufferedReader buffer = new BufferedReader(reader);
    ) {
      List<String> lines = new LinkedList<>();
      for (String line = buffer.readLine();
          line != null;
          line = buffer.readLine()) {
        line = line.trim();
        if (!line.isEmpty()) {
          lines.add(line);
        }
      }
      return lines.toArray(new String[0]);
    }
  }

  public static void main(String[] args) {
    try {
      for (String line : getLines(FILENAME)) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
