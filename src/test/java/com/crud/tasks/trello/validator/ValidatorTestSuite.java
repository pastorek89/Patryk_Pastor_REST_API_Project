package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.Trello;
import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorTestSuite {

    @InjectMocks
    private TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoards() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1","test",false));
        trelloBoards.add(new TrelloBoard("1","test",trelloLists));
        trelloBoards.add(new TrelloBoard("2","BlaBla",trelloLists));
        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        assertEquals(1,filteredBoards.size());
    }
}
