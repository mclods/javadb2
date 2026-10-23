# java-db2

Database Application made using Spring Data JPA.

## Steps to Setup:

1. Setup a Postgres DB.
2. Add the datasource in [application.yaml](src/main/resources/application.yaml).
3. Use [db_setup.sql](db/db_setup.sql) to setup the tables.
4. Start the application.

## Initial Data:

### authors table:

| Name | Age |
|---|---|
| Jane Austen | 45 |
| Harper Lee | 38 |
| George Orwell | 50 |
| F. Scott Fitzgerald | 60 |
| J.K. Rowling | 42 |
| Aldous Huxley | 69 |

### books table:

| Title | Author ID | ISBN |
|---|---|---|
| Pride and Prejudice | 1 | 978-3-16-148410-0 |
| Sense and Sensibility | 1 | 978-1-23-456789-7 |
| To Kill a Mockingbird | 2 | 978-0-19-852663-6 |
| 1984 | 3 | 978-0-684-84328-5 |
| Animal Farm | 3 | 978-0-14-312774-1 |
| The Great Gatsby | 4 | 978-0-14-118263-5 |
| Harry Potter and the Sorcerer's Stone | 5 | 978-0-439-06486-6 |
| Harry Potter and the Chamber of Secrets | 5 | 978-0-439-06486-7 |
| Emma | 1 | 978-0-679-60136-2 |
| Go Set a Watchman | 2 | 978-0-06-240985-0 |
| Brave New World | 6 | 978-0-06-085052-4 |
