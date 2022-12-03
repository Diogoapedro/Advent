import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day3.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line[] = new String[3];
        StringBuilder inCommon = new StringBuilder();
        int acc = 0;
		while ((line[0] = br.readLine()) != null) {
            line[1] = br.readLine();
            line[2] = br.readLine();
            for(int j = 0; j < line[0].length(); j++) {
                if(line[1].contains(line[0].substring(j, j + 1))) {
                    inCommon.append(line[0].substring(j, j + 1));
                }
            }
            line[1] = inCommon.toString();
            for(int j = 0; j < line[1].length(); j++) {
                if(!line[2].contains(line[1].substring(j, j + 1))) {
                    inCommon.deleteCharAt(inCommon.indexOf(line[1].substring(j, j + 1)));
                }
            }
            if(Character.isUpperCase(inCommon.charAt(0))) {
                acc += (int) inCommon.charAt(0) - 38;
            } else {
                acc += (int) inCommon.charAt(0) - 96;
            }
            inCommon = new StringBuilder();
        }
        System.out.println(acc);
    }
}
