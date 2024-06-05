package fr.univtours.polytech.bookshop.business;

import java.util.List;

import fr.univtours.polytech.bookshop.dao.BookDAO;
import fr.univtours.polytech.bookshop.dao.ExchangeRateDAO;
import fr.univtours.polytech.bookshop.dao.LibraryDAO;
import fr.univtours.polytech.bookshop.model.BookBean;
import fr.univtours.polytech.bookshop.model.exchange.ExchangeRateResult;
import fr.univtours.polytech.bookshop.model.library.OpenLibraryResult;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BookBusinessImpl implements BookBusiness {

    @Inject
    private BookDAO bookDAO;

    @Inject
    private LibraryDAO libraryDAO;

    @Inject
    private ExchangeRateDAO exchangeRateDAO;

   

    @Override
    public List<BookBean> getBooks() {
        List<BookBean> books = bookDAO.getBooks();
        ExchangeRateResult exchangeRateResult = exchangeRateDAO.getEuroExchangeRate();

        for (BookBean book : books) {
            OpenLibraryResult openLibraryResult = libraryDAO.getBookInfo(book.getTitle(), book.getAuthor());
            if (openLibraryResult != null && !openLibraryResult.getDocs().isEmpty()) {
                for (var doc : openLibraryResult.getDocs()) {
                    if (doc.getAuthor_name() != null && doc.getAuthor_name().contains(book.getAuthor()) &&
                        doc.getTitle() != null && doc.getTitle().equals(book.getTitle())) {
                        
                        book.setRatingsCount(doc.getRatings_count().toString());
                        book.setRatingsAverage(doc.getRatings_average().toString());
                        book.setAuthorPhotoUrl("https://covers.openlibrary.org/a/olid/" + doc.getAuthor_key().get(0) + ".jpg");
                        book.setFirstSentence(doc.getFirst_sentence().get(0));

                        if (exchangeRateResult != null && exchangeRateResult.getConversionRates() != null) {
                            String currency = book.getCurrency();
                            if (!"EUR".equals(currency)) {
                                Double rate = exchangeRateResult.getConversionRates().getRate(currency);
                                if (rate != null) {
                                    book.setPriceInEuro(Math.round(book.getPrice() * rate * 100.0) / 100.0);
                                }
                            } else {
                                book.setPriceInEuro(book.getPrice());
                            }
                        }
                        break;
                    }
                }
            }
        }

        return books;
    }

    @Override
    public BookBean getBook(Integer id) {
        BookBean book = bookDAO.getBook(id);
        if (book != null) {
            OpenLibraryResult openLibraryResult = libraryDAO.getBookInfo(book.getTitle(), book.getAuthor());
            if (openLibraryResult != null && !openLibraryResult.getDocs().isEmpty()) {
                for (var doc : openLibraryResult.getDocs()) {
                    if (doc.getAuthor_name() != null && doc.getAuthor_name().contains(book.getAuthor()) &&
                        doc.getTitle() != null && doc.getTitle().equals(book.getTitle())) {
                        
                        book.setRatingsCount(doc.getRatings_count().toString());
                        book.setRatingsAverage(doc.getRatings_average().toString());
                        book.setAuthorPhotoUrl("https://covers.openlibrary.org/a/olid/" + doc.getAuthor_key().get(0) + ".jpg");
                        book.setFirstSentence(doc.getFirst_sentence().get(0));
                        
                        ExchangeRateResult exchangeRateResult = exchangeRateDAO.getEuroExchangeRate();
                        if (exchangeRateResult != null && exchangeRateResult.getConversionRates() != null) {
                            String currency = book.getCurrency();
                            if (!"EUR".equals(currency)) {
                                Double rate = exchangeRateResult.getConversionRates().getRate(currency);
                                if (rate != null) {
                                    book.setPriceInEuro(Math.round(book.getPrice() * rate * 100.0) / 100.0);
                                }
                            } else {
                                book.setPriceInEuro(book.getPrice());
                            }
                        }
                        break;
                    }
                }
            }
        }
        return book;
    }


    @Override
    public void createBook(BookBean bookBean) {
        this.bookDAO.createBook(bookBean);
    }

    @Override
    public void updateBook(BookBean bookBean) {
        this.bookDAO.updateBook(bookBean);
    }

    @Override
    public void removeBook(Integer id) {
        this.bookDAO.removeBook(id);
    }
}
