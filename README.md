# ResfulWebServices
exercise-services



post operation by reading data from excel sheet and  insert into db (PostgreSQL). 
-excel columns should be same as the fields provided in the attached json.    
2. post operion by reading the json data and insert into db
3. PUT - update the data based on the employee id in db and excel 
4. Delete operation by using emp id from the db and excel 
5. Get opertaion for retrieve employee info either from db or excel using employee id.
5. Handle the exception scenarios.


{
	"employee": {
		"id":"U76090",
		"firstName": "Jeff",
		"lastName":"Bezos",
		"salary": 56000,
		"addresses": {
			"cityName": "MAYSVILLE",
			"telephoneNumber": "9600568708",
			"zipCode": "41056",
			"houseNumber": "45",
			"streetName": "MEADOW",
			"addressType": "CA",
			"streetType": "DR 45"
		}
	}
}


CREATE SEQUENCE address_id_seq;

CREATE SEQUENCE employee_id_seq;

CREATE TABLE ADDRESS (
 ADDRESS_ID integer DEFAULT nextval('address_id_seq') primary key,
 CITY_NAME varchar(11) NOT NULL ,
 TELEPHONE_NUMBER INTEGER DEFAULT NULL,
 ZIP_CODE INTEGER NOT NULL,
 HOUSE_NUMBER INTEGER DEFAULT NULL,
 STREET_NAME varchar(100) DEFAULT NULL,
 ADDRESS_TYPE VARCHAR(100) DEFAULT NULL,
 STREET_TYPE VARCHAR(100) DEFAULT NULL
);

CREATE TABLE EMPLOYEE(
 EMPLOYEE_ID integer DEFAULT nextval('employee_id_seq')  primary key,
 ID varchar(20) unique NOT NULL,
 FIRST_NAME varchar(11) NOT NULL ,
 LAST_NAME varchar(100) NOT NULL,
 SALARY varchar(100) DEFAULT NULL,
 ADDRESS_ID integer NOT null,
 constraint employee_address_key foreign key (ADDRESS_ID) references ADDRESS (ADDRESS_ID)
);



