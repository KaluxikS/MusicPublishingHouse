package com.artpublishinghouse.publishinghouse.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EachAlbumDTO {
    private String title;
    private int price;
    private List<SongDTO> songs;
}
