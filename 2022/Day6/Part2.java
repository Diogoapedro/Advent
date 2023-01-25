import java.io.*;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day6.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line = br.readLine();
        
        StringBuilder strb = new StringBuilder();
        int counter = 14;

        strb.append(line.substring(0, 14));

        for(int i = 14; i < line.length() && !valid(strb); i++) {                

            strb.deleteCharAt(0);
            strb.append(line.charAt(i));
            counter++;
            //System.out.println(strb.toString());
        }

        System.out.println(counter);

    }

    public static boolean valid(StringBuilder sb) { //verifica se todos os caracter são diferentes

        for (int i = 0; i < sb.length(); i++) {
            if((sb.substring(i+1)).indexOf(sb.substring(i, i+1)) != -1) {

                return false;

            }

        }

        return true;

    }

}