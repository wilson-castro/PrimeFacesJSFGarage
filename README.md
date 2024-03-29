

<h1>PrimeFacesJSFGarage</h1>

<p>
    Este é um projeto exemplo de uma aplicação web desenvolvida em Java 11 utilizando Tomcat 10, JSF PrimeFaces, Hibernate e Postgres. Foi criado por <a href="https://github.com/Luisricardo2825">Luis Ricardo</a> e <a href="https://github.com/wilson-castro">Wilson Castro</a> como um exemplo prático dessas tecnologias.
</p>

<h2>Tecnologias Utilizadas</h2>

<p>
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" title="java" alt="java" width="60" height="60"/>
 &nbsp;&nbsp;&nbsp;
 <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white" title="Hibernate" alt="Hibernate" width="170" height="50"/>
 &nbsp;&nbsp;&nbsp;
 <img src="https://www.primefaces.org/wp-content/uploads/2018/05/primetek_logo.png" alt="JSF PrimeFaces" title="JSF PrimeFaces" width="120" height="50"/>
 &nbsp;&nbsp;&nbsp;
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-plain-wordmark.svg" title="postgresql" alt="postgresql" width="60" height="50"/>
</p>


<h2>Requisitos</h2>

<p>
    Para executar o projeto, certifique-se de ter os seguintes requisitos instalados:
</p>

<ul>
    <li>Java 11 ou superior</li>
    <li>Apache Tomcat 10 ou superior</li>
    <li>Um banco de dados Postgres</li>
</ul>

<h2>Instalação</h2>

<p>
    Siga os passos abaixo para instalar e configurar o projeto em seu ambiente:
</p>

<ol>
<li>Clone o projeto do GitHub:</li>

<code>git clone https://github.com/wilson-castro/PrimeFacesJSFGarage.git</code>

<li>Acesse a pasta do projeto:</li>

<code>cd PrimeFacesJSFGarage</code>

  <li>Crie uma base de dados Postgres chamada `primefaces-garage`.</li>

  <li>Execute o script de criação de tabelas:</li>

<code>psql -U postgres -d primefaces-garage -f src/main/resources/db/create.sql</code>

  <li>Abra o arquivo `src/main/resources/META-INF/persistence.xml` e altere as credenciais do banco de dados para corresponder às suas configurações.</li>

  <li>Execute o projeto usando o Tomcat:</li>

<code>mvn tomcat:run</code>

</ol>

<h2>Execução</h2>

<p>
    Após executar o projeto, a aplicação estará disponível em <a href="http://localhost:8080/PrimeFacesJSFGarage">http://localhost:8080/PrimeFacesJSFGarage</a>.
</p>

<p>
    A aplicação consiste em uma interface simples para o cadastro de carros. Os carros podem ser cadastrados, atualizados, excluídos e consultados.
</p>
