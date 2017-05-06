# Errors and Exception Handling
#### *This document will explain how each language perofrms error and exception handling.* 

<br></br>
## Error and Exception Handling
Programs have a possibility of trying to execute code that may cause the program to crash. A programmer can prevent this by using exception handling, which will enclose a block of code and not execute it if it causes any exceptions by 'catching' the exception. The programmer can then decide to do something else if this happens. Errors are different from exceptions in that they mainly occur in the compile/ runtime environment, and therefore, they cannot be prevented by trying to 'catch' them like exceptions, as exceptions are caused directly by the application. Errors cannot be recovered from, meaning the application will crash; although errors do have exception codes. 

Errors will be discussed more in paragraph form than example code. Exceptions will be in example code format.

<br></br>
## Java's Implementation
*The classes may be ignored. Please start with main, as this will go in-depth with Java's error and exception handling.*
```java
public static void main(String[] args) {
        launch(args);
}

private void parseJsonNewsFeed(String jsonString) throws Exception {
        
        // start with clean list
        newsStories.clear();
        
        if (jsonString == null || jsonString.equals("")) return;
        
        JSONObject jsonObj;
        try {
            jsonObj = (JSONObject)JSONValue.parse(jsonString);
        } catch (Exception ex) {
            throw ex;
        }
        
        if (jsonObj == null) return;
        
        String status = "";
        try {
            status = (String)jsonObj.get("status");
        } catch (Exception ex) {
            throw ex;
        }
        
        if (status == null || !status.equals("OK")) {
            throw new Exception("Status returned from API was not OK.");
        }
        
        JSONObject response;
        try {
            response = (JSONObject)jsonObj.get("response");
        } catch (Exception ex) {
            throw ex;
        }
        
        JSONArray docs;
        try {
            docs = (JSONArray)response.get("docs");
        } catch (Exception ex) {
            throw ex;
        }
      
        for (Object doc : docs) {
            try {
                JSONObject story = (JSONObject)doc;
                String webUrl = (String)story.getOrDefault("web_url", "");
                String snippet = (String)story.getOrDefault("snippet", "");
                String leadParagraph = (String)story.getOrDefault("lead_paragraph", "");
                String source = (String)story.getOrDefault("source", "");
                String newsDesk = (String)story.getOrDefault("news_desk", "");
                String sectionName = (String)story.getOrDefault("section_name", "");
                JSONObject headlineObj = (JSONObject)story.getOrDefault("headline", null);
                String headline = "";
                if (headlineObj != null) {
                    headline = (String)headlineObj.getOrDefault("main", "");
                }
                
                System.out.println("headline: " + headline + "\n");
                System.out.println("webUrl: " + webUrl + "\n");
                System.out.println("snippet: " + snippet + "\n");
                System.out.println("leadParagraph: " + leadParagraph + "\n");
                System.out.println("newsDesk: " + newsDesk + "\n");
                System.out.println("sectionName: " + sectionName + "\n");
                System.out.println("source: " + source + "\n");
                System.out.println("------------------------------------------------------\n");
                
                NYTNewsStory newsStory = new NYTNewsStory(webUrl, headline, snippet, leadParagraph, newsDesk, sectionName, source );
                newsStories.add(newsStory);
                
            } catch (Exception ex) {
                throw ex;
            }
            
        }
        
}
```

<br></br>
## Swift's Implementation
*The classes may be ignored. Please start after the class declarations, as this will go in-depth with Swift's error and exception handling.*
```
let connectionOK = true
let connectionSpeed = 30.00
let fileFound = false

enum FileTransferError: Error {
    case noConnection
    case lowBandwidth
    case fileNotFound
}

func fileTransfer() throws {

    guard connectionOK else {
        throw FileTransferError.noConnection
    }

    guard connectionSpeed > 30 else {
        throw FileTransferError.lowBandwidth
    }

    guard fileFound else {
        throw FileTransferError.fileNotFound
    }
}

func sendFile() -> String {

    defer {
        removeTmpFiles()
        closeConnection()
    }

    do {
        try fileTransfer()
    } catch FileTransferError.NoConnection {
        return("No Network Connection")
    } catch FileTransferError.LowBandwidth {
        return("File Tranfer Speed too Low")
    } catch FileTransferError.FileNotFound {
        return("File not Found")
    } catch {
        return("Unknown error")
    }

    return("Successful transfer")
}
```

<br></br>
## Errors
Types of Errors:
* run-time: occurs while program is running.
  <br>
  1. Logic: produces the wrong output.
  2. Memory Leak: caused by continuous RAM use whil program is running.
* compile-time: prevents the program from compiling.
<br>
  1. Syntax error: a character or string incorrectly placed in a command or instruction that causes a failure in execution.
* syntax

<br>
## Comparing

Java exception handling is composed of try blocks, catch blocks, and finally blocks. A try block will *try* to execute the code it contains. A catch block will *catch* an exception should the code in the try block fail. The finally block will always execute, once the try block exits. Example:
```java
public void writeList() {
    PrintWriter out = null;

    try {
        System.out.println("Entering" + " try statement");

        out = new PrintWriter(new FileWriter("OutFile.txt"));
        for (int i = 0; i < SIZE; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
    } catch (IndexOutOfBoundsException e) {
        System.err.println("Caught IndexOutOfBoundsException: "
                           +  e.getMessage());
                                 
    } catch (IOException e) {
        System.err.println("Caught IOException: " +  e.getMessage());
                                 
    } finally {
        if (out != null) {
            System.out.println("Closing PrintWriter");
            out.close();
        } 
        else {
            System.out.println("PrintWriter not open");
        }
    }
}
```
<br>
Error handling in Swift resembles exception handling in other languages, with the use of the try, catch and throw keywords. Unlike exception handling in many languages, error handling in Swift does not involve unwinding the call stack, a process that can be computationally expensive. As such, the performance characteristics of a throw statement are comparable to those of a return statement.
<br>
Because Swift has optionals, users have the ability to write really concise error handling using ```try```, should you want all the errors to be handled in the same way. Example:
```
func fetchData() -> Data? {
    if let data = try? fetchDataFromDisk() { return data }
    if let data = try? fetchDataFromServer() { return data }
    return nil
}
```
There also exists the possibility to disable error propagation using using ```try!```. Example:
```
let photo = try! loadImage(atPath: "./Resources/John Appleseed.jpg")
```
Swift also has defer statements, which *defers* execution until the current scope is exited.
```
func processFile(filename: String) throws {
    if exists(filename) {
        let file = open(filename)
        defer {
            close(file)
        }
        while let line = try file.readline() {
            // Work with the file.
        }
        // close(file) is called here, at the end of the scope.
    }
}
```
