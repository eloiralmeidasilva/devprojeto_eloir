
package br.rest;

import br.model.Cidade;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:CidadeRest [cidade]<br>
 * USAGE:
 * <pre>
        RestCidadeClient client = new RestCidadeClient();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 </pre>
 *
 * @author eloir
 */
public class RestCidadeClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://maventest.herokuapp.com/mavenTest-1.0-SNAPSHOT/webresources/";

    public RestCidadeClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cidade");
    }

    public void post(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T get(Class<T> responseType) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

     public List<Cidade> getAll() throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Cidade>>() {});
    }

    public void close() {
        client.close();
    }
    
}
