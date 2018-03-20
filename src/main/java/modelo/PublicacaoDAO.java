package modelo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonNumber;
import org.bson.BsonString;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

public class PublicacaoDAO {
    
    CodecRegistry pojoCodecRegistry;
    MongoClient mongoClient;        
    MongoDatabase database;        
    MongoCollection<Publicacao> collection;
    
    public PublicacaoDAO(){
        pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        mongoClient = new MongoClient("localhost",
            MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        database = mongoClient.getDatabase("PublicacaoBD");
        collection = database.getCollection("Publicacao", Publicacao.class);
    }
    
    public void createIndex(){
        Bson bson = new BsonDocument().append("titulo", new BsonString("text"))
                    .append("conteudo", new BsonString("text"));
        IndexOptions io = new IndexOptions();
        Bson weights = new BsonDocument().append("titulo", new BsonInt32(2));
        io.weights(weights);
        collection.createIndex(bson, io);
    }
        
    public void add(Publicacao p){
        collection.insertOne(p);
    }
    
    public Publicacao readFirst(String text){
        return collection.find(Filters.text(text)).projection(Projections.metaTextScore("score"))
                              .sort(Sorts.metaTextScore("score")).first();
    }
    
}
