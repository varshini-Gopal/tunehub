package com.varsh.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varsh.demo.entity.Favorite;
import com.varsh.demo.repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService{
	
	@Autowired 
	FavoriteRepository repo;

	@Override
	public void addToFavorites(Favorite fav) {
		repo.save(fav);
		
	}

	@Override
	public List<Favorite> fetchAllFavorites() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean songExists(int songId) {
		// TODO Auto-generated method stub
		Favorite fav = repo.findBySongId(songId);
		if(fav == null)
			return false;
		else
			return true;
		
	}
	
	

}
