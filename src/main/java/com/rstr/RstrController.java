package com.rstr;

import com.rstr.cus.RestRestarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rstr")
public class RstrController {

    @Autowired
    RestRestarter restRestarter;

    @GetMapping("/str")
    public String str() {
        System.out.println("RstrController classloader: " + this.getClass().getClassLoader());
        return "RstrController#str";
    }

    @GetMapping("/restart")
    public String restart() {
        restRestarter.restart();
        return "RstrController#restart";
    }

    @GetMapping("/dw")
    public void doWhile() {
        do {
            System.out.println("do while");
        } while (true);
    }
}
