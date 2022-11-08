# avinty-hr-application test

Swagger: http://localhost:8085/swagger-ui/index.html#/

To see the time recording please open "time_record.html" in the project folder

To use the services provided by the HR application, you must authenticate your credentials.

Endpoint: http://localhost:8085/API/AUTH/login

Method: POST

Built-in user credentials (Request body):

{

"email":"test@test.com",

"password":"password"

}

For register a new employee you can call the following endpoint:

Endpoint: http://localhost:8085/API/AUTH/register

Method: POST

{

"email":"employee@test.com",

"password":"password",

"fullName":"employee7",

"depId":1

}

The API has the following endpoints: (requires a JWT token when calling an endpoint, so please call "login" endpoint for authentication)
- (GET) localhost:8085/API/V1/employees
  
  Gives back all of the records of the table.


- (GET) localhost:8085/API/V1/dep-emp
  
  Gives back every department with the connected employees. 


- (GET) localhost:8085/API/V1/department?name=?  (for example: localhost:8085/API/V1/department?name=test_dep)
  
- Filter departments based on name. The data is used in a drop-down, so the whole entity is not required.


- (POST) localhost:8085/API/V1/employees 
 
  Creates an employee.


- (DELETE) localhosts:8085/API/V1/department/:id   (for example: localhost:8085/API/V1/department/1)

  Deletes a department based on ID. Set Null to every connected employee’s DEP_ID field.