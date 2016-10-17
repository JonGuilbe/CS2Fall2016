import java.util.*;

//Rules:
//STRICTLY Decreasing order except for the last 2 letters
//Must match length
//No a, e, i, o, u, or y.
//Gonna take some working out, not something I can quickly do now...
public class XKCD{

    static boolean terribleProgramming = false;
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int length = stdin.nextInt();

        if(length > 20){
            System.out.println("Mostly Harmless");
        }
        else{
            Integer[] word = new Integer[length];
            answer(word, length, 0, 0);
        }
        
    } 
    
    public static void answer(Integer[] word, int length, int i, int sum){
        if(i == length && sum == 42)
            printWord(word);
        //this sum won't work, will it?
        for(int j = 26; j > 2; j--){
            if(j == 25 || j == 21 || j == 15 || j == 9 || j == 5)
                j++;
            if(sum + j <= 42){
                word[i] = j;
                sum += j;
                answer(word, length, i + 1, sum);
                sum -= j;
            }
        }
    }

    public static void printWord(Integer[] word){
        terribleProgramming = true;
        System.out.println("yes");
    }
}