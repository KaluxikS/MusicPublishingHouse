package com.artpublishinghouse.publishinghouse.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    private int idSong;
    private String Title;
    private int idAlbum;
}
