package itemis.sales.controllers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceControllerTest {

    @Test
    void getInvoiceInput1() {
        InvoiceController controller = new InvoiceController();
        // Define a Map<String, List<String>> to store items
        Map<String, List<String>> itemMap = new HashMap<>();

        // Sample data
        List<String> items = new ArrayList<>();
        items.add("1 book at 12.49");
        items.add("1 music CD at 14.99");
        items.add("1 chocolate bar at 0.85");

        // Add the items to the map with a key "items"
        itemMap.put("items", items);
        String res = controller.getInvoice(itemMap);

        String expected = "1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83";
        // Assert
        assertEquals(expected, res);
    }

    @Test
    void getInvoiceInput2() {
        InvoiceController controller = new InvoiceController();
        // Define a Map<String, List<String>> to store items
        Map<String, List<String>> itemMap = new HashMap<>();

        // Sample data
        List<String> items = new ArrayList<>();
        items.add("1 imported box of chocolates at 10.00");
        items.add("1 imported bottle of perfume at 47.50");
        // Add the items to the map with a key "items"
        itemMap.put("items", items);
        String res = controller.getInvoice(itemMap);

        String expected = "1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15";
        // Assert
        assertEquals(expected, res);
    }
    @Test
    void getInvoiceInput3() {
        InvoiceController controller = new InvoiceController();
        // Define a Map<String, List<String>> to store items
        Map<String, List<String>> itemMap = new HashMap<>();

        // Sample data
        List<String> items = new ArrayList<>();
        items.add("1 imported bottle of perfume at 27.99");
        items.add("1 bottle of perfume at 18.99");
        items.add("1 packet of headache pills at 9.75");
        items.add("1 box of imported chocolates at 11.25");

        // Add the items to the map with a key "items"
        itemMap.put("items", items);
        String res = controller.getInvoice(itemMap);

        String expected = "1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 box of imported chocolates: 11.85\n" +
                "Sales Taxes: 6.70\n" +
                "Total: 74.68";
        // Assert
        assertEquals(expected, res);
    }
}