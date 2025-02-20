import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Part1 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day2.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        line = "";
        boolean inc = true;
        int diff = 0;
        int unsafe = 0;
        int numLines = 0;
		while ((line = br.readLine()) != null) {
            numLines++;
            String[] levels = line.split(" ");
            if(Integer.parseInt(levels[0]) == Integer.parseInt(levels[1])) {
                unsafe++;
                continue;
            }
            inc = Integer.parseInt(levels[0]) < Integer.parseInt(levels[1]);
            for (int i = 0; i < levels.length - 1; i++) {
                diff = Integer.parseInt(levels[i+1]) - Integer.parseInt(levels[i]);
                if(!((inc && diff<4 && diff > 0) || ((!inc) && diff>-4 && diff < 0))) {
                    System.out.println(String.format("num1: %s, num2: %s, diff: %d " + inc, levels[i], levels[i+1], diff));
                    System.out.println(Arrays.asList(levels));
                    unsafe++;
                    break;
                }
            }
        }
        System.out.println(numLines - unsafe + " " + numLines);
    }
}