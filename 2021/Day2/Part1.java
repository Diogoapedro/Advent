import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day2.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        int depth = 0;
        int distance = 0;
		while ((line = br.readLine()) != null) {
            String[] x = line.split(" ");
            System.out.println(x[0]);
            if (x[0].equals("forward"))
                distance += Integer.parseInt(x[1]);
            else if (x[0].equals("up"))
                depth -= Integer.parseInt(x[1]);
            else
                depth += Integer.parseInt(x[1]);
        }
        System.out.println(distance*depth);
    }
}
