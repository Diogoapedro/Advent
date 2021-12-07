import java.io.*;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day1.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        int count = 0;
        int helper = 0;
        int helper2 = 0;
        int helper3 = 0;
        int track = 0;
        int track1 = 0;
        int track2 = 0;
        int track3 = 0;
        int teste = 0;
        line = br.readLine();
        track1 += Integer.parseInt(line);
        line = br.readLine();
        track1 += Integer.parseInt(line);
        track2 += Integer.parseInt(line);
        helper = 2;
        helper2 = 1;
		while ((line = br.readLine()) != null) {
            track = Integer.parseInt(line);
            track1 += track;
            helper++;
            track2 += track;
            helper2++;
            track3 += track;
            helper3++;
            if (helper == 3) {
                helper = 0;
                if (teste > 0) {
                    if (track1 > teste) {
                        count++;
                    }
                    teste = track1;
                    track1 = 0;
                } else 
                    teste = track1;
                    track1 = 0;
            }
            if (helper2 == 3) {
                helper2 = 0;
                if (teste > 0) {
                    if (track2 > teste) {
                        count++;
                    }
                    teste = track2;
                    track2 = 0;
                }
            }
            if (helper3 == 3) {
                helper3 = 0;
                if (teste > 0) {
                    if (track3 > teste) {
                        count++;
                    }
                    teste = track3;
                    track3 = 0;
                }
            }
        }
        System.out.println(count);
    }
}
