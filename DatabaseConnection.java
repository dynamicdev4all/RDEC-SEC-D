package com.rdec.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class DatabaseConnection {
	public static MongoClient client = null;
	public DatabaseConnection() {
		try {
			String URL = "mongodb+srv://piebytwo014:piebytwo014@cluster0.sy8lt.mongodb.net/rdec?retryWrites=true&w=majority&appName=Cluster0";
			ConnectionString string = new ConnectionString(URL);
			MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(string).build();
			client = MongoClients.create(settings);
			System.out.println("Database connection Success");
		} catch (Exception e) {
			System.out.println("Database connection error");
		}
		
	}
	
	public static MongoClient getDatabaseClient() {
		if(client == null) {
			new DatabaseConnection();
		}
		return client;
	}
}
