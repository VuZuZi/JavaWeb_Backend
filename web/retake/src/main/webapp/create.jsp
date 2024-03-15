
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.19.0/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        .error {
            border: 1px solid red !important;
            background-color: #ffdddd;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <!-- Brand và Toggle Button cho Mobile -->
        <a class="navbar-brand" href="/user">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
                <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z"/>
            </svg>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- Các liên kết và menu chính -->
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/user">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Adding</a>
                </li>

            </ul>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <h3>Add product</h3>
    <form action="product" method="post">
        <input type="hidden" name="action" value="create">
        <table class="table">
            <tbody>
            <tr>
                <td>Product Name:</td>
                <td><input type="text" id="name" name="name" class="form-control"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="number" class="form-control" id="price" name="price"></td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td><input type="number" class="form-control" name="quan"></td>
            </tr>
            <tr>
                <td>Color</td>
                <td><input type="text" name="color">
                <select>
                    <option value="đỏ">đỏ</option>
                    <option value="đỏ">vàng</option>
                    <option value="đỏ">xanh</option>
                    <option value="đỏ">đen</option>
                </select>
                </td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="des"></td>
            </tr>
            <tr>
                <td>Category</td>
                <td>

                </td>
            </tr>
            <%--        <tr>--%>
            <%--            <td>Email:</td>--%>
            <%--            <td><input type="text" id="email" class="form-control" oninput="checkVal(email)"></td>--%>
            <%--        </tr>--%>
            <%--        <tr>--%>
            <%--            <td>Phone Number:</td>--%>
            <%--            <td><input type="text" id="phoneNumber" class="form-control"></td>--%>
            <%--        </tr>--%>
            </tbody>
        </table>
    </form>

    <button id="submitButton" class="btn btn-primary" style="display: none;">Submit</button>
</div>
<footer class="footer bg-info">
    <div class="container text-center">
        <p>&copy; 2022 Your Company. All rights reserved.</p>
    </div>
</footer>
</body>
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const nameInput = document.getElementById('name');
        const price = document.getElementById('price');
        const phoneNumberInput = document.getElementById('phoneNumber');
        const submitButton = document.getElementById('submitButton');

        [nameInput, price, phoneNumberInput].forEach(input => {
            input.addEventListener('input', function () {
                validateInput(input);
                checkAllInputs();
            });
        });

        function validateName(name) {
            const regex = /^[a-zA-Z\s]+$/;
            return regex.test(name);
        }

        function validateEmail(email) {
            const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return regex.test(email);
        }
        function priceIn(price){
            if (price === '' || price >=10000000){
                input.classList.add('error');
            }else {
                input.classList.remove('error');

            }
        }

        function validatePhoneNumber(phoneNumber) {
            const regex = /^\+?\d+$/;
            return regex.test(phoneNumber);
        }

        function validateInput(input) {
            const value = input.value.trim();
            let isValid;

            if (value === '') {
                input.classList.add('error');
            } else {
                input.classList.remove('error');
            }

            switch (input.id) {
                case 'name':
                    isValid = validateName(value);
                    break;
                case 'price':
                    isValid = priceIn(value);
                    break;
                case 'phoneNumber':
                    isValid = validatePhoneNumber(value);
                    break;
                default:
                    isValid = false;
            }

            if (isValid) {
                input.classList.remove('error');
            } else {
                input.classList.add('error');
            }
        }

        function checkAllInputs() {
            const inputs = [nameInput, emailInput, phoneNumberInput];
            const allInputsValid = inputs.every(input => input.value.trim() !== '');

            if (allInputsValid) {
                submitButton.style.display = 'block';
            } else {
                submitButton.style.display = 'none';
            }
        }
    });
</script>
</html>