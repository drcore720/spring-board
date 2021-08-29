package hello.springboard.repository;

import hello.springboard.model.Board;

import java.util.List;

public interface BoardRepository {
    Board save(Board board);
    List<Board> findAll();
//    Board modify(Board board);
//    String delete(Long idx);
//    Board read(Long idx);
//    List<Board> list(Integer page);
}
