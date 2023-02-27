<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Customers Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"/>
</head>
<body>
<h1 class="display-6 text-center mt-3">Customer Relationship Management - CRM</h1>

<div class="container bg-light mt-3 p-3">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <table class="table table-success table-striped table-hover table-bordered border-dark">
                <thead class="text-center">
                <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody class="table-group-divider text-center">
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td class="col-md-2">
                            <div class="col-md d-flex justify-content-center">
                                <button type="button" name="add-customer" class="btn btn-success btn-sm me-1">View</button>
                                <button type="button" name="add-customer" class="btn btn-success btn-sm ">Delete</button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot class="table-group-divider">
                <tr>
                    <td colspan="12">
                        <button type="button" name="add-customer" class="btn btn-success">Add Customer</button>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"/>
</body>
</html>
