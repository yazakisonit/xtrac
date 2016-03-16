This set of web services provide the fucntionality of registerign of new users with emailId as unique id.
ALtering teh details of the user, deleting user and registering apps againts a user.
When an App is registered, the app id and secret password is retured

To add a new user:
http://localhost:8080/XTRAC/developer/signup?emailId=test@gmail.com&firstName=testFirst&lastName=testLast&telNumber=12345

To update an existing user
http://localhost:8080/XTRAC/developer/update?emailId=test@yahoo.com&firstName=testFirst&last1Name=test2Last&telNumber=54321

To search details of a user
http://localhost:8080/XTRAC/developer/search?emailId=test@gmail.com

To delete a user
http://localhost:8080/XTRAC/developer/delete?emailId=test@gmail.com

To register an app with an existing user
http://localhost:8080/XTRAC/developer/register?emailId=test@gmail.com&appName=testApp&appDesc=testAppDesc

To find all the app regiterd with an user
http://localhost:8080/XTRAC/developer/applist?emailId=test@gmail.com
