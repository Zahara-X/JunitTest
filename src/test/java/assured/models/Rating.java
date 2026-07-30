package assured.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	@JsonProperty("rate")
	private Object rate;

	@JsonProperty("count")
	private int count;
}