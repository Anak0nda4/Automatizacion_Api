package com.nttdata.glue;

import com.nttdata.steps.StoreService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StoreStepdefs {
    @Steps
    StoreService storeService;
    @When("creo la orden de compra con orderId {int}, petId {int}, quantity {int}")
    public void creoLaOrdenDeCompraConPetIdPetIdQuantityQuantity(int orderId, int petId, int quantity) {
        storeService.crearOrderinStore(orderId,petId,quantity);
    }

    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEsStatusCodeEsperado(int statusCodeEsperado) {
        storeService.validarCodigoRespuesta(statusCodeEsperado);
    }

    @And("el estado de la orden de compra es {string}")
    public void elEstadoDeLaOrdenDeCompraEs(String status) {
        storeService.validarNombre(status);
    }

    @Given("que tengo la URL {string}")
    public void queTengoLaURL(String url) {
        storeService.setURL_BASE(url);
    }

    @When("consulta la orden de compra de ID {int}")
    public void consultaLaOrdenDeCompraDeIDOrderId(int orderId) {
        storeService.consultarOrderporId(orderId);
    }

    @Then("el estado de respuesta es {int}")
    public void elEstadoDeRespuestaEsStatusCode(int StatusCode) {
        storeService.validarStatusCode(StatusCode);
    }

    @And("el campo complete es true")
    public void elCampoCompleteEsTrue() {
        storeService.validarCampoComplete();
    }
}
