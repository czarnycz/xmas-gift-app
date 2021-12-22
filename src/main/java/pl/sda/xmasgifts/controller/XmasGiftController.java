package pl.sda.xmasgifts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.xmasgifts.entity.Person;
import pl.sda.xmasgifts.entity.Wish;
import pl.sda.xmasgifts.service.XmasGiftService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.UUID;

@Controller
public class XmasGiftController {

    public static final String XMAS_USER_ID = "xmas-user-id";
    private final XmasGiftService xmasGiftService;

    public XmasGiftController(XmasGiftService xmasGiftService) {
        this.xmasGiftService = xmasGiftService;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/user/add")
    public String addUserForm(){
        return "add-user-form";
    }

    @PostMapping("/user/add")
    public ModelAndView addUser(@ModelAttribute Person person, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-user-confirm");
        Person user = xmasGiftService.addPerson(person);
        modelAndView.getModelMap().addAttribute("person",user);
        Cookie cookie = new Cookie(XMAS_USER_ID,user.getId().toString());
        cookie.setMaxAge(1_000_000_000);
        cookie.setPath("/");
        response.addCookie(cookie);
        return modelAndView;
    }

    @GetMapping("/user/list")
    public String listUsers(Model model){
        model.addAttribute("people", xmasGiftService.findAllPersons());
        return "user-list";
    }

    @GetMapping("/wish/add")
    public String addWishForm(){
        return "add-wish-form";
    }

    @PostMapping("/wish/add")
    public String addWish(@ModelAttribute Wish wish, HttpServletRequest request){
        String uuidStr;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals(XMAS_USER_ID)){
                uuidStr = cookie.getValue();
                Optional<Wish> optionalWish = xmasGiftService.addPersonWish(wish, UUID.fromString(uuidStr));
                if(optionalWish.isPresent()){
                return "/user/list";
            }else{
                    return "add-wish-error";
                }
            }
    }
        return "add-wish-error";
}
}
