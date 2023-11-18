package diamons.controllers.user;

import diamons.DTO.ProductDTO;
import diamons.service.user.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController extends BaseController{
    @Autowired
    private ProductServiceImpl _productService;
    @RequestMapping(value = "/chi-tiet-san-pham/{id}")
    public ModelAndView Product(@PathVariable long id){
        _mvShare.setViewName("user/products/product");
        ProductDTO productDTO = _productService.getProductByID(id);
        _mvShare.addObject("product",productDTO);
        _mvShare.addObject("productByIdCategory",_productService.getProductByIDCategory(productDTO.getId_category()));
        return _mvShare;
    }
}
