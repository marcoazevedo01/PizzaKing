<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>PizzaKing</title>
        <!-- meta -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/jqueryMask.js"></script>
        <script src="js/masks.js"></script>
    <head>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">Pizza King</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Alterna navegação">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <div class="hidden-xs" id="logo">
                        <a href="#header">
                            <img src="img/logo.png" alt="">
                        </a>
                    </div>
                    <ul class="nav navbar-nav w-100 justify-content-end">               
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="modal" data-target="#modal-cliente">Registrar</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp#food-menu">Cardápio</a>
                        </li>
                        <li class="nav-item">                 
                            <a class="nav-link" href="dashboard">Login</a> 
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <body>