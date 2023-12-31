package spring.react.jugtours;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration {
    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Override
    protected String getDatabaseName() {
        return this.database;
    }

    @Override
    public MongoClient mongoClient() {
        MongoClient client = MongoClients.create(this.uri);
        ListDatabasesIterable<Document> databases = client.listDatabases();
        databases.forEach(System.out::println);

        return client;
    }
}
