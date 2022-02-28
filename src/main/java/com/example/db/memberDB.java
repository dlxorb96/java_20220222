package com.example.db;

import java.util.ArrayList;

import com.example.vo.Member;
import com.mongodb.client.FindIterable;

// import javax.swing.text.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
// import com.mongodb.client.MongoIterable;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import org.bson.conversions.Bson;

// 파일명 : MemberDB.java
public class MemberDB {

    // 컬렉션
    private MongoCollection<Document> collection = null;

    // 생성자
    // DB연결시킴
    public MemberDB() {
        String url = "mongodb://id202:pw202@1.234.5.158:37017/db202";

        // 1. 접속하기 static로 되어있음. 접속은 객체를 n개 생성 불가
        MongoClient client = MongoClients.create(url);

        // 2. db연결
        MongoDatabase db = client.getDatabase("db202");

        // 3. 컬렉션선택 (member2)
        this.collection = db.getCollection("member2");

    }

    public int insertData(Member member) {
        try {

            Document doc = new Document();
            doc.append("_id", member.getId());
            doc.append("name", member.getId());
            doc.append("age", member.getAge());
            doc.append("regdate", member.getRegdate());
            doc.append("role", member.getRole());

            InsertOneResult result = this.collection.insertOne(doc);
            System.out.println(result);
            if (result.getInsertedId()
                    .asString()
                    .getValue().equals(member.getId())) {
                return 1;
            }
            return 0;

        } catch (Exception e) {
            e.printStackTrace(); // 오류출력
            return -1;
        }
    }
    // 메소드
    // get~ 정보가져오기
    // set~ 정보변경

    // 여러개 조회
    public ArrayList<Member> selectListData() {
        try {
            FindIterable<Document> docs = this.collection
                    .find().sort(Filters.eq("_id", 1));

            // 클래스명<E> list = new 클래스명<E>
            ArrayList<Member> list = new ArrayList<Member>();
            for (Document tmp : docs) {
                Member sendmember = new Member();
                sendmember.setId(tmp.getString("_id"));
                sendmember.setAge(tmp.getInteger("age"));
                sendmember.setName(tmp.getString("name"));
                sendmember.setRole(tmp.getString("role"));
                sendmember.setRegdate(tmp.getString("regdate"));

                list.add(sendmember); // tmp 개수만큼 시행된다
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 한 개 조회
    public Member selectOneData(Member member) {
        try {
            // 조건
            Bson bson = Filters.eq("_id", member.getId());

            FindIterable<Document> docs = this.collection.find(bson);

            Member sendMember = new Member();
            for (Document tmp : docs) {
                sendMember.setId(tmp.getString("_id"));
                sendMember.setAge(tmp.getInteger("age"));
                sendMember.setName(tmp.getString("name"));
                sendMember.setRole(tmp.getString("role"));
                sendMember.setRegdate(tmp.getString("regdate"));

            }
            return sendMember;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 삭제
    public int deleteData(Member member) {
        try {
            // 조건 만들기
            Bson bson = Filters.eq("_id", member.getId());
            // 삭제하기
            DeleteResult result = this.collection.deleteOne(bson);
            if (result.getDeletedCount() == 1L) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace(); // 오류 출력
            return -1;
        }

    }

    // 메소드 수정
    public int updateData(Member member) {
        try {
            // 수정하고자 하는 아이디 조건
            Bson bson = Filters.eq("_id", member.getId());

            Bson bson1 = Updates.set("name", member.getName());
            Bson bson2 = Updates.set("age", member.getAge());

            Bson bson3 = Updates.combine(bson1, bson2);

            UpdateResult result = this.collection.updateOne(bson, bson3);
            if (result.getModifiedCount() == 1L) {
                return 1;
            }
            return 0;

            // updateone이니까 하나만 가야하는데, 바꾸고자 하는 건 두개임 그래서 combine을 해줌

            // 변경하고자하는 내용

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

// // 3. 컬렉션 전체 목록 가져오기
// MongoIterable<String> colls = db.listCollectionNames();

// // 4. 컬렉션 출력하기
// for (String tmp : colls) {
// System.out.println(tmp);