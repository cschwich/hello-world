package de.cepesoft.playground.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @GetMapping("/")
    public String welcome(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name == null ? "world" : name);
        return "welcome";
    }
    
}
