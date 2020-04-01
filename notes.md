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

## jnlp file
the template for the jnlp file we can find on its main documentation page from oracle sun also which i find it from

some important tags are like
			
			<offline-allowed/>
that is the user can still run the application without interney