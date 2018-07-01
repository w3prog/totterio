package io.totter.Controllers;

import io.totter.domain.Message;
import io.totter.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class IndexController {

    @Autowired
    MessageRepo repo;

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
        Iterable<Message> all = repo.findAll();
        model.put("messages",all );
        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter,Map<String,Object> model){
        Iterable<Message> all;
        if (filter != null && !filter.isEmpty()) all = repo.findByTag(filter);
        else all = repo.findAll();
        model.put("messages",all );

        return "main";
    }
    @PostMapping("/add")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String,Object> model){
        Message message = new Message(text,tag);

        repo.save(message);

        Iterable<Message> all = repo.findAll();
        model.put("messages",all );

        return "main";
    }
}
