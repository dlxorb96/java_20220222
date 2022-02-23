package com.example;

import com.example.basic.Exam1;
import com.example.basic.Exam2;
import com.example.db.memberDB;
import com.example.vo.Book;
import com.example.vo.Member;

// import com.example.view.Print;
// import com.example.view.Print1;
// import com.example.vo.Item;
// import com.example.vo.Member;
// import com.example.vo.board;

// import com.example.vo.member;

//프로그램 시작 위치
public class App {

    public static void main(String[] args) {

        // db에 member데이터 삽입하기
        // memberDB obj = new memberDB();

        // Member member = new Member();
        // member.setId("1dx1");
        // member.setName("asdaqw");
        // member.setRegdate("202131020");
        // member.setAge(127);
        // member.setRole("customer");
        // int ret = obj.insertData(member);
        // if (ret == 1) {
        // System.out.println("추가성공");
        // } else {
        // System.out.println("추가실패");
        // }

        memberDB obj = new memberDB();

        Member member = new Member();
        member.setId("A");
        int ret = obj.deleteData(member);
        if (ret == 1) {
            System.out.println("삭제성공");
        } else {
            System.out.println("삭제실패");
        }

    }
}

// getter setter로 실행

// board obj = new board();
// obj.setNo(1);
// obj.setContent("안녕");
// obj.setHit(2);
// obj.setTitle("반갑당");
// obj.setWriter("율곡이이");
// print 에서 출력해ㅑㅇ함
// System.out.println(obj.toString());

// // 2 . 프른트하기
// Print obj1 = new Print();
// obj1.setBoard(obj);
// obj1.printAction();

// 물품 2개 보관

// Item[] array = new Item[2];
// for (int i = 0; i < array.length; i++) {
// array[i] = new Item();
// array[i].setNo(i + 1);
// array[i].setPrice((i + 1) * 2000);
// array[i].setQuantity((i + 1) * 1000);
// array[i].setTitle("가나다");
// }
// Print1 obj3 = new Print1();
// obj3.setItems(array);
// obj3.printAction1();

// Integer, String, Float
// Exam1<Integer> obj = new Exam1<Integer>();
// // 숫자로 하겠다고 하니까 자연스럽게 숫자로 바껴있음.
// obj.setData(13);

// System.out.println(obj.getData());

// Exam1<String> obj1 = new Exam1<String>();
// obj1.setData("안녕");
// System.out.println(obj1.getData());

// Exam1<Float> obj2 = new Exam1<Float>();
// obj2.setData(211.24f);
// System.out.println(obj2);
// Exam1<Float> obj2 = new Exam1<Float>();
// obj2.setData(211.24f);
// System.out.println(obj2.getData());
// toString이 있으면 println obj2 만 해도 getData를 한거와 같은 효과

// Book obj = new Book(2L, "java", 4500, "헤밍웨이");
// // 클래스를 만들면 생성자가 실행됨. 생성자는 최초에 1번만 수행됨
// // setter를 통해 추가로 변경시킴.

// System.out.println(obj.toString());

// obj.setCode(1L);
// obj.setPrice(4111);
// obj.setTitle("title");
// obj.setWriter("writer");
// System.out.println(obj.toString());

// Book obj1 = new Book(2L, "java", 4500, "헤밍웨이");
// System.out.println("obj:" + obj.toString());
// System.out.println("obj1:" + obj1.toString());

// Book obj2 = new Book(1L, "신과 함께");
// System.out.println("obj2 :" + obj2.toString());

// 고유한 객체를 만들고 싶음 왜냐 db를
// Exam2 ex2 = Exam2.create();
// Exam2 ex3 = Exam2.create();
// Exam2 ex4 = Exam2.create();
// Exam2 ex5 = Exam2.create();
// new가 없음
// 다 같은거임 같은 게 여러개 있는 거임
// Exam2가 private로 만들어졌기때문에 빨간줄
// 이건 다 1개임

// Book obj1 = new Book(2L, "java", 4500, "헤밍웨이");
// Book obj2 = new Book(2L, "java", 4500, "헤밍웨이");
// Book obj3 = new Book(2L, "java", 4500, "헤밍웨이");
// Book obj4 = new Book(2L, "java", 4500, "헤밍웨이");
// 이건 4개임

// db에 member데이터 삽입하기
// memberDB obj = new memberDB();

// Member member = new Member();
// member.setId("1dx1");
// member.setName("asdaqw");
// member.setRegdate("202131020");
// member.setAge(127);
// member.setRole("customer");
// int ret = obj.insertData(member);
// if (ret == 1) {
// System.out.println("추가성공");
// } else {
// System.out.println("추가실패");
// }