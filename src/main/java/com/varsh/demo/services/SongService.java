package com.varsh.demo.services;

import java.util.List;
import com.varsh.demo.entity.Song;

public interface SongService {
	
	public void addSong(Song song);

	public List<Song> fetchAllSongs();

	public boolean songExists(String name);
	
	public void updateSong(Song song);

	public Song findById(int id);

	public Song findBySongName(String songName);

	public List<Song> findByArtist(String name);

	public List<Song> findByGenre(String songName);

	//public void deleteByPlaylistId(int playlistId);

	

}
