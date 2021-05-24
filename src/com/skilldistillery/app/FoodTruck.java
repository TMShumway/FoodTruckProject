package com.skilldistillery.app;

public class FoodTruck {
	
	// Class fields
	//-------------
	private static int uniqueIdGenerator = 10001;
	
	// Field intializer block assigns each class instance a unique ID
	// Static field uniqueIDGenerator is then incremented for next instance
	//---------------------------------------------------------------------
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
	//-------------------
	public FoodTruck() {
		
	}
	
	// 3-arg constructor
	//------------------
	public FoodTruck(String name, String foodType ,double rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		sumOfAllRatings += this.rating;
	}


	// Getters and setters follow
	//---------------------------
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
	
	
	// Overrides built in toString() for class method
	//-----------------------------------------------
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("-Name: %-10s , ", name));
		builder.append(String.format("ID#: %-7s, ", uniqueId));
		builder.append(String.format("Rating: %-7f -", rating));
		return builder.toString(); 
	}
	
} //close brace for class
