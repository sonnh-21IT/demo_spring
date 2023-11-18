package diamons.service.user;

import diamons.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    @Autowired
    ProductDTO getProductByID(long id);
    @Autowired
    List<ProductDTO> getProductByIDCategory(int id);
}
