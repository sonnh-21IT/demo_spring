package diamons.service.user;

import diamons.DTO.CartDTO;
import diamons.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface IBillService {
    @Autowired
    int addBill(Bill bill);
    @Autowired
    void addBillDetail(HashMap<Long, CartDTO> cart);
}
