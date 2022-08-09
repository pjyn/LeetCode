# Write your MySQL query statement below

#select firstName, lastName, city, state from Person join address where person.id = address.id;

SELECT Person.FirstName, Person.LastName, Address.City, Address.State from Person LEFT JOIN Address on Person.PersonId = Address.PersonId;
