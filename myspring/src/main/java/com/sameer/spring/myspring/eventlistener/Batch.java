package com.sameer.spring.myspring.eventlistener;

public class Batch {

	String bid ;
	String sd ;
	String timings ;
	int nos ;
	
	public Batch(String bid, String sd, String timings, int nos) {
		super();
		this.bid = bid;
		this.sd = sd;
		this.timings = timings;
		this.nos = nos;
	}

	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", sd=" + sd + ", timings=" + timings + ", nos=" + nos + "]";
	}
}
