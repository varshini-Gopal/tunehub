package com.varsh.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Favorite {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	public int songId;
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Favorite(int id, int songId) {
		super();
		this.id = id;
		this.songId = songId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	@Override
	public String toString() {
		return "Favorite [id=" + id + ", songId=" + songId + "]";
	}
	
	
}

