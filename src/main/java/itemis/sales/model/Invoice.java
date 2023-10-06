package itemis.sales.model;

import java.util.List;

public class Invoice {
     InvoiceItem[] items;
     public static final int IMPORTED_TAX = 5;
    public static final int NORMAL_TAX = 10;

    public Invoice(List<String> itemDescriptions) {
        this.items = new InvoiceItem[itemDescriptions.size()];
        for (int i = 0; i < itemDescriptions.size(); i++) {
            InvoiceItem itemObj = new InvoiceItem(itemDescriptions.get(i));
            this.items[i] = itemObj;
        }
    }

    @Override
    public String toString() {
        StringBuilder overview = new StringBuilder();
        float taxsum = 0;
        float pricesum = 0;
        for(InvoiceItem item : this.items) {
            int tax = 0;
            if(item.imported) {
                tax += IMPORTED_TAX;
            }
            if(!item.taxFree) {
                tax += NORMAL_TAX;
            }
            float itemDueTax = item.count * (item.price * tax/100);
            itemDueTax = (float) (Math.ceil(itemDueTax * 20) / 20.0);
            float itemFinalPrice = item.count * (itemDueTax + item.price);
            pricesum += itemFinalPrice;
            overview.append(item.name).append(": ").append(itemFinalPrice).append("\n");
            taxsum += itemDueTax;
        }

        overview.append("Sales Taxes: ").append(String.format("%.02f", taxsum)).append("\n");
        overview.append("Total: ").append(String.format("%.02f", pricesum));
        return overview.toString();
    }
}
