package com.naver.service;

public class Student extends Person {
	public String department;
	void sduty() {
		System.out.println("공부합니다.");
	}
	
	// Source > Override 사용하면 자동 완성
	@Override
	public void sleep() {
		System.out.println("하루에 4시간 잡니다.");
	}
	
	//생성자 오버로딩
	public Student() {}; //기본생성자
	public Student(String name, String department) {
		//this.name=name;
		super(name); // 부모의 생성자를 호출해서 name 초기화. 권장
		this.department=department;
	}
	
}
