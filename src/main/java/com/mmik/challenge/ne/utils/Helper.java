package com.mmik.challenge.ne.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by mmik on 20/02/2017.
 */
public  class  Helper {

    private static Logger log = LoggerFactory.getLogger(Helper.class);

    public static String getUriComponentsBuilder(String httpUrl, MultiValueMap queryMap) {
        String uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .fromHttpUrl(httpUrl)
                .queryParams(queryMap).toUriString();
        log.info(String.format("Builder URI = {%s}",uriComponentsBuilder));
        return uriComponentsBuilder;
    }
}
