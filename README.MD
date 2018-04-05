## This is a pre configured Spring Boot application that provides the whole basic configuration for an API RESTful app with HTTPS.


### First thing to do is go to src/main/java/back/upload and put at line 39, your AWS S3 credentials, where is "Put here your credentials" writen.

### Next, go to src/main/java/back/mailing and at line 27 your email account for mailing, then at line 43, repeat by putting there your email and password.

### Next, got src/main/java/back/opentok and at line 14 put your API key, then at line 15, your API secret. With this you will be able to use videochat, by getting a session and saving it into your bd, in some place in a table. Then by giving this session you will get a token to connect an Front-end application with opentok.

### If you need to change the user model you should go to src/main/java/back/security/model. Then you will find the User.java file, which especifies the table representation.

### If you modify the user model, you should change also at src/main/java/back/security, JwtUser.java and JwtUserFactory.java adding or deleting your new attributes.

### Then to create a new component to your app, just create a new folder as this /src/main/java/back/my-entity-name, and inside create my-entity-name.java, my-entity-nameRepository.java and my-entity-nameRestController.java following the src/main/java/back/project examples.

### To create your own seeders, we use SQL lenguage, by configuring the database access at src/main/resources in the file import.sql.

### To configuring the access, go to src/main/resources at application.yml at lines 18, 19 and 20.

### This project, is configured to run over SSL certificate, we actually just create an self signed certificate, but getting your own certificate, and changing the name into keystore.p12 and puting it into src/main/resources you will be able to use your certificate.

### Then at src/main/resources you have to modify your applciation.properties and and modify at line 3 your KEY. (bebote34 is te actual key for the self signed SSL certificate).


### Finally you have to install Maven in your system, to run `mvn spring-boot:run` and system will deploy and create the whole data model in your database (Rembember to create first in your database engine the database).




# amazinGenerator® 