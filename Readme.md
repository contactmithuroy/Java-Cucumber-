# Cucumber Selenium Automation Framework

A robust BDD (Behavior-Driven Development) test automation framework using Cucumber, Selenium WebDriver, and Java with Maven.

## 📁 Project Structure

```
cucumber2025/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       (Main application code - if needed)
│   │
│   └── test/
│       ├── java/
│       │   └── eal/
│       │       ├── pages/
│       │       │   └── (Page Object Model classes)
│       │       │
│       │       ├── tests/
│       │       │   └── (Step definitions and test runners)
│       │       │
│       │       ├── hooks/
│       │       │   ├── Hooks.java
│       │       │   └── StepNameListener.java
│       │       │
│       │       └── utilities/
│       │           ├── CommonMethods.java
│       │           ├── ConfigurationReader.java
│       │           ├── DBUtil.java
│       │           ├── Driver.java
│       │           ├── ExcelUtil.java
│       │           ├── LogColor.java
│       │           ├── practice.java
│       │           ├── ScreenshotUtil.java
│       │           ├── SecretManager.java
│       │           └── StlAssert.java
│       │
│       └── resources/
│           ├── config.properties/
│           │   ├── Configuration.properties
│           │   └── Configuration_RealBrowser.properties
│           │
│           ├── features/
│           │   └── (Cucumber feature files)
│           │
│           ├── Downloads/
│           │   └── (Downloaded files during test execution)
│           │
│           └── log4j2.properties
│
├── target/
│   └── (Maven build output)
│
├── pom.xml
└── README.md
```

## 🚀 Features

- **BDD Framework**: Cucumber integration for behavior-driven testing
- **Multi-Browser Support**: Chrome, Edge (normal and headless modes)
- **Configuration Management**: Profile-based configuration system
- **Logging**: Log4j2 with color-coded console output
- **Screenshot Utility**: Automatic screenshot capture on test failures
- **Database Support**: DBUtil for database operations
- **Excel Integration**: ExcelUtil for data-driven testing
- **Hooks**: Test setup and teardown management
- **Secret Management**: Secure handling of sensitive data

## 🛠️ Technologies Used

- **Java** - Programming language
- **Cucumber** - BDD framework
- **Selenium WebDriver** - Browser automation
- **Maven** - Build and dependency management
- **Log4j2** - Logging framework
- **TestNG/JUnit** - Test execution framework

## 📋 Prerequisites

- Java JDK 8 or higher
- Maven 3.6+
- Chrome/Edge browser installed
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## ⚙️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd cucumber2025
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Configure properties**
   - Update `Configuration.properties` in `src/test/resources/config.properties/`
   - Set browser type, URLs, and other test parameters

4. **Run tests**
   ```bash
   mvn test
   ```

## 🔧 Configuration

### Browser Configuration
Set the browser in `Configuration.properties`:
```properties
browser=chrome
# Options: chrome, edge, chrome-headless, edge-headless
```

### Profile-Based Configuration
Run tests with specific profiles:
```bash
mvn test -Dprofile=Configuration_RealBrowser
```

## 📊 Utilities

### Driver.java
- WebDriver management
- Multi-browser support
- Headless mode configuration
- Automatic cleanup

### ConfigurationReader.java
- Reads properties files
- Profile-based configuration loading
- Environment-specific settings

### CommonMethods.java
- Reusable Selenium methods
- Wait utilities
- Element interaction helpers

### LogColor.java
- Color-coded console logging
- Enhanced log readability

### ScreenshotUtil.java
- Automatic screenshot on failure
- Custom screenshot capture

### ExcelUtil.java
- Read/write Excel files
- Data-driven testing support

### DBUtil.java
- Database connection management
- Query execution utilities

## 🎯 Test Execution

### Run all tests
```bash
mvn test
```

### Run with specific browser
```bash
mvn test -Dbrowser=chrome
```

### Run with specific profile
```bash
mvn test -Dprofile=Configuration_RealBrowser
```

### Run in headless mode
```bash
mvn test -Dbrowser=chrome-headless
```

## 📝 Logging

Logs are configured in `log4j2.properties` with color-coded output:
- **RED** - Errors and critical messages
- **GREEN** - Success messages
- **YELLOW** - Warnings
- **BLUE** - Info messages
- **MAGENTA** - Configuration details

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

-Mithu Roy - Initial work

## 📞 Contact

For questions or support, please contact [contact.mithuroy@gmail.com]

---

**Happy Testing! 🎉**