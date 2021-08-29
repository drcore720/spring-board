package hello.springboard.controller;

import hello.springboard.model.Board;
import hello.springboard.model.Member;
import hello.springboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/create")
    public String createForm(){
        return "board/create";
    }

    @PostMapping("/board/create")
    public String create(BoardForm form){
        Board board = new Board();
        board.setTitle(form.getSubject());
        board.setContent(form.getContent());
        board.setReadcount(0);
        board.setMemberSeq(0L);
        board.setWritedate(LocalDateTime.now());
        board.setEditdate(LocalDateTime.now());
        board.setDelflag(Boolean.FALSE);
        boardService.write(board);
        return "redirect:/";
    }

    @GetMapping("/board")
    public String list(Model model){
        List<Board> list = boardService.boardlist();
        model.addAttribute("list", list);
        return "board/all";
    }
}
