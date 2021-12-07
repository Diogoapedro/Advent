import java.io.*;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day7.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line = br.readLine();
        String[] linha = line.split(",");
        ArrayList<Integer> nums = new ArrayList<>();
        long lowest = 999999999;
        int aux = 0;
        for (String a:linha) {
            nums.add(Integer.parseInt(a));
        }
        int small = nums.get(0);
        int big = nums.get(0);
        for (int i : nums) {
            if (i < small) {
                small = i;
            } else if (i > big) {
                big = i;
            }
        }
        for (int k = small; k < big; k++) {
            aux = 0;
            for (int j : nums) {
                aux += calc(Math.abs(j-k), 0) ;
            }
            if (aux < lowest) 
                lowest = aux;
        }
        System.out.println(lowest);
    }
    private static int calc (int a, int b) {
        if(a != 0) { 
            return calc(a-1, b+a);
        }
        return b;
    }
}
