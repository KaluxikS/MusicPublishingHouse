package com.artpublishinghouse.publishinghouse.Repositories;

import com.artpublishinghouse.publishinghouse.Models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addSong(Song song){
        String sql = "INSERT INTO Song (Title, idAlbum) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, song.getTitle(), song.getIdAlbum());
    }
}
