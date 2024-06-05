package fr.univtours.polytech.bookshop.dao;

import fr.univtours.polytech.bookshop.model.library.OpenLibraryResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class LibraryDAOImpl implements LibraryDAO {

    private static final String URL = "https://openlibrary.org/search.json";

    @Override
    public OpenLibraryResult getBookInfo(String title, String author) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL).queryParam("q", title + " " + author).queryParam("limit", 1);
        ;

        OpenLibraryResult result = target.request(MediaType.APPLICATION_JSON).get(OpenLibraryResult.class);

        return result;
    }
}
