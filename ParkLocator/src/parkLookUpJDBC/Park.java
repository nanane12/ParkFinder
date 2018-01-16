package parkLookUpJDBC;

public class Park {
	
private int id;
private String nameOfPark;
private String addressOfPark;
private String zipCode;
private String website;

public Park(int id, String nameOfPark, String addressOfPark, String zipCode, String website) {
	super();
	this.id = id;
	this.nameOfPark = nameOfPark;
	this.addressOfPark = addressOfPark;
	this.zipCode = zipCode;
	this.website = website;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNameOfPark() {
	return nameOfPark;
}

public void setNameOfPark(String nameOfPark) {
	this.nameOfPark = nameOfPark;
}

public String getAddressOfPark() {
	return addressOfPark;
}

public void setAddressOfPark(String addressOfPark) {
	this.addressOfPark = addressOfPark;
}

public String getZipCode() {
	return zipCode;
}

public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}

public String getWebsite() {
	return website;
}

public void setWebsite(String website) {
	this.website = website;
}

@Override
public String toString() {
	return "Park [id=" + id + ", nameOfPark=" + nameOfPark + ", addressOfPark=" + addressOfPark + ", zipCode=" + zipCode
			+ ", website=" + website + "]";
}


}
