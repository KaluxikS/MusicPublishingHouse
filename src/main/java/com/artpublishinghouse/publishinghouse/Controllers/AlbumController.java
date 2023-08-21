package com.artpublishinghouse.publishinghouse.Controllers;

import com.artpublishinghouse.publishinghouse.DTOs.AlbumDTO;
import com.artpublishinghouse.publishinghouse.DTOs.EachAlbumDTO;
import com.artpublishinghouse.publishinghouse.Models.Album;
import com.artpublishinghouse.publishinghouse.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @PostMapping("/album")
    public ResponseEntity<String> addAlbum(@RequestBody Album album){
        albumRepository.addAlbum(album);
        return ResponseEntity.ok("Album added successfully");
    }

    @GetMapping("/album")
    public List<AlbumDTO> getAllAlbums(){
        return albumRepository.getAllAlbums();
    }

    @GetMapping("/{idAlbum}")
    public ResponseEntity<EachAlbumDTO> getAlbumDetails(@PathVariable int idAlbum) {
        EachAlbumDTO albumDetails = albumRepository.getAlbumDetails(idAlbum);
        if (albumDetails != null) {
            return ResponseEntity.ok(albumDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
