package com.blueseaheart.slgmodwebsite.controller;

import com.blueseaheart.slgmodwebsite.dto.GameRequestDto;
import com.blueseaheart.slgmodwebsite.dto.GameResponseDto;
import com.blueseaheart.slgmodwebsite.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // 添加游戏
    @PostMapping
    public GameResponseDto addGame(@RequestBody GameRequestDto dto) {
        return gameService.addGame(dto);
    }

    // 获取所有游戏
    @GetMapping
    public List<GameResponseDto> getAllGames() {
        return gameService.getAllGames();
    }

    // 删除游戏
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGameById(id);
    }

    // 修改游戏
    @PutMapping("/{id}")
    public GameResponseDto updateGame(@PathVariable Long id, @RequestBody GameRequestDto dto) {
        return gameService.updateGame(id, dto);
    }

}
