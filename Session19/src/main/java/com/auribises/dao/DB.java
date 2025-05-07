package com.auribises.dao;

import java.util.List;

import org.bson.Document;

import com.auribises.model.User;
import com.auribises.model.Util;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;

import static com.mongodb.client.model.Filters.eq;

public class DB {
	
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	public DB() {
	
		ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
		MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(Util.URI)).serverApi(serverApi).build();
		MongoClient mongoClient = MongoClients.create(settings);
		database = mongoClient.getDatabase(Util.DB_NAME);
		
		collection = database.getCollection(Util.COLLECTION_USERS);
	}
	
	public String addUserToCollection(User user) {
		collection.insertOne(user.toDocument());
		return user.name+" added in database";
	}

	public void fetchUser(String where, String what) {
		System.out.println(collection.find(eq(where, what)).first().toJson());
	}
	
}
	
	
	
	
	
	