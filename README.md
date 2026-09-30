# Smart Pantry Manager

## Mobile App Development 700 -- Practical Assignment

**Project:** Smart Pantry Manager\
**Platform:** Android\
**Language:** Java\
**IDE:** Android Studio\
**Database:** Room Database (SQLite)\
**UI Components:** AndroidX, Material Design, RecyclerView

------------------------------------------------------------------------

## 1. Project Overview

Smart Pantry Manager is an Android mobile application designed to help
users manage pantry ingredients and receive recipe suggestions based on
ingredients that are already available.

The application provides pantry management features and recipe
recommendations while applying a strict matching approach: a recipe
should only be suggested when all of its required ingredients are
available in the pantry.

The project was developed in Java using Android Studio and uses Room
Database for persistent local data storage.

------------------------------------------------------------------------

## 2. Main Features

### Pantry Management

-   Add pantry ingredients
-   View pantry ingredients
-   Edit/update pantry ingredients
-   Delete pantry ingredients
-   Store quantity and unit
-   Store an optional expiry date
-   Persist pantry information using Room Database

### Recipe Management

-   Store a collection of recipes
-   Store recipe names
-   Store required ingredients
-   Store preparation steps
-   Display suggested recipes
-   Open a recipe to view its full details

### Recipe Matching

The application uses strict recipe matching.

A recipe is displayed only when all required ingredients are available
in the pantry. Partial matches are not intended to be displayed.

### Settings

The application includes a settings/profile area with an expiry-alert
option.

------------------------------------------------------------------------

## 3. Main Screens

The application includes the following main screens/activities:

1.  **MainActivity** -- application navigation/home screen
2.  **PantryListActivity** -- displays pantry ingredients
3.  **AddEditIngredientActivity** -- adds and edits pantry ingredients
4.  **SuggestedRecipesActivity** -- displays matching recipes
5.  **RecipeDetailActivity** -- displays recipe ingredients and
    preparation steps
6.  **SettingsActivity** -- application settings

------------------------------------------------------------------------

## 4. Database

The application uses **Room Database** for local persistent storage.

Main database components include:

-   `PantryItem` -- pantry ingredient entity
-   `PantryItemDao` -- pantry CRUD operations
-   `Recipe` -- recipe entity
-   `RecipeDao` -- recipe database operations
-   `PantryDatabase` -- Room database definition
-   `DatabaseClient` -- database access

Room provides persistent storage so pantry information can remain
available after the application is closed and reopened.

------------------------------------------------------------------------

## 5. Important Java Files

The main Java source files include:

``` text
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
```

Additional adapter, converter and recipe classes may be included in the
project source folder.

------------------------------------------------------------------------

## 6. Technologies Used

-   Java
-   Android Studio
-   Android SDK
-   AndroidX
-   RecyclerView
-   Material Design
-   Room Persistence Library
-   SQLite through Room
-   Git/GitHub

The project does not require Google Maps, GPS or location services.

------------------------------------------------------------------------

## 7. How to Open the Project

1.  Install Android Studio.
2.  Extract the submitted project ZIP.
3.  Open Android Studio.
4.  Select **Open**.
5.  Select the `SmartPantryManager` project folder.
6.  Allow Gradle to synchronize.
7.  Connect an Android device or start an Android Emulator.
8.  Select the `app` run configuration.
9.  Click **Run**.

If Android Studio asks to install missing SDK components, install the
components required by the project.

------------------------------------------------------------------------

## 8. Testing Evidence

The submission report contains screenshots demonstrating the application
interface and core functionality, including:

-   Pantry item display
-   Adding ingredients
-   Editing/updating ingredients
-   Deleting ingredients
-   Recipe suggestions
-   Recipe details
-   Strict recipe matching
-   Settings
-   Database/persistence-related functionality

The report also includes explanations of the implementation, testing,
challenges and solutions.

------------------------------------------------------------------------

## 9. Assignment Documentation

The submission includes:

``` text
Smart_Pantry_Manager_Final_Submission_Report.pdf
Smart_Pantry_Manager_Final_Submission_Report.docx
README.md
SmartPantryManager project source
Screenshots/
```

The report contains the project introduction, system design,
implementation discussion, testing evidence, challenges and solutions,
conclusion and references.

------------------------------------------------------------------------

## 10. Video Demonstration

A narrated demonstration video was planned as part of the practical
assignment requirements.

Due to repeated system memory/performance crashes while attempting to
record the demonstration, a complete recording could not be produced.

The submission therefore provides detailed screenshots and written
technical evidence in the report to document the implemented
functionality.

------------------------------------------------------------------------

## 11. GitHub

The project is intended to be maintained in a public GitHub repository.

Repository:

**\[Insert your GitHub repository link here\]**

Before submission, replace the line above with the actual repository
URL.

------------------------------------------------------------------------

## 12. Author

**Student:** Nthabiseng Tshwale\
**Programme:** Richfield Graduate Institute of Technology\
**Module:** Mobile App Development 700\
**Project:** Smart Pantry Manager

------------------------------------------------------------------------

## 13. Academic Statement

This README describes the submitted Smart Pantry Manager Android
application, its technologies, project structure and documented
functionality. The accompanying report provides additional
implementation details and screenshot-based evidence.
