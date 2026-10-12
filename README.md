# Java API Test Automation

A Java-based API test automation project built with **JUnit 5, REST Assured, and Maven** to validate REST API responses through automated functional and negative testing.

This project demonstrates fundamental Software Development Engineer in Test (SDET) practices, including HTTP status code validation, response data assertions, content-type verification, query parameter testing, and test case documentation.

## Project Overview

The project tests the [JSONPlaceholder](https://jsonplaceholder.typicode.com/) REST API, focusing on the `/posts` resource.

The test suite covers successful API requests, response validation, filtering, and selected negative scenarios to verify that the API behaves as expected.

## Tech Stack

| Technology         | Purpose                             |
| ------------------ | ----------------------------------- |
| Java 21            | Programming language                |
| JUnit 5            | Test framework                      |
| REST Assured 5.5.1 | REST API testing                    |
| Maven              | Dependency and build management     |
| JSONPlaceholder    | Public test API                     |
| Git & GitHub       | Version control and project hosting |

## Project Structure

```text
java-api-test-automation/
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── naufal/
│                   └── sdet/
│                       └── PostsApiTest.java
├── docs/
│   └── test-cases.md
├── pom.xml
└── README.md
```

## Automated Test Coverage

The project currently contains seven automated test cases.

| Test Case ID | Scenario                       | Validation                       |
| ------------ | ------------------------------ | -------------------------------- |
| API-001      | Retrieve all posts             | HTTP 200                         |
| API-002      | Retrieve a post by ID          | Status code and response fields  |
| API-003      | Verify posts list is not empty | Non-empty response list          |
| API-004      | Verify JSON content type       | Response Content-Type            |
| API-005      | Request an unknown endpoint    | HTTP 404                         |
| API-006      | Request a non-existent post    | HTTP 404                         |
| API-007      | Filter posts by user ID        | Status code and matching results |

For detailed preconditions, test steps, expected results, and execution status, see [`docs/test-cases.md`](docs/test-cases.md).

## Prerequisites

Before running the tests, ensure that you have:

* JDK 21 installed.
* Maven installed and configured, or an IDE with Maven support.
* An internet connection to access JSONPlaceholder.
* Git installed if you want to clone the repository.

Verify your Java and Maven installations:

```bash
java -version
mvn -version
```

## Getting Started

### 1. Clone the repository

Replace the placeholder URL with your actual GitHub repository URL.

```bash
git clone https://github.com/naufalhakims/java-api-test-automation.git
cd java-api-test-automation
```

### 2. Run the automated tests

Execute the following command from the project root:

```bash
mvn clean test
```

Maven will compile the test code, execute the automated tests through Maven Surefire, and display the execution summary in the terminal.

### 3. Review the test results

Check the terminal output for the number of tests executed, failures, and errors.

Detailed Surefire reports are generated under:

```text
target/surefire-reports/
```

## Example Test Implementation

The following example demonstrates how the project validates a post response using REST Assured and JUnit 5.

```java
@Test
void getPostByIdReturnsExpectedData() {
    given()
        .when()
        .get("/posts/1")
        .then()
        .statusCode(200)
        .body("id", equalTo(1))
        .body("userId", equalTo(1))
        .body("title", not(emptyString()))
        .body("body", not(emptyString()));
}
```

This test validates the HTTP status code and checks selected fields in the JSON response.

## Test Documentation

The project includes structured test case documentation with the following information:

* Test Case ID
* Test Scenario
* Preconditions
* Test Steps
* Expected Result
* Actual Result
* Execution Status

The documentation provides traceability between test scenarios and their corresponding automated test methods.

## Current Limitations

* The test suite covers selected API scenarios rather than the complete API specification.
* Negative tests currently validate HTTP status codes without checking the full error response body.
* Response schema validation and response-time assertions have not been implemented.
* Tests depend on the availability of the public JSONPlaceholder service.
* Continuous integration through GitHub Actions is planned for the next development stage.
