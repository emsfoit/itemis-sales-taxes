package itemis.sales.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceItem {
    public String originalItemString;
    public String name;
    public Boolean imported;
    public float price;
    public boolean taxFree;
    public int count;
    public InvoiceItem(String item) {
        this.originalItemString = item;
        String[] splittedString = item.split(" ");
        boolean imported = item.toLowerCase().contains("imported");
        int count = Integer.parseInt(splittedString[0]);
        float price = Float.parseFloat(splittedString[splittedString.length - 1]);

        String[] newArray = new String[splittedString.length - 2];

        // Copy elements except the first and last ones to the new array
        System.arraycopy(splittedString, 0, newArray, 0, splittedString.length - 2);

        // Join the elements in the new array into a single string
        String name = String.join(" ", newArray);
        boolean taxFree = isTaxFree(item);

        this.imported = imported;
        this.count = count;
        this.name = name;
        this.price = price;
        this.taxFree = taxFree;
    }

    private boolean isTaxFree(String item) {
        List<String> taxFreeItemsArr = new ArrayList<>();

        // Specify the path to your CSV or text file
        String filePath = "./src/main/java/itemis/sales/model/taxfree_items.txt"; // Change to your file path

        // Read and initialize the list from the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Add each line (food item) to the taxFreeItemsArr
                taxFreeItemsArr.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String word : taxFreeItemsArr) {
            if(item.toLowerCase().contains(word.toLowerCase())) return true;
        }
        return false;
    }
}