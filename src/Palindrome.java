import java.util.*;
public class Palindrome{
    static Integer[][] memo;
    static String[][] path;
    static String word;
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        word = stdin.next();
        int length = word.length();
        if (length == 1)
            //Prevents any potential sneaky test cases
            System.out.println(1);
        else {
            memo = new Integer[length][length];
            path = new String[length][length];
            for (int i = 0; i < length; i++) {
                Arrays.fill(path[i], "");
            }
            System.out.println(rec(0,word.length()-1));
        }
    }

    public static int rec(int start, int end){
        if(memo[start][end] != null)
            return memo[start][end];
        if(start == end){
            memo[start][end] = 1;
            return memo[start][end];
        }
        else if(start > end) return 0;
        else if(word.charAt(start) == word.charAt(end)){
            memo[start][end] = 2 + rec(start+1, end - 1);
            return memo[start][end];
        }
        else{
            memo[start][end] =  Math.max(rec(start, end-1), rec(start+1,end));
            return memo[start][end];}
    }



}