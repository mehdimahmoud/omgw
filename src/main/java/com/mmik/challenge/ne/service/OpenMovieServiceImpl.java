package com.mmik.challenge.ne.service;

import com.mmik.challenge.ne.dto.OmDetailsDTO;
import com.mmik.challenge.ne.dto.OmSearchResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Created by mmik on 19/02/2017.
 */
@Service
public class OpenMovieServiceImpl implements OpenMovieService {

    private static Logger log = LoggerFactory.getLogger(OpenMovieServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${resources.server1.omdbapi}")
    private String resServerOmDbApi;

    @Override
    public Optional<OmSearchResponseDTO> searchByTitle(String title) {
        String uri = resServerOmDbApi + "?s="+title;
        Optional<OmSearchResponseDTO> oOmSRDto = Optional.of(restTemplate.getForObject(uri, OmSearchResponseDTO.class));
        log.info(oOmSRDto.get().toString());
        return oOmSRDto;
    }

    @Override
    public Optional<OmDetailsDTO> getDetailsById(String id) {
        String uri = resServerOmDbApi + "?i="+id;
        Optional<OmDetailsDTO> oOmDDto = Optional.of(restTemplate.getForObject(uri,OmDetailsDTO.class));
        log.info(oOmDDto.get().toString());
        return oOmDDto;
    }


}
