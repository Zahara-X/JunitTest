package assured.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseItem {

	@JsonProperty("image")
	private String image;

	@JsonProperty("price")
	private Object price;

	@JsonProperty("rating")
	private Rating rating;

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("category")
	private String category;
}