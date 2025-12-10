<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/login.css">
</head>
<body class="login-page">
<div class="container">
    <div class="login-box">
        <h2>Já estuda com a gente?</h2>
        <p>Faça seu login e boa aula!</p>
        <a href="/admin/categories" class="btn-login">ENTRAR</a>
    </div>

    <div class="courses">
        <h1>Ainda não estuda com a gente?</h1>
        <p>São mais de mil cursos nas seguintes áreas:</p>

        <div class="grid">
            <c:forEach var="category" items="${categoryList}">
                <div class="card">
                <img src="${pageContext.request.contextPath}/assets/icons/${category.categoryCode}.svg"
                     class="category-icon"
                     style="color: ${category.categoryColor};" />

                    <div class="category-title">
                        <p style="color: ${category.categoryColor} !important" class="line">Escola_</p>
                        <p style="color: ${category.categoryColor} !important" class="line">${category.categoryName}</p>
                    </div>
                    <p>${category.categoryCourses}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
