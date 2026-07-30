package assured.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating{

	@JsonProperty("rate")
	private Object rate;

	@JsonProperty("count")
	private int count;

	public Object getRate(){
		return rate;
	}

	public int getCount(){
		return count;
	}
}