/**
 * Created by reneg on 9/11/2016.
 */
import java.util.*;
import java.io.*;

public class TestCaseCreator {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.print("Insert File Name Here: ");
        String fileName = stdin.nextLine();

        System.out.print("\n Array Size: ");
        int arraySize = stdin.nextInt();
        //int array[] = new int[arraySize];

        System.out.println("\nRandom Number Range, 0 to :");
        int highRange = stdin.nextInt();

        Random random = new Random();

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName + ".txt")))) {
            writer.write(arraySize + " ");
            writer.write(arraySize + " ");
            writer.write(100000);
            for (int i = 0; i < arraySize - 1; i++) {
                writer.write((random.nextInt(highRange - 1) + 1) + " ");
            }
            writer.write(100000);
            for (int i = 0; i < arraySize - 1; i++) {
                writer.write((random.nextInt(highRange - 1) + 1) + " ");
            }
        }
        catch(Exception e){
            System.out.println("Something went wrong!");
        }

        System.out.println("Done!");
    }
}
