import java.util.*;
//Split array into 2
public class Palindrome{
    static Integer[][] memo;
    static String wordLeft;
    static String wordRight;
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String word = stdin.next();
        if (word.length() == 1)
            //Prevents any potential sneaky test cases
            System.out.println(1);
        else {
            wordLeft = word.substring(0, word.length() / 2);
            if (word.length() % 2 == 1) {
                int answer = 1;
                wordRight = word.substring(word.length() / 2 + 1, word.length());
            } else {
                int answer = 0;
                wordRight = word.substring(word.length() / 2, word.length());
                {
                    //replace math.max with rec, did this for compile reasons
                    answer += (Math.max(0, wordLeft.length()) * 2);
                }
            }
        }
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