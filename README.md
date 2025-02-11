# Server-Log-Statistics
# Server-Log-Statistics

## Description
Server-Log-Statistics is a Java program that reads a web server log file and processes it to generate statistics based on user-specified options. The program utilizes a thread pool to efficiently handle log entries and extract meaningful insights.

## Features
- **Option 1**: Count the number of accesses by each remote host.
- **Option 2**: Count the total number of bytes transmitted.
- **Option 3**: Count the total bytes transmitted per remote host.
- **Multithreaded** for improved performance on large log files.

## Prerequisites
- Java Development Kit (JDK) 8 or later.
- A valid web server log file in Common Log Format (CLF).

## Installation
1. **Clone or Download the Repository:**
   ```sh
   git clone <repository-url>
   cd Server-Log-Statistics
   ```
2. **Compile the Java Program:**
   ```sh
   javac MyPooledWeblog.java
   ```

## Usage
To execute the program, run:
```sh
java MyPooledWeblog <log_file> <option>
```
where:
- `<log_file>` is the path to the web server log file.
- `<option>` is one of the following:
  - `1` → Count accesses per remote host.
  - `2` → Count total bytes transmitted.
  - `3` → Count total bytes per remote host.

### Example Commands:
```sh
java MyPooledWeblog weblog.txt 1   # Count accesses per remote host
java MyPooledWeblog weblog.txt 2   # Count total bytes transmitted
java MyPooledWeblog weblog.txt 3   # Count bytes transmitted per host
```

## Output
Based on the selected option, the program will print:
- **Option 1:** A list of remote hosts with the number of times they accessed the server.
- **Option 2:** The total number of bytes transmitted.
- **Option 3:** The total bytes transmitted per remote host.

## Error Handling
- If the log file is missing or unreadable, an error message will be displayed.
- If an invalid option is provided, the program will prompt the user to enter a valid option (1, 2, or 3).

## Performance Considerations
- The program uses a **fixed thread pool** to handle large log files efficiently.
- Results are **cached** to avoid redundant calculations.

## Future Improvements
- Add support for additional log formats.
- Store results in a database for better analysis.
- Implement a graphical user interface (GUI) for ease of use.

## License
This project is open-source and available under the MIT License.

## Author
Henok Woldemichael

