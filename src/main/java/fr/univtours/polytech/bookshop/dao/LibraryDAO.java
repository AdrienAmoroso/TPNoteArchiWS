package fr.univtours.polytech.bookshop.dao;

import fr.univtours.polytech.bookshop.model.library.OpenLibraryResult;

public interface LibraryDAO {
    OpenLibraryResult getBookInfo(String title, String author);
}
