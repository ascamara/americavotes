# michiganvotes

A project for the helping campaigns organize their volunteers and match them with perspective voters!

## How to run:

In order to run this program, simply download the ZIP off of GitHub and put the executable JAR file in its own folder when you run it!
Putting the JAR file in its own folder isn't technically necessary, but it helps with keeping the output files organized, as the program
returns .txt files.

## Links to dependancy documentation:

I utilized Eclipse's SWT (Standard Widget Toolkit) in order to help create the GUI.
https://www.eclipse.org/swt/

Besides that, everything else is standard Java. I used ArrayLists of Volunteer and Voter objects in order to organize my data.

## Architecture:

This program allows a user to input voter and volunteer information and returns a text file for each volunteer with the
information for the voters that they've been "assigned" to reach out to!

Each time the user creates a new voter or a new volunteer using the dialog boxes in the application, a Voter or Volunteer object is
created, each containing all the information that the user inputted, and then stored in an ArrayList of voters or volunteers respectively.
When the user is finished inputting information, they can press the "Assign Volunteers!" button, which creates a text file for each
volunteer and evenly distributes voters for the volunteers to contact. Each volunteer's text file contains their information as well as
all the information of their assigned voters (and their locations/phone numbers). 
