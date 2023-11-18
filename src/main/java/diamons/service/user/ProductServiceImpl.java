package diamons.service.user;

import diamons.DAO.ProductDAO;
import diamons.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    ProductDAO productDAO = new ProductDAO();
    @Override
    public ProductDTO getProductByID(long id) {
        return productDAO.getProductByID(id).get(0);
    }

    @Override
    public List<ProductDTO> getProductByIDCategory(int id) {
        return productDAO.getAllProductDTOByID(id);
    }
}
