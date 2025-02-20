import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Part2 {
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
        boolean oneFalse = false;
		while ((line = br.readLine()) != null) {
            numLines++;
            String[] levels = line.split(" ");
            oneFalse = false;
            if(Integer.parseInt(levels[0]) == Integer.parseInt(levels[1])) {
                oneFalse = true;
                inc = Integer.parseInt(levels[1]) < Integer.parseInt(levels[2]);
            } else {
                inc = Integer.parseInt(levels[0]) < Integer.parseInt(levels[1]);
            }
            for (int i = 0; i < levels.length - 1; i++) {
                diff = Integer.parseInt(levels[i+1]) - Integer.parseInt(levels[i]);
                if(!((inc && diff<4 && diff > 0) || ((!inc) && diff>-4 && diff < 0))) {
                    if(oneFalse == false) {
                        if (i >= levels.length - 2){
                            continue;
                        }
                        diff = Integer.parseInt(levels[i+2]) - Integer.parseInt(levels[i]);
                        if(i == 0) {
                            inc = Integer.parseInt(levels[0]) < Integer.parseInt(levels[2]);
                        }
                        if(!((inc && diff<4 && diff > 0) || ((!inc) && diff>-4 && diff < 0)))
                        oneFalse = true;
                    } else {
                        System.out.println(String.format("num1: %s, num2: %s, diff: %d " + inc, levels[i], levels[i+1], diff));
                        System.out.println(Arrays.asList(levels));
                        unsafe++;
                        break;
                    }
                }
            }
        }
        System.out.println(numLines - unsafe + " " + numLines);
    }
}