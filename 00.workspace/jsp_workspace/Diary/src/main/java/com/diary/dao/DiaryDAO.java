package com.diary.dao;

import com.diary.common.DBConnPool;
import com.diary.vo.DiaryVO;

public class DiaryDAO extends DBConnPool{
	public DiaryDAO() {
		super();
	}
	
	// 일기 작성
	public int insertDiary(DiaryVO vo) {
		int result=0;
		try {
			String query=""
						+"insert into diary values(seq_diary.nextval, ?, ?, ?, sysdate)";
			psmt=con.prepareStatement(query);
			psmt.setString(1, vo.getWeather());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			
			result=psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
}
