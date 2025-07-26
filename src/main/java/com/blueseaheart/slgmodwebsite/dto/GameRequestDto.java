package com.blueseaheart.slgmodwebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GameRequestDto {
    private String name;
    private String shortName;
    private String developer;
    private String platforms;
    private Boolean isActive;
    private String coverImageUrl;
    private String description;
    private Integer sortOrder;

    // Getter 和 Setter（或使用 lombok）
}
