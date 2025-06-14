package edu.icet.ecom;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  FileWriter;
        //  BufferedReader
        writeInFileWithFileWriter();
        writeInFileWithBufferedReader();


            System.out.println(readingUsingBuffer());


    }


    // File Writer
    public static void writeInFileWithFileWriter() {

        FileWriter writer = null;
        try {
            writer = new FileWriter("output.txt", true);
            writer.write("Hello World");
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // BufferedWriter
    public static void writeInFileWithBufferedReader() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("outputBuffer.txt", true));
            writer.write("write with BufferedWriter");
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Scanner -> Reader
    public static String readUsingScanner() {

        StringBuilder builder = new StringBuilder();
        File file = new File("outputBuffer.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                builder.append(line);
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public static String readingUsingBuffer()  {
        StringBuilder builder = new StringBuilder();

        try {

            BufferedReader bufferedReader = null;
            String line;

            bufferedReader = new BufferedReader(new FileReader("outputBuffer.txt"));

            while((line = bufferedReader.readLine()) != null){
                builder.append(line);
            }
            bufferedReader.close();
            return builder.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}