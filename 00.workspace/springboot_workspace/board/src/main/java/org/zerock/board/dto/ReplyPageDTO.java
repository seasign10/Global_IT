package org.zerock.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyPageDTO {
    private List<ReplyDTO> dtoList;
    private long totalElements;

    private int page;
    private int size;
    private int start;
    private int end;
    private boolean prev;
    private boolean next;
}
