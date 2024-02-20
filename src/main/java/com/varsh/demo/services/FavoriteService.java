package com.varsh.demo.services;

import java.util.List;

import com.varsh.demo.entity.Favorite;

public interface FavoriteService {
	public void addToFavorites(Favorite fav);

	public List<Favorite> fetchAllFavorites();

	public boolean songExists(int songId);
}
