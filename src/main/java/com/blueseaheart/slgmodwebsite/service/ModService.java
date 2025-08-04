package com.blueseaheart.slgmodwebsite.service;

import com.blueseaheart.slgmodwebsite.dto.GameRequestDto;
import com.blueseaheart.slgmodwebsite.dto.ModResponseDto;
import com.blueseaheart.slgmodwebsite.entity.Mod;
import com.blueseaheart.slgmodwebsite.repository.ModRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModService {
    private final ModRepository modRepository;
    public ModService(ModRepository modRepository) {
        this.modRepository = modRepository;
    }

    /**
     * 根据游戏信息查询所有相关的Mod
     * @param gameId 游戏的ID
     * @return Mod响应数据传输对象列表
     */
    public List<ModResponseDto> findAllGameMods(Long gameId) {
        List<ModResponseDto> modDtos= new ArrayList<>() ;
        for (Mod mod : modRepository.findAllByGameId(gameId))
            modDtos.add(toModResponseDto(mod));
        return modDtos;
        //return modRepository.findAllByGameId(gameId).stream().map(this::toModResponseDto).collect(Collectors.toList());
    }

    /**
     * 根据Mod ID查询Mod信息
     * @param modId Mod的ID
     * @return Mod响应数据传输对象
     */
    public ModResponseDto findModById(Long modId) {

        return toModResponseDto(modRepository.findById(modId).orElse(null));

    }


    /**
     * 根据游戏ID添加Mod
     * @param gameId 游戏的ID
     * @param dto Mod响应数据传输对象
     * @return Mod响应数据传输对象
     */
    public ModResponseDto  addModByGameId(Long gameId, ModResponseDto dto) {
        //TODO
    }

    private ModResponseDto toModResponseDto(Mod mod) {
        // 先判空，提取值
        String gameName = mod.getGame() != null ? mod.getGame().getName() : null;
        Long gameId = mod.getGame() != null ? mod.getGame().getId() : null;

        String relatedModName = mod.getRelatedMod() != null ? mod.getRelatedMod().getName() : null;
        Long relatedModId = mod.getRelatedMod() != null ? mod.getRelatedMod().getId() : null;

        return new ModResponseDto(
                mod.getId(),
                mod.getName(),
                mod.getAuthor(),
                mod.getIconUrl(),
                mod.getDescription(),
                mod.getSize(),
                mod.getScale(),
                mod.getVersion(),
                mod.getType(),
                mod.getSourceUrl(),
                mod.getIsActive(),
                mod.getSortOrder(),
                gameName,
                gameId,
                relatedModName,
                relatedModId
        );
    }

}
