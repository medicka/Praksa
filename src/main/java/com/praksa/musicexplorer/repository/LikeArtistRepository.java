package com.praksa.musicexplorer.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.praksa.musicexplorer.model.LikeArtist;
import com.praksa.musicexplorer.model.LikeArtistId;

public interface LikeArtistRepository extends JpaRepository<LikeArtist,LikeArtistId>{

}
