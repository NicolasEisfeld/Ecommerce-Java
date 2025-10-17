<?php
$pageTitle = "E-Commerce Sistema";
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $pageTitle; ?></title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1><?php echo $pageTitle; ?></h1>

        
        <h2>Bem-vindo ao Sistema de E-Commerce</h2>
        <p>Este é o painel administrativo do sistema de e-commerce.</p>
        <!-- Realizar primeiramente as operações básicas -->
        <a href="">Cadastrar</a>
        <a href="">Listar</a>
        
        <?php

        
        $menuItems = [
            'Dashboard' => 'dashboard.php',
            'Produtos' => 'produtos.php',
            'Pedidos' => 'pedidos.php',
            'Clientes' => 'clientes.php',
            'Relatórios' => 'relatorios.php'
        ];
        ?>
        
        
    </div>
</body>
</html>
