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
