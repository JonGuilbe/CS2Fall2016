/**
 * Created by Jonathan on 10/20/2016.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Beams {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String lasers = stdin.next();
        if(lasers.length() < 2 )
            System.out.println("0");
        else {
            int sum = 0;
            List<Character> list = lasers.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());

            for (int i = 0; i < list.size() - 1; i++) {
                if(i == 0)
                    if(list.get(i) == list.get(list.size()-1)){
                        list.remove(i);
                        list.remove(list.size()-1);
                        sum++;
                        i--;
                }
                else{
                        if(list.get(i) == list.get(i + 1)){
                            list.remove(i);
                            list.remove(i + 1);
                            sum++;
                            i--;
                        }
                    }

            }
            sum+= list.size() / 2;
            System.out.println(sum);
        }

    }

}
