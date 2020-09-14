# mobile-food-truck-permit-zelish

**PROJECT REUIREMENTS**
---------------------------------------

 1. STS(SPRING TOOL SUIT)
 2. JAVA(1.8 VERSION)
 3. MYSQL
 4. POSTMAN
 
**STEPS TO RUN THE APPLICATION**
 --------------------------------------- 

1. CLONE PROJECT FORM GIT BY USING **GIT CLONE+HTTP LINK** COMMAND TO YOUR SPECIFIC FOLDER.

2. ONCE THE PROJECT SETUP IS DONE, GO TO **src/main/resources** AND FIND A **application.properties**, WHERE NEED TO SET UP THE VALUES FOR
            1. spring.datasource.username=**YOUR-USERNAME**
            2. spring.datasource.password=**YOUR-PASSWORD**
            3. spring.datasource.url=jdbc:mysql://127.0.0.1:3306/**YOUR-DATABASENAME**?useSSL=false

3. ONCE THE 2ND STEP IS DONE THEN CLICK ON THE PROJECT RUN AS SPRING BOOT- APPLICATION, WHICH INTERNALLY DEVELOP THE TABLES.

4. IN FOLLOWING THESE THREE STEPS IF ANY ERROR OCCURS REGARDING DEPENDENCIES, THEN CLICK ON PROJECT MAVEN CLEAN AND MAVEN BUILD.

**STEPS TO PERFORM TESTING**
-------------------------------------------

NOTE :- IF WANT EASE TO FIND DETAILS OF ALL API AND JSON FOR REQUEST METHODS THEN TRY TO USE SWAGGER URL AS BELOW MENTIONED FOR THIS PROJECT ONCE THE PROJECT STARTED SUCCESSFULLY

SWAGGER URL :- http://localhost:8080/swagger-ui.html#/


IF THE ABOVE MENTIONED WON'T WORK THEN PLEASE FOLLOW BELOW MENTIONED DETAILS FOR TESTING USING POSTMAN

NOTE :- To Bulk Upload The API is specified below, so for convenience use this
METHOD :- POST
URL :- http://localhost:8080/api/v1/upload/file

from using this upload the .CSV file which internally imports the Data

1. **TO CREATE FOODTRUCK**

METHOD - POST
URL - http://localhost:8080/api/v1/foodtruck

REQUEST JSON - 
{
     "locationid": 1430868,
    "applicant": "MOMO INNOVATION LLC",
    "facilityType": "Truck",
    "cnn": 3525000,
    "locationDescription": "CALIFORNIA ST: DAVIS ST to FRONT ST (100 - 199)",
    "address": "101 CALIFORNIA ST",
    "blocklot": "0263011",
    "block": "0263",
    "lot": "011",
    "status": "REQUESTED",
    "foodItems": "MOMO spicy noodle: POPO's noodle: Spicy Chicken noodle: Rice Noodles",
    "x": 6013245.668,
    "y": 2116754.292,
    "latitude": 37.7929489528347,
    "longitude": -122.398098613167,
    "schedule": "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=20MFF-00004&ExportPDF=1&Filename=20MFF-00004_schedule.pdf",
    "approved": null,
    "received": "2020-04-16T18:30:00.000+00:00",
    "priorPermit": false,
    "expirationDate": "2020-07-14T18:30:00.000+00:00",
    "location": {
        "type": "Point",
        "coordinates": [
            -122.398098613167,
            37.7929489528347
        ]
    },
    "noiSent": "2020-07-14T18:30:00.000+00:00"
}

2. **TO UPDATE**

METHOD - PUT
URL - http://localhost:8080/api/v1/foodtruck/{id}
Example:- http://localhost:8080/api/v1/foodtruck/1

Change any fields value and use this JSON
REQUEST JSON -
{
     "locationid": 1430868,
    "applicant": "MOMO INNOVATION LLC",
    "facilityType": "Truck",
    "cnn": 3525000,
    "locationDescription": "CALIFORNIA ST: DAVIS ST to FRONT ST (100 - 199)",
    "address": "101 CALIFORNIA ST",
    "blocklot": "0263011",
    "block": "0263",
    "lot": "011",
    "status": "REQUESTED",
    "foodItems": "MOMO spicy noodle: POPO's noodle: Spicy Chicken noodle: Rice Noodles",
    "x": 6013245.668,
    "y": 2116754.292,
    "latitude": 37.7929489528347,
    "longitude": -122.398098613167,
    "schedule": "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=20MFF-00004&ExportPDF=1&Filename=20MFF-00004_schedule.pdf",
    "approved": null,
    "received": "2020-04-16T18:30:00.000+00:00",
    "priorPermit": false,
    "expirationDate": "2020-07-14T18:30:00.000+00:00",
    "location": {
        "type": "Point",
        "coordinates": [
            -122.398098613167,
            37.7929489528347
        ]
    },
    "noiSent": "2020-07-14T18:30:00.000+00:00"
}

3. **TO GET FOODTRUCK BY ID**

METHOD - GET
URL - http://localhost:8080/api/v1/foodtruck/{id}
Example:- http://localhost:8080/api/v1/foodtruck/1

4. **TO GET FOODTRUCK BY STATUS**

METHOD - GET
URL - http://localhost:8080/api/v1/foodtruck/status?status=approved
Example:- http://localhost:8080/api/v1/foodtruck/status/APPROVED

5. **TO GET ALL FOODTRUCKS **

METHOD - GET
URL - http://localhost:8080//api/v1/foodtrucks

6. **TO GET BY FACILITY TYPE**

METHOD - GET
URL - http://localhost:8080/api/v1/foodtruck/facility
Example:- http://localhost:8080/api/v1/foodtruck/facility?facilityType=port


7. **TO GET BY APPLICANT**

METHOD - GET
URL - http://localhost:8080/api/v1/foodtruck/applicant
Example:- http://localhost:8080/api/v1/foodtruck/applicant?applicant=hm

8. **TO GET ALL EXPIRED LICENCE FOOD TRUCKS**

METHOD - GET
URL - http://localhost:8080/api/v1/foodtruck/licence/expired

9. **TO DELETE BY ID**

METHOD - DELETE
URL - http://localhost:8080/api/v1/foodtruck/{id}
Example:- http://localhost:8080/api/v1/foodtruck/1



********************************************************************************************************************************************************************
