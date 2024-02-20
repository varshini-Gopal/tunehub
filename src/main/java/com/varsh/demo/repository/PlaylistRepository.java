package com.varsh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.varsh.demo.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

	//void deleteByPlaylistId(int playlistId);
	/*@Modifying
    @Query("DELETE FROM Playlist p WHERE p.id = :playlistId")
    void deleteByIdWithSongs(@Param("playlistId") int playlistId);*/
}


