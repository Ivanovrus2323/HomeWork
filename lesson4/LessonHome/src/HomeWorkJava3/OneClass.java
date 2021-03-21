package HomeWorkJava3;
import java.util.*;
public class OneClass {
    public static void main(String[] args) {
        String[] alphabet = {"Alpha","Beta","Gamma","Alpha","Epsilon","Zeta","Zeta","Eta","Alpha","Theta","Iota","Kappa"};
            HashMap<String, Integer> words = new HashMap<>();
            for (String x : alphabet) {
                words.put(x, words.getOrDefault(x,0)+1);
            }
            System.out.println(words);
            System.out.println("<----------------->");
            PhoneBook book = new PhoneBook();
            book.addContact("Maks", "242324");
            book.addContact("Bob",  "270977");
            book.addContact("Mike", "3252456");
            book.addContact("Alla", "8714365");
            book.addContact("Bob", "337737");
            book.addContact("Rick", "127733");
            book.addContact("Maks","8899661");
            book.addContact("Gosha","532234");

            book.findAndPrint("Bob");
            book.findAndPrint("Rick");
        }
    }

