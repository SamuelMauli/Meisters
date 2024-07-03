# Desafios de Programação Java para Estágio na Meisters

Este repositório contém soluções para desafios de programação Java propostos como parte do processo seletivo para estágio na Meisters.

Os códigos foram desenvolvidos por Samuel Mauli no dia 02/07/2024.

## Estrutura dos Códigos

Os codigos estão organizados em 2 pastas, Exercicíos-1-4 contendo os exercicíos do 1 ao 4 e a pasta to-do-list contendo o exercicío extra. 

## Exercícios

1. Filtragem de Strings:
   Dada uma lista de strings, o método retorna uma lista com strings que começam com 'a' (minúsculo) e têm exatamente 3 letras, utilizando Lambdas e Streams da API do Java.

   O código utiliza o método Files.readAllLines para ler todas as linhas do arquivo de texto especificado, filtra as palavras, rdena as palavras filtradas em ordem alfabética. utiliza o size() para contabilizar a quantidade de palavras selecionadas em palavrasFiltradas e captura e trata exceções caso ocorram durante a leitura do arquivo.

2. Remoção de Espaços Brancos:
   Programa Java para remover todos os espaços em branco de uma string sem utilizar o método replace().

   O programa recebe um texto digitado pelo usuário, chama o método 'removeSpaces' passando a entrada do usuário como argumento e armazena o resultado na variável 'result' e imprime o resultado.

3. Troca de Números:
   Implementação em Java para trocar o valor de duas variáveis sem utilizar uma terceira variável.

   O programa recebe 2 numeros digitados pelo usuário, armazena nas variaveis a e b, executa a troca de valores usando operações aritméticas simples. Retornando os valores trocados. 

4. Consultas SQL:
   a. Consulta SQL para encontrar todos os clientes cujo sobrenome é "Smith" e foram criados no ano de 2023, retornando os campos customer_id, first_name, last_name e email.
   b. Consulta SQL para inserir um novo cliente na tabela de clientes com os detalhes: first_name = Pilar, last_name = Rosa, email = pilar_rosa@email.com.

5. Exercício em desenvolvimento:
   No exercício 5, não foi possível desenvolver a integração entre o front-end e o back-end, nem implementar o banco de dados MySQL conforme solicitado. No entanto, realizei a criação de uma página que permite criar, editar e remover tarefas. Essa página é uma representação clara das funcionalidades que devem ser implementadas no back-end.

   O back-end já possui as funcionalidades necessárias. Infelizmente, ainda não tenho o conhecimento técnico para realizar o projeto completo conforme o desafio, mas vejo isso como uma oportunidade de crescimento. Estou empenhado em aprender e, com dedicação, conseguirei desenvolver completamente o projeto To-Do, incluindo a integração com banco de dados e a comunicação entre front-end e back-end.
