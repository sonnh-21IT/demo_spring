package diamons.service.user;

import diamons.DAO.CategoryDAO;
import diamons.DAO.MenuDAO;
import diamons.DAO.ProductDAO;
import diamons.DAO.SlideDAO;
import diamons.DTO.ProductDTO;
import diamons.entity.Category;
import diamons.entity.Menu;
import diamons.entity.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements IHomeService {
    @Autowired
    private SlideDAO slideDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private MenuDAO menuDAO;
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Slide> getDataSlide() {
        return slideDAO.getDataSlide();
    }

    @Override
    public List<Category> getDataCategory() {
        return categoryDAO.getDataCategory();
    }

    @Override
    public List<Menu> getDataMenu() {
        return menuDAO.getDataMenu();
    }

    @Override
    public List<ProductDTO> getDataProductDTO(boolean newProducts,boolean highLight) {
        List<ProductDTO> listProductDTO = productDAO.getDataProductDTO(newProducts,highLight);
        return listProductDTO;
    }
}
