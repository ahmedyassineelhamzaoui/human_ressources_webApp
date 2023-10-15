# human_ressources_webApp

A Java EE web application for managing tasks.

## Project Content
| Technologies Used         | <a name="technologies-used"></a>                    |

## Technologies Used
- Java
- Java EE (Enterprise Edition)
- HTML5,CSS3 and bootsrap
- JavaScript
- Spring Framework (version 5.2)
- Hibernate ORM (version 6.3.3)
- Maven (for project management)
- MySQL Database
- JSP,JSF Servlet
- Apache Tomcat Server (version 9)

## Getting Started

### Method 1: Cloning the Project

1. Open a terminal or command prompt.
2. Navigate to the directory where you want to clone the project.
3. Run the following command to clone the project repository:
5. git clone [repository_url]
6. After opening the project, open a terminal or command prompt and navigate to the project directory.
Run the following Maven commands to clean and build the project: mvn clean install
7. To configure the database, edit the `persistence.xml` file.
8. Visit `http://localhost:8080/human_ressources_webApp` to access the application.

### Method 2: Creating the Project from Scratch in Eclipse
1. Install tomcat.
2. Integration of tomcat in eclipse https://objis.com/tutoriel-java-ee-integration-tomcat-8-dans-eclipse/
3. Open Eclipse IDE.
4. Click on File in the menu bar, then select New and choose Dynamique web project.
5. Enter a project name and click Next and choose the tomcat apache.
6. Right click in your project -> go to configure -> click on Convert to maven project.
7. Right click on your project and click into build path -> configure  Build path -> click into JRE System Library[javaSE-version] -> click Apply and close  (here you can see a new 
   direction resources ).
8.  Right click on src/main/resources -> new -> folder and type META-INF -> Right click on this folder and new -> file name it persistence.xml
9.  ![persistence](https://github.com/ahmedyassineelhamzaoui/human_ressources_webApp/assets/110307855/d0774b21-cbde-4b60-9c44-fada5b02454e)
10.  Right click on src/main/main -> new -> package name it com.app.controller (here  add all servlets)
11. Right click on src/main/main -> new -> package name it com.app.entity (here  add all entitys )
12. Right click on src/main/main -> new -> package name it com.app.util (here  add all HibernateUtil class to create your database and your tables )
![hibernateutil](https://github.com/ahmedyassineelhamzaoui/human_ressources_webApp/assets/110307855/5ab0eccd-11e4-43fe-a844-94d406d43b6a)

## Folder Structure
![project_structure](https://github.com/ahmedyassineelhamzaoui/human_ressources_webApp/assets/110307855/490f344b-d5c9-4d53-933c-6921dc3c1782)
## UML Diagrame
![uml diagrame](https://github.com/ahmedyassineelhamzaoui/human_ressources_webApp/assets/110307855/7d5a2ee5-ba76-4ab4-b8e0-6e21b8517d1f)
