import java.util.*;

//Rules:
//STRICTLY Decreasing order except for the last 2 letters
//Must match length
//No a, e, i, o, u, or y.
//Gonna take some working out, not something I can quickly do now...
public class XKCD{

    static ArrayList<String> words = new ArrayList<>();
    public static void main(String[] args){


        Scanner stdin = new Scanner(System.in);
        int length = stdin.nextInt();

        if(length > 7 || length < 2){
            System.out.println("Mostly Harmless");
        }
        else{
            Integer[] word = new Integer[length];
            answer(word, length, 0, 0, 26);
            printWords();
        }

        // T E S T M O D E
        /*
        for (int i = 0; i < 43; i++) {
            System.out.println("Word size " + i);
            int length = i;

            if(length > 7 || length < 2){
            System.out.println("Mostly Harmless");
        }
        else{
            Integer[] word = new Integer[length];
            answer(word, length, 0, 0, 26);
            printWords();
        }

            System.out.println("\n");
            words.clear();
        }
        */
        
    } 
    
    public static void answer(Integer[] word, int length, int i, int sum, int max){
        if(i == length && sum == 42)
            addWord(word);
        if(i >= length)
            return;
        //this sum won't work, will it?
        for(int j = max; j > 1; j--){
            if(j == 25 || j == 21 || j == 15 || j == 9 || j == 5)
                j--;
            if(sum + j <= 42){
                //System.out.println("Things are happening?");
                word[i] = j;
                sum += j;
                answer(word, length, i + 1, sum, j - 1);
                sum -= j;
            }
        }
    }

    //The words need to be in alphabetical order, ughhhhh
    public static void addWord(Integer[] word){
        int temp = word[word.length - 1];
        word[word.length - 1] = word[word.length - 2];
        word[word.length - 2] = temp;
        String currentWord = "";
        for (int i = 0; i < word.length; i++) {
            currentWord += (char)(96 + word[i]);
        }
        words.add(currentWord);
    }

    public static void printWords(){
        for (int i = words.size() - 1; i >= 0; i--) {
            System.out.println(words.get(i));
        }
    }
}