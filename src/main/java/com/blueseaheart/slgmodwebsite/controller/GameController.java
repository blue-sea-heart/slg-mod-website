package com.blueseaheart.slgmodwebsite.controller;

import com.blueseaheart.slgmodwebsite.dto.GameDto;
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
    public GameDto addGame(@RequestBody GameDto dto) {
        return gameService.addGame(dto);
    }

    // 获取所有游戏
    @GetMapping
    public List<GameDto> getAllGames() {
        return gameService.getAllGames();
    }

    // 删除游戏
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGameById(id);
    }

    // 修改游戏
    @PutMapping("/{id}")
    public GameDto updateGame(@PathVariable Long id, @RequestBody GameDto dto) {
        return gameService.updateGame(id, dto);
    }

}
