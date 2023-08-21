package com.artpublishinghouse.publishinghouse.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {
    private int idArtist;
    private String Name;
    private String Surname;
    private String MusicType;
    private int Age;
    private String Country;
}
