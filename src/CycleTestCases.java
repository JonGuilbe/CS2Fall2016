import java.io.*;

/**
 * Created by reneg on 11/23/2016.
 */
public class CycleTestCases {
    public static void main(String[] args){
        boolean[][] used = new boolean [1001][1001];
        used[0][0] = true;
        File file = new File("Cycle.txt");
        for (int i = 0; i < 1000; i++) {
            int x = 0, y = 0;
            while(used[x][y]){
                x = (int)(Math.random() * 1000);
                y = x;
                while(y == x)
                    y = (int)(Math.random() * 1001);
            }
            try{
                if(!file.exists())
                    file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(x);
                bw.write(" ");
                bw.write(y);
                bw.close();
            }
            catch(Exception e){
            }
            used[x][y] = true;
        }

    }
}
