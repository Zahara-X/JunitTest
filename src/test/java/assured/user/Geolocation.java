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
public class Geolocation{
	@JsonProperty("let")
	private String lat;
	@JsonProperty("jsonMemberLong")
	private String jsonMemberLong;
}
