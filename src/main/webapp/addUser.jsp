<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  ~ Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
  ~ Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
  ~ Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
  ~ Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
  ~ Vestibulum commodo. Ut rhoncus gravida arcu.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Hsian
  Date: 14-6-28
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
</head>
<body>

    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <h2>User Registration Form</h2>
            <form:form id="registrationForm" method="post" action="/user/addUser" modelAttribute="user" cssStyle="width: 800px; margin: 0 auto;" class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="userName" class="col-sm-2 control-label">UserName*</label>
                    <div class="col-sm-4">
                        <input type="text" id="userName" name="userName" class="form-control" placeholder="UserName" />
                        <form:errors path="userName"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password*</label>
                    <div class="col-sm-4">
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password" />
                        <form:errors path="password"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email*</label>
                    <div class="col-sm-4">
                        <input type="text" id="email" name="email" class="form-control" placeholder="Email" />
                        <form:errors path="email"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="firstName" class="col-sm-2 control-label">FirstName*</label>
                    <div class="col-sm-4">
                        <input type="text" id="firstName" name="firstName" class="form-control" placeholder="FirstName" />
                        <form:errors path="firstName"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastName" class="col-sm-2 control-label">LastName</label>
                    <div class="col-sm-4">
                        <input type="text" id="lastName" name="lastName" class="form-control" placeholder="LastName" />
                        <form:errors path="lastName"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="dob" class="col-sm-2 control-label">Date Of Birth</label>
                    <div class="col-sm-4">
                        <input type="text" id="dob" name="dob" class="form-control" placeholder="dd-MM-yyyy" />
                        <form:errors path="dob" cssClass="text-danger" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-4">
                        <input type="submit" class="btn btn-primary" value="Register">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-4">
                        Already Registered? <a href="login">Login</a>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</body>
</html>
