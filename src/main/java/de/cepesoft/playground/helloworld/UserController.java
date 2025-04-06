package de.cepesoft.playground.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService users;

    @GetMapping
    public String showUsersList(Model model) {
        model.addAttribute("users", users.getAllUsers());
        return "users";
    }

    @GetMapping("add")
    public String showAddUserForm(Model model) {
        model.addAttribute("action", "add");
        return "user";
    }

    @PostMapping("add")
    public View submitAddUserForm(@ModelAttribute UserForm form) {
        users.addUser(form.firstName(), form.lastName());
        return new RedirectView("/users");
    }
    
    @GetMapping("edit/{id}")
    public String showEditUserForm(@PathVariable Integer id, Model model) {
        var user = users.findUserById(id);
        model.addAttribute("firstName", user.firstName());
        model.addAttribute("lastName", user.lastName());
        model.addAttribute("action", "edit");
        return "user";
    }
    
    @PostMapping("edit/{id}")
    public View submitEditUserForm(@PathVariable Integer id, @ModelAttribute UserForm form) {
        users.updateUser(new User(id, form.firstName(), form.lastName()));
        return new RedirectView("/users");
    }

    @GetMapping("delete/{id}")
    public View deleteUser(@PathVariable Integer id) {
        users.deleteUserById(id);
        return new RedirectView("/users");
    }    

}
