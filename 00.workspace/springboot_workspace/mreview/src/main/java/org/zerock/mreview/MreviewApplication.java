package org.zerock.mreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // 날짜 자동입력시 필요
public class MreviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MreviewApplication.class, args);
	}

}
