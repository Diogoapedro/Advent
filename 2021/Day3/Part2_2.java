import java.io.*;
import java.util.*;


public class Part2_2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day3.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        List<String> bits = new ArrayList<String>();
        List<String> bits2 = new ArrayList<String>();
        int[] oxigen = new int[12];
		while ((line = br.readLine()) != null) {
            bits.add(line);
        }
        
        for(int i = 0; i<11; i++) {
            int[] x = c(bits);
            // System.out.println(x[i]);
            if(x[i] == 1) {
                for (int j = 0; j<bits.size()-1;j++) {
                    if(bits.get(j).charAt(i) == '0') {
                        bits2.add(bits.get(j));
                    }
                }
            } else {
                for (int j = 0; j<bits.size()-1;j++) {
                    if(bits.get(j).charAt(i) == '1') {
                        bits2.add(bits.get(j));
                    }
                }
            }
            bits = new ArrayList<>(bits2);
            System.out.println(bits.size());
            if(bits.size() == 1) {
                System.out.println(bits.get(0));
            }
            bits2.clear();
        }
        System.out.println(bits.size());
    }
    public static int[] c (List<String> b) {
        int[] oneAppear = new int[12];
		for (int j = 0; j < b.size(); j++) {
            for(int i = 0; i < 12; i++) {
                if(b.get(j).charAt(i)=='1') 
                    oneAppear[i]++;
            }
        }
        for(int p = 0; p < 12; p++) {
            if(oneAppear.length == 1) {
                oneAppear[p] = oneAppear[p];
            }
            else if(oneAppear[p] >= b.size()/2)
                oneAppear[p] = 1;
            else
                oneAppear[p] = 0;
        }
        return oneAppear;
    }       
}
