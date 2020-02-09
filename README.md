
# Getting Started with Apache kafka

[Follow installation instructuctions from this link] (https://tecadmin.net/install-apache-kafka-ubuntu/)

### Test if Zookeeper is running
```bash
telnet localhost 2181
ruok
```

### Start kafka Server
```bash
cd /usr/local/kafka
bin/kafka-server-start.sh config/server.properties
```

### Check Kafka Topics
```bash
cd /usr/local/kafka
bin/kafka-topics.sh
```
### Create new topic
```bash
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic firstKafkaTopic
```

### Producing data to a topic
```bash
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic firstKafkaTopic
write your message
```

### Consuming data from a topic
```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic firstKafkaTopic --from-beginning
```

### Description of a topic
```bash
bin/kafka-topics.sh --zookeeper localhost:2181 --describe --topic firstKafkaTopic
```
#### Creating random Topics for consumption 
```bash
/usr/local/kafka/bin# 
./kafka-producer-perf-test.sh --topic firstKafkaTopic  --num-records 50 --record-size 1 --throughput 10 --producer-props bootstrap.servers=localhost:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer
```
