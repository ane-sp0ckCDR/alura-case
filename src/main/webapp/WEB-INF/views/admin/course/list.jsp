<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Cursos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/assets/external-libs/bootstrap/css/bootstrap.min.css">
</head>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h1>Cursos</h1>
            <c:if test="${not empty successMessage}">
                <div class="alert alert-success">${successMessage}</div>
            </c:if>

            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>
            <a class="btn btn-info new-button" href="/admin/course/new">Cadastrar novo</a>
        </div>

        <table class="panel-body table table-hover">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Código</th>
                <th>Instrutor</th>
                <th>Categoria</th>
                <th>Status</th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${courses}" var="c">
                <tr>
                    <td>${c.name}</td>
                    <td>${c.code}</td>
                    <td>${c.instructor.name}</td>
                    <td>${c.category.name}</td>
                    <td>${c.status}</td>
                    <td><a class="btn btn-primary" href="/admin/course/edit/${c.id}"> Editar </a></td>
                    <td>
                        <form action="/course/${c.id}/inactive" method="post" style="display:inline;">
                            <button class="btn btn-warning" type="submit" data-status="${c.status}">
                                Inativar
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
