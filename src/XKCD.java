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
        else(){

        }
        
    } 
    
    public static void answer(Integer[] word, int length, int i){
        if(i == length)
            printWord(word);
        //this sum won't work, will it?
        int sum = 0;
        for(int j = 26; j > 2; j--){
            if(sum + j <= 42)
        }

    }

    public static void printWord(Integer[] word){
        terribleProgramming = true;
        System.out.println("yes");
    }
}