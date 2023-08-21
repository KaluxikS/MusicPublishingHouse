package com.artpublishinghouse.publishinghouse.Controllers;

import com.artpublishinghouse.publishinghouse.Models.Song;
import com.artpublishinghouse.publishinghouse.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SongController {

    @Autowired
    SongRepository songRepository;

    @PostMapping("/song")
    public ResponseEntity<String> addSong(@RequestBody Song song){
        songRepository.addSong(song);
        return ResponseEntity.ok("Song added successfully");
    }
}
