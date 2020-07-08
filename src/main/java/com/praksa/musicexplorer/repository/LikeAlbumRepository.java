package com.praksa.musicexplorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praksa.musicexplorer.model.LikeAlbum;
import com.praksa.musicexplorer.model.LikeAlbumId;

public interface LikeAlbumRepository extends JpaRepository<LikeAlbum, LikeAlbumId> {

}
