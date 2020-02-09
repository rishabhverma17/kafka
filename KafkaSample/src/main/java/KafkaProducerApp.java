import org.apache.kafka.clients.producer.*;

import java.util.Properties;
/*
* This Class produces messages for kafka topic.
* */
public class KafkaProducerApp {
    public static void main(String[] args){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> myProducer = new KafkaProducer<String,String>(props);

        String messageTopic = "firstKafkaTopic";
        try{
            for(int i=0; i<150; i++){
                myProducer.send(new ProducerRecord<String, String>(messageTopic,Integer.toString(i),"My Message : "+Integer.toString(i)));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            myProducer.close();
        }
    }
}
