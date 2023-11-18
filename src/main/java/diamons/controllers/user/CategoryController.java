package diamons.controllers.user;

import diamons.DTO.PaginateDTO;
import diamons.service.user.CategoryServiceImpl;
import diamons.service.user.PaginateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController extends BaseController {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private PaginateServiceImpl paginateService;
    private int totalProductsPage = 9;

    @RequestMapping(value = "/san-pham/{id}")
    public ModelAndView Product(@PathVariable String id) {

        _mvShare.setViewName("user/products/category");

        int totalData = categoryService.getDataProductByID(Integer.parseInt(id)).size();
        PaginateDTO paginateDTO = paginateService.getInfoPaginate(totalData, totalProductsPage, 1);
        _mvShare.addObject("paginateDTO", paginateDTO);
        _mvShare.addObject("productsPaginate", categoryService.getDataProductPaginate(Integer.parseInt(id),paginateDTO.getStart(), totalProductsPage));
        _mvShare.addObject("idCategory", id);
        return _mvShare;
    }

    @RequestMapping(value = "/san-pham/{id}/{currentPage}")
    public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {

        _mvShare.setViewName("user/products/category");

        int totalData = categoryService.getDataProductByID(Integer.parseInt(id)).size();
        PaginateDTO paginateDTO = paginateService.getInfoPaginate(totalData, totalProductsPage, Integer.parseInt(currentPage));
        _mvShare.addObject("paginateDTO", paginateDTO);
        _mvShare.addObject("productsPaginate", categoryService.getDataProductPaginate(Integer.parseInt(id),paginateDTO.getStart(), totalProductsPage));
        _mvShare.addObject("idCategory", id);
        return _mvShare;
    }
}
