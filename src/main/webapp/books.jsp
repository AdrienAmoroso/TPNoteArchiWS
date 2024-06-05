<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>

<head>
    <title>Résultats</title>
    <meta charset="UTF-8" />

    <style>
        table,
        th,
        td {
            border: 1px solid;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>

<body>
    <h1>Liste des livres</h1>
    <fieldset>
        <legend>Livres</legend>
        <table>
            <tr>
                <th>Titre</th>
                <th>Auteur</th>
                <th>Nombre de notes</th>
                <th>Moyenne des notes</th>
                <th>Prix en euros</th>
                <th>Photo de l'auteur</th>
            </tr>
            <c:forEach items="${requestScope.BOOKS_LIST}" var="book">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.ratingsCount}</td>
                    <td>${book.ratingsAverage}</td>
                    <td>${book.priceInEuro} €</td>
                    <td>
                        <c:if test="${not empty book.authorPhotoUrl}">
                            <img src="${book.authorPhotoUrl}" alt="Photo de l'auteur" width="50px" />
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</body>

</html>
