package ti.exame.exercicio1;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ti.exame.soap.GetPetsByOwnerRequest;
import ti.exame.soap.GetPetsByOwnerResponse;

@Endpoint
public class PetEndpoint {

    private static final String NAMESPACE = "https://exame.ti/soap";

    @PayloadRoot(namespace = NAMESPACE, localPart = "getPetsByOwnerRequest")
    @ResponsePayload
    public GetPetsByOwnerResponse getPetsByOwner(
            @RequestPayload GetPetsByOwnerRequest request) {

        String nif = request.getOwnerNif();

        GetPetsByOwnerResponse response = new GetPetsByOwnerResponse();

        if (nif.equals("234567890")) {
            GetPetsByOwnerResponse.Pet pet1 = new GetPetsByOwnerResponse.Pet();
            pet1.setName("Bobby");
            pet1.setSpecies("dog");
            pet1.setAge(3);
            pet1.setOwnerNif(nif);
            response.getPet().add(pet1);

            GetPetsByOwnerResponse.Pet pet2 = new GetPetsByOwnerResponse.Pet();
            pet2.setName("Mimi");
            pet2.setSpecies("cat");
            pet2.setAge(5);
            pet2.setOwnerNif(nif);
            response.getPet().add(pet2);
        }

        return response;
    }
}