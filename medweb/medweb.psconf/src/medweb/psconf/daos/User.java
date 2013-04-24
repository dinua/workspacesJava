package medweb.psconf.daos;

import java.io.Serializable;

/**
 * 
 * @author adi
 *
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	private int idUser;
	private String username;
	private String password;
	private boolean activ;
	private UserType userType;
	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the activ
	 */
	public boolean isActiv() {
		return activ;
	}
	/**
	 * @param activ the activ to set
	 */
	public void setActiv(boolean activ) {
		this.activ = activ;
	}
	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}
