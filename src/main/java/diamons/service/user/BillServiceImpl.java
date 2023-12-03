package diamons.service.user;

import diamons.DAO.BillDAO;
import diamons.DTO.CartDTO;
import diamons.entity.Bill;
import diamons.entity.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BillServiceImpl implements IBillService{
    @Autowired
    private BillDAO billDAO;
    @Override
    public int addBill(Bill bill) {
        return billDAO.addBill(bill);
    }

    @Override
    public void addBillDetail(HashMap<Long, CartDTO> cart) {
        long idBill = billDAO.getIdLastBill();
        for (Map.Entry<Long,CartDTO> itemCart: cart.entrySet()){
            BillDetail billDetail = new BillDetail();
            billDetail.setId_bills(idBill);
            billDetail.setId_product(itemCart.getValue().getProductDTO().getId_product());
            billDetail.setQuantity(itemCart.getValue().getQuantity());
            billDetail.setTotal(itemCart.getValue().getTotal());
            billDAO.addBillDetail(billDetail);
        }
    }
}
