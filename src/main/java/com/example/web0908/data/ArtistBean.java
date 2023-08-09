package com.example.web0908.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ArtistBean {
    private List<Artist> artists;
}
