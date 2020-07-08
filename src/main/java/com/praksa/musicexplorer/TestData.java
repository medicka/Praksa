package com.praksa.musicexplorer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.praksa.musicexplorer.model.Album;
import com.praksa.musicexplorer.model.Artist;
import com.praksa.musicexplorer.model.Song;
import com.praksa.musicexplorer.service.AlbumService;
import com.praksa.musicexplorer.service.ArtistService;
import com.praksa.musicexplorer.service.SongService;

@Component
public class TestData {

	@Autowired
	private SongService songService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ArtistService artistService;
	
	
	@PostConstruct
	public void init() {
		
		Artist artist1 = new Artist ();
		artist1.setName("Šinobusi");
		artistService.save(artist1);
		
		
		Artist artist2 = new Artist ();
		artist2.setName("Del Arno Band");
		artistService.save(artist2);
		
		Album album1 = new Album();
		album1.setName("Nekad jurimo kroz polja, a nekad stojimo u stanicama");
		album1.setYear(2005);
		album1.setPublisher("City Records");
		album1.setNumberOfSongs(11);
		album1.setArtist(artist1);
		albumService.save(album1);
		
		Album album2 = new Album();
		album2.setName("U pravcu jablanova");
		album2.setYear(2007);
		album2.setPublisher("PGP RTS");
		album2.setNumberOfSongs(12);
		album2.setArtist(artist1);
		albumService.save(album2);
		
		Album album3 = new Album();
		album3.setName("Vagon za provetravanje tunela");
		album3.setYear(2010);
		album3.setPublisher("PGP RTS");
		album3.setNumberOfSongs(13);
		album3.setArtist(artist1);
		albumService.save(album3);
		
		Album album4 = new Album();
		album4.setName("Nebo od skaja");
		album4.setYear(2013);
		album4.setPublisher("Dallas Records");
		album4.setNumberOfSongs(14);
		album4.setArtist(artist1);
		albumService.save(album4);
		
		Album album5 = new Album();
		album5.setName("Ljubav i dalje diše");
		album5.setYear(2017);
		album5.setPublisher("PGP RTS");
		album5.setNumberOfSongs(13);
		album5.setArtist(artist1);
		albumService.save(album5);
		
		Album album6 = new Album();
		album6.setName("Vreme vode");
		album6.setYear(2005);
		album6.setPublisher("Automatik");
		album6.setNumberOfSongs(12);
		album6.setArtist(artist2);
		albumService.save(album6);

		Song song1 = new Song();
		song1.setName("Lowlanders Blues");
		song1.setDuration(3.0);
		song1.setAlbum(album1);
		
		songService.save(song1);
		album1.addSong(song1);
		
		Song song2 = new Song();
		song2.setName("Kada svrake bulje u mene");
		song2.setDuration(3.0);
		song2.setAlbum(album1);
		
		songService.save(song2);
		album1.addSong(song2);
		
		Song song3 = new Song();
		song3.setName("U pravcu jablanova");
		song3.setDuration(3.0);
		song3.setAlbum(album2);
		
		songService.save(song3);
		album2.addSong(song3);
		
		Song song4 = new Song();
		song4.setName("Moje ruke sad su ptice");
		song4.setDuration(3.0);
		song4.setAlbum(album2);
		
		songService.save(song4);
		album2.addSong(song4);
		
		Song song5 = new Song();
		song5.setName("Super bejbe");
		song5.setDuration(3.0);
		song5.setAlbum(album3);
		
		songService.save(song5);
		album3.addSong(song5);
		
		Song song6 = new Song();
		song6.setName("Bluz novog dana");
		song6.setDuration(3.0);
		song6.setAlbum(album3);
		
		songService.save(song6);
		album3.addSong(song6);
		
		Song song7 = new Song();
		song7.setName("Skačem visoko");
		song7.setDuration(3.0);
		song7.setAlbum(album4);
		
		songService.save(song7);
		album4.addSong(song7);
		
		Song song8 = new Song();
		song8.setName("Iz drugog ugla");
		song8.setDuration(3.0);
		song8.setAlbum(album4);
		
		songService.save(song8);
		album4.addSong(song8);
		
		Song song9 = new Song();
		song9.setName("U nevreme");
		song9.setDuration(3.0);
		song9.setAlbum(album5);
		
		songService.save(song9);
		album5.addSong(song9);
		
		Song song10 = new Song();
		song10.setName("U nevreme");
		song10.setDuration(3.0);
		song10.setAlbum(album5);
		
		songService.save(song10);
		album5.addSong(song10);
		
		Song song11 = new Song();
		song11.setName("Pauk tišine");
		song11.setDuration(3.0);
		song11.setAlbum(album5);
		
		songService.save(song11);
		album5.addSong(song11);
		
		Song song12 = new Song();
		song12.setName("Svakog dana reci hvala");
		song12.setDuration(3.1);
		song12.setAlbum(album6);
		
		songService.save(song12);
		album6.addSong(song12);
		
		Song song13 = new Song();
		song13.setName("Dobra vest");
		song13.setDuration(3.0);
		song13.setAlbum(album6);
		
		songService.save(song13);
		album6.addSong(song13);
		
	}
}
