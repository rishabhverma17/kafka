import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.Properties;
/*
* This Class Subscribes to a partition of a topic.
* */
public class KafkaConsumerAssignApp {
    public static void main(String[] args){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "firstKafkaTopic");
        KafkaConsumer<String,String> myConsumer = new KafkaConsumer<String, String>(props);

        ArrayList<TopicPartition> partitions = new ArrayList<TopicPartition>();
        TopicPartition myTopicPartition = new TopicPartition("firstKafkaTopic",0);
        partitions.add(myTopicPartition);

        /* Consume an Assigned partition of a topic */
        myConsumer.assign(partitions);

        try{
            while (true){
                ConsumerRecords<String, String> records = myConsumer.poll(10);

                for(ConsumerRecord<String,String> record : records){
                    System.out.println(String.format("Topic: %s, Partition: %d, Offset: %d, key: %s, Value: %s",
                            record.topic(),record.partition(),record.offset(),record.key(),record.value()));
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            myConsumer.close();
        }
    }
}
