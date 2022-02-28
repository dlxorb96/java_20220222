package com.example.vo;

// @Getter
// @Setter
// @ToString
// @AllArgsConstructor
// @NoArgsConstructor
public class Board {
    // 1. 변수설정 (ERD다이어그램에서 참고)
    // 글번호 , 제목, 내용, 작성자, 조회수
    private long no = 0L;
    private String title = null;
    private String content = null;
    private String writer = null;
    private int hit = 0;

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
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

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "Board [content=" + content + ", hit=" + hit + ", no=" + no + ",title=" + title + ", writer=" + writer
                + "]";
    }

    public Board(long no, String title, String content, String writer, int hit) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hit = hit;
    }

    public Board() {
    }

}
