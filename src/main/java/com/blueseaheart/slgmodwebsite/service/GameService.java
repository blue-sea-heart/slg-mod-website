package com.blueseaheart.slgmodwebsite.service;

import com.blueseaheart.slgmodwebsite.dto.GameDto;
import com.blueseaheart.slgmodwebsite.entity.Game;
import com.blueseaheart.slgmodwebsite.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    //TODO:有3段逻辑，可以合并

    // 添加游戏
    public GameDto addGame(GameDto dto) {
        Game game = new Game();
        game.setName(dto.getName());
        game.setShortName(dto.getShortName());
        game.setCoverImageUrl(dto.getCoverImageUrl());
        game.setDescription(dto.getDescription());
        game.setDeveloper(dto.getDeveloper());
        game.setPlatforms(dto.getPlatforms());
        game.setIsActive(dto.getIsActive());
        game.setSortOrder(dto.getSortOrder());

        Game saved = gameRepository.save(game);
        dto.setId(saved.getId());
        return dto;
    }

    // 获取所有游戏
    public List<GameDto> getAllGames() {
        return gameRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private GameDto toDto(Game game) {
        GameDto dto = new GameDto();
        dto.setId(game.getId());
        dto.setName(game.getName());
        dto.setShortName(game.getShortName());
        dto.setCoverImageUrl(game.getCoverImageUrl());
        dto.setDescription(game.getDescription());
        dto.setDeveloper(game.getDeveloper());
        dto.setPlatforms(game.getPlatforms());
        dto.setIsActive(game.getIsActive());
        dto.setSortOrder(game.getSortOrder());
        return dto;
    }

    // 删除游戏
    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }

    // 修改游戏
    public GameDto updateGame(Long id, GameDto dto) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("找不到该游戏"));

        game.setName(dto.getName());
        game.setShortName(dto.getShortName());
        game.setCoverImageUrl(dto.getCoverImageUrl());
        game.setDescription(dto.getDescription());
        game.setDeveloper(dto.getDeveloper());
        game.setPlatforms(dto.getPlatforms());
        game.setIsActive(dto.getIsActive());
        game.setSortOrder(dto.getSortOrder());

        Game updated = gameRepository.save(game);
        return toDto(updated);
    }

}
