import java.io.*;
import java.util.*;

public class Part1 {
    
    public static void main(String[] args) throws Exception {
        File file = new File("Day4.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int acc = 0;
		while ((line = br.readLine()) != null) {
            String[] sections = line.split(",");
            String[] range1 = sections[0].split("-");
            String[] range2 = sections[1].split("-");
            if(((Integer.parseInt(range1[0]) <= Integer.parseInt(range2[0])) && (Integer.parseInt(range1[1]) >= Integer.parseInt(range2[1]))) ||
                ((Integer.parseInt(range1[0]) >= Integer.parseInt(range2[0])) && (Integer.parseInt(range1[1]) <= Integer.parseInt(range2[1])))) {
                acc++;
            } else if ((Integer.parseInt(range1[1]) >= Integer.parseInt(range2[0]) && Integer.parseInt(range1[1]) <= Integer.parseInt(range2[1])) || 
                (Integer.parseInt(range2[1]) >= Integer.parseInt(range1[0]) && Integer.parseInt(range2[1]) <= Integer.parseInt(range1[1])))  {
                acc++;
            }
        }
        System.out.println(acc);
    }
}
