package medweb.psconf.daos;

import java.io.Serializable;
/**
 * 
 * @author adi
 *
 */
@SuppressWarnings("serial")
public class UserType implements Serializable {
private int idUserType;
private String name;
/**
 * @return the idUserType
 */
public int getIdUserType() {
	return idUserType;
}
/**
 * @param idUserType the idUserType to set
 */
public void setIdUserType(int idUserType) {
	this.idUserType = idUserType;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}


}
