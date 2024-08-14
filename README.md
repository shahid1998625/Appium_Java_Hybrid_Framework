# AppiumHybridFramework

## Overview
This is a hybrid framework designed for mobile automation using Java and Appium. It supports both Android and iOS platforms and follows best practices like Page Object Model (POM), data-driven testing, and reusable components.

## Project Structure

### Main Directory


#### Directories:
- **APK Files**: Contains APK files for different versions of the application.
- **drivers**: Includes WebDriver and mobile driver configurations.
- **hooks**: Contains hook classes for setup and teardown methods.
- **pageObjects.android**: Contains page object classes for Android application pages.
- **resources**: Includes configuration files and other resources.
- **Runner**: Test runner classes to execute tests.
- **utils**: Utility classes for common functions like data handling, logging, etc.

### Test Directory



#### Directories:
- **Appium_Hybrid_Framework**: Contains test classes for Mobile Android Appium and demonstration purposes.
- **Setups**: Setup classes for initializing test environments.
- **testData**: Test data files for data-driven testing.

## Setup Instructions

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-repo/AppiumHybridFramework.git




# BDD-cucumber-Framework with TestNG, Java, and Selenium
BDD cucumber Framework

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [Installation](#installation)
5. [Project Structure](#project-structure)
6. [Reports](#reports)
7. [Dependencies](#dependencies)


## Introduction
This repository contains a Hybrid test automation framework using TestNG, Java, and Appium Android Driver using Page Object model.
The framework supports the Page Object Model (POM) pattern and integrates with Extent Reports for test reporting.

## Features
1. **Driver Management**
    - Utilized 'AndroidDriverManager.java' class to initiate the Driver instance and support execution on different mobile devices Virtual or real devices.
    - Path: src/main/java/com/QM/drivers/AndroidDriverManager.java

2. **Page Object Model**
    - Implemented the Page Object Model pattern using @AndroidFindBy with the Page Factory model for better maintainability and readability of Mobile application page classes.
    - Path: src/main/java/com/QM/pageObjects.android/

3. **Test Cases**
    - Created Test Cases and Called Methods to define the steps of each steps in the TestCases.
    - Path: src/test/java/com/QM/PracticeTestCasesHybridApp/

4. **TestNG**
    - Integrated TestNG as the @Test, @Before, @After for test execution.
    
5. **Extent Reports**
    - Generated Cucumber Report and detailed Extent Reports.
    - Utilized an Extent Report Utility File to log the pass/fail status of test steps.
    - Captured and included screenshots for each test step in the HTML Extent Report, enhancing the clarity and detail of the test results.
    - Path: reports/extent-reports
    - Path: src/main/java/com/QM/utils/ExtentReportUtil.java

6. **Test Data Input**
    - Implemented an Excel Utility File to manage and input test data efficiently using File Input Stream for Data-driven testing with Excel utility
    - Path: src/test/resources/Test Data/InputTestData.xlsx

7. **Test Data Security**
    - Implemented encryption and decryption of test data using Jar files to ensure the data security.


## Prerequisites
- Java JDK 11 or higher
- Maven 3 or higher
- An IDE (e.g., IntelliJ IDEA)
- Mobile browsers (e.g., Chrome, Edge, Firefox)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/shahid1998625/BDD-cucumber-Framework
   cd BDD-cucumber-Framework
   mvn clean install

## Project Structure
AppiumHybridFramework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── QM/
│   │   │           ├── APK Files/
│   │   │           │   └── ApiDemos-debug.apk
│   │   │           │   └── General-Store.apk
│   │   │           ├── drivers/
│   │   │           │   └── AndroidDriverManager.java
│   │   │           ├── jars/
│   │   │           │   └── DataDecryptor.java
│   │   │           ├── pageObjects.android/
│   │   │           │   └── BuiltInGmailPage.java
│   │   │           │   └── CartPage.java
│   │   │           │   └── FormPage.java
│   │   │           │   └── InBuiltApp.java
│   │   │           │   └── ProductCataloguePage.java
│   │   │           ├── resources/
│   │   │           │   └── data.properties
│   │   │           ├── setups/
│   │   │           │    └── chromedriver.exe
│   │   │           │    └── chromedriver1.exe
│   │   │           ├── utils/
│   │   │           │    └── AndroidActions.java
│   │   │           │    └── DataDecrypt.java
│   │   │           │    └── DecryptionUtil.java
│   │   │           │    └── ExtentReportUtil.java
│   │   │           │    └── Listeners.java
│   │   │           │    └── SwipeUtil.java
│   │   │           │    └── CaptureScreenshot.java
│   ├── test/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── QM/
│   │   │           ├── Base/
│   │   │           │    └── BaseClass.java
│   │   │           │    └── BaseClass1.java
│   │   │           ├── hooks/
│   │   │           │   └── Hooks.java
│   │   │           ├── PracticeTestCasesHybridApp/
│   │   │           │   └── GmailApp_Practice.java
│   │   │           │   └── PhotosApp_Practice.java
│   │   │           │   └── TC_01_NativeApp_to_WebMobile_Browser_Navigation.java
│   │   │           │   └── TC_02_Practice.java
│   │   │           │   └── TC_02_Practice.java
│   │   ├── resources/
│   │   │   └── testData/
│   │   │       └── eComm.json
│── pom.xml
├── reports/
│   ├── extent-reports/
│   │  └── extent-report.html
├── targetoutput/
│   ├── cucumber-reports.html
└── README.md



## Reports
Cucumber Reports:
Cucumber reports are generated in the target/cucumber-reports directory.

Extent Reports:
Extent reports are generated in the reports/extent-reports directory. These reports include detailed information about test execution and screenshots.

## Dependencies
Appium
TestNG
Appium Android WebDriver
Extent Reports
Json
Apache POI (for Excel utility)
Encryption libraries (for data security)
For detailed versioning, please refer to the pom.xml file.
