package learn.nopcommerce.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

import java.io.File;

public class UserDataMapper {
	@JsonProperty("firstname")
	private String firstname;
	
	@JsonProperty("lastname")
	private String lastname;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("admin_email")
	private String emailAdmin;
	
	@JsonProperty("admin_password")
	private String passwordAdmin;
	
	public static UserDataMapper getUserData()
	{
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.getGloabalConstant().getProjectPath() + "/resources/UserData.json"), UserDataMapper.class);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public String getFirstName() {
		return firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public String getPassWord() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getAdminEmail() {
		return emailAdmin;
	}
	public String getAdminPassword() {
		return passwordAdmin;
	}
}
