package sets_and_maps;

import com.sun.source.tree.Tree;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Shop> revision = new TreeMap<>();
        while(!"Revision".equals(input)) {
            String[] inputTokens = input.split(",\\s+");
            String shopName = inputTokens[0];
            String product = inputTokens[1];
            Double price = Double.parseDouble(inputTokens[2]);

            if(!revision.containsKey(shopName)) {
                Shop shop = new Shop();
                shop.setName(shopName);
                Map<String, Double> productWithPrices = new LinkedHashMap<>();
                productWithPrices.put(product, price);
                shop.setProductsAndPrices(productWithPrices);
                revision.put(shopName, shop);
            } else {
                revision.get(shopName).getProductsAndPrices().put(product, price);
            }

            input = scanner.nextLine();
        }
        printMap(revision);
    }

    private static void printMap(Map<String, Shop> revision) {
        for (Map.Entry entry: revision.entrySet()) {
            System.out.println(entry.getKey() + "->");
            revision.get(entry.getKey()).getProductsAndPrices().entrySet().forEach(innerEntry -> {
                System.out.println("Product: " +  innerEntry.getKey() + ", Price: " + String.format("%.1f", innerEntry.getValue()));
            });
        }
    }

    private static class Shop {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        private String name;

        public Map<String, Double> getProductsAndPrices() {
            return productsAndPrices;
        }

        public void setProductsAndPrices(Map<String, Double> productsAndPrices) {
            this.productsAndPrices = productsAndPrices;
        }

        private Map<String, Double> productsAndPrices;
    }
}
