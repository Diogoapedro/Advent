import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day8.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        String[] linha;
        int count = 0; 
		while ((line = br.readLine()) != null) {
            linha = line.split(" ");
            for (int i = 11; i < 15; i++) {
                if(linha[i].length() == 2 || linha[i].length() == 3 || linha[i].length() == 4 || linha[i].length() == 7)
                    count++;
            }
        }
        System.out.println(count);
    }
}
