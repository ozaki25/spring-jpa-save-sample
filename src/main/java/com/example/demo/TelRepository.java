package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TelRepository extends JpaRepository<TelData, Long> {
  // 本当は戻り値の型をList<TelBean>にしたいがTelBeanはEntityでないから指定できず仕方なくList<Object[]>で返す
  // 以下の記事を参考に実装
  // https://www.ne.jp/asahi/hishidama/home/tech/java/spring/boot/jpa/jpql_join.html
  @Query(value = "SELECT d.id,d.user_name,d.tel_no,d.mail_addr,g.group_name FROM tel_data d LEFT JOIN tel_group g ON d.group_id = g.group_id", nativeQuery = true)
  public List<Object[]> findAllData();
}
