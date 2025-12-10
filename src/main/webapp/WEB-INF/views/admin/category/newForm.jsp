<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>${formTitle}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/assets/external-libs/bootstrap/css/bootstrap.min.css">
</head>

<div class="container">
    <section class="panel panel-primary vertical-space">
        <div class="panel-heading">
            <h1>${formTitle}</h1>
        </div>

        <form:form
            modelAttribute="formObject"
            cssClass="form-horizontal panel-body"
            method="post"
            action="${formAction}"
        >
            <div class="row form-group">
                <div class="col-md-9">
                    <label>Nome:</label>
                    <form:input path="name" class="form-control"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>

                <div class="col-md-9">
                    <label>Código:</label>
                    <form:input path="code" class="form-control"/>
                    <form:errors path="code" cssClass="text-danger"/>
                </div>

                <div class="col-md-9">
                    <label>Cor:</label>
                    <form:input path="color" class="form-control"/>
                    <form:errors path="color" cssClass="text-danger"/>
                </div>

                <div class="col-md-9">
                    <label>Ordem:</label>
                    <form:input path="order" type="number" min="1" class="form-control"/>
                    <form:errors path="order" cssClass="text-danger"/>
                </div>
            </div>

            <input class="btn btn-success submit" type="submit" value="Salvar"/>
        </form:form>
    </section>
</div>
