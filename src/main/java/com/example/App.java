package com.example;

// import com.example.view.Print;
import com.example.view.Print1;
import com.example.vo.Item;
// import com.example.vo.Member;
// import com.example.vo.board;

// import com.example.vo.member;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
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
        Item[] array = new Item[2];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Item();
            array[i].setNo(i + 1);
            array[i].setPrice((i + 1) * 2000);
            array[i].setQuantity((i + 1) * 1000);
            array[i].setTitle("가나다");

        }
        Print1 obj3 = new Print1();
        obj3.setItems(array);
        obj3.printAction1();

    }
}
