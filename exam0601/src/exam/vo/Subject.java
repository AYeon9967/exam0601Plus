package exam.vo;

public class Subject {
	private String id;
	private String name;
	private String count;
	private String prof;
	
	public Subject() {	}
	
	public Subject(String id, String name, String count, String prof) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.prof = prof;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	
}
