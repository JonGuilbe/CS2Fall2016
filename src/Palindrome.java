import java.util.*;
//Split array into 2   164    3
public class Palindrome{
    static Integer[][] memo;
    static String[][] path;
    static String word;
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        word = stdin.next();
        if (word.length() == 1)
            //Prevents any potential sneaky test cases
            System.out.println(1);
        else {
            memo = new Integer[word.length()][word.length()];
            path = new String[word.length()][word.length()];
            System.out.println(rec(0,word.length()-1));
            System.out.println("Top row of the memo table: " + Arrays.toString(memo[0]));
            System.out.println("Top row of the string table: " + Arrays.toString(path[0]));
            System.out.println("2Top row of the memo table: " + Arrays.toString(memo[1]));
            System.out.println("2Top row of the string table: " + Arrays.toString(path[1]));
            printString();
            //backtrack(word);
        }
    }

    public static int rec(int start, int end){
        if(memo[start][end] != null)
            return memo[start][end];
        if(start == end){
            //System.out.println("Start is " + start + " and end is " + end);
            memo[start][end] = 1;
            path[start][end] = Character.toString(word.charAt(start));
            //System.out.println(path[start][end]);
            return memo[start][end];
        }
        else if(start > end) return 0;
        else if(word.charAt(start) == word.charAt(end)){
            memo[start][end] = 2 + rec(start+1, end - 1);
            path[start][end] = path[start+1][end-1] + Character.toString(word.charAt(start));
            //System.out.println(path[start][end]);
            return memo[start][end];
        }
        else{ //Broke something here...
            memo[start][end] =  Math.max(rec(start, end-1), rec(start+1,end));
            if (path[start + 1][end] != null || path[start][end-1] != null) {
                int rightLength;
                int leftLength;
                if(path[start + 1][end] != null){
                    rightLength = path[start+1][end].length();}
                else{
                    rightLength = 0;}
                if(path[start][end-1] != null){
                    leftLength = path[start][end-1].length();}
                else{
                    leftLength = 0;}
                if (rightLength == leftLength) {
                    if (path[start + 1][end] != null && new StringBuilder(path[start + 1][end]).reverse().toString().compareTo(new StringBuilder(path[start][end - 1]).reverse().toString()) == 1) {
                        path[start][end] = path[start + 1][end];
                    }
                    else
                        path[start][end] = path[start][end-1];
                    }
            }
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
        System.out.println(palindromeList);
    }

    public static String buildString(int i, int j, int maxLength){
        if(maxLength % 2 == 0){
            return new StringBuilder(path[i][j]).reverse().toString() + path[i][j];
        }
        else
            return new StringBuilder(path[i][j].substring(1)).reverse().toString() + path[i][j];
    }

    /*public static void backtrack(String word){
        char[] palindromeWord = new char[memo[0][word.length()-1]];
        int index = palindromeWord.length - 1;
        int length = index;
        for(int j = memo.length-1, i = 0; i < memo.length && j > 0;){
            if(memo[i][j] == 1){
                palindromeWord[index] = word.charAt(j);
                break;
            }
            else if(memo[i][j] == 2 + memo[i+1][j-1]){
                palindromeWord[index] = word.charAt(j);
                palindromeWord[length - index] = word.charAt(j);
                index--;
                i++;
                j--;

            }
            else{
                if(memo[i][j-1] == memo[i][j]){
                    j--;
                }
                else
                    i++;
            }
        }
        System.out.println(Arrays.toString(palindromeWord));
    }  */


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
      {5
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