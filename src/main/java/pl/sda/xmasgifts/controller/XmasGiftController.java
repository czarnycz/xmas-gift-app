package pl.sda.xmasgifts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.xmasgifts.entity.Person;
import pl.sda.xmasgifts.service.XmasGiftService;

@Controller
public class XmasGiftController {

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
    public ModelAndView addUser(@ModelAttribute Person person){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-user-confirm");
        modelAndView.getModelMap().addAttribute("person",xmasGiftService.addPerson(person));
        return modelAndView;
    }
}
