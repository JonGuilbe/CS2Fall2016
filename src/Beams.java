/**
 * Created by Jonathan on 10/20/2016.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Beams {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String lasers = stdin.next();
        int length = lasers.length();
        if(length < 2 )
            System.out.println("0");
        else {
            int sum = 0;
            List<Character> list = lasers.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());

            /*for (int i = 0; i < list.size() - 1; i++) {
                if(i == 0 || i == list.size() - 1) {
                    if (list.get(i) == list.get(list.size() - 1)) {
                        list.remove(i);
                        list.remove(list.size() - 1);
                        sum++;
                        i--;
                        //System.out.println(list);
                    }
                }
                //else{
                        if(i > -1 && list.get(i) == list.get(i + 1)){
                            list.remove(i);
                            list.remove(i + 1);
                            sum++;
                            i--;
                            //System.out.println(list);
                        }
                    //}
                System.out.println("i is " + i + " list.size is " + list.size());
            } */

            for (int i = 0; i < length; i++) {
                //System.out.println("Before: i is " + i + " list.size is " + length);
                if(length == 1)
                    break;
                if(i == 0 || i == length - 1) {
                    if (list.get(i) == list.get(length - 1)) {
                        list.remove(i);
                        list.remove(list.size() - 1);
                        length -= 2;
                        sum++;
                        i--;
                        //System.out.println(list);
                    }
                }
                //else{
                if(i < length && i > -1 && list.get(i) == list.get(i + 1)){
                    list.remove(i);
                    list.remove(i + 1);
                    sum++;
                    i--;
                    length -= 2;
                    //System.out.println(list);
                }
                boolean loop = i + 1 < length - 1;
                //System.out.println("After: i is " + i + " list.size is " + length + " should the loop run again? " + loop);

                //}

            }

            sum+= length / 4;
            System.out.println(sum);
        }

    }

}
