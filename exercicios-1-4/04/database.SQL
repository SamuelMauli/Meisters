-- Consulta para encontrar todos os clientes cujo sobrenome é "Smith" e foram criados em 2023
SELECT 
    customer_id, 
    first_name, 
    last_name, 
    email
FROM 
    customers
WHERE 
    last_name = 'Smith' 
    AND YEAR(created_at) = 2023;

-- Inserção de um novo cliente na tabela customers
INSERT INTO customers (first_name, last_name, email, created_at)
VALUES ('Pilar', 'Rosa', 'pilar_rosa@email.com', NOW());
