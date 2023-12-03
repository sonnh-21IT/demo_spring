package diamons.controllers.user;

import diamons.entity.User;
import diamons.service.user.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController extends BaseController {
    @Autowired
    AccountServiceImpl accountService = new AccountServiceImpl();

    @RequestMapping(value = "/dang_ky", method = RequestMethod.GET)
    public ModelAndView register() {
        _mvShare.setViewName("user/accounts/register");
        _mvShare.addObject("categories",_homeService.getDataCategory());
        return _mvShare;
    }

    @RequestMapping(value = "/dang_ky", method = RequestMethod.POST)
    public ModelAndView createAcc(@ModelAttribute("user") User user) {
        int count = accountService.addAccount(user);
        if (count > 0) {
            _mvShare.addObject("status", "Đăng ký tài khoản thành công");
        } else {
            _mvShare.addObject("status", "Đăng ký tài khoản thất bại");
        }
        _mvShare.setViewName("user/accounts/register");
        return _mvShare;
    }
    @RequestMapping(value = "/dang_nhap", method = RequestMethod.POST)
    public ModelAndView login(HttpSession session, @ModelAttribute("user") User user) {
        user = accountService.checkAccount(user);
        if (user!=null) {
            _mvShare.setViewName("redirect:trang-chu");
            session.setAttribute("loginInfo",user);
        } else {
            _mvShare.addObject("statusLogin", "Đăng nhập thất bại");
        }
        return _mvShare;
    }
    @RequestMapping(value = "/dang_xuat",method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest request){
        session.removeAttribute("loginInfo");
        return "redirect:"+request.getHeader("Referer");
    }
}
