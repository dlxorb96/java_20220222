package com.example.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MemberDB2 {

    MongoCollection<Document> collection = null;

    public MemberDB2() {
        String url = "mongodb://id202:pw202@1.234.5.158:37017/db202";

        MongoClient client = MongoClients.create(url);
        MongoDatabase db = client.getDatabase("db202");
        this.collection = db.getCollection("member2");

    }

}
