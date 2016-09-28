package angularauthbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
     
    private String firstname;
     
    private String lastname;
     
    private String username;
    
    private String password;
     
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(){
        id=0;
    }
     
    public User(long id, String firstname, String lastnaem, String username, String password){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password=password;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long l) {
        this.id = l;
    }
 
    
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    /*@Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", address=" + address
                + ", email=" + email + "]";
    }
     */
 
     
}