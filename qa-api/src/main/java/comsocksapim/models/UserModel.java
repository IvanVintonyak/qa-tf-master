package comsocksapim.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(fluent = true)


public class UserModel {

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

//	public void setPassword(String password){
//		this.password = password;
//	}
//
//	public String getPassword(){
//		return password;
//	}
//
//	public void setEmail(String email){
//		this.email = email;
//	}
//
//	public String getEmail(){
//		return email;
//	}
//
//	public void setUsername(String username){
//		this.username = username;
//	}
//
//	public String getUsername(){
//		return username;
//	}
//
//	@Override
// 	public String toString(){
//		return
//			"UserModel{" +
//			"password = '" + password + '\'' +
//			",email = '" + email + '\'' +
//			",username = '" + username + '\'' +
//			"}";
//		}
}