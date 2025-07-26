package com.blueseaheart.slgmodwebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameResponseDto {
    private Long id;
    private String name;
    private String shortName;
    private String developer;
    private List<String> platforms;
    private Boolean isActive;
    private String coverImageUrl;
    private String description;
    private Integer sortOrder;


    // Getter 和 Setter
}
