package com.artpublishinghouse.publishinghouse.Repositories;

import com.artpublishinghouse.publishinghouse.DTOs.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<CountryDTO> getAllCountries(){
        String sql = "SELECT * FROM Country";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CountryDTO.class));
    }

}
