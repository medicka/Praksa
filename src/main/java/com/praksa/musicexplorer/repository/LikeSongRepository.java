package com.praksa.musicexplorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praksa.musicexplorer.model.LikeSong;
import com.praksa.musicexplorer.model.LikeSongId;

public interface LikeSongRepository extends JpaRepository<LikeSong, LikeSongId>{

}
