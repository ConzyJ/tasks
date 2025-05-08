package controller;

import com.crud.tasks.domain.TrelloBoardDto;
import trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("boards")
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream()
                .filter(b -> b.getId() != null && b.getName() != null)
                .filter(b -> b.getName().contains("Kodilla"))
                .forEach(b -> System.out.println(b.getId() + " " + b.getName()));
    }
}
