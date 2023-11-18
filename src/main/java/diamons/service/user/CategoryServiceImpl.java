package diamons.service.user;

import diamons.DAO.ProductDAO;
import diamons.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private ProductDAO productDAO;
    @Override
    public List<ProductDTO> getDataProductPaginate(int id,int start, int totalPage) {
        return productDAO.getDataProductDTOByPaginate(id,start,totalPage);
    }
    @Override
    public List<ProductDTO> getDataProductByID(int id) {
        return productDAO.getAllProductDTOByID(id);
    }
}
