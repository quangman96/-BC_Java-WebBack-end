<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/10/2019
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Stock</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/CSS/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
</head>
<body>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>Mobile Warehouse Management </h1>
        <p>Create New Stock</p> 
    </div>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="http://localhost:8080/">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="collapsibleNavbar">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="/phones">Phones</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/brands">Brands</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/exportOrder">Export Order</a>
            </li>  
            <li class="nav-item">
              <a class="nav-link" href="/importOrders">Import Order</a>
            </li> 
            <li class="nav-item">
              <a class="nav-link" href="/stores">Stores</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/stocks">Stocks</a>
            </li>  
          </ul>
        </div>  
    </nav>
    <div class="container">
        <div class="row">
            <h1>Create new Stock</h1>
        </div>
        <div class="row">
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">
                    <div class="alert alert-success">
                        <strong>Success!</strong>${requestScope["message"]}
                    </div>
                </span>
        </c:if>
        </div>
        <button type="button" class="btn btn-secondary">
                <a href="/stocks">Back to stocks list</a>
            </button>

        <form method="post">
            <fieldset>
                <legend>Stock information</legend>
                 <div class="form-row">
                    <label>Name:</label>
                    <input type="text" class="form-control is-invalid" id="name" name="name" placeholder="Enter name Stock" required>
                    <div class="invalid-feedback">
                        Please provide a valid Stock.
                    </div>
                </div>
                <div class="form-row">
                    <label>Address:</label>
                    <input type="text" class="form-control is-invalid" id="address" name="address" placeholder="Enter address Stock" required>
                    <div class="invalid-feedback">
                        Please provide a valid Stock.
                    </div>
                </div>
                <div class="form-row">
                    <label>Phone Number:</label>
                    <input type="text" class="form-control is-invalid" id="phoneNumber" name="phoneNumber" placeholder="Enter phone Number Stock" required>
                    <div class="invalid-feedback">
                        Please provide a valid phone Number Stock.
                    </div>
                </div>
                <div class="form-row">
                    <label>Create By:</label>
                    <input type="text" class="form-control is-invalid" id="createBy" name="createBy" placeholder="Enter create By" required>
                    <div class="invalid-feedback">
                        Please provide a valid creater.
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Create stock</button>
            </fieldset>
        </form>
    </div>
</body>
</html>