import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day1.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        int cal = 0;
        int curr = 0;
		while ((line = br.readLine()) != null) {
            if(line.equals("")) {
                if (curr > cal) {
                    cal = curr;
                }
                curr = 0;
            }
            else {
                curr += Integer.parseInt(line);
            }
        }
        System.out.println(cal);
    }
}