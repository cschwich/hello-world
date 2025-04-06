package de.cepesoft.playground.helloworld;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String welcome(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name == null ? "world" : name);
        return "welcome";
    }

    @RequestMapping(path = "/urlencoder", method = { RequestMethod.GET, RequestMethod.POST })
    public String getUrlEncoder(@ModelAttribute UrlEncoderForm form, Model model) throws UnsupportedEncodingException {
        if (form.input() != null) {
            model.addAttribute("input", form.input());            
        }
        if (form.action() != null) {
            switch (form.action()) {
                case "Encode": {
                    model.addAttribute("output", URLEncoder.encode(form.input(), "utf8"));
                    break;
                }
                case "Decode": {
                    model.addAttribute("output", URLDecoder.decode(form.input(), "utf8"));
                    break;
                }
                case "Swap": {
                    model.addAttribute("input", form.output());
                    model.addAttribute("output", form.input());
                    break;
                }
                case "Clear": {
                    model.addAttribute("input", "");
                    model.addAttribute("output", "");
                    break;
                }
                default:
                    // ignore
            }
        }
        return "urlencoder";
    }
    
}
