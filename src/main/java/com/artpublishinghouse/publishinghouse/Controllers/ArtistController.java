package com.artpublishinghouse.publishinghouse.Controllers;


import com.artpublishinghouse.publishinghouse.DTOs.ArtistDTO;
import com.artpublishinghouse.publishinghouse.Models.Artist;
import com.artpublishinghouse.publishinghouse.Repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ArtistController {

    @Autowired
    ArtistRepository artistRepository;

    @PostMapping("/artist")
    public ResponseEntity<String> addArtist(@RequestBody Artist artist) {
        artistRepository.addArtist(artist);
        return ResponseEntity.ok("Artist added successfully");
    }


    @GetMapping("/artist")
    public List<ArtistDTO> getAllArtists(){
        return artistRepository.getAllArtists();
    }

}
