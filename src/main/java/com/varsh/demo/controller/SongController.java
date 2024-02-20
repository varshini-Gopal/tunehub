package com.varsh.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varsh.demo.entity.Song;
import com.varsh.demo.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService service;
	
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		
		boolean songStatus = service.songExists(song.getName());
		if(songStatus == false) {
			service.addSong(song);
			System.out.println("Song added successfully");
		}
		else {
			System.out.println("Song already exists");
		}
		
		return "adminHome";
	}
	
	@GetMapping("/playSongs")
	public String viewSongs(Model model) {
		
		boolean premiumUser = false;
		if(premiumUser == true) {
			List<Song> songsList = service.fetchAllSongs();
			model.addAttribute("songs", songsList);
			
			return "displaySongs";
		}
		else
			return "makePayment";
		
		
	}
	
	@GetMapping("/viewSongs")
	public String viewSongsAdmin(Model model) {
		
		
			List<Song> songsList = service.fetchAllSongs();
			model.addAttribute("songs", songsList);
			
			return "displaySongs";
		
	}
	
	@PostMapping("/search")
	public String searchSong(@RequestParam String songName, Model model) {
		Song songList = service.findBySongName(songName);
		model.addAttribute("songName", songName);
		
		
			model.addAttribute("song", songList);
			return "searchSongs";
		
		
		
	}
	/*
	@PostMapping("/searchByArtist")
	public String searchByArtist(Model model, @RequestParam String songName) {
		List<Song> songsList = service.findByArtist(songName);
		model.addAttribute("songs", songsList);		
		return "search";
		
		
	}*/
	
	@GetMapping("/searchByArtist/{songName}")
    public String searchByArtist(@PathVariable String songName, Model model) {
        
        System.out.println("Received myValue: " + songName);
        
        List<Song> songsList = service.findByArtist(songName);
		model.addAttribute("songs", songsList);
        
        return "search";
    }
	
	@GetMapping("/searchByGenre/{songName}")
    public String searchByGenre(@PathVariable String songName, Model model) {
        
        System.out.println("Received myValue: " + songName);
        
        List<Song> songsList = service.findByGenre(songName);
        System.out.println(songsList);
		model.addAttribute("songs", songsList);
        
        return "search";
    }

}
