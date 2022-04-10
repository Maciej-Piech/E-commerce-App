package pl.mpiech.credit.productCatalog;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalog {
    ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public String addProduct(String id, String name) {
        ProductData newProduct = new ProductData(id, name);
        productStorage.save(newProduct);
        return id;
    }

    private ProductData loadProductById(String productId) {
        return productStorage.load(productId);
    }

    public void publish(String productId) {
        ProductData loaded = productStorage.load(productId);

        if (loaded.getPrice() == null) {
            throw new CantPublishProductException();
        }

        loaded.publish();
    }

    public List<ProductData> allPublishedProducts() {
        return productStorage.allPublished();
    }

    public void changePrice(String productId, BigDecimal newPrice) {
        ProductData loaded = loadProductById(productId);
        loaded.changePrice(newPrice);
    }

    public ProductData getDetails(String productId) {

        return loadProductById(productId);
    }

    public void assignImage(String productId, String imageUrl) {
        ProductData loaded = loadProductById(productId);
        loaded.assignImage(imageUrl);
    }
}
