#Overview
-> The VTracker application aims to manage distributed connected vehicles connectivity information and their owners information. 
The system is designed to maintain the status of the connection one time per minute. also it enables users to register a new owner (customer), add a new vehicle, view all vehicles status (Online/Offline) and vehicles owners, or to check connectivity with selected vehicles in real time.

#Capabilities
-> Maintain vehicles connectivity status periodically:
The system pings vehicles to send their status of the connection one time per minute.

-> Register New Owner:
The user can add (register) a new owner (customer) entering their information (name, address, id). This is a pre-requisite for 
adding a new vehicle. 

-> Add new vehicle:
The user can add (register) a new vehicle which belongs to an owner (customer), entering vehicle information (regNr, vehicleId, owner, status(online, offline)).

-> Check vehicle connectivity:
The user can select a vehicle from the list and checks it's connectivity, the system tries to ping the selected vehicle, and detectd whether it was online or offline. 

#System design:
-> Restfull APIs Java back-end module to serve the vehicles and vehicle owners operations, 
along with data store (data store in this version is in-memory h2 based database). 
-> A Single Page Application front-end framework will be selected (React.js is the closest). 
Vehicle status refreshing activity will be delegeted to the front-end to perform a periodic check, calling an API from the back-end (which is a simulator in this version).

#Used technologies:
-> Spring Boot, Maven, H2 Database, Rest
