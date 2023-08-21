package com.artpublishinghouse.publishinghouse.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
    private String title;
    private List<ArtistDTO> artists;
}
