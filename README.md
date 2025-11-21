Simple use of Redis cloud : implemented in spring boot

Requirement:
Create account from:
https://cloud.redis.io/#/login
you will get database, copy redis client cli and paste it to wsl 
also add the same uri to the application.properties

(Please start up the server and follow the code)
RedisConfig.java : declaring bean for RedisTemplate object
Student: entity that holds info of student
StudentController: contains end point that return Student info
StudentService: that contains method (also contains logic to decide where to fetch data from?)
if in cache(redis) then fetch from cache, else from database
RedisService: method for setting and getting key, value to server
uses ObjectMapper to map the returned object to the object of desired type

