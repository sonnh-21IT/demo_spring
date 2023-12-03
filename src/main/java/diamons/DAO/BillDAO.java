package diamons.DAO;

import diamons.entity.Bill;
import diamons.entity.BillDetail;
import org.springframework.stereotype.Repository;

@Repository
public class BillDAO extends BaseDAO{
    public int addBill(Bill bill){
        StringBuffer  sql = new StringBuffer();
        sql.append("INSERT INTO `bills`(`user`, `phone`, `display_name`, `address`, `total`, `quantity`, `note`) ");
        sql.append("VALUES ( ");
        sql.append("'"+bill.getUser()+"', ");
        sql.append("'"+bill.getPhone()+"', ");
        sql.append("'"+bill.getDisplay_name()+"', ");
        sql.append("'"+bill.getAddress()+"', ");
        sql.append("'"+bill.getTotal()+"', ");
        sql.append("'"+bill.getQuantity()+"', ");
        sql.append("'"+bill.getNote()+"' ");
        sql.append(")");
        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    }
    public long getIdLastBill(){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT MAX(ID) FROM bills");
        long id = _jdbcTemplate.queryForObject(sql.toString(),new Object[]{}, Long.class );
        return id;
    }
    public int addBillDetail(BillDetail billDetail){
        StringBuffer  sql = new StringBuffer();
        sql.append("INSERT INTO `billdetail`(`id_product`, `id_bills`, `quantity`, `total`) ");
        sql.append("VALUES ( ");
        sql.append("'"+billDetail.getId_product()+"', ");
        sql.append("'"+billDetail.getId_bills()+"', ");
        sql.append("'"+billDetail.getQuantity()+"', ");
        sql.append("'"+billDetail.getTotal()+"' ");
        sql.append(")");
        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    }
}
