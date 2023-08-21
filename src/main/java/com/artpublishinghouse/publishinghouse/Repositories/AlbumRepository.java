package com.artpublishinghouse.publishinghouse.Repositories;

import com.artpublishinghouse.publishinghouse.DTOs.*;
import com.artpublishinghouse.publishinghouse.Models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class AlbumRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addAlbum(Album album){
        String sql = "INSERT INTO Album (Title, Price) VALUES (?, ?)";
        jdbcTemplate.update(sql, album.getTitle(), album.getPrice());
    }

    public List<AlbumDTO> getAllAlbums() {
        String sql = "SELECT Album.idAlbum, Album.Title, Album.Price, " +
                "(SELECT COUNT(Song.idSong) FROM Song WHERE Song.idAlbum = Album.idAlbum) AS NumberOfSongs " +
                "FROM Album";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AlbumDTO.class));
    }

    public EachAlbumDTO getAlbumDetails(int idAlbum) {
        String albumSql = "SELECT Album.Title, Album.Price " +
                "FROM Album " +
                "WHERE Album.idAlbum = ?";

        AlbumDTO albumDTO = jdbcTemplate.queryForObject(albumSql, new Object[]{idAlbum}, BeanPropertyRowMapper.newInstance(AlbumDTO.class));

        if (albumDTO == null) {
            return null;
        }

        String songsSql = "SELECT Song.Title " +
                "FROM Song " +
                "WHERE Song.idAlbum = ?";

        List<SongDTO> songDTOs = jdbcTemplate.query(songsSql, new Object[]{idAlbum}, BeanPropertyRowMapper.newInstance(SongDTO.class));

        for (SongDTO songDTO : songDTOs) {
            String artistsSql = "SELECT Artist.Name, Artist.Surname, Artist.MusicType, Artist.Age, Country.Name AS Country " +
                    "FROM SongArtist " +
                    "INNER JOIN Artist ON SongArtist.idArtist = Artist.idArtist " +
                    "INNER JOIN Country ON Artist.idCountry = Country.idCountry " +
                    "WHERE SongArtist.idSong = ?";
            List<ArtistDTO> artistDTOs = jdbcTemplate.query(artistsSql, new Object[]{idAlbum}, BeanPropertyRowMapper.newInstance(ArtistDTO.class));
            songDTO.setArtists(artistDTOs);
        }


        EachAlbumDTO eachAlbumDTO = new EachAlbumDTO(albumDTO.getTitle(), albumDTO.getPrice(), songDTOs);

        return eachAlbumDTO;
    }
}
