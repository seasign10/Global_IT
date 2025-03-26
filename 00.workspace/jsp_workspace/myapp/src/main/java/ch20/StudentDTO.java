package ch20;

class RegisterForms{
	private String firstName;
	private String lastName;
	private String country;
	private String subject;
	
	public RegisterForms(String f, String l, String c, String s) {
		this.firstName=f;
		this.lastName=l;
		this.country=c;
		this.subject=s;
	}
	
	// getter
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCountry() {
		return country;
	}
	public String getSubject() {
		return subject;
	}
}

public class StudentDTO {
	private String firstName;
    private String lastName;
    private String country;
    private String subject;
	
	// getter
    public RegisterForms getRegisterForms() {
        return new RegisterForms(firstName, lastName, country, subject);
    }
    
    // getter
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getSubject() {
        return subject;
    }
	
	// setter
    public void setFirstName(String f) {
        this.firstName=f;
    }
    public void setLastName(String l) {
        this.lastName=l;
    }
    public void setCountry(String c) {
        this.country=c;
    }
    public void setSubject(String s) {
        this.subject=s;
    }
}
