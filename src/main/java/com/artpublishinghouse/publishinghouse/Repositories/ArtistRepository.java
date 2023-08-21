package com.artpublishinghouse.publishinghouse.Repositories;

import com.artpublishinghouse.publishinghouse.DTOs.ArtistDTO;
import com.artpublishinghouse.publishinghouse.Models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addArtist(Artist artist){
        String countryName = artist.getCountry();
        String findCountryId = "SELECT idCountry FROM Country WHERE Name = '" + countryName + "'";
        int countryID = jdbcTemplate.queryForObject(findCountryId, Integer.class);

        String sql = "INSERT INTO Artist (Name, Surname, MusicType, Age, idCountry) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, artist.getName(), artist.getSurname(), artist.getMusicType(), artist.getAge(), countryID);
    }


    public List<ArtistDTO> getAllArtists(){
        String sql = "SELECT a.Name, a.Surname, a.MusicType, a.Age, c.Name AS Country" +
                " FROM Artist a" +
                " JOIN Country c ON a.idCountry = c.idCountry";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ArtistDTO.class));
    }
}
