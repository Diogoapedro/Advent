import java.io.*;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day1_2.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        int cal1 = 0;
        int cal2 = 0;
        int cal3 = 0;
        int curr = 0;
		while ((line = br.readLine()) != null) {
            if(line.equals("")) {
                if (curr > cal1) {
                    cal3 = cal2;
                    cal2 = cal1;
                    cal1 = curr;
                } else if (curr > cal2) {
                    cal3 = cal2;
                    cal2 = curr;
                } else if (curr > cal3) {
                    cal3 = curr;
                }
                curr = 0;
            }
            else {
                curr += Integer.parseInt(line);
            }
        }
        System.out.println(cal1);
        System.out.println(cal2);
        System.out.println(cal3);
        System.out.println(cal1 + cal2 + cal3);
    }
}