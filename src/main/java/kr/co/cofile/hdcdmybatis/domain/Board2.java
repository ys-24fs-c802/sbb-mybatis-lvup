package kr.co.cofile.hdcdmybatis.domain;

import lombok.Data;
import lombok.NonNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

//@RequiredArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode(of="id")
//@ToString(exclude = "content")
@Data
public class Board2 implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private String writer;
    private LocalDateTime createTime;

}
