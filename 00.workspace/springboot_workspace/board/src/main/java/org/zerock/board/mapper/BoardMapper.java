package org.zerock.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.board.dto.BoardDTO;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<BoardDTO> list2();
    public void delete2();
}