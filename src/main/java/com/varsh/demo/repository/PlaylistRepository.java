package com.varsh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varsh.demo.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
