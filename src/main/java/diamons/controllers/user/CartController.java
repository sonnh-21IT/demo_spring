package diamons.controllers.user;

import diamons.DTO.CartDTO;
import diamons.entity.Bill;
import diamons.entity.User;
import diamons.service.user.BillServiceImpl;
import diamons.service.user.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class CartController extends BaseController {
    private final boolean YES = true;
    private final boolean NO = false;

    @Autowired
    BillServiceImpl billService = new BillServiceImpl();

    @Autowired
    private CartServiceImpl cartService = new CartServiceImpl();
    @RequestMapping(value = "gio_hang")
    public ModelAndView Index(){
        _mvShare.addObject("slides",_homeService.getDataSlide());
        _mvShare.addObject("categories",_homeService.getDataCategory());
        _mvShare.addObject("products_new",_homeService.getDataProductDTO(YES,NO));
        _mvShare.addObject("products_highlight",_homeService.getDataProductDTO(NO,YES));
        _mvShare.setViewName("user/carts/list_cart");
        return _mvShare;
    }
    @RequestMapping(value = "add_cart/{id}")
    public String addCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.addCart(id, cart);
        session.setAttribute("cart",cart);
        session.setAttribute("totalPrice",cartService.totalPrice(cart));
        session.setAttribute("totalQuantity",cartService.totalQuantity(cart));
        return "redirect:"+request.getHeader("Referer");
    }
    @RequestMapping(value = "edit_cart/{id}/{quantity}")
    public String editCart(HttpServletRequest request, HttpSession session, @PathVariable long id,@PathVariable int quantity) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.editCart(id, quantity, cart);
        session.setAttribute("cart",cart);
        session.setAttribute("totalPrice",cartService.totalPrice(cart));
        session.setAttribute("totalQuantity",cartService.totalQuantity(cart));
        return "redirect:"+request.getHeader("Referer");
    }
    @RequestMapping(value = "delete_cart/{id}")
    public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.deleteCart(id,cart);
        session.setAttribute("cart",cart);
        session.setAttribute("totalPrice",cartService.totalPrice(cart));
        session.setAttribute("totalQuantity",cartService.totalQuantity(cart));
        return "redirect:"+request.getHeader("Referer");
    }
    @RequestMapping(value = "checkout",method = RequestMethod.GET)
    public ModelAndView checkout(HttpServletRequest request, HttpSession session) {
        _mvShare.setViewName("user/bills/checkout");
        _mvShare.addObject("categories",_homeService.getDataCategory());
        Bill bill = new Bill();
        User loginInfo = (User) session.getAttribute("loginInfo");
        if (loginInfo!=null){
            bill.setAddress(loginInfo.getAddress());
            bill.setDisplay_name(loginInfo.getDisplay_name());
            bill.setUser(loginInfo.getUser());
        }
        _mvShare.addObject("bills",bill);
        return _mvShare;
    }
    @RequestMapping(value = "checkout",method = RequestMethod.POST)
    public String checkOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bill bill){
        bill.setQuantity(Integer.parseInt(session.getAttribute("totalQuantity").toString()));
        bill.setTotal(Double.parseDouble(session.getAttribute("totalPrice").toString()));
        if (billService.addBill(bill)>0){
            HashMap<Long,CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
            billService.addBillDetail(cart);
        }
        session.removeAttribute("cart");
        session.removeAttribute("totalPrice");
        session.removeAttribute("totalQuantity");
        return "redirect:gio_hang";
    }
}
