package com.nttdata.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class StoreService {
    private String URL_BASE;
    Response response;
    public void setURL_BASE(String URL_BASE) {
        this.URL_BASE = URL_BASE;
    }

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";
    public void crearOrderinStore(int orderId, int petId, int quantity){
        response = SerenityRest.given()
                .accept("application/json")
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": \"" +orderId+"\",\n" +
                        "  \"petId\": \"" +petId+"\",\n" +
                        "  \"quantity\": \"" +quantity+"\",\n" +
                        "  \"shipDate\": \"2025-08-24T21:48:31.896Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all()
                .extract().response();
    }

    public void validarCodigoRespuesta(int statusCodeEsperado) {
        restAssuredThat(response -> response.statusCode(statusCodeEsperado));
    }

    public void validarNombre(String status) {
        restAssuredThat(response -> response.body("status", equalTo(status)));
    }
    public void consultarOrderporId(int orderId){
        response = SerenityRest
                .given()
                .accept("application/json")
                .relaxedHTTPSValidation()
                .baseUri(this.URL_BASE)
                .log().all()
                .when()
                .get("store/order/"+orderId)
                .then()
                .log().all()
                .extract().response();
    }

    public void validarStatusCode(int StatusCode) {
        restAssuredThat(response -> response.statusCode(StatusCode));
    }

    public void validarCampoComplete() {
        restAssuredThat(response -> response.body("complete", equalTo(true)));
    }
}
