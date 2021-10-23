# [Lab 4] JavaServer-Faces, Faceletes, JNDI

### ✔️ Templates

* Templates: **webapp/WEB-INF/templates**
* Decorators: **webapp/WEB-INF/decorators**

### ✔️ Composite component

* Components: **webapp/resources**. I created a composite component for a generic dataTable and another one for an autocomplete input.

### ✔️ Ajax & poll

### ✔️ Implement an efficient way for obtaining connections to the database

* Configured a connection pool and a JDBC resource using an administrative tool.
* Created DataSource objects using JNDI.

# [Lab 3] JavaServer-Faces

### ✔️ Components

* A Web page for defining the exams: **src/main/webapp/exams.xhtml**
* A Web page for defining the students that must attend the exams: **src/main/webapp/students.xhtml**
* Use a relational database and JDBC in order to store and retrieve data: **ro/fii/javaserverfaces/db/Database.java** (PostgreSQL was used)
* Use at least one non trivial JSF component: **data tables** were used to display exams and students
* Internationalize the user interface and offer support for at least two locales: support for **English** and **Romanian** was provided.
* [PrimeFaces](https://www.primefaces.org/)  Ajax-based JSF implementation was used
* Custom validators were used (through validator classes): **ro/fii/javaserverfaces/validators**

### ❌️ Solve the problem