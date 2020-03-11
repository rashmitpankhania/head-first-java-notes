a new chapter with the Swae Lee - Sunflower

two ways of aading the or saving the objects
1. if used by java application then **SERIALIZATION**
2. if used by non java applcation then can make a simple plain text

we did example of it

data moves in streams from one place to another
1. connection stream - to connect the source or the destination
2. chaining stream - cant connect on theri own has to connect with the connection stream

atleast two stream are required for the useful thing to do because connection stream can just write bytes to file but here with the object output stream we are able to convert the object to the bytes
with chaing we can do patch on our own

when an object is serialized all objects it refers to are also serialized

every object it refers to has to be serializable otherwie it will fail at run time

to mark any thing not serializable mark it *transient*

and there are somethings which will mean not to save like network connectons or file objects because they are just created at the runtime every time from the scratch
if two objects point at the same refrence then the serialoized dont create it again it uses the foirst one

Deserialization
example done and yeah i accidently check the transient keyword also :x

now will be learning about writing to file

bufferedreader and bufferedwriter is mmuch more efficient as it stores the data in it will only go back to the file to read only when the buffere  is empty