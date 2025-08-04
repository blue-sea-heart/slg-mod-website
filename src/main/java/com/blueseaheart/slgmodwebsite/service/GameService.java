package com.blueseaheart.slgmodwebsite.service;

import com.blueseaheart.slgmodwebsite.dto.GameRequestDto;
import com.blueseaheart.slgmodwebsite.dto.GameResponseDto;
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

    /**
     * 添加新游戏
     * @param dto 游戏请求数据传输对象
     * @return 游戏响应数据传输对象
     */
    public GameResponseDto addGame(GameRequestDto dto) {
        Game game = fromRequestDto(dto);
        Game saved = gameRepository.save(game);
        return toResponseDto(saved);
    }

    /**
     * 获取所有游戏
     * @return 游戏响应数据传输对象列表
     */
    public List<GameResponseDto> getAllGames() {
        return gameRepository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    /**
     * 更新游戏信息
     * @param id 游戏ID
     * @param dto 游戏请求数据传输对象
     * @return 游戏响应数据传输对象
     */
    public GameResponseDto updateGame(Long id, GameRequestDto dto) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("找不到该游戏"));

        updateEntityFromRequest(game, dto);
        Game updated = gameRepository.save(game);
        return toResponseDto(updated);
    }


    /**
     * 删除游戏
     * @param id 游戏ID
     */
    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }

    private GameResponseDto toResponseDto(Game game) {
        GameResponseDto dto = new GameResponseDto();
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

    private Game fromRequestDto(GameRequestDto dto) {
        Game game = new Game();
        updateEntityFromRequest(game, dto);
        return game;
    }

    private void updateEntityFromRequest(Game game, GameRequestDto dto) {
        game.setName(dto.getName());
        game.setShortName(dto.getShortName());
        game.setCoverImageUrl(dto.getCoverImageUrl());
        game.setDescription(dto.getDescription());
        game.setDeveloper(dto.getDeveloper());
        game.setPlatforms(dto.getPlatforms());
        game.setIsActive(dto.getIsActive());
        game.setSortOrder(dto.getSortOrder());
    }


}
