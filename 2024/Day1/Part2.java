import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day1.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        line = "";
        Set<Integer> list1 = new HashSet<Integer>();
        HashMap<Integer, Integer> list2 = new HashMap<Integer, Integer>();
		while ((line = br.readLine()) != null) {
            String[] list = line.split("   ");
            list1.add(Integer.parseInt(list[0]));
            int num2 = Integer.parseInt(list[1]);
            if(list2.get(num2) == null) {
                list2.put(num2, 1);
            } else {
                list2.put(num2, list2.get(num2)+1);
            }
        }
        list1.retainAll(list2.keySet());
        int finalValue = 0;
        for (Integer num1 : list1) {
            finalValue += num1*list2.get(num1);
        }
        System.out.println(finalValue);
        
    }
}