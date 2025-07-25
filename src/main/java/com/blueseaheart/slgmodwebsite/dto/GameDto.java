package com.blueseaheart.slgmodwebsite.dto;

import lombok.Data;

import java.util.List;

@Data
public class GameDto {
    private Long id;
    private String name;
    private String shortName;
    private String coverImageUrl;
    private String description;
    private String developer;
    private List<String> platforms;
    private Boolean isActive;
    private Integer sortOrder;
}
