package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.*;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {

    @Test
    @DisplayName("Should get all books")
    void testHelloEndpoint() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
          .when().get("api/books")
          .then()
             .statusCode(200)
             .body("size()", is(4));
    }

    @Test
    @DisplayName("Should count all books")
    void shouldCountAllBooks() {
        given()
                .header(ACCEPT, TEXT_PLAIN)
          .when().get("api/books/count")
          .then()
             .statusCode(200)
             .body(is("4"));
    }

    @Test
    @DisplayName("Should get book by id")
    void shouldGetBookById() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .when().get("api/books/1")
                .then()
                .statusCode(200)
                .body("title", is("Understanding Quarkus"))
                .body("author", is("Antonio"))
                .body("genre", is("IT"))
                .body("yearOfPublication", is(2020));
    }

}