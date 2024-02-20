package com.varsh.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.varsh.demo.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{
	
	public Song findByName(String name);

	public List<Song> findByArtist(String name);

	public List<Song> findByGenre(String songName);
	/*
	 @Modifying
	    @Query("DELETE FROM Song s WHERE :playlistId MEMBER OF s.playlists")
	    void deleteByPlaylistId(@Param("playlistId") int playlistId);
	*/
	

}
