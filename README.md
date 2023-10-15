# human_ressources_webApp

A Java EE web application for managing tasks.

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
9.  Right click on src/main/main -> new -> package name it com.app.controller (here  add all servlets)
10. Right click on src/main/main -> new -> package name it com.app.entity (here  add all entitys )
11. Right click on src/main/main -> new -> package name it com.app.util (here  add all HibernateUtil class to create your database and your tables )
12. Configure the project settings (such as the JRE, build path, etc.) as needed.
13. Click Finish to create the project.

## Folder Structure

