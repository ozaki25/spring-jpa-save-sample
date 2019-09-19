package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
  @Autowired
  private TelService telService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("list", telService.findAllData());
    return "index";
  }
}