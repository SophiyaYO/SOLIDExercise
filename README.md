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

**_The above code should log the messages both on the console and in LogFile in the format SimpleLayout provides._**


### **Extensibility**

The end-user should be able to add his own layouts/appenders/loggers and use them. For example, he should be able to create his own XmlLayout and make the appenders use it, without directly editing the library source code. 

| Sample Source Code |
| --- |

```java
public class Main {
    public static void main(String[] args) throws IOException {
      Layout xmlLayout = new XmlLayout();
      Appender consoleAppender = new ConsoleAppender(xmlLayout);
      Logger logger = new MessageLogger(consoleAppender);
      
      logger.logFatal("3/31/2015 5:23:54 PM", "mscorlib.dll does not respond");
      logger.logCritical("3/31/2015 5:23:54 PM", "No connection string found in App.config");        
    }
}
```

| Console Output |
| --- |

![ConsoleOutput](https://github.com/SophiyaYO/SOLIDExercise/blob/master/consoleOutput.png)

### **Report Threshold**

**Implement a report level threshold** in all appenders. The appender **_should append only messages with report level above or equal to its report level threshold_** (by default all messages are appended). The report level is in the order **Info > Warning > Error > Critical > Fatal**.

| Sample Source Code |
| --- |

```java
public class Main {
    public static void main(String[] args) throws IOException {
      Layout simpleLayout = new SimpleLayout();
      Appender consoleAppender = new ConsoleAppender(simpleLayout);
      consoleAppender.setReportLevel(ReportLevel.ERROR);
      
      Logger logger = new MessageLogger(consoleAppender);
      
      logger.logInfo("3/31/2015 5:33:07 PM", "Everything seems fine");
      logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
      logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
      logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
      logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");
    
    }
}
```

| Console Output |
| --- |

![ConsoleOutput](https://github.com/SophiyaYO/SOLIDExercise/blob/master/consoleOutput2.png)

**_Only messages from error and above are appended._**