package com.blueseaheart.slgmodwebsite.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Mod {
    @Id
    @GeneratedValue
    private Long id;// 主键ID

    private String name;// 名称
    private String author;// 作者
    private String iconUrl;// 图标链接
    private String description;// 描述
    private String size;// 大小
    private String scale;// 规模
    private String version;// 版本
    private String type;// 类型
    private String sourceUrl;// 官方链接

    private Boolean isActive;// 是否启用
    private Integer sortOrder;// 排序

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;// 关联的游戏

    @ManyToOne
    @JoinColumn(name = "related_mod_id")
    private Mod relatedMod;// 依赖的Mod
}
