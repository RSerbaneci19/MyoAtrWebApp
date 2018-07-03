package tango.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tango.webapp.model.User;
import tango.webapp.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private HashMap<String, String> userFormModel = new HashMap<>();

    public HashMap<String, String> getUserFormModelMap() {
        return userFormModel;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("register", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("register") User userForm, BindingResult bindingResult, Model model) {


        userFormModel.put("firstName", userForm.getFirstName());
        userFormModel.put("lastName", userForm.getLastName());
        userFormModel.put("eMail", userForm.getEmail());
        userFormModel.put("phoneNumber", userForm.getPhoneNumber());
        userFormModel.put("type", userForm.getType());

        String regExp = "[\\$\\£\\€](\\d+(?:\\.\\d{1,2})?)";
        String str = userForm.getWorkshops();
        ArrayList<String> numbers = new ArrayList<>();
        String[] workshops = str.split(",");

        for (int i = 0; i < workshops.length; i++) {
            userFormModel.put("workshops" + i, workshops[i]);
        }

        Pattern p = Pattern.compile(regExp);
        Matcher matcher = p.matcher(str);
        while (matcher.find()) {
              numbers.add(matcher.group().replaceAll("€", ""));
        }

        double[] doubleList = new double[numbers.size()];
        Double totalAmount = 0.0;
        for (int i = 0; i < numbers.size(); ++i) {
            doubleList[i] = Double.parseDouble(numbers.get(i));
            totalAmount += doubleList[i];
        }

        userFormModel.put("totalAmount", totalAmount.toString());
        userForm.setTotalAmount(totalAmount.toString());

        if (bindingResult.hasErrors()) {
            return "Sorry MAN ! NOT THIS TIME";
        }

        userService.save(userForm);

        return "redirect:/confirmation";
    }

}
