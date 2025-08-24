Feature: Funcionalidad Store

  @crearOrden
  Scenario Outline: Crear orden de compra con petId y quantity
    When creo la orden de compra con orderId <orderId>, petId <petId>, quantity <quantity>
    Then el codigo de respuesta es <statusCodeEsperado>
    And el estado de la orden de compra es "placed"
    Examples:
      | orderId | petId | quantity | statusCodeEsperado |
      |    5    |  2    |   1      |    200             |
      |    6    |  3    |   2      |    200             |
      |    7    |  4    |   3      |    200             |
      |    8    |  5    |   1      |    200             |
      |    9    |  6    |   3      |    200             |

  @consultarOrden
  Scenario Outline: Consultar orden de compra por orderId
    Given que tengo la URL "https://petstore.swagger.io/v2/"
    When consulta la orden de compra de ID <orderId>
    Then el estado de respuesta es <StatusCode>
    And el campo complete es true
    Examples:
      | orderId | StatusCode |
      |    5    |    200     |
      |    6    |    200     |
      |    7    |    200     |
      |    8    |    200     |
      |    9    |    200     |