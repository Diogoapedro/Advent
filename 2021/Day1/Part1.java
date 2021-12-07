import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day1.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        int count = 0;
        int track;
        line = br.readLine();
        track = Integer.parseInt(line);
		while ((line = br.readLine()) != null) {
            if (Integer.parseInt(line) > track)
                count++;
            track = Integer.parseInt(line);
        }
        System.out.println(count);
    }
}
