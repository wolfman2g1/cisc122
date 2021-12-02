import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class counter {
    public static void main(String[] args) throws Exception {
        ArrayList<String> words = new ArrayList<>();
        Map<String, Integer> kv = new HashMap<String, Integer>();
        try {
            // get file path
            Scanner input = new Scanner(System.in);
            System.out.println("please enter path to file");
            String file = input.nextLine();
            // read file
            Scanner reader = new Scanner(new BufferedReader(new FileReader(file)));

            // add words to the arraylist
            while (reader.hasNext()) {
                words.add(reader.nextLine());
            }
        } catch (IOException e) {
            System.out.println(" Looks like the file couldn't be found " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Looks like something broke! " + e.getMessage());
        }
        int count =0;
        for (int i = 0; i < words.size(); i++) { // loop through the array list, and assign index and count to a hashmap
            String index = words.get(i);

            if (kv.containsKey(index)) {

                kv.put(index, kv.get(index) +1);

            } else {
                kv.put(index, 1);
            }

        }
        System.out.println(" Words" + "\t" + "Frequency");
        // loop through the hashmap and print
        for( Map.Entry<String, Integer> values : kv.entrySet()){
            System.out.println(values.getKey() + "\t" + values.getValue());
        }
    }

}
