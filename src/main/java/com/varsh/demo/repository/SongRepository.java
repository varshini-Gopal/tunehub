package com.varsh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varsh.demo.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{
	
	public Song findByName(String name);

}
