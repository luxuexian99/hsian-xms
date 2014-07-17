<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="" lang="en">
<head>
    <title>User</title>
</head>
<body>
<h1>Hello: ${user.userName}!</h1>
<form:form id="registrationForm" method="post" action="/user/delete" modelAttribute="user" cssStyle="width: 800px; margin: 0 auto;" class="form-horizontal" role="form">
    <h1>${user.id}</h1>
    <div class="form-group">
            <%--<label for="userName" class="col-sm-2 control-label">UserName*</label>--%>
        <div class="col-sm-4">
                <%--<form:hidden path="id" id="id" />--%>
            <input type="text" id="id" name="id" value="${user.id}" class="form-control" placeholder="id" />
                <%--<form:errors path="userName"/>--%>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-4">
            <input type="submit" class="btn btn-primary" value="delete">
        </div>
    </div>
</form:form>
</body>
</html>