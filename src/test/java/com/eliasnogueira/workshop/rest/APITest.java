package com.eliasnogueira.workshop.rest;

import com.eliasnogueira.workshop.api.SparkMockAPI;
import com.eliasnogueira.workshop.api.model.Person;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;

/**
 * Run thought the Mocked API
 *
 * @author Elias Nogueira <elias.nogueira@gmail.com> | eliasnogueira.com
 * @see com.eliasnogueira.workshop.api.SparkMockAPI
 */
public class APITest {

    @BeforeClass
    public static void setUp() {
        baseURI = "http://localhost";
        basePath = "/api";
        port = 4567;

        SparkMockAPI.main(null);
    }

    @AfterClass
    public static void tearDown() {
        Spark.stop();
    }

    @Test
    public void getPersonById() {
        when().
            get("/person/{id}", 1).
        then().
            contentType("application/json").and().
            body("nome", equalTo("Elias Nogueira")).and().
            body("endereco", equalTo("RS")).and().
            body("hobbies", equalTo("Automate tests")).and().
            statusCode(200);
    }

    @Test
    public void insertPerson() {
        given()
            .contentType(ContentType.JSON)
            .body(new Person("Yara Senger", "SP", "TDC")).
        when()
            .post("/person").
        then().
            body("nome", equalTo("Yara Senger")).and().
            body("endereco", equalTo("SP")).and().
            body("hobbies", equalTo("TDC")).and().
            statusCode(200);

    }

    @Test
    public void deletePerson() {
        int personID = 
            given()
                .contentType(ContentType.JSON)
                .body(new Person("Yara Senger", "SP", "TDC")).
        when().
            post("/person").
        then().
            extract().
                path("id");
                
        when().
            delete("/person/{id}", personID).
        then().
            body("status", equalTo("success")).and().
            statusCode(200);
    }

    @Test
    public void alterPerson() {
        given().
            contentType(ContentType.JSON).
            body(new Person("Bruno Souza", "SP", "Comer")).
        when().
            put("/person/{id}", 2).
        then().
            body("nome", equalTo("Bruno Souza")).and().
            body("endereco", equalTo("SP")).and().
            body("hobbies", equalTo("Comer")).and().
            statusCode(200);
    }
}
