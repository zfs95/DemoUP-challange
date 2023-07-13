package com.example.demoUpClipster;

import com.example.demoUpClipster.serviceImpl.Microbenchmark;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoUpClipsterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoUpClipsterApplication.class, args);

		Microbenchmark benchMark = new Microbenchmark();
		benchMark.execute();
	}

}
