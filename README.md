# Bubble Tea Tracker

## An app for boba addicts

My personal project idea is a desktop Java application that is able to track the bubble tea intake of the user. 
It does so by allowing the user to input the drink(s) that they ingested throughout the day, week, or month, etc... 
And the program will calculate the amount of calories they have ingested in total as well as the amount of money
they have spent on purchasing bubble tea drinks. 

The key features include:
- User can select the type of drink (milk or non-milk)
- User can choose the sugar level (0%, 30%, 50%, 70%, 100%, 120%)
- User can select a topping they ingested
- The total amount of money the user has spent so far on bubble tea
- The total amount of calories the user has ingested

Possible extra features include:
- A *surprise me* button in which the application generates a random drink for the user to try out
- A personalized recommendation on which drink to try next based on the user's past drinks

This project is of interest to me because I grew up drinking bubble tea. When bubble tea's popularity started to grow
in Vancouver, I was extremely happy because it meant more accessibility to these drinks. However, as it is easier to
buy bubble tea now, it is very common to overspend on it, which can also cause health concerns. For someone like me who
is not only health-conscious, but also money-conscious, an application like this will help me be more aware of how much 
I actually drink bubble tea.

## User Stories

- As a user, I want to be able to add a Drink to my DrinkList
- As a user, I want to be able to view my list of drinks
- As a user, I want to be able to select the type of drink to input (milk or non-milk)
- As a user, I want to be able to specify the sugar level of the drink to input
- As a user, I want to be able to select a topping for my drink to input
- As a user, I want to be able to specify how much my drink costs
- As a user, I want to be able to see the total amount of money I have spent on drinks
- As a user, I want to be able to see the total amount of calories in my list


- As a user, when I select the quit option from the application menu, I want the option to save my to-do list to file
- As a user, I want to be able to optionally load my to-do list from file when the program starts 


##Instructions for Grader
- You can generate the first required event by: Press add drink, choose a size, choose a flavour, choose a sugar level,
choose a topping, input number of calories (integer) and press submit, enter a price (double) such as 5.12 and press
submit. This will add the Drink to the list on the right side when the application is reopened.
- You can generate the second required event by closing the application and reopening it, as the second event's goal
is to display that the new drink's calories and price is added to the total on the left panel.
- You can locate my audio component by pressing the submit button on the enter price page.
- You can save the state of my application by entering a drink. The application will save automatically.
- You can reload the state of my application by closing my application and reopening it as the state will load
automatically.


##Phase 4: Task 2
The option I chose to implement is to test and design a class that is robust. My method that throws a checked exception
is my playSound method in the CenterPanel class. The corresponding test class to this method is in the class called 
"SoundTest". It has two tests: one where an exception is expected, and another where it is not expected. Other methods
that throw a checked exception is getTextCalories and getTextPrice methods inside CenterPanel. They throw a
NegativeNumberException, which is an exception I created to ensure the Calories and Price fields are non-negative
numbers.
