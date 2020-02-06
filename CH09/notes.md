New chapterrr baby and yes listening to one of the beautiful....Perfect by Ed Sheeeran!1

*Warning this chapter contains the material about the death if object so dont get too attached to that*

simly awesome..see this is how i like to start a neww chapter

two areas of memory
1. for objects created is the **HEAP**
2. for the method invocations and local variables is the **STACK**

and about the objects in the method we shou;d remember that the actual object stays in the heap and the object reference goes to stack...
the object always always **ALWAYS** goes on the heap

the dumb question is pretyy obviouss :)) lohl
ohk so STACK and HEAP coooool

now that  we know where our variable live
that is objects live on the heaps always
and the method which has the non primitive type only store the value of the refrence

theonly way to invoke the constructor is with the keyword ***new*** followed by the name of the class
every class has a **CONSTRUCTOR** which instantiates the object

we can call the constructor within the the constructor..how cool is that??
ooooooh...and we dont have to write the constructor...obvio we can but if we dont then the compiler writes for you....hawww!!


owww so we can write our own like that

## Sharpen your pencil
1. for sure the counter to see how many objects 
2. create has -a objects
3. assign values to the objects instance variable

## shapren your pencil
1. Duck(density. weightt) --> Duck(float d, int w)
2. Duck(name, feathers) --> Duck(String s, long[])
3. Duck(canFly) --> Duck(boolean b)
4. Duck(3.3F, airspeed) --> 1. one
5. Duck(airspeed, denstiy) --> Duck(int a, float b)

## TANDQ
its really a good question that marking the constructor private what would happen them

so i get it whenever we say **new** or call it the whole **Chain reaction** starts of calling the constructors and yes the abstract class also have the constructors even though we cannont call the new on that particular class

The above process is called **Constructor Chaining**

its really nice the way we thought of the next situationa and voila the next topic is that only

## SYP
A first animal then hippo

the superclass part of the object has to be fully formed before constructng the subclass object

if we dont call the super constructor then its fine the compiler will call itself or put it in the code
but if we explicitly define a super constructor then it has to be the first statment in the constructor otherwise it wont compile

if the super class needs any arguments to make the object then we can send the arguments in the *super(args)* also which will eventually be forwarded to the superclass

## sharpen your pencil
1. public SonOfBoo(String a, String b, String c) {
super(a,b);
}

2. public SonOfBoo(int i, int x, int y) {
super(i, “star”);
}

3. public SonOfBoo(int i, String s) {
}

life of an variable depends on whether its a local variable or instance variable

Suppose the local variable is in the method A and the method A calls the method B then the *life* of the variable is still alive but *scope* is not there when the method b completes the execution the the *scope* comes in it 

if you want to get rid of the object refernece just make it *null* like
*Object a = new Object();
a = null*

# ways of object killing
1. Reference goes out of scope
2. assigning it the another object
3. explicity setting it to *null*


yehhhhhhh **FIRESIDE CHATS**

wow local variables are also calles wait...local(obvio), stack, automatic, scope-challenged
