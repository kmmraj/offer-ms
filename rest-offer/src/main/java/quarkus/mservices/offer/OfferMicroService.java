package quarkus.mservices.offer;


import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(title = "Offer API",
                description = "Returns Offers",
                version = "1.0",
                contact = @Contact(name = "@kmmraj", url = "https://twitter.com/kmmraj")),
        externalDocs = @ExternalDocumentation(url = "https://rndwww.", description = "All the Microservice course code"),
        tags = {
                @Tag(name = "api", description = "Public API that can be used by anybody"),
                @Tag(name = "offers", description = "Offers API")
        }
)
public class OfferMicroService  extends Application {
}
