package com.blueseaheart.slgmodwebsite.repository;

import com.blueseaheart.slgmodwebsite.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    // 可选添加：检查是否重名
    boolean existsByName(String name);
}
