package com.example231.crud.service;

import com.example231.crud.dto.CoordsDTO;
import com.example231.crud.model.Avatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;

@Service
public class ApiService {
    private RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String randomApi = "https://random-d.uk/api/random";
    private String postApi = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/geolocate/postal_unit";

    public Avatar getAvatar() {
        return restTemplate.getForEntity(randomApi, Avatar.class).getBody();
    }

    public String getPostDaData(CoordsDTO coordsDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth("Token ed1f4bba356a3bdfc9930594b948a465712cbf34");

        HttpEntity<CoordsDTO> request = new HttpEntity<>(coordsDTO, headers);
        CoordsDTO response = restTemplate.postForObject(postApi, request, CoordsDTO.class);

        HashMap<String, String> map = (HashMap<String, String>) response.getSuggestions()[0];
        return map.get("unrestricted_value");
    }

}
