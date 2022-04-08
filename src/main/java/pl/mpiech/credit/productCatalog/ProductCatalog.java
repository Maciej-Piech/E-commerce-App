package pl.mpiech.credit.productCatalog;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductCatalog {
    Map<String, ProductInfo> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
    }

    public String addProduct(String id, String name) {
        ProductInfo productData = new ProductInfo(id, name);
        products.put(id, productData);
        return id;
    }

    public void publish(String productId) {
        ProductInfo loaded = products.get(productId);

        if (loaded.getPrice() == null) {
            throw new CantPublishProductException();
        }

        loaded.publish();
    }

    public List<ProductInfo> allPublishedProducts() {
        return products.values()
                .stream()
                .filter(item -> item.isOnline())
                .collect(Collectors.toList());
    }

    public void changePrice(String productId, BigDecimal newPrice) {
        ProductInfo loaded = findById(productId);
        loaded.changePrice(newPrice);
    }

    public ProductInfo findById(String productId) {
        return products.get(productId);
    }

    public void assignImage(String productId, String imageUrl) {
        ProductInfo loaded = findById(productId);
        loaded.assignImage(imageUrl);
    }
}
