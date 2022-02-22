package com.example.vo;


//main/java
//여기까지가 기본

//파일명 : member.java 
//대소문자 파일명 다 일치해야 한다.
//변수
//여기는 가지고 가는 거 만드는 거 다 있음
//const obj = {_id : 'a@a.com', name: 'a', role: "CUSTOMER", regdate: '2020'}
public class Member {
    //1. 변수
    private String Id = null;
    private String name = null;
    private String role = null;
    private int age =999;
    private String regdate = null;

    //메소드(함수)

    //외부에서 가지고 가는거, 데이터를 넣어주는거
    // 2. getter와 setter를 만든다.

    public String getId(){
        return this.Id;
    }

    public void setId( String Id){
        this.Id = Id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String b){
        this.name = b;
    }
    
    public String getRole(){
        return this.role;
    }

    public void setRole(String c){
        this.role = c;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int d){
        this.age = d;
    }

    public String getRegdate(){
        return this.regdate;
    }

    public void setRegdate(String e){
        this.regdate = e;
    }


    // 3. toString만들기
    //어떤게 변화가 됐는ㄴ지
    @Override
    public String toString() {
        return "Member [Id=" + Id + ", age=" + age + ", name=" + name + ", regdate=" + regdate + ", role=" + role + "]";
    }

    
    
}
