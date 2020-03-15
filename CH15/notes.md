new chaopter with the dance monkey
and if the chapter based on the network andd threadds one of my favoutite

three important things
1. connection
2. sending
3. recieving

## socket connection
which ip and on which port

ok so each ip can run atmost 65536 services out of it 0 to 1023 are reserved for inside systems
## sharpen your pencil

reading
client - buffuredstream(bufferedchar) - inputstream(characters) - socket(01010101) -server

writing
client - printWriter - socket(01010) - server

## sharepn yyour pencil
ip and port
0 to 1023
false

## creation 
for a server to create you need two socket 
1. serversocket - this scoket is the one which waits for the client sockets to connect on and thi sport remians constant
2. normal socket after thiis connection with the server socket the connection is given to normal socket whose post is different from the server socket

now we have come to exciting part of **THREADING**

so exxatly
the thread object is given the runnable object and when we start the start it does the work aka job that us given in the runnable class
after that qwe wiull just get to learn using the runnable interface

## brain barball
first back in main
and thgen thread paart

so its goes like 
object creation - runnable - execution

and the loop usually runs between runnable and execution

## The thread scheduler
thread schedular is fuzzy we cannot change the implementations of it

**write-once-run-anywhere** platform independent code
so onec the thread has done its run part then its dead so it kind of has lost it threadness

concurrency ooooooh....so cool
the one of the most important point to be note is that when an object have more than one synchronised method then the two threads can't enter into any of those method not only the same method
because any of those method can potentially change the instance variable

Thread priorites are no guarantee they are just there to make difference in performance not to completley relying on them