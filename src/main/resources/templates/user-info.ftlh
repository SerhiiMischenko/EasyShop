<!DOCTYPE html>
<html>
<head>
    <title>Easy Shop</title>
</head>
<body>
<h1>Easy Shop</h1>
<h3>Подробная информация о пользователе ${user.name}</h3>
<b>Номер телефона: </b> ${user.phoneNumber}<br>
<b>Электронная почта: </b> ${user.email}<br>
<h4>Товары пользователя ${user.name}</h4>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} грн. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
    <H3>Товаров нет</H3>
</#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>