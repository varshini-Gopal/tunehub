package com.varsh.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varsh.demo.entity.Song;
import com.varsh.demo.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService{
	
	@Override
	public void updateSong(Song song) {
		repo.save(song);
	}

	@Autowired
	SongRepository repo;

	@Override
	public void addSong(Song song) {
		
		repo.save(song);
		
		
	}

	@Override
	public List<Song> fetchAllSongs() {
		return repo.findAll();
		
	}

	@Override
	public boolean songExists(String name) {
		Song song = repo.findByName(name);
		if(song == null)
			return false;
		else
			return true;
		
	}

	@Override
	public Song findById(int id) {
		Optional<Song> optionalSong = repo.findById(id);
		Song song = optionalSong.get();
		return song;
	}

	@Override
	public Song findBySongName(String songName) {
		// TODO Auto-generated method stub
		Song song = repo.findByName(songName);
		return song;
	}

	@Override
	public List<Song> findByArtist(String name) {
		// TODO Auto-generated method stub
		List<Song> songList = repo.findByArtist(name);
		return songList;
	}

	@Override
	public List<Song> findByGenre(String songName) {
		// TODO Auto-generated method stub
		List<Song> songList = repo.findByGenre(songName);
		return songList;
	}
/*
	@Override
	public void deleteByPlaylistId(int playlistId) {
		// TODO Auto-generated method stub
		repo.deleteByPlaylistId(playlistId);
		
	}
	*/
	
	
	
	
	
	
	

}
