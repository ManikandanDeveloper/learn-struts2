
public class TestAction {

	private String message;
	private String firstName;
	
	public String execute() {
		System.out.println("TestAction.execute() method is called");
		
		if (firstName.isEmpty()) {
			this.message = "Name is Empty!";
			return "error";
		}

		return "success";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
