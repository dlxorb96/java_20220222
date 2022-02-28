package com.example.db;

import java.util.ArrayList;
import java.util.List;

import com.example.vo.Board;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import org.bson.conversions.Bson;

public class BoardDBImpl implements BoardDB {

    // final 하나만 가능
    private final String url = "mongodb://id202:pw202@1.234.5.158:37017/db202";

    private MongoCollection<Document> collection = null;

    // 생성자에서 외부에서 객체를 생성하는 시점에 DB연결하고 컬렉션도 선택
    public BoardDBImpl() {

        // 1. 접속하기 static로 되어있음. 접속은 객체를 n개 생성 불가
        MongoClient client = MongoClients.create(this.url);
        // 2. db연결
        MongoDatabase db = client.getDatabase("db202");
        // 3. 컬렉션선택 (member2)
        this.collection = db.getCollection("board2");
    }

    @Override
    public int insertBoard(Board board) {
        try {
            // 2. Document 타입의 변수를 만듦
            Document doc = new Document();
            doc.append("_id", board.getNo());
            doc.append("content", board.getContent());
            doc.append("hit", board.getHit());
            doc.append("title", board.getTitle());
            doc.append("writer", board.getWriter());

            // 1. 컬렉션에 데이터를 추가하기(Document가 필요)
            InsertOneResult result = this.collection.insertOne(doc);

            // String aa = "aa" => if(aa.equals("aa"){}
            // long aa =1L; => if(aa ==2){}

            if (result.getInsertedId()
                    .asInt64()
                    .getValue() == board.getNo()) {
                return 1; // 성공
            }
            return 0; // 실패

        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 오류
        }

    }

    @Override
    public int deleteBoard(Board board) {
        try {
            // 2.bson
            Bson bson = Filters.eq("_id", board.getNo());

            // 1. 삭제
            DeleteResult result = this.collection.deleteOne(bson);
            if (result.getDeletedCount() == 1L) {
                return 1;
            }
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 오류
        }

    }

    @Override
    public int updateBoard(Board board) {
        try {
            Bson bson = Filters.eq("_id", board.getNo());
            Bson bson1 = Updates.set("title", board.getTitle());
            Bson bson2 = Updates.set("content", board.getContent());
            Bson bson3 = Updates.set("writer", board.getWriter());
            Bson bsonCombine = Updates.combine(bson1, bson2, bson3);

            UpdateResult result = this.collection.updateOne(bson, bsonCombine);

            if (result.getModifiedCount() == 1L) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 오류
        }

    }

    @Override
    public List<Board> selectListBoard() {
        try {

            // 전체조회
            FindIterable<Document> rows = this.collection.find();

            // Board를 n개 보관할 수 있는 list 변수
            // 가변길이 배열 [{},{},{}]
            // 안에 들어갈 수 있는 배열의 수를 맘대로 정함
            // 늘어나고, 즐어들고
            List<Board> list = new ArrayList<Board>();
            // 리스트에 담을 수 있는 자식은 4개 인데, 기능이 비워져있음
            // 그래서 list로 객체 호출 안됨

            for (Document tmp : rows) {
                // 여러개를 보관할 때는 객체를 여기에 만듬
                Board board = new Board(
                        tmp.getLong("_id"),
                        tmp.getString("title"),
                        tmp.getString("content"),
                        tmp.getString("writer"),
                        tmp.getInteger("hit"));
                list.add(board);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null; // 오류
        }
    }

    @Override
    public Board selectOneBoard(Board board) {
        try {
            Bson bson1 = Filters.eq("_id", board.getNo());

            // List<Document> <= "aa","bb","cc"
            FindIterable<Document> rows = this.collection.find(bson1);

            for (Document tmp : rows) { // 1번만 반복
                return new Board(
                        tmp.getLong("_id"),
                        tmp.getString("title"),
                        tmp.getString("content"),
                        tmp.getString("writer"),
                        tmp.getInteger("hit"));
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null; // 오류
        }
    }

}
