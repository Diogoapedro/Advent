import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day3.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        int[] oneAppear = new int[12];
		while ((line = br.readLine()) != null) {
            for(int i = 0; i < 12; i++) {
                if(line.charAt(i)=='1') 
                    oneAppear[i]++;
            }
        }
        for(int j:oneAppear) {
            if(j>500)
                System.out.println(1);
            else 
                System.out.println(0);
        }
    }
}
