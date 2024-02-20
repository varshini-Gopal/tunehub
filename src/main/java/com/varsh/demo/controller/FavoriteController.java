package com.varsh.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varsh.demo.entity.Favorite;
import com.varsh.demo.entity.Song;
import com.varsh.demo.services.FavoriteService;
import com.varsh.demo.services.SongService;

@Controller
public class FavoriteController {
	
	@Autowired FavoriteService service;
	@Autowired SongService songService;
	
	@PostMapping("/addToFavorites")
	public String addToFavorites(@ModelAttribute Favorite fav, Model model) {
		
		boolean songStatus = service.songExists(fav.getSongId());
		
		if(songStatus == false) {
		 service.addToFavorites(fav);
		System.out.println(fav.getId()+" "+fav.getSongId());
		System.out.println("Song added successfully");
		}
		
		List<Favorite> favo = service.fetchAllFavorites();
		
		List<Song> songList = new ArrayList<Song>();
		for(Favorite f : favo) {
			int id = f.getSongId();
			Song song = songService.findById(id);
			songList.add(song);
			//System.out.println(song);
		}
		
		model.addAttribute("songs", songList);
		return "userFavourites";
		//return addToFavorites;
		
	}
	
	@GetMapping("/userFavorites")
	public String userFavorites(Model model) {
		
		List<Favorite> fav = service.fetchAllFavorites();
		
		List<Song> songList = new ArrayList<Song>();
		for(Favorite f : fav) {
			int id = f.getSongId();
			Song song = songService.findById(id);
			songList.add(song);
			//System.out.println(song);
		}
		
		model.addAttribute("songs", songList);
		return "userFavourites";
	}

}
