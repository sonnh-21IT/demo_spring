package diamons.controllers.user;

import diamons.entity.User;
import diamons.service.user.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class BaseController {
    @Autowired
    HomeServiceImpl _homeService;
    public ModelAndView _mvShare = new ModelAndView();

    @PostConstruct
    public ModelAndView init(){
        _mvShare.addObject("menus",_homeService.getDataMenu());
        _mvShare.addObject("user", new User());
        return _mvShare;
    }
}
