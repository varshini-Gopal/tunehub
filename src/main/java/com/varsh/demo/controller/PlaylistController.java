package com.varsh.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varsh.demo.entity.Playlist;
import com.varsh.demo.entity.Song;
import com.varsh.demo.services.PlaylistService;
import com.varsh.demo.services.SongService;

@Controller
public class PlaylistController {
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createPlaylist";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlayList(@ModelAttribute Playlist playlist) {
		
		playlistService.addplaylist(playlist);
		System.out.println(playlist);
		
		//updating song table
		List<Song> songList = playlist.getSongs();
		for(Song s: songList) {
			s.getPlaylists().add(playlist);
			//update song in db
			songService.updateSong(s);
		}
		return "adminHome";		
	}
	
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		List<Playlist> allPlaylist = playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylist", allPlaylist);
		return "displayPlaylists";
	}
	

}
