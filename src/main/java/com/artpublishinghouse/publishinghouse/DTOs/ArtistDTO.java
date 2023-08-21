package com.artpublishinghouse.publishinghouse.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {
    private String Name;
    private String Surname;
    private String MusicType;
    private int Age;
    private CountryDTO country;
}