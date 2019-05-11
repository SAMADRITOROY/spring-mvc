package com.sam.model;

import org.hibernate.validator.constraints.Range;

public class Goal {

	@Range(min=1, max=20)
	private int minutes;

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
}
