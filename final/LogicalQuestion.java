import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem
 */
public class LogicalQuestion {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = scn.nextLine();
        System.out.println("Enter space separated list of words");
        String[] words = scn.nextLine().split(" ");
        boolean canForm = canFormUsingWords(str, words);
        System.out.println(canForm);
        scn.close();
    }

    static boolean canFormUsingWords(String str, String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        int size = str.length();
        if (size == 0)
            return true;

        boolean[] wb = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            if (wb[i] == false && set.contains(str.substring(0, i)))
                wb[i] = true;

            if (wb[i] == true) {
                if (i == size)
                    return true;

                for (int j = i + 1; j <= size; j++) {
                    if (wb[j] == false && set.contains(str.substring(i, j)))
                        wb[j] = true;

                    if (j == size && wb[j] == true)
                        return true;
                }
            }
        }

        return false;
    }
}
