package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TelRepository extends JpaRepository<TelData, Long> {
  @Query(value = "SELECT d.id,d.user_name,d.tel_no,d.mail_addr,g.group_name FROM tel_data d LEFT JOIN tel_group g ON d.group_id = g.group_id", nativeQuery = true)
  public List<Object[]> findAllData();
}
