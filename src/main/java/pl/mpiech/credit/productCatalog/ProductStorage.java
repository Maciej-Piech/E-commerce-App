package pl.mpiech.credit.productCatalog;

import java.util.List;

public interface ProductStorage {
    void save(ProductData newProduct);

    ProductData load(String productId);

    List<ProductData> allPublished();
}