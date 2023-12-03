package diamons.DAO;

import diamons.DTO.CartDTO;
import diamons.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDAO extends BaseDAO {
    @Autowired
    ProductDAO productDAO = new ProductDAO();

    public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart) {
        CartDTO itemCart = new CartDTO();
        ProductDTO productDTO = productDAO.findProductByID(id);
        if (productDTO != null && cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setTotal(itemCart.getQuantity() * itemCart.getProductDTO().getPrice());
            itemCart.setQuantity(itemCart.getQuantity() + 1);
        } else {
            itemCart.setProductDTO(productDTO);
            itemCart.setQuantity(1);
            itemCart.setTotal(productDTO.getPrice());
        }
        cart.put(id, itemCart);
        return cart;
    }

    public HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart) {
        if (cart == null) {
            return cart;
        }
        CartDTO itemCart = new CartDTO();
        if (cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQuantity(quantity);
            double total = quantity * itemCart.getProductDTO().getPrice();
            itemCart.setTotal(total);
        }
        cart.put(id, itemCart);
        return cart;
    }

    public HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart) {
        if (cart == null) {
            return cart;
        }
        if (cart.containsKey(id)) {
            cart.remove(id);
        }
        return cart;
    }

    public int totalQuantity(HashMap<Long, CartDTO> cart) {
        int totalQuantity = 0;
        for (Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
            totalQuantity += itemCart.getValue().getQuantity();
        }
        return totalQuantity;
    }

    public double totalPrice(HashMap<Long, CartDTO> cart) {
        double totalPrice = 0;
        for (Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
            totalPrice += itemCart.getValue().getTotal();
        }
        return totalPrice;
    }
}
