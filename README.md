# Java API Test Automation

Automated REST API testing project built with **Java 21, JUnit 5, REST Assured, and Maven**. This project focuses on API functional testing, response validation, negative testing, and continuous integration using GitHub Actions.

The project demonstrates fundamental SDET practices, from designing and documenting test cases to executing automated tests locally and through a CI workflow.

## Project Overview

The project tests the public [JSONPlaceholder REST API](https://jsonplaceholder.typicode.com/), focusing on the `/posts` resource.

The test suite covers successful API requests, JSON response validation, query parameter filtering, and negative scenarios involving invalid endpoints and non-existent resources.

## Tech Stack

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java 21            | Programming language            |
| JUnit 5.12.2       | Test framework                  |
| REST Assured 5.5.1 | REST API automation             |
| Maven              | Dependency and build management |
| JSONPlaceholder    | API under test                  |
| Git & GitHub       | Version control                 |
| GitHub Actions     | Continuous integration (CI)     |

## Project Structure

```text
java-api-test-automation/
├── .github/
│   └── workflows/
│       └── api-tests.yml
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
├── README.md
└── .gitignore
```

## Automated Test Coverage

The project currently contains seven automated test cases.

| Test ID | Test Scenario                  | Expected Result                                             |
| ------- | ------------------------------ | ----------------------------------------------------------- |
| API-001 | Retrieve all posts             | HTTP 200                                                    |
| API-002 | Retrieve post by ID            | HTTP 200 and valid response fields                          |
| API-003 | Verify posts list is not empty | Non-empty response list                                     |
| API-004 | Verify JSON content type       | Content-Type contains `application/json`                    |
| API-005 | Request an unknown endpoint    | HTTP 404                                                    |
| API-006 | Request a non-existent post    | HTTP 404                                                    |
| API-007 | Filter posts by user ID        | HTTP 200 and all returned posts match the requested user ID |

### Testing Approach

* **Positive testing:** Validate successful API requests and expected response data.
* **Negative testing:** Verify HTTP 404 responses for invalid endpoints and non-existent resources.
* **Response validation:** Check status codes, selected JSON fields, response list size, and Content-Type.
* **Query parameter testing:** Verify that filtering by `userId` returns matching posts.

Detailed preconditions, test steps, expected results, actual results, and execution statuses are documented in [`docs/test-cases.md`](docs/test-cases.md).

## Getting Started

### Prerequisites

* JDK 21
* Maven
* Git
* Internet access to reach JSONPlaceholder

Verify your installation:

```bash
java -version
mvn -version
git --version
```

### Clone the Repository

```bash
git clone https://github.com/naufalhakims/java-api-test-automation.git
cd java-api-test-automation
```

### Run the Tests

Execute the following command from the project root:

```bash
mvn clean test
```

Maven compiles and executes the test suite using the Maven Surefire Plugin.

## Test Execution Results

### Local Execution

The seven automated tests have been reported to execute successfully in the local environment.

**Reported test summary:**

| Metric      | Result |
| ----------- | -----: |
| Total Tests |      7 |
| Passed      |      7 |
| Failures    |      0 |
| Errors      |      0 |
| Skipped     |      0 |
| Pass Rate   |   100% |

Maven/Surefire summary:

```text
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

### Test Reports

Maven Surefire generates test reports in:

```text
target/surefire-reports/
```

These reports can be used to review individual test execution results and investigate failures.

## Continuous Integration with GitHub Actions

The project includes a GitHub Actions workflow at `.github/workflows/api-tests.yml`.

The workflow is configured to run automatically when:

* Code is pushed to the `main` branch.
* A pull request targets the `main` branch.
* The workflow is triggered manually through `workflow_dispatch`.

### CI Workflow

1. Check out the repository.
2. Set up Java 21 using Eclipse Temurin.
3. Cache Maven dependencies.
4. Execute the automated test suite using:

```bash
mvn --batch-mode clean test
```

GitHub Actions reports the workflow status as successful or failed based on the job result.

**CI status:** Check the repository's Actions tab for the latest execution result.

## Current Limitations

* The test suite covers selected API scenarios rather than the complete API specification.
* Negative tests validate HTTP status codes but do not yet validate the complete error response body.
* JSON schema validation and response-time assertions have not been implemented.
* Tests depend on the availability of the external JSONPlaceholder service.
* CI execution results depend on the actual workflow run and external API availability.
