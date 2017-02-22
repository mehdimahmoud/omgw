package com.mmik.challenge.ne.controller;

/**
 * Implementation to consume the Open Movie Services API
 * Created by mmik on 19/02/2017.
 */

import com.mmik.challenge.ne.dto.OmDetailsDTO;
import com.mmik.challenge.ne.dto.OmSearchResponseDTO;
import com.mmik.challenge.ne.service.OpenMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Component
@RequestMapping("/movies")
public class OpenMovieController extends BaseController{
    Logger log = LoggerFactory.getLogger(OpenMovieController.class);

    // Query builder variable:
    MultiValueMap<String,Object> queryMap = null;

    @Autowired
    OpenMovieService openMovieService;

    @GetMapping("")
    public OmSearchResponseDTO searchMovies(@RequestParam @NotNull String title, String page) {
        if (StringUtils.isEmpty(title))
            throw new IllegalArgumentException(String.format("title parameter should not be: title = {%s}",title));

        if (!StringUtils.isEmpty(page) && !page.chars().allMatch(Character::isDigit))
            throw new NumberFormatException(String.format("page parameter should not be: page = {%s}",page));

        queryMap = new LinkedMultiValueMap<>();
        queryMap.add("s",title);
        queryMap.add("page",page);
        Optional<OmSearchResponseDTO> oOmS = openMovieService.searchMovies(queryMap);
        OmSearchResponseDTO omSearchResponseDTO = oOmS.get();

        if (oOmS.isPresent()) {
            log.debug(omSearchResponseDTO.toString());
            return omSearchResponseDTO;
        }else
            throw new IllegalArgumentException(String.format("Searching failed due to parameter: title = {%s}",title));
    }

    @GetMapping("/{id}")
    public OmDetailsDTO getMovieDetails(@PathVariable @NotNull String id) {
        if (StringUtils.isEmpty(id))
            throw new IllegalArgumentException(String.format("Movie ID should not be null: ID = {%s}",id));

        queryMap = new LinkedMultiValueMap<>();
        queryMap.add("i",id);
        Optional<OmDetailsDTO> oOmD = openMovieService.getMovieDetails(queryMap);
        OmDetailsDTO omDetailsDTO = oOmD.get();

        if(oOmD.isPresent()) {
            log.debug(omDetailsDTO.toString());
            return omDetailsDTO;
        }else
            throw new IllegalArgumentException(String.format("Movie's details can't be retrieved due to: Movie ID  = {%s}",id));
    }
}
