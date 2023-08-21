package com.artpublishinghouse.publishinghouse.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
    private String Title;
    private int Price;
    private int NumberOfSongs;
}