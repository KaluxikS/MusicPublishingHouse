package com.artpublishinghouse.publishinghouse.Controllers;

import com.artpublishinghouse.publishinghouse.DTOs.CountryDTO;
import com.artpublishinghouse.publishinghouse.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<CountryDTO> getAllCountries(){
        return countryRepository.getAllCountries();
    }
}
