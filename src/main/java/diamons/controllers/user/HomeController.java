package diamons.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
    private final boolean YES = true;
    private final boolean NO = false;
    @RequestMapping(value = {"/","/trang-chu"})
    public ModelAndView Index(){
        _mvShare.addObject("slides",_homeService.getDataSlide());
        _mvShare.addObject("categories",_homeService.getDataCategory());
        _mvShare.addObject("products_new",_homeService.getDataProductDTO(YES,NO));
        _mvShare.addObject("products_highlight",_homeService.getDataProductDTO(NO,YES));
        _mvShare.setViewName("user/index");
        return _mvShare;
    }
}
