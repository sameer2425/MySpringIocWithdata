package com.sameer.spring.myspring.eventlistener;

public class Workshop {

	String topic ;
	double fee ;
	int nos  ;
	
	public Workshop(String topic, double fee, int nos) {
		super();
		this.topic = topic;
		this.fee = fee;
		this.nos = nos;
	}
	
	@Override
	public String toString() {
		return "Workshop [topic=" + topic + ", fee=" + fee + ", nos=" + nos + "]";
	}
}
