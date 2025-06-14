package edu.icet.ecom;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      //  FileWriter;
      //  BufferedReader
        try {
            writeInFileWithFileWriter();
            writeInFileWithBufferedReader();

            System.out.println(readUsingScanner());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    // File Writer
    public static  void writeInFileWithFileWriter() throws IOException {

        FileWriter writer = new FileWriter("output.txt", true);
            writer.write("Hello World");
            writer.write("\n");
            writer.close();

    }

    // BufferedWriter
    public static void writeInFileWithBufferedReader() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("outputBuffer.txt", true));
        writer.write("write with BufferedWriter");
        writer.write("\n");
        writer.close();
    }

    // Scanner -> Reader
    public static String readUsingScanner(){

        StringBuilder builder = new StringBuilder();
        File file = new File("outputBuffer.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
          while(scanner.hasNext()){
              String line = scanner.nextLine();
              builder.append(line);
          }
          return builder.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }







}