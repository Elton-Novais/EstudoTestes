package cep;


import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;


public class CepTest {
    @Test
    public void validarStatusCode() {
        baseURI = "https://viacep.com.br";
        basePath = "/ws";
        given()
        .when()
            .get("/01001000/json/")
        .then()
            .log().all()
            .statusCode(200)
        ;
    }

    @Test
    public void validarBody() {
        baseURI = "https://viacep.com.br";
        basePath = "/ws";
        given()
        .when()
            .get("/04852005/json/")
        .then()
            .log().all()
            .statusCode(200)
            .body("logradouro", is("Rua erson"))
        ;
    }

    @Test
    public void validarStatusCodeErro() {
        baseURI = "https://viacep.com.br";
        basePath = "/ws";
        given()
        .when()
            .get("/0A825oo5/json/")
        .then()
            .log().all()
            .statusCode(400)
        ;
    }
}
