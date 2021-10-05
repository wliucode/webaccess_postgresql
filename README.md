# Task
Create a REST API with Spring Boot 2

# Requirement
We need to create a simple REST API to store user data (e.g. FirstName, LastName, Email, and Password) to database (e.g. PostgreSQL) with that API so can create, get and update users information (delete is optional).

# Solution 
1. Create the Spring Boot project using IntelliJ IDEA Ultimate Edition. 
2. Define Database Configurations
    
    2.1 Setup Docker with PostgreSQL    
    2.2 Create new database instance named as “demodb” using psql    
    2.3 Define DB connection and table in Spring Boot project
              
        2.3.1 Create new file: resources/application.yml          
        2.3.2 Remove default file: resources/application.properties          
        2.3.3 Create resources/db/migration/V1__PersonTable.sql          
3. Create Model Class (“Person”) to present JSON payload for request body or response of REST API
4. Create DAO (Data Access Object) interface ("PersonDAO")

    4.1 Create Class "PersonDAOImpl" to implement for PostgreSQL
    
        4.1.1 Annotation: @Repository(“PostgreSQL”)
    4.2 Create Class "FakePersonDataAccessService" to Implement when DB is resided in Memory
    
        4.2.1 Annotation @Repository(“fakeDao”)
5. Create Service Class which will use corresponding DAO through “Dependency Injection” 
6. Create Rest Controller and Map API Request

    6.1 Class name: PersonController
    
    6.2 Annotation for class 
				  
		6.2.1 @RequestMapping("api/v1/person")		
		6.2.2 @RestController
	6.3 Annotation for methods
		
		6.3.1 @GetMapping for getAllPeople()		
		6.3.2 @GetMapping(path = "{id}") for getPersonById(..)		
		6.3.3 @PostMapping for addPerson(..)
7. Create Unit Testing for API Requests and Run the Unit Testing (TBD)
8. Build and Run the project

    8.1 Build: maven >> install
    
    8.2 Run: The app will start running at http://localhost:8080
9. End-to-End Testing using Postman

    9.1 Test Case 1: Add User information to DB
	    
	    9.1.1 Type: POST		
		9.1.2 Request Endpoint: http://localhost:8080/api/v1/person
		9.1.3 Request Body (JSON format)
		    {
		        "first name": "Sky",
		        "last name": "King",
		        "email": "sky.king@test.com",
		        "password": "password"
		    }
     	9.1.4 Return Status: 200 (OK)
    9.2 Test Case 2: Get User information for All the people if two person were added to DB through step 9.1
    
		9.2.1 Type: GET
	    9.2.2 Request Endpoint: http://localhost:8080/api/v1/person
		9.2.3 Response (JSON format)
	        [
    		    {
    		        "id": "cb33cbfb-1390-4663-821c-99b67ac3d4e3",
    		        "first name": "Sky",
    		        "last name": "King",
    		        "email": “Sky.King@test.com",
    		        "password": "password"
    		    },
    		    {
    		        "id": "bed415c0-c48e-426a-9947-5e77ba44e0d7",
    		        "first name": “Earth”,
    		        "last name": “Queen”,
    		        "email": “Earth.Queen@test.com",
    		        "password": "password"
    		    }
    		]
	9.3 Test Case 3: Get User information using its unique id
	
	    9.3.1 Type: GET
		9.3.2 Request Endpoint: http://localhost:8080/api/v1/person/cb33cbfb-1390-4663-821c-99b67ac3d4e3
		9.3.3 Response (JSON format)
            [
                {
    		        "id": "cb33cbfb-1390-4663-821c-99b67ac3d4e3",
    		        "first name": "Sky",
    		        "last name": "King",
    		        "email": “Sky.King@test.com",
    		        "password": "password"
                }
            ]

10. To be improved : Password Encryption. 			

[END]
