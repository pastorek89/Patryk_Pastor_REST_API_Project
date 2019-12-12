package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Value("${trello.app.username}")
    private String trelloUsername;

    @Autowired
    private RestTemplate restTemplate;


    public List<TrelloBoardDto> getTrelloBoards() {

       TrelloBoardDto[] boardsResponse = restTemplate.getForObject(createUrl(), TrelloBoardDto[].class);

       TrelloBoardDto[] emptyArray = new TrelloBoardDto[0];
       TrelloBoardDto[] result = Optional.ofNullable(emptyArray).orElse(boardsResponse);
       return Arrays.asList(result);
    }

    private URI createUrl() {
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/patrykpastor/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id")
                .queryParam("lists", "all").build().encode().toUri();
        return url;
    }
}
