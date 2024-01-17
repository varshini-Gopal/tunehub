package com.varsh.demo.services;

import java.util.List;

import com.varsh.demo.entity.Playlist;

public interface PlaylistService {

	public void addplaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();

}
