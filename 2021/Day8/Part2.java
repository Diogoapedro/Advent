import java.io.*;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day8.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        String[] linha;
        int[] uniquePos = new int[10];
        String[] solPos = new String[7];
        StringBuilder sb;
        int count = 0;
		while ((line = br.readLine()) != null) {
            linha = line.split(" ");
            solPos = new String[7];
            for (int i = 0; i < 10; i++) {
                if(linha[i].length() == 2)
                    uniquePos[1] = i;
                else if (linha[i].length() == 3)
                    uniquePos[7] = i;
                else if (linha[i].length() == 4)
                    uniquePos[4] = i;
                else if (linha[i].length() == 7)
                    uniquePos[8] = i;
            }
            solPos[0] = notIn(linha[uniquePos[7]], linha[uniquePos[1]]);
            for (int i = 0; i < 10; i++) {
                if(linha[i].length() == 6) {
                    if(notIn(linha[uniquePos[1]], linha[i]) != "") {
                        solPos[2] = notIn(linha[uniquePos[1]], linha[i]);
                        uniquePos[6] = i;
                    }    
                }
            }
            solPos[5] = notInAr(linha[uniquePos[1]], solPos);
            // System.out.println(Arrays.asList(solPos));

            for (int i = 0; i < 10; i++) {
                if(linha[i].length() == 5) {
                    if(!linha[i].contains(solPos[2])) {
                        uniquePos[5] = i;
                    } else if (!linha[i].contains(solPos[5])) {
                        uniquePos[2] = i;
                    } else {
                        uniquePos[3] = i;
                    }
                }
            }
            solPos[4] = notIn(linha[uniquePos[2]], linha[uniquePos[3]]);
            for (int i = 0; i < 10; i++) {
                if(linha[i].length() == 6) {
                    if(!linha[i].contains(solPos[4])) {
                        uniquePos[9] = i;
                    } else if (i != uniquePos[6])
                        uniquePos[0] = i;
                }
            }
            solPos[3] = notIn(linha[uniquePos[8]], linha[uniquePos[0]]);
            solPos[1] = notIn(linha[uniquePos[5]], linha[uniquePos[3]]);
            solPos[6] = notInAr(linha[uniquePos[8]], solPos);
            
            sb = new StringBuilder();
            for(int p = 11; p < linha.length; p++) {
                sb.append(sol(linha[p], solPos));
                // System.out.println(linha[p]);
                // System.out.println(sb.toString());
            }
            count += Integer.parseInt(sb.toString());
        }
        System.out.println(count);
    }
    private static String notIn (String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (!b.contains(a.substring(i, i+1)))
                return a.substring(i, i+1);
        }
        return "";
    }
    private static String notInAr (String a, String[] c) {
        for (int i = 0; i < a.length(); i++) {
            if(!Arrays.asList(c).contains(a.substring(i, i+1)))
                return a.substring(i, i+1);
        }
        return "";
    }
    private static String sol (String a, String[] b) {
        if (a.length() == 2) {
            return "1";
        } else if (a.length() == 4) {
            return "4";
        } else if (a.length() == 3) {
            return "7";
        } else if (a.length() == 7) {
            return "8";
        } else if (a.length() == 5) {
            if (a.contains(b[1])) {
                return "5";
            } else if (a.contains(b[4])) {
                return "2";
            } else {
                return "3";
            }
        } else {
            if (!a.contains(b[3])) {
                return "0";
            } else if (!a.contains(b[2])) {
                return "6";
            } else {
                return "9";
            } 
        }
    }
}
