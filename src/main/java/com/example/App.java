package com.example;

import java.util.List;
import com.example.db.ItemDB;
import com.example.db.ItemDBImpl;

import com.example.vo.Item;

//프로그램 시작 위치
public class App {

    public static void main(String[] args) {

        // 물품하나 조회하기
        ItemDB obj = new ItemDBImpl();
        // List<Item> item = obj.selectListItem();
        // for (Item tmp : item) {
        // System.out.println(tmp.toString());
        // }
        List<Item> item = obj.selectListPageItem(1);
        for (Item tmp : item) {
            System.out.println(tmp.toString());
        }
    }
}

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

// db 데이터 삭제하기
// memberDB obj = new memberDB();

// Member member = new Member();
// member.setId("A");
// int ret = obj.deleteData(member);
// if (ret == 1) {
// System.out.println("삭제성공");
// } else {
// System.out.println("삭제실패");
// }

// 객체 생성
// memberDB obj = new memberDB();

// 리스트 조회하기
// ArrayList<Member> list = obj.selectListData();
// System.out.println(list);
// // 이걸로 하면 원하는 값이 안나옴
// for (Member tmp : list) {
// System.out.println(tmp.toString());
// }

// child.java, parent.java 상속 파트 공부 -20220224
// Parent obj1 = new Parent();
// 미완성된 것이기 때문에 만들 수가 없다. 객체 자체가 만들어지지 않는다.
// obj1.printNum();

// 이방식을 잴 많이씀 obj2
// Parent obj2 = new child1();
// obj2.printNum();
// obj2.printNum1();

// 업데이트

// BoardDB obj = new BoardDBImpl();
// Board board = new Board(1L, "아아느", "먀머주", "자자자", 13);

// // board.setTitle("아아");
// // board.setContent("메메");
// // board.setWriter("리카노");
// int ret = obj.updateBoard(board);
// System.out.println(ret);

// 삭제 오류 직접 처리
// try {
// int ret = obj.deleteItem(10134);
// System.out.println(ret);
// } catch (Exception e) {
// e.printStackTrace();
// }

// map을 통해서 조회하기
// 컬레션 => 수집

// ex) "aaa", "bbb", "ccc"
// 데이터를 순차적으로 넣어줌
// 순차적인 거에 유리하다ㅏ
// List<String> list1 = new ArrayList<>();

// // ex ) {"_id": "value", "Name": "bbb", "age":13}
// // 특정한거를 한개 찝어낼때 유리하다
// Map<String, String> map1 = new HashMap<>();

// // 3. 한 개 조회
// Map<String, Object> map = obj.selectOneItem(3L);
// System.out.println(map.get("ID"));
// System.out.println(map.get("TITLE"));
// System.out.println(map.get("PRICE"));
// System.out.println(map.get("QTY"));

// //물품하나 조회하기
// ItemDB obj = new ItemDBImpl();
// Item item = obj.selectoneItem(3L);
// System.out.println(item.getPrice());
// System.out.println(item.getTitle());
// System.out.println(item.getQuantity());
// System.out.println(item.getNo());