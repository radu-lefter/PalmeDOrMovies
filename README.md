# Palme D'Or Nominees REST API
## A Java Bootcamp final project

This project is the result of the final challenge from the QA DFE Bootcamp. The challenge was to create a REST API that can handle HTTP requests and that demonstrates CRUD functionality. The project was also built following Agile and MoSCoW practices. 
Although this is a REST API, a simple fron-end was built into it using Thymeleaf templates. Access routes adding "app" at the end of the route to get a more
pleasant visualisation, for example "/allmoviesapp".


## Features

- Get a list of all the nominees : http://localhost:8080/allmovies
- Get a list of all the nominees with frontend: http://localhost:8080/allmoviesapp
- Get a nominees by id: http://localhost:8080/getmovie/{movieid}
- Add a nominee : http://localhost:8080/createmovie
- Add a nominee from frontend: http://localhost:8080/createmovieform
- Update a nominee:  http://localhost:8080/updatemovie
- Delete a nominee: http://localhost:8080/deletemovie/{movieid}
- Get winners or runner ups: http://localhost:8080/getmoviebywinners/{win}
- Get nominees for a certain year: http://localhost:8080/getmovieyear/{year}
- Get nominees after a certain year: http://localhost:8080/getmovieafteryear/{year}



## Tech


I used a number of open source projects to create the project:

- [Spring Boot] - Create a basic REST API in a day!
- [Thymeleaf] - As simple as installing the extension
- [Eclipse] - A lightweight but powerful editor
- [Swagger] - Generates an endpoint interface
- [Postman] - For testing more complex endpoints
- [Lombok] - Removes the clutter in your code
- [Mockito] - Makes testing more manageable
- [Plant UML] - Used to create the ERDs


## Installation

The API requires Spring Boot vs 2.7 and Java vs 18 to run. The jar file is called palmedor and it can be found in the main or the target folder.
It can be executed from the command line with java -jar palmedor.jar.
It will automatically install the dependencies and start the server.

## Development

Want to contribute? Great!

The project is stil in its first stages and needs to be enhanced. Contributions are welcome! More custom queries need to be added. The views for the app needs to be enhanced and the update and delete functionality for the fron-end need to be implemented. Tests need to be added to reach 100% coverage.  

## Visual guide
Swagger\
<img width="938" alt="image" src="https://user-images.githubusercontent.com/68811789/187079225-2ec147c3-30a4-45bf-acc8-1d71c5db538a.png">


Postman requests\
<img width="658" alt="image" src="https://user-images.githubusercontent.com/68811789/186955047-31cd5fe4-5500-41c9-91b4-2e83db28c9c4.png">

Frontend\
<img width="940" alt="image" src="https://user-images.githubusercontent.com/68811789/187404083-75bc3b74-9c18-4107-8380-2be1519f6e5e.png">



Data persisted locally\
<img width="783" alt="image" src="https://user-images.githubusercontent.com/68811789/186955390-a01f6c10-135f-4ca9-80b1-d4b2c412fa06.png">


Test coverage\
<img width="864" alt="image" src="https://user-images.githubusercontent.com/68811789/187077446-4df211b0-9f3d-4d7e-afce-71eeaf840d0e.png">


ERD\
<img width="436" alt="image" src="https://user-images.githubusercontent.com/68811789/186958356-408fbbd2-6874-401c-8068-b0d0744b6064.png">


Jira board: https://palmedor.atlassian.net/jira/software/projects/PDM/boards/2



## License

MIT

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [Spring Boot]: <https://spring.io/projects/spring-boot/>
   [Eclipse]: <https://www.eclipse.org/downloads/>
   [Thymeleaf]: < https://www.thymeleaf.org/>
   [Lombok]: <https://projectlombok.org/>
   [Swagger]: <https://swagger.io/>
   [Mockito]: <https://site.mockito.org/>
   [Postman]: <https://www.postman.com/>
   [Plant UML]: <https://plantuml.com/>
