package com.example.jpa100_Sample1.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

  @RequestMapping(value = "/first-url", method = RequestMethod.GET)
  public void first() {

  }

  @ResponseBody
  @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
  public String second(){
    return "hello world";
  }

}
