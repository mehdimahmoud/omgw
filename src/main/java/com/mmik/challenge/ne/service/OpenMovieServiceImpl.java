package com.mmik.challenge.ne.service;

import com.mmik.challenge.ne.dto.OmDetailsDTO;
import com.mmik.challenge.ne.dto.OmSearchResponseDTO;
import com.mmik.challenge.ne.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

import static com.mmik.challenge.ne.utils.Helper.getUriComponentsBuilder;

/**
 * Created by mmik on 19/02/2017.
 */
@Service
public class OpenMovieServiceImpl implements OpenMovieService {

    private static Logger log = LoggerFactory.getLogger(OpenMovieServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${resources.server1.omdbapi}")
    private String baseUrlOmDbApi;

    @Override
    public Optional<OmSearchResponseDTO> searchMovies(MultiValueMap<String,String> queryMap) {
        Optional<OmSearchResponseDTO> oOmSRDto = Optional.of(restTemplate.getForObject(getUriComponentsBuilder(baseUrlOmDbApi, queryMap), OmSearchResponseDTO.class));
        return oOmSRDto;
    }

    @Override
    public Optional<OmDetailsDTO> getMovieDetails(MultiValueMap<String,String> queryMap) {
        Optional<OmDetailsDTO> oOmDDto = Optional.of(restTemplate.getForObject(getUriComponentsBuilder(baseUrlOmDbApi, queryMap),OmDetailsDTO.class));
        return oOmDDto;
    }

}
