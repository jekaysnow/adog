package vip.adog.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by jekay on 19-3-25.
 */
@RestController("/user")
public class UserController {


    @GetMapping("/test")
    public String test(@RequestParam String userName){
        return "hello "+userName;
    }
}
