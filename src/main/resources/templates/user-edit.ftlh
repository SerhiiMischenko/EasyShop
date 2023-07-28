<!DOCTYPE html>
<html lang="">
<head>
    <title>Easy Shop</title>
</head>
<body>
<h1>Easy Shop</h1>
<h3>Редактирование пользователя</h3>
<form action="/admin/user/edit" method="post">
    <#list roles as role>
        <div>
            <Label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Сохранить</button>
</form>
</body>
</html>