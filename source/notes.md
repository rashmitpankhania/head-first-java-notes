feels like we are in endgame

always it so cool to learn about deployment because to deliver the end users in the most efficient way

so the deployment options are

1. executable jars
2. java webstart
3. rmi(remote method invoaction) app
4. http servelets

one important step is to separate the source code and class file

so a jar file is **J**ava **AR**chive

to run the jar we have to make it executable and to make it executable you just create a **Manifest** file which tells the jvm where is class holding the main method

we created our own jar also with below steps
1. create a manifest.txt file in the classes directory
2. type
        
        
            Main-Class: <Your class containing main method without .class>
3. type in the classes directory
            
            
           jar -cvmf manifest.txt <whatever name you want>.jar *.class
4. this will create the jar

and to run finally type
        
        
        java -jar <your>.jar
thats it!!

one more important thing is that after you have put your class in the package you cannot run it by its short name

you just have to run it by its full qualified name

now here is the time to create the  jar out of the package

1. make sure the structure is correct and always include the first directory in jar only usually here com

2. now create the manifest file same level as the com directory and write
			
			Main-Class: com.rashmit.RAsh
remember to write the fully qualified name as the jvm wont know th short name now

3. now write the magical command of jar
			
			cd classes/
			jar -cvmf manifest.txt newRash.jar com

## sharpen your pencil
			
			cd source
			javac -d ../classes/ com/rashmit/Foof.java

			cd ../classes
			jar -cvmf manifest.txt foof.jar com/rashmit/Foof.class

			cd .
			java -jar foof.jar

in bonus question the javaranch.cows the name is ambigoius??

one important and obvious thing - to run jar you need to have java

so that was all part of the executable JARS

## now it is getting more and more exituing - **java WEB START**
oohk so its just executable JAR distributed over the browser

so first time you get it one the browser after you download it becomes a stand alone java application

to make java we start app you need .jnlp file **JAVA NETWORK LAUNCH PROTOCOL**

## steps for making and deploying java web start app
1. obviiously make a jar application

2. make a jnlp file

3. place your file in the web server(you can create simple html and make a link out of it)

4. add a new mime type to your web server

## whats first
user clicks the link
browser requests the jnlp file
server sends the jnlp file
browser start up the jws helper app
helper app request the jar file
webserver sends the jar to the jws helper app
the jws helper app invokes the main method

## true or false
t t(f) f f t f f t t(f) f f t t t t f f f

## crossword after long time
# across
6. wont travel-transient
9. dont split me - atomic


# down