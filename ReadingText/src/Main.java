import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList <String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            lines.add(line);
        }
        br.close();
        System.out.println("Please enter word to be searched");
        String searchWord;
        Scanner scanner = new Scanner(System.in);
        searchWord = scanner.nextLine();
        ArrayList <Integer> indices = searchForWord (lines, searchWord);
        for (Integer index : indices){
            System.out.println(index + 1);
        }
    }

    public static ArrayList <Integer> searchForWord (ArrayList <String> lines, String searchWord) {
        ArrayList <Integer> lineIndices = new ArrayList<>();
        for (int i = 0; i < lines.size(); i ++ ){
            String line = lines.get(i);
            if (line.contains(searchWord)){
                lineIndices.add(i);
            }
        }
        return lineIndices;
    }




}