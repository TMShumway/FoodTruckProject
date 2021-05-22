package com.skilldistillery.app;

import java.util.Arrays;
import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		
		FoodTruckApp foodTruckApp = new FoodTruckApp();
		Scanner kb = new Scanner(System.in);
		
		foodTruckApp.printWelcomeHeader();
		
		FoodTruck[] foodTrucks;
		foodTrucks = foodTruckApp.truckCreationMenu(kb);
		
		boolean quitLoop = false;
		
		while(!quitLoop) {
			foodTruckApp.printMenu(); 
			int userChoice = kb.nextInt();
			
			switch(userChoice) {
				case 1:
					System.out.println("-------------------------------------------------------------------------------");
					for(FoodTruck truck : foodTrucks) {
						System.out.println(truck.toString());
					}		
					foodTruckApp.pauseBeforeContinuing(kb);
					break;
				case 2:
					double average = 0;
					for(int i = 0; i < foodTrucks.length; ++i) {
						average += foodTrucks[i].getRating();
						if(i == foodTrucks.length - 1) {
							average /= (i + 1);
						}
					}
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("The average rating of all the food trucks is: " + average + " stars");

					foodTruckApp.pauseBeforeContinuing(kb);
					break;
				case 3:
					int highestRatedIndex = 0;
					for(int i = 0; i < foodTrucks.length; ++i) {
						if(foodTrucks[i].getRating() > foodTrucks[highestRatedIndex].getRating()) {
							highestRatedIndex = i;
						}
					}
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("Highest-rated Truck: " + foodTrucks[highestRatedIndex].toString());
					foodTrucks[highestRatedIndex].toString();

					foodTruckApp.pauseBeforeContinuing(kb);
					break;
				case 4:
					quitLoop = true;
					break;
				default:
					System.err.println("Invalid input. Please choose from the available options.");
					break;
			}
		
			System.out.println("-------------------------------------------------------------------------------");
		}
		
		System.out.println("---------------------------------- Farewell! ----------------------------------");
		kb.close(); 
	}
	

	private void printWelcomeHeader() {
		System.out.println("*************************Welcome to the Food Truck App*************************");
		System.out.println("-------------------------------------------------------------------------------");
	}

	private FoodTruck[] truckCreationMenu(Scanner kb) {
		FoodTruck[] foodTrucksTemp = new FoodTruck[5];
				
		System.out.println("                 - Let's create up to five food trucks! -");
		System.out.println("\nFollow the prompts. Input 'quit' as the truck name to exit creation menu.");
		int index;
		for(index = 0; index < 5; ++index){
			System.out.print("Please enter the name of the food truck: ");
			String name = kb.nextLine();
			
			if(name.equalsIgnoreCase("quit")) {
				if (index == 0) {
					System.err.println("You must create at least one Food Truck.");
					System.out.println("-------------------------------------------------------------------------------");				
					--index;
					continue;
				}
				System.out.println("-------------------------------------------------------------------------------");				
				break;
			}
			
			System.out.print("Please enter the truck food type: ");
			String foodType = kb.nextLine();
			
			System.out.print("Please enter the food truck rating from 1 - 5: ");
			int rating = kb.nextInt();
			kb.nextLine();
			
			foodTrucksTemp[index] = new FoodTruck(name, foodType, rating);			
			System.out.println("-------------------------------------------------------------------------------");				
		} 
		return Arrays.copyOf(foodTrucksTemp, index); // TODO FIXME
	}

	private void printMenu() {
		System.out.println("                                 - Main Menu -");
		System.out.println("\nPlease make a selection from the following choices: ");
		System.out.println("\n1) View each food truck ");
		System.out.println("2) View the average rating of all food trucks ");
		System.out.println("3) View the highest-rated food truck");
		System.out.println("4) Exit and close program");
		System.out.print("\nInput your selection as a number from 1 - 4: ");
	}
	
	private void viewAllFoodTrucks() {
		
	}
	
	private void pauseBeforeContinuing(Scanner kb) {
			System.out.print("\nInput any letter or number to continue...");
			String userInput = kb.next();
			System.out.println();
	}
}
