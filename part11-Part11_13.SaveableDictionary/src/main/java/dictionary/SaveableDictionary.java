package dictionary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {

    //private String file;
    private File file;
    private HashMap<String, String> dictionary;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary (String file) {
        this.dictionary = new HashMap<>();
        this.file = new File(file);
    }
    public void add(String words, String translation) {
        this.dictionary.putIfAbsent(words, translation);
    }

    public String translate(String word) {
        for (String item : this.dictionary.keySet()) {
            if (this.dictionary.get(item).equals(word)) {
                return item;
            } else if (this.dictionary.get(word) != null) {
                return this.dictionary.get(word);
            }
        }

        return null;
    }

    public void delete(String word) {
        String toBeRemoved = "";
        for (String item : this.dictionary.keySet()) {
            if (this.dictionary.get(item).equals(word)) {
                toBeRemoved = item;
            } else if (this.dictionary.get(word) != null) {
                toBeRemoved = word;
            }
        }

        this.dictionary.remove(toBeRemoved);

    }

    public boolean save() {
        try {
            PrintWriter pw = new PrintWriter(this.file.getName());
            for (String s : this.dictionary.keySet()) {
                String word = s;
                String translation = this.dictionary.get(s);
                pw.println(word + ":" + translation);
            }

            pw.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean load() {

        try {
            Scanner fileReader = new Scanner(Paths.get("words.txt"));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");   // split the line based on the ':' character

                //add to the dictionary.
                this.dictionary.put(parts[0], parts[1]);
            }
            return true;
        } catch (IOException e) {
            System.out.println("File not read: " + e.getMessage());
            return  false;
        }

    }
}
