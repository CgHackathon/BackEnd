package App.services.interfaces;

import App.models.Cart;
import App.models.Product;

import java.util.Map;

public interface CartService {

    Cart getCart(String userEmail);

    void buyCart(String userEmail,Integer StoreId);

    void modifyCart(String userEmail, Map<Product,Integer> products);

    void addToCart(String userEmail, Map<Product,Integer> products);


}
