package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PlayerServiceTest {
  @Mock
  private PlayerRepository playerRepository;

  @InjectMocks
  private PlayerService playerService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void calc_それぞれ正の値を渡した場合() {

    int result = playerService.calc(1, 2);
    int expected = 3;
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void findAll_正常系() {
    PlayerData player = new PlayerData();
    player.setId(1L);
    player.setName("oz");
    player.setAge(29);
    when(playerRepository.findAll()).thenReturn(Arrays.asList(player, player));


    List<PlayerData> result = playerService.findAll();
    List<PlayerData> expected = Arrays.asList(player, player);


    for (int i = 0; i > result.size(); i++) {
      assertThat(result.get(i)).isSameAs(expected.get(i));
    }
  }

  @Test
  public void findById_正常系() {
    PlayerData player = new PlayerData();
    player.setId(1L);
    player.setName("oz");
    player.setAge(29);
    when(playerRepository.findById(1L)).thenReturn(Optional.ofNullable(player));

    PlayerData result = playerService.findById(1L);
    PlayerData expected = player;

    assertThat(result).isSameAs(expected);
  }

}


