package com.blueseaheart.slgmodwebsite.repository;

import com.blueseaheart.slgmodwebsite.entity.Mod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModRepository extends JpaRepository<Mod,Long> {
    List<Mod> findAllByGameId(Long gameId);

}
