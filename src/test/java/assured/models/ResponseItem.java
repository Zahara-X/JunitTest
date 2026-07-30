package assured.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseItem{

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

	public String getImage(){
		return image;
	}

	public Object getPrice(){
		return price;
	}

	public Rating getRating(){
		return rating;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getCategory(){
		return category;
	}
}