package org.agoncal.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Path("api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookReporitory reporitory;

    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Return all books");
        final List<Book> books = reporitory.getAllBooks();
        logger.debug("books " + books.toString());
        return books;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        logger.info("Return the number of books");
        return reporitory.getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBookById(@PathParam("id") int id) {
        logger.info("Returns a single book");
        return reporitory.getBook(id);
    }

}
