package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlayerServiceTest {
  @Mock
  private PlayerRepository playerRepository;

  @InjectMocks
  private PlayerService playerService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    when(playerRepository.findById(1L))
        .thenReturn(Optional.ofNullable(new PlayerData(1L, "oz", 29)));
    when(playerRepository.findAll())
        .thenReturn(Arrays.asList(new PlayerData(1L, "oz", 29), new PlayerData(2L, "test", 20)));

  }

  @Test
  public void calc_それぞれ正の値を渡した場合() {

    int result = playerService.calc(1, 2);
    int expected = 3;
    assertEquals(result, expected);
  }

  @Test
  public void findAll_正常系() {
    List<PlayerData> result = playerService.findAll();
    List<PlayerData> expected =
        Arrays.asList(new PlayerData(1L, "oz", 29), new PlayerData(2L, "test", 20));

    assertEquals(result, expected);
  }

  @Test
  public void findById_正常系() {
    PlayerData result = playerService.findById(1L);
    PlayerData expected = new PlayerData(1L, "oz", 29);

    assertEquals(expected, result);
  }

}


