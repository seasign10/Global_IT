package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 모든 필드를 초기화하는 생성자. 모든 parameter를 갖는 생성자
@NoArgsConstructor // parameter가 없는 생성자
public class SampleVO {
	private Integer mno;
	private String firstName;
	private String lastName;
}
