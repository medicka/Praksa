package com.praksa.musicexplorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praksa.musicexplorer.model.Album;



@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

	
//	@Query("select f from Festival f where "
//			+ "(:naziv IS NULL OR f.naziv like :naziv) AND "
//			+ "(:maksimalnaCena IS NULL OR f.cenaKarte <= :maksimalnaCena) AND "
//			+ "(:mestoId IS NULL OR f.mesto.id = :mestoId) "
//			)			
//	
//	Page<Festival> pretraga(@Param("naziv")String naziv, @Param("maksimalnaCena") Double maksimalnaCena, @Param("mestoId") Long mestoId, Pageable pageRequest);
//
//	List<Festival> findByMestoId(Long mestoId);
}