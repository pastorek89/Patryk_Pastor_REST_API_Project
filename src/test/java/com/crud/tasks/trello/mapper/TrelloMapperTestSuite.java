package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void testMapTrelloCardToTrelloCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test", "mapping", "top", "123");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertTrue(trelloCard.getName().equals(trelloCardDto.getName()) &&
                trelloCard.getDescription().equals(trelloCardDto.getDescription()) &&
                trelloCard.getListId().equals(trelloCardDto.getListId()) &&
                trelloCard.getPos().equals(trelloCardDto.getPos()));
    }

    @Test
    public void testMapTrelloCardDtoToTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "mapping", "top", "123");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertTrue(trelloCard.getName().equals(trelloCardDto.getName()) &&
                trelloCard.getDescription().equals(trelloCardDto.getDescription()) &&
                trelloCard.getListId().equals(trelloCardDto.getListId()) &&
                trelloCard.getPos().equals(trelloCardDto.getPos()));
    }

    @Test
    public void testMapTrelloListToTrelloListDto() {
        //Given
        TrelloList trelloList = new TrelloList("123", "testList", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        //When
        List<TrelloListDto> trelloListsDtos = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(trelloLists.get(0).getId(), trelloListsDtos.get(0).getId());
    }

    @Test
    public void testMapTrelloListDtoToTrelloList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("123", "testList", false);
        List<TrelloListDto> trelloListsDtos = new ArrayList<>();
        trelloListsDtos.add(trelloListDto);
        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListsDtos);
        //Then
        assertEquals(trelloLists.get(0).getId(), trelloListsDtos.get(0).getId());
    }

    @Test
    public void testMapTrelloBoardToTrelloBoardDto() {
        //Given
        TrelloList trelloList = new TrelloList("123", "testList", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard("321", "testBoard", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);
        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        assertEquals(trelloBoardsDto.get(0).getId(), trelloBoards.get(0).getId());
    }

    @Test
    public void testMapTrelloBoardDtoToTrelloBoard() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("123", "testList", false);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("321", "testBoard", trelloListsDto);
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto);
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);
        //Then
        assertEquals(trelloBoardsDto.get(0).getId(), trelloBoards.get(0).getId());
    }
}
