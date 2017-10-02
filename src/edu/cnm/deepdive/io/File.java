package edu.cnm.deepdive.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class File {

  private static final String FILENAME ="largest-product-data.txt";

  public static String[] getLines(String filename)
      throws IOException {

    // try with resources
    try (
        FileInputStream inStream = new FileInputStream(filename);
        InputStreamReader reader = new InputStreamReader(inStream);
        BufferedReader buffer = new BufferedReader(reader)
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

  public static int[][] getMatrix(String[] lines, String delimiter) {
    // allocates space for the references for each row
    int[][] data = new int[lines.length][];
    for(int i = 0; i < lines.length; i++) {
      // use the delimiter to use as the template for my chunks.
      String[] parts = lines[i].split(delimiter);
      int[] row = new int[parts.length];
      // loop to go across the columns
      for (int j = 0; j < parts.length; j++) {
        row[j] = Integer.parseInt(parts[j]);
      }
      data[i] = row;
    }
    return data;
  }

  public static void main(String[] args)
      throws IOException {
//    try {
//      for (String line : getLines(FILENAME)) {
//        System.out.println(line);
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
    for (int[] row : getMatrix(getLines(FILENAME), "\\s+")) {
      // Arrays.toString places arrays into brackets
      // because java sucks at printing multi-dimensional arrays
      System.out.println(Arrays.toString(row));
    }
  }

}
