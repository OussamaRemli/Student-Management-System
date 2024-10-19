CREATE TABLE etudiant (
  id INT PRIMARY KEY,
  firstname VARCHAR(50),
  lastname VARCHAR(50),
  identifiant VARCHAR(20) UNIQUE,
  email VARCHAR(100)
);
