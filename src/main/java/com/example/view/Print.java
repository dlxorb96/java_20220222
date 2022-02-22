package com.example.view;

import com.example.vo.board;

// 출력하는 곳
// jsp, vue, react로 전환될 영역
public class Print {

    // 1. 변수 만들기
    // 받아오는 값이니까 null 여기서 선언할게 아님
    private board board = null;

    // 2. getter setter 만들기
    public board getBoard() {
        return board;
    }

    public void setBoard(board board) {
        this.board = board;
    }

    // 4. 메소드
    // (실제 업무 게시판 정보가 오면 글번호, 제목을 출려하는 일
    public void printAction() {
        System.out.println("------------------------");
        System.out.println(this.board.getNo());
        System.out.println(this.board.getTitle());
        System.out.println("------------------------");
    }

}
