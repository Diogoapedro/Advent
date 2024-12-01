import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day1.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        line = "";
        PriorityQueue<Integer> list1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> list2 = new PriorityQueue<Integer>();
		while ((line = br.readLine()) != null) {
            String[] list = line.split("   ");
            list1.add(Integer.parseInt(list[0]));
            list2.add(Integer.parseInt(list[1]));
        }
        int finalValue = 0;
        for (int i = 0; !list1.isEmpty(); i++) {
            //System.out.println(list1.peek() + " " + list2.peek() + " " + Math.abs(list1.peek() - list2.peek()));
            finalValue += Math.abs(list1.poll() - list2.poll());
        }
        System.out.println(finalValue);
    }
}