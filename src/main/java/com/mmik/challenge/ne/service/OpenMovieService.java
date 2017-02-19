package com.mmik.challenge.ne.service;

import com.mmik.challenge.ne.dto.OmDetailsDTO;
import com.mmik.challenge.ne.dto.OmSearchResponseDTO;

import java.util.Optional;

/**
 * Created by mmik on 19/02/2017.
 */
public interface OpenMovieService {
    Optional<OmSearchResponseDTO> searchByTitle(String title);
    Optional<OmDetailsDTO> getDetailsById(String id);
}
