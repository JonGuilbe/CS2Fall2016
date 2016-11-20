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
            for (int i = 0; i < length; i++) {
                if(length == 1)
                    break;
                if(i == 0 || i == length - 1) {
                    if (list.get(0).equals(list.get(length - 1))) {
                        list.remove(0);
                        list.remove(list.size() - 1);
                        length -= 2;
                        sum++;
                        i--;
                    }
                }
                if(i < length - 1 && i > -1 && list.get(i) == list.get(i + 1)){
                    list.remove(i);
                    list.remove(i + 1);
                    sum++;
                    i--;
                    length -= 2;
                }
            }
            if(length > 1)
                sum+= length / 2 - 1;

            System.out.println(sum);
        }

    }

}
