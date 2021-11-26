package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexPage() {
//        if(userService.getUserByName("user") != null){
            Set<Role> roles = new HashSet<>();
            roleService.getAllRoles().stream().forEach((role) -> roles.add(role));

        Set<Role> roleAdmin = new HashSet<>();
        roleAdmin = roleService.getAllRoles().stream().limit(1).collect(Collectors.toSet());

        Set<Role> roleUser = new HashSet<>();
        roleUser = roleService.getAllRoles().stream().skip(1).collect(Collectors.toSet());

            //userService.saveUser(new User("ADMIN", "ADMIN", (byte)0, "ADMIN", roleAdmin));
            userService.saveUser(new User("admin",
                    "admin",
                    (byte)0,
                    "$2a$12$NcBQGelXdh9WqxHEzck/l.2fo4pVyAOxRqZcP/alHW30aYQAg5O4u",
                    roles));
            userService.saveUser(new User("user",
                    "user",
                    (byte)0,
                    "$2a$12$MsSHLzOym.WYy6l10njKAuaMWrOKfjER4dI1R.yIY3xPXzPjVG0LC",
                    roleUser));
//        }

        return "index";
    }

}