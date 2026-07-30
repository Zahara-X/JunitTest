package assured.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response{
	@JsonProperty("Response")
	private List<ResponseItem> response;

}