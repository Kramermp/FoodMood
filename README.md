# FoodMood
An Application that tracks food eaten and the resulting mood

Login: 
Username: User1 
Password: password


Chain of Responsibility - Food/Mood CRUD (Controllers and Models) - Lowell Buttorff
Password Strength Meter - Login UI - Lowell Buttorff
Iterator - Notification Detail Views - Hannah Garthwaite
Notifications - Notification List View and Notification Detail View - Hannah Garthwaite


Refractoring Implementations
NavigationCntl - fixed bug that made the application crash when the Notification button was selected on homescreen
The SQLite is now included in the zipped project file to ensure the application can run properly
    This problem was the bulk of the refractoring plan given to us by our 'partner group'
All of the UI's (Home, Food, Mood, FoodList, MoodList, Notifications, Recommendations, and UserProfile) have been changed to the same size (a typical mobile device visual). 
    Instead of creating a new frame with each UI, one frame is used and the application passes it around and adds new panels for each screen (implemented by Michael Kramer)
