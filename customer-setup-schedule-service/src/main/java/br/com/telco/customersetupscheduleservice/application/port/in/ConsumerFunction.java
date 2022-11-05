package br.com.telco.customersetupscheduleservice.application.port.in;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerFunction<T> {
	void consume(ConsumerRecord<String, T> record);
}
