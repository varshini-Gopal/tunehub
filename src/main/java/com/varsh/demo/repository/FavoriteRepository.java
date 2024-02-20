package com.varsh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varsh.demo.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

	Favorite findBySongId(int songId);

}
