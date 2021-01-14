# freshworks_project1
this is created by Pradeep.E from Misrimal Navajee Munoth Jain Engineering College. Ph. No: 9551371278 Mail to OniPradeep@gmail.com

project is developed in " java with maven " and tested in Windows environment.

Main class ChooseMode.java. GUI based project. tested in windows .
I have used json file format as datastore since its flexible and easy to work with.
By default the Files are stored in FileSystem . 
AllDataStore.json used to identify the .json files which are stored in custom directory . 
In the acutal file , the Key-Value pair is stored as :

key---time:{
  "value":1
}

--- here is delimter to keep track of time

File Write is thread safe

Guide to project:
1) first choose laptop and create the AllDataStore.json and File.json(Either on predefined path or External path)
2) Use functions like Read , Write, Delete to manipulate the file.json
2) then use close all threads to safely close the file 
3) after creating file using laptop , re launch the application and choose client
4) click on YES in the table to open the file specified in first column of that row 
5) client can access the file if the name of the client is same as the client which is being with with.
6) after working with the file click on "close all threads" to safely close the file.

In the last interface / 4th user interface(common for both mode) , 
1) in order to read: enter the key next to Read button. Then press Read button to read the data from the file . the data will be displayed in the text area next to it
2) in order to write: enter the key next to Write button and time in seconds in next box(2nd box in Write button row). type the data in json value format . Then press Write button to save the data with or without time.
3) in order to delete: enter the key next to Delete button. Then press Delete button to delete the data in the file . the data will be deleted in the json file and the delete status will ne displayed

Concepts applied to complete the assignment :
1) Singleton Class Concept
2) ThreadGrouping Concept
3) MultiThreading

System info:

Developed in : NetBeans 12.2<br>

Os: windows 10 pro<br>
