package com.skilldistillery.app;

import java.util.Arrays;
import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {

		// Instantiate needed objects
		// ---------------------------
		FoodTruckApp foodTruckApp = new FoodTruckApp();
		Scanner kb = new Scanner(System.in);
		FoodTruck[] foodTrucks;

		// Print Welcome Header to terminal
		// ---------------------------------
		foodTruckApp.printWelcomeHeader();

		// Loop menu to create minimum 1 truck up to max 5 trucks
		// -------------------------------------------------------
		foodTrucks = foodTruckApp.truckCreationMenu(kb);

		// Loop menu to display different information about food trucks
		// -------------------------------------------------------------
		foodTruckApp.makeMenuSelections(foodTruckApp, foodTrucks, kb);

		// Print End of Program Message to terminal
		// -----------------------------------------
		foodTruckApp.printFarewell();

		// Housekeeping, close all doors, don't let the cold air out!
		// -------------------------------------------------------------------
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
		for (index = 0; index < 5; ++index) {
			System.out.print("Please enter the name of the food truck: ");
			String name = kb.nextLine();

			if (name.equalsIgnoreCase("quit")) {
				if (index == 0) {
					System.err.println("You must create at least one Food Truck.");
					System.out
							.println("-------------------------------------------------------------------------------");
					--index;
					continue;
				}
				System.out.println("-------------------------------------------------------------------------------");
				break;
			}

			System.out.print("Please enter the truck food type: ");
			String foodType = kb.nextLine();

			System.out.print("Please enter the food truck rating from 1 - 5: ");
			int rating = validateIntInput(kb, 1);
			kb.nextLine();

			foodTrucksTemp[index] = new FoodTruck(name, foodType, rating);
			System.out.println("-------------------------------------------------------------------------------");
		}
		return Arrays.copyOf(foodTrucksTemp, index); // TODO FIXME
	}

	// This menu prints available options for viewing food truck data
	//---------------------------------------------------------------
	private void printMenu() {
		System.out.println("                                 - Main Menu -");
		System.out.println("\nPlease make a selection from the following choices: ");
		System.out.println("\n1) View each food truck ");
		System.out.println("2) View the average rating of all food trucks ");
		System.out.println("3) View the highest-rated food truck");
		System.out.println("4) Exit and close program");
		System.out.print("\nInput your selection as a number from 1 - 4: ");
	}
	
	// Handles switching on user selection from options in printMenu
	//--------------------------------------------------------------------------
	private void makeMenuSelections(FoodTruckApp foodTruckApp, FoodTruck[] foodTrucks, Scanner kb) {
		boolean quitLoop = false;

		while (!quitLoop) {
			foodTruckApp.printMenu();
			int userChoice = foodTruckApp.validateIntInput(kb, 2);

			switch (userChoice) {
			case 1:
				foodTruckApp.menuSelectionOne(foodTrucks);
				foodTruckApp.pauseBeforeContinuing(kb);
				break;
			case 2:
				foodTruckApp.menuSelectionTwo(foodTrucks);
				foodTruckApp.pauseBeforeContinuing(kb);
				break;
			case 3:
				foodTruckApp.menuSelectionThree(foodTrucks);
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
	}

	// The do-stuff method for selection one in printMenu options
	//-----------------------------------------------------------
	private void menuSelectionOne(FoodTruck[] foodTrucks) {
		System.out.println("-------------------------------------------------------------------------------");
		for (FoodTruck truck : foodTrucks) {
			System.out.println(truck.toString());
		}
	}

	// The do-stuff method for selection two in printMenu options
	//-----------------------------------------------------------
	private void menuSelectionTwo(FoodTruck[] foodTrucks) {
		double average = foodTrucks[0].getAllTruckAverageRating();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("The average rating of all the food trucks is: " + average + " stars");
	}

	// The do-stuff method for selection three in printMenu options
	//-------------------------------------------------------------
	private void menuSelectionThree(FoodTruck[] foodTrucks) {
		int highestRatedIndex = 0;
		for (int i = 0; i < foodTrucks.length; ++i) {
			if (foodTrucks[i].getRating() > foodTrucks[highestRatedIndex].getRating()) {
				highestRatedIndex = i;
			}
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Highest-rated Truck: " + foodTrucks[highestRatedIndex].toString());
		foodTrucks[highestRatedIndex].toString();
	}

	// This method creates a user-keyed pause before reprinting menu
	//--------------------------------------------------------------
	private void pauseBeforeContinuing(Scanner kb) {
		System.out.print("\nInput any letter or number to continue...");
		String userInput = kb.next();
		System.out.println();
	}

	// This method validates user input where an int is desired
	//---------------------------------------------------------
	private int validateIntInput(Scanner kb, int whichMenu) {
		boolean isInt = false;
		int number = 0;

		do {
						
			if(kb.hasNextInt()) {
				number = kb.nextInt();
				isInt = true;
			} else {
				System.err.println("I did not understand your input.");
				if(whichMenu == 1) {
					System.out.print("Please enter the food truck rating from 1 - 5: ");					
				} else {
					System.out.print("Input your selection as a number from 1 - 4: ");
				}
				kb.next();
			}
		} while (!(isInt));

		return number;
	}

	private void printFarewell() {
		System.out.println("---------------------------------- Farewell! ----------------------------------");
	}
}//close brace for public class
