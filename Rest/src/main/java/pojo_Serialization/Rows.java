package pojo_Serialization;

import java.util.List;

public class Rows {
	
	private Distance distance ;
	private List<Duration> duration;
	private String status;
	
	public List<Duration> getDuration() {
		return duration;
	}

	public void setDuration(List<Duration> duration) {
		this.duration = duration;
	}

	
	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




}
