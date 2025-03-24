package ch20;

public class ELBean {
	// field는 모두 private
	private String siteName;
	
	// getter. 읽기용 (외부에서 접근할 수 있게)
	public String getSiteName() {
		return siteName; // 직접엑세스가 아닌, 간접 엑세스 허용
	}
	
	// setter. 쓰기용
	public void setSiteName(String siteName) {
		this.siteName=siteName;
	}

}
