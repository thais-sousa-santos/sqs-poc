package com.tsantos.sqspoc;

import com.tsantos.sqspoc.consumer.ReceiverMessage;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqsPocApplication implements CommandLineRunner {

	public SqsPocApplication(SqsTemplate sqsTemplate) {
		this.sqsTemplate = sqsTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(SqsPocApplication.class, args);
	}

	private final SqsTemplate sqsTemplate;

	@Override
	public void run(String... args) throws Exception {
		var SQS = "https://localhost.localstack.cloud:4566/000000000000/process-payments";
		sqsTemplate.send(SQS, new ReceiverMessage("send payment for analysis"));
	}
}
