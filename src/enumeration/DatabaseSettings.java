package enumeration;

public enum DatabaseSettings {
	
	DRIVER("com.mysql.jdbc.Driver"),
	URL("jdbc:mysql://localhost:3306/aula06"),
	USER("root"),
	PASSWORD("brqbrq");

	private String value;
	
	private DatabaseSettings(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
