package com.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.demo.model.BookedSeats;

@Configuration
public class kafkaConfiguration {
	
	@Bean
	public ProducerFactory<String, BookedSeats> producerFactory(){
		Map<String, Object> config = new HashMap<String, Object>();
		
		 config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		 config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		 config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<String, BookedSeats>(config);
	}
	
	@Bean
	public KafkaTemplate<String, BookedSeats> kafkaTemplate(){
		return new KafkaTemplate<String, BookedSeats>(producerFactory());
	}
}
