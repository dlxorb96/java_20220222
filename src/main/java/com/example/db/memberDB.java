package com.example.db;

import com.example.vo.Member;

// import javax.swing.text.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
// import com.mongodb.client.MongoIterable;
import com.mongodb.client.result.InsertOneResult;

import org.bson.Document;
import org.bson.conversions.Bson;

// 파일명 : MemberDB.java
public class memberDB {

    // 컬렉션
    private MongoCollection<Document> collection = null;

    // 생성자
    // DB연결시킴
    public memberDB() {
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

}

// // 3. 컬렉션 전체 목록 가져오기
// MongoIterable<String> colls = db.listCollectionNames();

// // 4. 컬렉션 출력하기
// for (String tmp : colls) {
// System.out.println(tmp);