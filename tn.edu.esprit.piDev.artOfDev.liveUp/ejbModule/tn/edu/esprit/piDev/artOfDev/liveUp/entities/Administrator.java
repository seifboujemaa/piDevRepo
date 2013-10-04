package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

public class Administrator {
	
	private int idAdmin;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	
	public Administrator(){
		
	}

	
	
	

	public int getIdAdmin() {
		return idAdmin;
	}





	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}





	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAdmin;
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrator other = (Administrator) obj;
		if (idAdmin != other.idAdmin)
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Administrator [FirstName=" + firstName + ", LastName="
				+ lastName + "]";
	}
	
	

}
