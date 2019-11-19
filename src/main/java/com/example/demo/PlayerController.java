package com.example.demo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {
  @Autowired
  private PlayerService playerService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("list", playerService.findAll());
    return "index";
  }

  @GetMapping("save")
  public String save(Model model) {
    PlayerData data = new PlayerData();
    data.setName("save");
    data.setAge(10);
    playerService.save(data);
    return "redirect:index";
  }

  @GetMapping("update")
  public String update(Model model, @RequestParam Long id) {
    if (id != null) {
      PlayerData data = new PlayerData();
      data.setId(id);
      data.setName("update");
      data.setAge(20);
      playerService.update(data);
    }
    return "redirect:index";
  }

  @GetMapping("put")
  public String put(Model model, @RequestParam Long id) {
    if (id != null) {
      PlayerData data = playerService.findById(id);
      data.setId(id);
      data.setName("put");
      playerService.put(data);
    }
    return "redirect:index";
  }

}