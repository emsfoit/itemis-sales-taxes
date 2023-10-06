package itemis.sales.controllers;

import itemis.sales.model.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class InvoiceController {
    @PostMapping("/getInvoice")
    public String getInvoice(@RequestBody Map<String, List<String>> requestBody) {
        try {
            List<String> items = requestBody.get("items");
            Invoice inv = new Invoice(items);
            return inv.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
