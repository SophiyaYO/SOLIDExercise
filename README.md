# **Exercises: SOLID**
---------------
## **Problem 1. Logger**
----------
 Write a logging library for logging messages. The interface for the end-user should be as follows:
 
 | Sample Source Code |
 | --- |
 | Layout simpleLayout = new SimpleLayout\(); |
 | Appender consoleAppender = new ConsoleAppender\(simpleLayout); |
 | Logger logger = new MessageLogger\(consoleAppender); |
 |  |
 | logger.logError\("3/26/2015 2:08:11 PM", "Error parsing JSON."); |
 | logger.logInfo\("3/26/2015 2:08:11 PM", "User Pesho successfully registered."); |
 | Sample Output                                                                   |   
  
![sampleOutput]()