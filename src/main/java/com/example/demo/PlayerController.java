package com.example.demo;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {
  @Autowired
  private PlayerRepository playerRepository;

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
  public String update(Model model, @RequestParam(required = false) Long id) {
    if (id != null) {
      PlayerData data = playerService.findById(id);
      if (data != null) {
        data.setId(id);
        data.setName("update");
        data.setAge(20);
        playerService.update(data);
      }
    }
    return "redirect:index";
  }

  @GetMapping("put")
  public String put(Model model, @RequestParam(required = false) Long id) {
    if (id != null) {
      PlayerData data = playerService.findById(id);
      if (data == null) {
        data = new PlayerData();
      }
      data.setId(id);
      data.setName("put");
      playerService.put(data);
    }
    return "redirect:index";
  }

  @GetMapping("save-or-update")
  public String saveOrUpdate(Model model, @RequestParam(required = false) Long id) {
    if (id == null) {
      PlayerData data = new PlayerData();
      data.setName("save or update => save");
      playerService.save(data);
    } else {
      PlayerData data = playerService.findById(id);
      data.setId(id);
      data.setName("save or update => update");
      playerService.update(data);

    }
    return "redirect:index";
  }

  @ResponseBody
  @GetMapping("/ids")
  public List<PlayerData> ids(Model model) {
    return playerRepository.findByIdIn(Arrays.asList(1L, 2L, 3L));
  }

  @ResponseBody
  @GetMapping("/ids-and-names")
  public List<PlayerData> idsAndNames(Model model) {
    return playerRepository
        .findByIdInAndNameIn(Arrays.asList(1L, 2L, 3L), Arrays.asList("save", "put"));
  }


  @ResponseBody
  @GetMapping("/id-between-and-names")
  public List<PlayerData> idBetweenAndNames(Model model) {
    return playerRepository.findByIdBetweenAndNameIn(2L, 3L, Arrays.asList("save", "put"));
  }
}