import java.util.*;
//Split array into 2
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
        }
    }

    public static int rec()
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