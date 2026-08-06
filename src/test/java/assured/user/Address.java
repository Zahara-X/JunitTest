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
public class Address{
	@JsonProperty("zipcode")
	private String zipcode;
	@JsonProperty("number")
	private int number;
	@JsonProperty("city")
	private String city;
	@JsonProperty("street")
	private String street;
	@JsonProperty("geolocation")
	private Geolocation geolocation;
}
