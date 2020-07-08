package com.praksa.musicexplorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praksa.musicexplorer.model.Artist;



@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
