package com.example.demo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelService {
  @Autowired
  private TelRepository telRepository;

  public List<TelBean> findAllData() {
    List<Object[]> result = telRepository.findAllData();
    List<TelBean> beans = new ArrayList<>();
    for (Object[] array : result) {
      TelBean bean = new TelBean();
      bean.setId(((BigInteger) array[0]).longValue());
      bean.setUserName((String) array[1]);
      bean.setTelNo((String) array[2]);
      bean.setMailAddr((String) array[3]);
      bean.setGroupName((String) array[4]);
      beans.add(bean);
    }
    return beans;
  }
}