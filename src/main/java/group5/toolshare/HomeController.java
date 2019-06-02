package group5.toolshare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    private AccountsService accountsService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


//
//    @RequestMapping(value="/login", method = RequestMethod.GET)
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }


    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Accounts account = new Accounts();
        modelAndView.addObject("accounts", account);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Accounts account, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Accounts userExists = accountsService.findUserByEmail(account.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            accountsService.saveUser(account);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("accounts", new Accounts());
            modelAndView.setViewName("register");

        }
        return modelAndView;
    }


}
