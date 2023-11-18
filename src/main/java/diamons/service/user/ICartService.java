package diamons.service.user;

import diamons.DTO.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ICartService {
    @Autowired
    HashMap<Long, CartDTO> addCart(long id, HashMap<Long,CartDTO> cart);
    @Autowired
    HashMap<Long,CartDTO> editCart(long id,int quantity, HashMap<Long,CartDTO> cart);
    @Autowired
    HashMap<Long,CartDTO> deleteCart(long id, HashMap<Long,CartDTO> cart);
    @Autowired
    int totalQuantity(HashMap<Long, CartDTO> cart);
    @Autowired
    double totalPrice(HashMap<Long, CartDTO> cart);
}
