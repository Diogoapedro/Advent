import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        int valid = 0;
        long count = 0;
        File file = new File("Day1.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
		while ((line = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(line," ");
            String nums = token.nextToken();
            String[] n = nums.split("-");
            char letra = token.nextToken().charAt(0);
            String pass = token.nextToken();
            count = countChar(pass, letra);
            // System.out.println(Integer.parseInt(n[0]));
            if (Integer.parseInt(n[0]) <= count && Integer.parseInt(n[1]) >= count) {
                valid++;
            }   
        }
        System.out.println(valid);
    }
    public static int countChar(String str, char c){
        int count = 0;
        for(int i=0; i < str.length(); i++) {
            if(str.charAt(i) == c)
                count++;
        }
        return count;
    }
} 