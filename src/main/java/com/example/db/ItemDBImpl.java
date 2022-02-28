package com.example.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.vo.Item;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
// import org.bson.conversions.Bson;
import org.bson.conversions.Bson;

public class ItemDBImpl implements ItemDB {

    // final 하나만 가능
    private final String url = "mongodb://id202:pw202@1.234.5.158:37017/db202";

    private MongoCollection<Document> collection = null; // item2
    private MongoCollection<Document> seqCollection = null; // sequence

    // DB접속
    public ItemDBImpl() {
        // 1. 접속하기 static로 되어있음. 접속은 객체를 n개 생성 불가
        MongoClient client = MongoClients.create(this.url);
        // 2. db연결
        MongoDatabase db = client.getDatabase("db202");
        // 3. 컬렉션선택 (member2)
        this.collection = db.getCollection("item2");
        this.seqCollection = db.getCollection("sequence");
    }

    @Override
    public int insertItem(Item item) {
        try {
            // 시퀀스가져오기
            Bson filter = Filters.eq("_id", "SEQ_ITEM2_NO");
            Bson update = Updates.inc("seq", 1L);

            Document doc = this.seqCollection.findOneAndUpdate(filter, update);
            long seq = doc.getLong("seq");

            Document doc1 = new Document();

            doc1.append("_id", seq);
            doc1.append("title", item.getTitle());
            doc1.append("price", item.getPrice());
            doc1.append("quantity", item.getQuantity());

            InsertOneResult result = this.collection.insertOne(doc1);
            if (result.getInsertedId()
                    .asInt64().getValue() == seq) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public int deleteItem(long code) throws Exception {
        // throws Exception이 있기 때문에
        // try catch 문을 쓸 필요가 없다.
        // 오류가 나오면 자동으로 가게 되어있다
        Bson bson = Filters.eq("_id", code);

        DeleteResult result = this.collection.deleteOne(bson);
        if (result.getDeletedCount() == 1L) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateItem(Item item) {

        try {
            Bson filter = Filters.eq("_id", item.getNo());
            Bson bson1 = Updates.set("title", item.getTitle());
            Bson bson2 = Updates.set("price", item.getPrice());
            Bson bson3 = Updates.set("quantity", item.getQuantity());
            Bson update = Updates.combine(bson1, bson2, bson3);
            UpdateResult result = this.collection.updateOne(filter, update);
            if (result.getModifiedCount() == 1L) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Map<String, Object> selectOneItem(long code) {

        try {
            Bson filter = Filters.eq("_id", code);

            // map은 부모 hashmap은 자식
            Map<String, Object> map = new HashMap<>();
            // map.put("_id", 1L);
            // map.put("name", "가나다");
            // map.put("title", "제목");
            // 아이템으로 넘기는 거랑 차이점은 아이템을 미리 만들어 놔야함
            // 아이템은 정해진 걸 넣는 거, map은 원하는 걸 넣는 것
            // 좋은 건 아이템이 좋은 거임 뭘 넣을지 알고 있으니까

            FindIterable<Document> rows = this.collection.find(filter);
            // Iterable이 붙은건 반복시켜줘야함
            for (Document tmp : rows) {
                // map키(변수)를 마음대로 해서 추가함
                map.put("ID", tmp.getLong("_id"));
                map.put("TITLE", tmp.getString("title"));
                map.put("PRICE", tmp.getInteger("price"));
                map.put("QTY", tmp.getInteger("quantity"));
            }

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Item selectoneItem(long code) {

        try {
            Bson filter = Filters.eq("_id", code);

            Item item = new Item();

            FindIterable<Document> rows = this.collection.find(filter);

            for (Document tmp : rows) {
                // map키(변수)를 마음대로 해서 추가함
                item.setNo(tmp.getLong("_id"));
                item.setPrice(tmp.getInteger("price"));
                item.setQuantity(tmp.getInteger("quantity"));
                item.setTitle(tmp.getString("title"));

            }

            return item;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Item> selectListItem() {

        try {

            // 1 오름차순, -1 내림차순
            Bson sort = Filters.eq("_id", 1);
            // 일부 데이터만 가져오기
            Bson projection = Projections.exclude("quantity");
            // exclude(제외시킴) , include 포함시킴

            FindIterable<Document> document = this.collection.find()
                    .projection(projection)
                    .sort(sort);

            List<Item> list = new ArrayList<>();
            for (Document tmp : document) {
                Item item = new Item(
                        tmp.getLong("_id"),
                        tmp.getString("title"),
                        tmp.getInteger("price"),
                        0);
                list.add(item);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Item> selectListPageItem(int page) {

        try {
            Bson sort = Filters.eq("_id", 1);
            int skip = (page - 1) * 3;
            int limit = 3;

            FindIterable<Document> document = this.collection
                    .find().sort(sort).skip(skip).limit(limit);

            List<Item> list = new ArrayList<>();
            for (Document tmp : document) {
                Item item = new Item(
                        tmp.getLong("_id"),
                        tmp.getString("title"),
                        tmp.getInteger("price"),
                        tmp.getInteger("quantity"));
                list.add(item);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
