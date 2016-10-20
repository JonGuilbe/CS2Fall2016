import java.util.*;
//Split array into 2   164    3
public class Palindrome{
    static Integer[][] memo;
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String word = stdin.next();
        if (word.length() == 1)
            //Prevents any potential sneaky test cases
            System.out.println(1);
        else if(word.length() == 2){
            System.out.println(0);
        }
        else {
            memo = new Integer[word.length()][word.length()];
            System.out.println(rec(0,word.length()-1,word));
        }
    }

    public static int rec(int start, int end, String word){
        if(memo[start][end] != null)
            return memo[start][end];
        if(start == end){
            //System.out.println("Start is " + start + " and end is " + end);
            return 1;
        }
        else if(start > end) return 0;
        else if(word.charAt(start) == word.charAt(end)){
            memo[start][end] = 2 + rec(start+1, end - 1, word);
            return memo[start][end];
        }
        else{
            memo[start][end] =  Math.max(rec(start, end-1,word), rec(start+1,end,word));
            return memo[start][end];}
    }
    /*
    public static int rec(int i, int j)
   {
      if (i == wordLeft.length() || j == wordRight.length())
         return 0;

      if (memo[i][j] != null)
         return memo[i][j];

       //copypasta code is bad code >:(
      choice[i][j] = 1;
      int result = rec(i+1, j);

      int result2 = rec(i, j+1);
      if (result2 > result)
      {
         choice[i][j] = 2;
         result = result2;
      }

      if (left.charAt(i) == right.charAt(j))
      {
         int result3 = 1+rec(i+1, j+1);
         if (result3 > result)
         {
            choice[i][j] = 3;
            result = result3;
         }
      }

      memo[i][j] = result;
      return result;
   }
   */

}