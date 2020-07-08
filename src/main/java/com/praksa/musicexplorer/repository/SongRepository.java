package com.praksa.musicexplorer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.praksa.musicexplorer.model.Song;

public interface SongRepository extends JpaRepository<Song, Long>{

	
	@Query("select s from Song s where "
			+ "(:name IS NULL OR s.name like :name) AND "
			+ "(:albumId IS NULL OR s.album.id = :albumId) "
			)	
	List<Song> search(@Param("name") String name, @Param("albumId") Long albumId);
	
	List<Song> findByAlbumId(Long albumId);
}
