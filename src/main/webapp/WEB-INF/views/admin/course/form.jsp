<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>${formTitle}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/assets/external-libs/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="panel panel-default" style="margin-top: 30px">
        <div class="panel-heading">
            <h1>${formTitle}</h1>
        </div>
        <div class="panel-body">
            <form method="post" action="${formAction}" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" value="${formObject.name}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Código</label>
                    <div class="col-sm-10">
                        <input type="text" name="code" class="form-control" value="${formObject.code}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Instrutor</label>
                    <div class="col-sm-10">
                        <select name="instructorEmail" class="form-control" required>
                        <option value="">Selecione</option>
                            <c:forEach var="ins" items="${instructors}">
                                <option value="${ins.email}"
                                    ${formObject.instructorEmail == ins.email ? 'selected' : ''}>
                                    ${ins.name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Descrição</label>
                    <div class="col-sm-10">
                        <input type="text" name="description" class="form-control" value="${formObject.description}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Categoria</label>
                    <div class="col-sm-10">
                        <select name="category" class="form-control" required>
                        <option value="">Selecione</option>
                            <c:forEach var="cat" items="${categories}">
                                <option value="${cat.id}"
                                    ${formObject.category == cat.id ? 'selected' : ''}>
                                    ${cat.name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success">
                            Salvar
                        </button>

                        <a href="/admin/courses" class="btn btn-default">
                            Voltar
                        </a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>