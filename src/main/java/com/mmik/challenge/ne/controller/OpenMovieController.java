package com.mmik.challenge.ne.controller;

/**
 * Implementation to consume the Open Movie Services API
 * Created by mmik on 19/02/2017.
 */

import com.mmik.challenge.ne.dto.OmDetailsDTO;
import com.mmik.challenge.ne.dto.OmSearchResponseDTO;
import com.mmik.challenge.ne.service.OpenMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class OpenMovieController {

    @Autowired
    OpenMovieService openMovieService;

    @GetMapping("")
    public List<OmDetailsDTO> searchByTitle(@RequestParam String title) {
        Optional<OmSearchResponseDTO> oOmS = openMovieService.searchByTitle(title);

        if (oOmS.isPresent()  && oOmS.get().isResponse().equals(Boolean.TRUE)) {
            OmSearchResponseDTO omSearchResponseDTO = oOmS.get();
            return omSearchResponseDTO.getSearch();
        }else
            throw new IllegalArgumentException(String.format("Searching failed due to parameter: title = {%s}",title));
    }

    @GetMapping("/{id}")
    public OmDetailsDTO getDetails(@PathVariable String id) {
        Optional<OmDetailsDTO> oOmD = openMovieService.getDetailsById(id);
        if(oOmD.isPresent() && oOmD.get().isResponse().equals(Boolean.TRUE)) {
            return oOmD.get();
        }else
            throw new IllegalArgumentException(String.format("Movie's details can't be retrieved due to: ID movie = {%s}",id));
    }
}
