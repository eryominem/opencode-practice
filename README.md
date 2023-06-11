# Web-приложение для администрирования справочной информации о кредитно-финансовых учреждениях

### Описание проекта:  
Данное web-приложение, позволяет администрировать справочную информацию о кредитно-финансовых учреждениях. 

### Приложение обладает следующими функциональностями:  
1. Добавление, редактирование и удаление записей в справочнике через пользовательский интерфейс.
2. Механизм пакетной загрузки и обновления справочных данных на основе предоставляемых сведений ЦБ РФ.
Для хранения справочной информации о кредитно-финансовых учреждениях будет использоваться база данных.

### Стэк проекта:  
1. Backend: [Spring Boot](https://spring.io/projects/spring-boot), [Spring MVC](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html), [Spring Data](https://spring.io/projects/spring-data-jpa), [Spring Secuity](https://spring.io/projects/spring-security), [Docker](https://www.docker.com/).  
2. База данных: [H2 Database](https://www.h2database.com/html/main.html).  
3. Frontend: HTML, [SCSS](https://sass-lang.com/), [Bootstrap](https://getbootstrap.com/), JavaScript, [JQuery](https://jquery.com/), [React](https://react.dev/).   
4. Взаимодействие между backend и frontend осуществляется посредством JSON, REST.  
5. Для описания API используются [Swagger](https://swagger.io/tools/swagger-ui/).  

### Инструкции по запуску:
1. Убедитесь, что у вас установлены Java Development Kit (JDK) и Maven.
2. Склонируйте репозиторий проекта на свой локальный компьютер.
3. Откройте терминал (или командную строку) и перейдите в каталог проекта.
4. Запустите следующую команду для сборки проекта и запуска встроенного сервера:
mvn spring-boot:run
5. Откройте веб-браузер и перейдите по адресу http://localhost:9090 для доступа к web-приложению.

### Функцинальность проекта:
 1. http://localhost:9090/api/ed807  
Данный эндпоинт выполняет функцию работы с загрузкой файлов в приложение. Использует фреймворк JAXB.
 2. http://localhost:9090/api/bics  
Данный эндпоинд предоставляет просмотр всех плательщиков юзеру.
 3. http://localhost:9090/api/directories  
Данный эндпоинт предоставляет возможность для работы со справочниками
 
### Заключение:  
Данный проект представляет собой web-приложение для администрирования справочной информации о кредитно-финансовых учреждениях. Он разработан с использованием Spring Boot, Spring MVC, Spring Data и Spring Security на backend'е, H2 Database для хранения данных и одного из стеков технологий для фронтенда. Проект также предоставляет API доступа к справочной информации и её поиску. Реализован настраиваемый логгер, "дружелюбный" интерфейс и предотвращение проблем при возникновении ошибок и сбоях в сети или на сервере.
