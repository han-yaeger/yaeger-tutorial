package com.github.tvloet1.seacleaner.entities;

import com.github.hanyaeger.api.Timer;

public class OxogenTimer extends Timer {

	public OxogenTimer(long intervalInMs) {
		super(intervalInMs);
		System.out.println("Constructed");
	}

	@Override
	public void onAnimationUpdate(long timestamp) {
		if (timestamp > 0) {
			System.out.println("Breathe!!!");
		}
	}
}
