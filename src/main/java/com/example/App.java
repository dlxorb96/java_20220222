package com.example;

import com.example.view.Print;
// import com.example.vo.Member;
import com.example.vo.board;

// import com.example.vo.member;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        board obj = new board();
        obj.setNo(1);
        obj.setContent("안녕");
        obj.setHit(2);
        obj.setTitle("반갑당");
        obj.setWriter("율곡이이");
        // print 에서 출력해ㅑㅇ함
        // System.out.println(obj.toString());

        // 2 . 프른트하기
        Print obj1 = new Print();
        obj1.setBoard(obj);
        obj1.printAction();
    }
}
