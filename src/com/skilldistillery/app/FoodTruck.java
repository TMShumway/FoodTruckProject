package com.skilldistillery.app;

public class FoodTruck {
	
	private static int uniqueIdGenerator = 10001;
	private final int uniqueId;
	private String name;
	private String foodType;
	private double rating;
	
	// no-arg constructor
	public FoodTruck() {
		this.uniqueId = uniqueIdGenerator;
		++uniqueIdGenerator;
	}
	
	// 3-arg constructor
	public FoodTruck(String name, String foodType ,double rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.uniqueId = uniqueIdGenerator;
		++uniqueIdGenerator;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFoodType() {
		return foodType;
	}


	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getUniqueId() {
		return uniqueId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name = ");
		builder.append(name);
		builder.append(", uniqueID = ");
		builder.append(uniqueId);
		builder.append(", rating = ");
		builder.append(rating);
		builder.append(" Stars");
		return builder.toString(); 
	}
	
	
}
