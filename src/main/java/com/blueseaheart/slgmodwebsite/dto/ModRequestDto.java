package com.blueseaheart.slgmodwebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModRequestDto {
    private String name;
    private String author;
    private String iconUrl;
    private String description;
    private String size;
    private String scale;
    private String version;
    private String type;
    private String sourceUrl;

    private Boolean isActive;
    private Integer sortOrder;

    private Long gameId;         // 用于关联 Game
    private Long relatedModId;   // 可为空
}
