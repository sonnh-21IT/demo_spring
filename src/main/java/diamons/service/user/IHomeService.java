package diamons.service.user;

import diamons.DTO.ProductDTO;
import diamons.entity.Category;
import diamons.entity.Menu;
import diamons.entity.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHomeService {
    @Autowired
    List<Slide> getDataSlide();
    @Autowired
    List<Category> getDataCategory();
    @Autowired
    List<Menu> getDataMenu();
    @Autowired
    List<ProductDTO> getDataProductDTO(boolean newProducts,boolean highLight);
}
