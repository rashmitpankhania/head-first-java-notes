New chapterrrrrrr... name gives goosebumps..not really but yeah Serious Polymorphism
importantt thing to remember is that we can use the refrenece of the superclass to point the subclass object

the biggest statement about the interface is that **Some class should not just be instantaited** they are just meant to you know stay ther and inherit it..you know lohl!!

**when we make our class as abstract we are telling that its not meant for instantiated it just for the inheritance and the polymorphism**

abstract is antiii *concrete*

if we mark a method abstract then we have to mark the class  as abstract as well
there cannont be a concrete or non abstract class with a abstract method but
there is a possiblity that a asbtract class can have the abstaract and/or non abstract methods obviuolsy

##reason of the abstract methods 
the reason for the abstract methods is that we cannot come up with the generic code of all the subclasses to put it into the superclass so the point of the abstract method is that to use **protocol**

the whole point of the polymorphism is that ability to use the superclass as the method argument or the return type or array type

an abstract class inheriting from the abstract class can have abstract methods as well concrete methods

##sharpen your pencil
1. Tree in abstract can be for tree nursery application and concrete in golf course simulation
2. House in abstract can be for architect applicatioon and concrete in city map
3. Town in abstract can be for urban develeopment application and concrete for the sateliite view
4. Football as abstract in coaching application and player concrete in FIFA
5. Chair as abstract in carpentry type simulation and as concrete in House or building model simulation
6. Customer as abstract in Banking type sophisticated application and as concrete in small online shop
7. Sales order as abstract in Ecommerce application and as concrete in small ecommerce i m so dumb
8. Book as abstract in library application and as concrete in Student data
9. Store as abstract in Mege mall kind of application and as concrete in town planning application
10. Supplier as abstract in logistics application and as concrete in convienient store 
11. Golf club as abstract in golf game and as concrete in store data
12. Carburetor as abstract in mechanic simulation and as concrete in Car ecommerce application
13. Oven as abstract in Bakery kind of application and as kitchen model

WHOAAh!! **class OBJECT is the mother of all the classes its super class of everything in this knwon and unknown universe**

when an object is refrenced by the variable of type of Object class, it can't be assigned to actual variable declared with actual type

**Roses are re,  violets are blue
extend only one, implement two**

#bullet points
1. when you dont want the clas to be instantiated just make it ***abstract***
2. an abstract class can have both abstract and non abstract methods
3. if the class has even one abstract method whole class must be marked abstract
4. an abstract method has no body
5. all abstract methods must be implemented in first and latter subclasses
6. Every class in java is either dirct or indirect subclass of class *Object*
7. to invoke the superclass version of the method use *super* keyword

#Whats the decalaration
1.
public class Click{}
public class Clack extends Click{}

2.
public abstract class Top{}
public class Tip extends Top{}

3.
public abstract class Fee{}
public abstract class Fi extends Fee{}

4.
public interface Foo{}
public class Bar implements Foo{}
public class Baz extends Bar{}

5.
public interface Zeta{}
public class Alpha implements Zeta{}
public interface Beta{}
public class Delta extends Alpha implements Beta{}
