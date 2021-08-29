package hello.springboard.service;

import hello.springboard.model.Board;
import hello.springboard.repository.BoardRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long write(Board board){
        boardRepository.save(board);
        return board.getIdx();
    }

    public List<Board> boardlist(){
        return boardRepository.findAll();
    }
}
