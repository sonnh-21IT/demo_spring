package diamons.service.user;

import diamons.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    @Autowired
    List<ProductDTO> getDataProductPaginate(int id,int start, int totalPage);
    @Autowired
    List<ProductDTO> getDataProductByID(int id);
}
