# QuizMonolithicApplication
Monolithic Application with MySQL.

## Quiz App:
- We will build a Monolithic application first and then break it down into micro-services.
- Using Dependencies like Spring Web, Mysql, data JPA, and Lambok.
- Installed: STS and Mysql Workbench.

## Steps to Build this App:

### Database
```text
- Created Database Questions with tables questiontb, quiz and quiz_questions.
```
- ![image](https://github.com/pranjalisingh1201/QuizMonolithicApplication/assets/75729195/f107d935-f479-4b58-aee9-4a566bdce5b6)
## ERR  Diagram
![image](https://github.com/pranjalisingh1201/QuizMonolithicApplication/assets/75729195/3311a1a0-7931-4ae9-83f5-dbc82a3fdbc9)

## Database Dumps and SQL Scripts
-  Added Collection in the repository : https://github.com/pranjalisingh1201/QuizMonolithicApplication/blob/main/TestingAndDatabaseDumps.

### Application
- Created a question controller to get all questions from the database.
- With the help of Rest Controller to make this file a controller, Getmapping is used to map the function to the all-questions endpoint and request mapping for mapping the request path question to dispatcher.
- Now to get all the data from the database, we use multiple layers in the app.
- We have 3 layers -
- Controller Layer - Request handling
- Service Layer - Business Logic or Processing
- Dao Layer   - Database class
- We create an Entity class to represent the table and variables in this class are columns of the tables, this class is called model in MVC.
- Class name  - Table name
- Class fields - Table Columns
- Class object is one row of table data (ORM).
	
### 5 Types  of Status Codes
- Informational Responses (100-199)
- Successful Responses (200-299)
- Redirection messages (300-399)
- Client Error Responses (400-499)
- Server Error Responses (500-599)

## Testing With Postman Collection
- Added Collection in the repository : https://github.com/pranjalisingh1201/QuizMonolithicApplication/blob/main/TestingAndDatabaseDumps/QUIZ%20APP.postman_collection.json.
