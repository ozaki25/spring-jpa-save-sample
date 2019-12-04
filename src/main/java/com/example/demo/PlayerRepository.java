package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerData, Long> {
  public List<PlayerData> findByIdIn(List<Long> ids);
  public List<PlayerData> findByIdInAndNameIn(List<Long> ids, List<String> names);
  public List<PlayerData> findByIdBetweenAndNameIn(Long startId, Long endId, List<String> names);
}
