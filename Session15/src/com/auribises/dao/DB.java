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
		
		database.listCollectionNames().cursor().forEachRemaining((String name) -> System.out.println(name));
		
		collection = database.getCollection(Util.COLLECTION_USERS);
	}
	
	public void addUserToCollection(User user) {
		collection.insertOne(user.toDocument());
		System.out.println(user.name+" added in database");
	}
	
	public void addManyUsers(List<Document> documents) {
		collection.insertMany(documents);
		System.out.println(documents.size()+" document inserted");
	}
	
	public void fetchAllDocuments() {
		System.out.println(collection.countDocuments());
		collection.find().cursor().forEachRemaining((Document doc) -> System.out.println(doc.toJson()));
	}
	
	public void fetchUser(String where, String what) {
		System.out.println(collection.find(eq(where, what)).first().toJson());
	}
	
	public void updateUser(String where, String what, String newWhat) {
		collection.updateOne(eq(where, what), new Document("$set", new Document(where, newWhat)));
		System.out.println("User updated");
	}
	
	public void deleteUser(String where, String what) {
		collection.deleteOne(eq(where, what));
		System.out.println("Document deleted");
	}
	
}
	
	
	
	
	
	