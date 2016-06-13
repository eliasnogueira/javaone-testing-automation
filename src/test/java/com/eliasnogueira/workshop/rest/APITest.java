package com.eliasnogueira.workshop.rest;

import com.eliasnogueira.workshop.api.SparkMockAPI;
import com.eliasnogueira.workshop.api.model.Person;
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

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
            body("hobbies", equalTo("Automate tests"));        
    }
    
    @Test
    public void insertPerson() {
        given()
            .contentType(ContentType.JSON)
            .body(new Person("Yara Senger", "SP", "TDC")).
        when()
            .post("/person").
        then().
            body("nome", equalTo("Yara Senger")).
            body("endereco", equalTo("SP")).
            body("hobbies", equalTo("TDC"));    
                
    }
    
    @Test
    public void deletePerson() {
        when().
            delete("/person/{id}", 3).
        then().
            body("status", equalTo("success"));      
    }
    
    @Test
    public void alterPerson() {
        given().
            contentType(ContentType.JSON).
            body(" { \"nome\" : \"Elias da Silva Nogueira\" } ");
        when().
            put("/person/{id}", 1).
        then().
            body("nome", equalTo("Elias da SIlva Nogueira")).
            body("endereco", equalTo("RS")).
            body("hobbies", equalTo("Automate Tests")); 
    }
}
