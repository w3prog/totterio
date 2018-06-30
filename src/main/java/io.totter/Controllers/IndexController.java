package io.totter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(
            @RequestParam(name="name", required = false, defaultValue ="World") String name,
            Map<String, Object> model
    ){
        model.put("name",name);
        return "index";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        model.put("text","hello");
        return "main";
    }
}
