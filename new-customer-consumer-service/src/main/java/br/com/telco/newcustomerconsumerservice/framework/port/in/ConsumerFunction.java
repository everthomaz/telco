package br.com.telco.newcustomerconsumerservice.framework.port.in;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerFunction<T> {
	void consume(ConsumerRecord<String, T> record);
}
