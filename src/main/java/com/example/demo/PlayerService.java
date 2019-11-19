package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
  @Autowired
  private PlayerRepository playerRepository;

  public List<PlayerData> findAll() {
    return playerRepository.findAll();
  }

  public PlayerData findById(Long id) {
    return playerRepository.findById(id).orElse(null);
  }

  public void save(PlayerData playerData) {
    playerRepository.save(playerData);
  }

  public void update(PlayerData playerData) {
    playerRepository.save(playerData);
  }

  public void put(PlayerData playerData) {
    playerRepository.save(playerData);
  }
}