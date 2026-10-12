# API Test Case Documentation

## 1. Project Information

| Field                | Details                              |
| -------------------- | ------------------------------------ |
| Project Name         | Java API Test Automation             |
| API Under Test       | JSONPlaceholder                      |
| Base URL             | https://jsonplaceholder.typicode.com |
| Programming Language | Java 21                              |
| Test Framework       | JUnit 5                              |
| API Testing Library  | REST Assured                         |
| Build Tool           | Maven                                |
| Test Class           | `PostsApiTest.java`                  |

## 2. Test Environment and Preconditions

### Environment

* Java Development Kit (JDK) 21
* Maven
* JUnit 5
* REST Assured
* Internet connection to access JSONPlaceholder

### General Preconditions

* The project dependencies are installed successfully.
* The API is reachable from the test environment.
* The test suite is executed using Maven or IntelliJ IDEA.
* The API responses are evaluated against the assertions defined in the Java test methods.

## 3. Test Cases

### API-001: Retrieve All Posts Successfully

**Test Scenario:** Verify that the API returns HTTP 200 when retrieving all posts.

**Preconditions:**

* The API is accessible.
* The test environment is configured correctly.

**Test Steps:**

1. Send an HTTP GET request to `/posts`.
2. Capture the API response.
3. Verify the HTTP status code.

**Expected Result:**

* The API returns HTTP status code `200 OK`.

**Actual Result:**

* HTTP status code `200` was returned and the assertion passed during the successful test run.

**Status:** PASS

---

### API-002: Retrieve a Post by ID

**Test Scenario:** Verify that the API returns the expected fields for post ID 1.

**Preconditions:**

* The API is accessible.
* Post ID 1 is available in the API response.

**Test Steps:**

1. Send an HTTP GET request to `/posts/1`.
2. Verify that the response status code is `200`.
3. Verify that the response field `id` equals `1`.
4. Verify that the response field `userId` equals `1`.
5. Verify that the `title` field is not an empty string.
6. Verify that the `body` field is not an empty string.

**Expected Result:**

* The API returns HTTP `200 OK`.
* The post ID equals `1`.
* The user ID equals `1`.
* The title and body are not empty strings.

**Actual Result:**

* All defined response assertions passed during the successful test run.

**Status:** PASS

---

### API-003: Verify the Posts List Is Not Empty

**Test Scenario:** Verify that retrieving all posts returns a non-empty list.

**Preconditions:**

* The API is accessible.

**Test Steps:**

1. Send an HTTP GET request to `/posts`.
2. Verify that the response status code is `200`.
3. Verify that the response list contains more than zero items.

**Expected Result:**

* The API returns HTTP `200 OK`.
* The response contains at least one post.

**Actual Result:**

* The status code and non-empty list assertions passed during the successful test run.

**Status:** PASS

---

### API-004: Verify JSON Content Type

**Test Scenario:** Verify that the API returns a JSON response for a valid post request.

**Preconditions:**

* The API is accessible.
* Post ID 1 is available.

**Test Steps:**

1. Send an HTTP GET request to `/posts/1`.
2. Verify that the response status code is `200`.
3. Verify that the response Content-Type contains `application/json`.

**Expected Result:**

* The API returns HTTP `200 OK`.
* The response Content-Type indicates JSON.

**Actual Result:**

* The status code and Content-Type assertions passed during the successful test run.

**Status:** PASS

---

### API-005: Verify an Unknown Endpoint Returns 404

**Test Scenario:** Verify that an invalid API endpoint returns HTTP 404.

**Preconditions:**

* The API host is accessible.
* The requested path `/invalid-endpoint` is not a valid endpoint.

**Test Steps:**

1. Send an HTTP GET request to `/invalid-endpoint`.
2. Capture the API response.
3. Verify that the response status code is `404`.

**Expected Result:**

* The API returns HTTP `404 Not Found`.

**Actual Result:**

* HTTP status code `404` was returned and the assertion passed during the successful test run.

**Status:** PASS

---

### API-006: Verify a Non-Existent Post Returns 404

**Test Scenario:** Verify that requesting a post that does not exist returns HTTP 404.

**Preconditions:**

* The API host is accessible.
* The requested post ID does not correspond to an existing post.

**Test Steps:**

1. Send an HTTP GET request to `/posts/9999`.
2. Capture the API response.
3. Verify that the response status code is `404`.

**Expected Result:**

* The API returns HTTP `404 Not Found`.

**Actual Result:**

* HTTP status code `404` was returned and the assertion passed during the successful test run.

**Status:** PASS

**Note:** This test validates the HTTP status code only. The response body is not currently validated.

---

### API-007: Filter Posts by User ID

**Test Scenario:** Verify that the API returns posts belonging to the specified user.

**Preconditions:**

* The API is accessible.
* Posts belonging to user ID 1 are available.

**Test Steps:**

1. Send an HTTP GET request to `/posts` with the query parameter `userId=1`.
2. Verify that the response status code is `200`.
3. Verify that the response contains at least one post.
4. Verify that every returned post has `userId` equal to `1`.

**Expected Result:**

* The API returns HTTP `200 OK`.
* The response list is not empty.
* Every returned post has `userId` equal to `1`.

**Actual Result:**

* All defined response assertions passed during the successful test run.

**Status:** PASS

---

## 4. Test Execution Summary

| Metric           | Result |
| ---------------- | -----: |
| Total Test Cases |      7 |
| Passed           |      7 |
| Failed           |      0 |
| Blocked          |      0 |
| Pass Rate        |   100% |

**Execution Command:**

```bash
mvn clean test
```

**Execution Notes:**

* The summary above reflects the reported successful test run.
* Re-run the test suite before publishing a new test execution report.
* The execution summary describes the current seven automated test cases and does not imply exhaustive API coverage.

## 5. Scope and Limitations

* The tests cover successful retrieval, response field validation, response format, filtering, and selected negative scenarios.
* The tests validate the response from the public JSONPlaceholder API and depend on network availability.
* The test suite does not currently validate every response field, response schema, response time, authentication, or request payload validation.
* The negative test cases verify HTTP status codes; they do not currently assert the complete error response body.

## 6. Future Improvements

* Add explicit response body validation for error scenarios.
* Add response schema validation.
* Add tests for invalid query parameters and boundary conditions.
* Add automated test execution through GitHub Actions.
* Generate and retain test execution reports.
