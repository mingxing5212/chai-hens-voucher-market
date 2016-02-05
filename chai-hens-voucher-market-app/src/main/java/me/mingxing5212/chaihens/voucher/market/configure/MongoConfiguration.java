package me.mingxing5212.chaihens.voucher.market.configure;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import me.mingxing5212.chaihens.voucher.market.data.WechatVoucher;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Configuration
@EnableConfigurationProperties()
public class MongoConfiguration {

    @Autowired
    private MongoProperties mongoProperties;
    @Bean
    MongoClient mongoClient() {
        try {
            String mongodbAddress = mongoProperties.getServerAddress();
            String[] addresses = mongodbAddress.split(",");
            ArrayList<ServerAddress> servers = new ArrayList<ServerAddress>();
            for (String address : addresses) {
                String[] addPort = address.split(":");
                String add = addPort[0];
                int port = addPort.length > 1 ? Integer.parseInt(addPort[1]) : 27017;
                servers.add(new ServerAddress(add, port));
            }
            MongoClientOptions.Builder builder = MongoClientOptions.builder();
            builder.socketKeepAlive(true)
                    .socketTimeout(60000)
                    .connectTimeout(30000)
                    .readPreference(ReadPreference.secondary())
                    .connectionsPerHost(60);
            MongoClient mongoClient = new MongoClient(servers, builder.build());
            return mongoClient;
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Bean
    Morphia morphia() {
        return new Morphia();
    }

    @Bean
    Datastore datastore() {
        Morphia morphia = morphia();
        morphia.map(WechatVoucher.class);
        Datastore datastore = morphia.createDatastore(mongoClient(),mongoProperties.getDbName());
        datastore.ensureIndexes();
        return  datastore;
    }
}

