package com.artpublishinghouse.publishinghouse.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    private int idAlbum;
    private String Title;
    private int Price;

}
