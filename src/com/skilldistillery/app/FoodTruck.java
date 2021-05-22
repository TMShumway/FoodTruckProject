package com.skilldistillery.app;

public class FoodTruck {
	
	private static int uniqueIdGenerator = 10001;
	private final int uniqueId;
	{
		this.uniqueId = uniqueIdGenerator;
		uniqueIdGenerator++;
	}
	private String name;
	private String foodType;
	private double rating;
	private static double sumOfAllRatings;
	
	// no-arg constructor
	public FoodTruck() {
		
	}
	
	// 3-arg constructor
	public FoodTruck(String name, String foodType ,double rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		sumOfAllRatings += this.rating;
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

	public double getAllTruckAverageRating() {
		return sumOfAllRatings / ((uniqueIdGenerator - 1) % 10000);
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
