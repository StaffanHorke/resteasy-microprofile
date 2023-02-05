package org.jboss.resteasy.microprofile.client;

import java.net.URI;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.RestClientDefinitionException;
import org.junit.Test;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

public class AutoCloseableClientTest {

    /**
     * A rest interface annotated with an URI path that contains an URI template
     * is valid. Extending that interface with AutoCloseable is expected to also
     * be valid.
     * <p>
     * {@link RestClientDefinitionException} is not expected.
     *
     */
    @Test
    public void buildAutoCloseableClientWithUriTemplate() {
        RestClientBuilder.newBuilder().baseUri(URI.create("http://foo"))
                .build(AutoCloseableClientWithUriTemplate.class);
    }

}


@Path("/{name}")
interface AutoCloseableClientWithUriTemplate extends AutoCloseable {

    @GET
    String hello(@PathParam("name") String name);

}
