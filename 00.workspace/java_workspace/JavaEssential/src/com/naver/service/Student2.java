package com.naver.service;

public class Student2 implements Person3 {
	public String name;
	public String department;

	// interface를 상속받은 자식클래스는 반드시 추상메서드를 overriding해야 함.
	@Override
	public void sleep() {
		System.out.println("2시간 잠을 잡니다.");
		
	}

}
