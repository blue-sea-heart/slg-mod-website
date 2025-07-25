package com.blueseaheart.slgmodwebsite.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主键

    private String name;//游戏名称
    private String shortName;//游戏简称
    private String coverImageUrl;//游戏封面图片URL
    private String description;//游戏描述
    private String developer;//开发商

    @ElementCollection
    @CollectionTable(name = "game_platforms", joinColumns = @JoinColumn(name = "game_id"))
    @Column(name = "platform")
    private List<String> platforms; //游戏平台 多个平台，例如 ["Steam", "Epic", "Xbox"]

    private Boolean isActive = true;//是否激活
    private Integer sortOrder = 0;//排序
}
