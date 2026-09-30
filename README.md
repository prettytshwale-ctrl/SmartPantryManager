# Smart Pantry Manager

## Mobile App Development 700 -- Practical Assignment

**Project:** Smart Pantry Manager  
**Platform:** Android  
**Language:** Java  
**IDE:** Android Studio  
**Database:** Room Database (SQLite)  
**UI Components:** AndroidX, Material Design, RecyclerView, Jetpack Compose (theme)

---
 1. Project Overview

Smart Pantry Manager is an Android mobile application designed to help
users manage pantry ingredients and receive recipe suggestions based on
ingredients that are already available.

The application provides pantry management features and recipe
recommendations while applying a strict matching approach: a recipe
should only be suggested when all of its required ingredients are
available in the pantry.

The project was developed in Java using Android Studio and uses Room
Database for persistent local data storage. Jetpack Compose was used for
theme customization.

 2. Main Features

### Pantry Management
- Add pantry ingredients  
- View pantry ingredients  
- Edit/update pantry ingredients  
- Delete pantry ingredients  
- Store quantity and unit  
- Store an optional expiry date  
- Persist pantry information using Room Database  

### Recipe Management
- Store a collection of recipes  
- Store recipe names  
- Store required ingredients  
- Store preparation steps  
- Display suggested recipes  
- Open a recipe to view its full details  

### Recipe Matching
The application uses strict recipe matching.  
A recipe is displayed only when all required ingredients are available
in the pantry. Partial matches are not intended to be displayed.

### Settings
The application includes a settings/profile area with an expiry-alert
option.


3. Main Screens
1. **MainActivity** -- application navigation/home screen  
2. **PantryListActivity** -- displays pantry ingredients  
3. **AddEditIngredientActivity** -- adds and edits pantry ingredients  
4. **SuggestedRecipesActivity** -- displays matching recipes  
5. **RecipeDetailActivity** -- displays recipe ingredients and steps  
6. **SettingsActivity** -- application settings  

4. Database
The application uses **Room Database** for local persistent storage.

Main database components include:
- PantryItem -- pantry ingredient entity  
- PantryItemDao -- pantry CRUD operations  
- Recipe -- recipe entity  
- RecipeDao -- recipe database operations  
- PantryDatabase -- Room database definition  
- DatabaseClient -- database access  

Room provides persistent storage so pantry information remains available
after the application is closed and reopened.


 5. Important Java Files

MainActivity.java
PantryItem.java
PantryItemDao.java
PantryDatabase.java
DatabaseClient.java
PantryListActivity.java
PantryAdapter.java
AddEditIngredientActivity.java
SuggestedRecipesActivity.java
RecipeDetailActivity.java
SettingsActivity.java

6. Technologies Used
Java

Andrid Studio

Android SDK

AndroidX

RecyclerView

Material Design

Room Persistence Library

SQLite through Room


Git/GitHub

7. How to Open the Project
Install Android Studio.

Extract the submitted project ZIP.

Open Android Studio.

Select Open.

Select the SmartPantryManager project folder.

Allow Gradle to synchronize.

Connect an Android device or start an Android Emulator.

Select the app run configuration.

Click Run.

8. Screenshots
The submission includes screenshots demonstrating:

Pantry CRUD (Add, Read, Update, Delete)

Input validation (required fields, quantity checks)

Persistence after reopening the app

Recipe suggestions and recipe details

Strict matching and no-match feedback

Settings screen with expiry-alert toggle


9. Known Issues / Limitations

A narrated video demonstration could not be completed due to repeated
system memory crashes during recording.

Detailed screenshots and written evidence are provided instead to
document functionality.

10. Future Improvements
Notifications for expiring items

Cloud synchronization

User authentication

Improved UI with more Jetpack Compose components

11. GitHub
The project is intended to be maintained in a public GitHub repository.

Repository:
[https://github.com/prettytshwale-ctrl/SmartPantryManager.git]

12. Author
Student: Nthabiseng Tshwale
Programme: Richfield Graduate Institute of Technology
Module: Mobile App Development 700
Project: Smart Pantry Manager

13. Academic Statement
This README describes the submitted Smart Pantry Manager Android
application, its technologies, project structure and documented
functionality. The accompanying report provides additional
implementation details and screenshot-based evidence.
