
package petstore;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static io.restassured.RestAssured.given;

public class Pet {

    // Atributos:
    String uri = "https://petstore.swagger.io/v2/pet"; // endereço da entidade exibida no swagger


    // Metodos e funções:
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json"); // passando o caminho onde está o Body de envio

        given()
                .contentType("application/json")
                .log().all() // mostrar o retorno no console
                .body(jsonBody)

                .when()
                .post(uri)

                .then()
                .log().all() // mostrar o retorno no console
                .statusCode(200);
    }



    @Test
    public void consultarPet(){
        String petId = "9223372036854775807";

        given()
                .contentType("application/json")
                .log().all()

                .when()
                .get(uri + "/" + petId)

                .then()
                .log().all()
                .statusCode(200);

  }

}
