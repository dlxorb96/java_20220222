package com.example.basic;

// Parent는 라이브러리이고,
// Child1을 만드는데 기존기능 + 새로운기능 추가
// 인터페이스는 n개 들어갈 수 있다.
public class child1 extends Parent implements Parent1 {

    public child1() {
        super();
        // public Parent();
    }

    public child1(int num) {
        // 부모의 생성자를 호출
        super(num);
        // 이런 생성자 호출 public Parent(int num){}
    }

    @Override // 부모의 기능을 재구현하겠다.(부모의 구현부 + 자식의 구현부)
    // 부모의 모양(타입, 함수명)을 유지해야한다.
    public void printNum() {
        super.printNum();
        // 부모의 메소드가 호출
        System.out.println("child1에서 출력");
    }

    // 부모와 전혀상관없는 메소드
    public void printChild1() {
        System.out.println("printChild1");
    }

    // 부모 클래스에서 추상화를 했기때문에 자식 클래스에서 상속받으면서 일을 마무리 해야함.
    @Override
    public void printNum1() {

        System.out.println("printchild1-printNum1");

    }

    @Override
    public void printA() {

        System.out.println(1);
    }

    @Override
    public void printB() {

    }

}
