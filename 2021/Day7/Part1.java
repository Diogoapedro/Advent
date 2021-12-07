import java.io.*;
import java.util.*;

public class Part1 {
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
                aux += Math.abs(j-k);
            }
            if (aux < lowest) 
                lowest = aux;
        }
        System.out.println(lowest);
    }
}
