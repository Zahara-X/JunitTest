package assured.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserItem {
	@JsonProperty("password")
	private String password;
	@JsonProperty("address")
	private Address address;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("v")
	private int v;
	@JsonProperty("name")
	private Name name;
	@JsonProperty("id")
	private int id;
	@JsonProperty("email")
	private String email;
	@JsonProperty("username")
	private String username;
}
