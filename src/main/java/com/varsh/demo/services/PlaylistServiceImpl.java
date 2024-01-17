package com.varsh.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varsh.demo.entity.Playlist;
import com.varsh.demo.repository.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistRepository repo;
	
	@Override
	public void addplaylist(Playlist playlist) {
		
		repo.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		
		return repo.findAll();
	}

}
