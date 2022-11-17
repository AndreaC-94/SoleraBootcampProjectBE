package configurations;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public MongoClient mongoClient() {
        // ConnectionString connectionString = new ConnectionString("mongodb+srv://Andrea:Permongo1@group4Solera.moptybi.mongodb.net/?retryWrites=true&w=majority");
        // MongoClientSettings settings = MongoClientSettings.builder()
        //         .applyConnectionString(connectionString)
        //         .serverApi(ServerApi.builder()
        //                 .version(ServerApiVersion.V1)
        //                 .build())
        //         .build();
        // MongoClient mongoClient = MongoClients.create(settings);
        // MongoDatabase database = mongoClient.getDatabase("group4Solera");

        // return mongoClient;

        ConnectionString connectionString = new ConnectionString("mongodb+srv://Andrea:Permongo1@cluster0.moptybi.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .serverApi(ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build())
        .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("test");
        return mongoClient;
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("");
    }

    @Override
    protected boolean autoIndexCreation(){
        return true;
    }
}
