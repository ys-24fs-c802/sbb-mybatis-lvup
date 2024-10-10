package kr.co.cofile.hdcdmybatis.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Board implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createTime;

    public Board() {
        super();
    }

    public Board(int id, String title) {
        super();
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;
        return id == board.id && title.equals(board.title) && content.equals(board.content) && writer.equals(board.writer) && createTime.equals(board.createTime);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + writer.hashCode();
        result = 31 * result + createTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
