package diamons.service.user;

import diamons.DAO.CartDAO;
import diamons.DTO.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartServiceImpl implements ICartService{
    @Autowired
    private CartDAO cartDAO = new CartDAO();

    @Override
    public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart) {
        return cartDAO.addCart(id,cart);
    }

    @Override
    public HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart) {
        return cartDAO.editCart(id,quantity,cart);
    }

    @Override
    public HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart) {
        return cartDAO.deleteCart(id,cart);
    }

    @Override
    public int totalQuantity(HashMap<Long, CartDTO> cart) {
        return cartDAO.totalQuantity(cart);
    }

    @Override
    public double totalPrice(HashMap<Long, CartDTO> cart) {
        return cartDAO.totalPrice(cart);
    }
}
