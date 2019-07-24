# **Exercises: SOLID**
---------------
## **Problem 1. Logger**
----------
 Write a logging library for logging messages. The interface for the end-user should be as follows:
 
| Sample Source Code |
| --- |

```java
public class Main {
    public static void main(String[] args) throws IOException {
 Layout simpleLayout = new SimpleLayout\(); 
 Appender consoleAppender = new ConsoleAppender\(simpleLayout); 
 Logger logger = new MessageLogger\(consoleAppender); 
  
 logger.logError\("3/26/2015 2:08:11 PM", "Error parsing JSON."); 
 logger.logInfo\("3/26/2015 2:08:11 PM", "User Pesho successfully registered."); 
 }
 }
```
 
 | Sample Output |
 | --- |                                                                     
  
![sampleOutput](https://github.com/SophiyaYO/SOLIDExercise/blob/master/output0.png)

Logger logs data and time **\(String)** and a message **\(String)**.

### **Library Architecture**

The library should have the following components:
-	**Layouts** - define the format in which messages should be appended \(e.g. SimpleLayout displays logs in the format "<date-time> - <report level> - <message>")
-	**Appenders** - responsible for appending the messages somewhere \(e.g. Console, File, etc.)
-	**Loggers** - hold methods for various kinds of logging \(warnings, errors, info, etc.\)
Whenever a logger is told to log something, it calls all of its appenders and tells them to append the message. In turn, the appenders append the message \(e.g. to the console or a file\) according to the layout they have.

### **Requirements**

Your library should correctly follow all **SOLID** principles:

-	**Single Responsibility Principle** - no class or method should do more than one thing at once
-	**Open-Closed Principle** - the library should be open for extension \(i.e. its user should be able to create his own layouts/appenders/loggers)
-	**Liskov Substitution Principle** - children classes should not break the behavior of their parent
-	**Interface Segregation Principle** - the library should provide simple interfaces for the client to implement
-	**Dependency Inversion** - no class/method should directly depend on concretions \(only on abstractions)

###### _**Avoid code repetition. Name everything accordingly.**_

### **Implementations**

The library should provide the following ready classes for the client:
-	**SimpleLayout** - defines the format **_"<date-time> - <report level> - <message>"_**
-	**ConsoleAppender** - appends a log to the console using the provided layout
-	**FileAppender** - appends a log to a file **_\(You need to implement a CustomFile class)_** using 
the provided layout
-	**LogFile** - a custom file class which logs messages in a string builder using a method **write\(\)**. It **should have a _getter_** for its **_size_** which **is the sum of the ascii codes of all alphabet characters** it contains \(e.g. a-z and A-Z).
-	**Logger** - a logger class which is used to log messages. Calls each of its appenders when something needs to be logged.

|Sample Source Code |
| --- |

```java
public class Main {
    public static void main(String[] args) throws IOException {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        
        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);
        
        Logger logger = new MessageLogger(consoleAppender, fileAppender);
        
        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
    }
}
```

