package ua.org.gostroy.mimicFlickr.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

/**
 * Created by Sergey on 12/21/2015.
 */
@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "redirect:/angular/dist/index.html";
    }

    @RequestMapping(value = "photo", method = RequestMethod.GET)
    public String photo(@RequestHeader HttpHeaders httpHeaders){
        return "redirect:/photo/";
    }
}
