import java.util.*;
public class Palindrome2{
    static Integer[][] memo;
    static String[][] path;
    static String word;
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        word = stdin.next();
        int length = word.length();
        if (length == 1)
            System.out.println(word);
        else {
            memo = new Integer[length][length];
            path = new String[length][length];
            for (int i = 0; i < length; i++) {
                Arrays.fill(path[i], "");
            }
            rec(0,word.length()-1);
            printString();
        }
    }

    public static int rec(int start, int end){
        if(memo[start][end] != null)
            return memo[start][end];
        if(start == end){
            memo[start][end] = 1;
            path[start][end] = Character.toString(word.charAt(start));
            return memo[start][end];
        }
        else if(start > end) return 0;
        else if(word.charAt(start) == word.charAt(end)){
            memo[start][end] = 2 + rec(start+1, end - 1);
            path[start][end] = path[start+1][end-1] + Character.toString(word.charAt(start));
            return memo[start][end];
        }
        else{
            memo[start][end] =  Math.max(rec(start, end-1), rec(start+1,end));
            int leftLength = path[start][end-1].length();
            int rightLength = path[start+1][end].length();
            if(rightLength == leftLength){
                path[start][end] = path[start][end-1].compareTo(path[start+1][end]) < 1 ? path[start][end-1] : path[start+1][end];
            }
            else
                path[start][end] = leftLength < rightLength ? path[start+1][end] : path[start][end-1];
            return memo[start][end];}
    }

    public static void printString(){
        int wordLength = memo.length - 1;
        int maxLength = memo[0][wordLength];
        int i = 0;
        int j = wordLength;
        ArrayList<String> palindromeList = new ArrayList<>();
        while(true){
            if(memo[i][j] != null && memo[i][j] == maxLength){
                palindromeList.add(buildString(i,j, maxLength));
                j--;
            }
            else{
                if(j == wordLength)
                    break;
                i++;
                j = wordLength;
            }
        }
        Collections.sort(palindromeList);
        System.out.println(palindromeList.get(0));
    }

    public static String buildString(int i, int j, int maxLength){
        if(maxLength % 2 == 0){
            return new StringBuilder(path[i][j]).reverse().toString() + path[i][j];
        }
        else
            return new StringBuilder(path[i][j].substring(1)).reverse().toString() + path[i][j];
    }
}