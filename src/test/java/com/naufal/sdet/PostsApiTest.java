
package com.naufal.sdet;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.*;

class PostsApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI =
                "https://jsonplaceholder.typicode.com";
    }

    // TEST 1: API returns HTTP 200
    @Test
    void getAllPostsReturns200() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200);
    }

    // TEST 2: Verify the data of post with ID 1
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

    // TEST 3: Posts endpoint returns a non-empty list
    @Test
    void getPostsReturnsNonEmptyList() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    // TEST 4: Verify the response uses JSON
    @Test
    void getPostReturnsJsonContentType() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"));
    }

    // TEST 5: An unknown endpoint returns HTTP 404
    @Test
    void unknownEndpointReturns404() {
        given()
                .when()
                .get("/invalid-endpoint")
                .then()
                .statusCode(404);
    }

    // TEST 6: A non-existent post returns HTTP 404
    @Test
    void nonexistentPostReturns404() {
        given()
                .when()
                .get("/posts/9999")
                .then()
                .statusCode(404);
    }

    // TEST 7: Filter posts by userId
    @Test
    void filterPostsByUserIdReturnsMatchingPosts() {
        given()
                .queryParam("userId", 1)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("userId", everyItem(equalTo(1)));
    }
}