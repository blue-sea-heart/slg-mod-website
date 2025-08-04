package com.blueseaheart.slgmodwebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModResponseDto {
    private Long id;
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

    private String gameName;        // 展示游戏名称
    private Long gameId;

    private String relatedModName;  // 可为空
    private Long relatedModId;
}
