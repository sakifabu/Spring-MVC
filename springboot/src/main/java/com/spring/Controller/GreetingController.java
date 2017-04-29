package com.spring.Controller;

/**
 * Created by Brian on 4/25/2017.
 */
import com.spring.Model.Testing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/test")
    public String testingForm(Model model){
        model.addAttribute("instance", new Testing());
        return "testing";
    }
    @PostMapping("/test")
    public String testingSubmit(@ModelAttribute Testing jack){
        System.out.println(jack.getName());
        return "result";
    }
}