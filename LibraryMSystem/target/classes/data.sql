-- Reset IDs
ALTER TABLE books ALTER COLUMN id RESTART WITH 1;
ALTER TABLE students ALTER COLUMN id RESTART WITH 1;
ALTER TABLE librarians ALTER COLUMN id RESTART WITH 1;
ALTER TABLE loan ALTER COLUMN id RESTART WITH 1;
ALTER TABLE loan_items ALTER COLUMN id RESTART WITH 1;

-------------------------------------------------------------
-- BOOKS
-------------------------------------------------------------
INSERT INTO books (title, author, publisher, isbn, publication_year, copies) VALUES
                                                                                 ('1984', 'George Orwell', 'Secker & Warburg', '9780451524935', 1949, 3),
                                                                                 ('To Kill a Mockingbird', 'Harper Lee', 'J. B. Lippincott & Co.', '9780061120084', 1960, 4),
                                                                                 ('The Great Gatsby', 'F. Scott Fitzgerald', 'Charles Scribner''s Sons', '9780743273565', 1925, 5),
                                                                                 ('Pride and Prejudice', 'Jane Austen', 'T. Egerton', '9780141439518', 1813, 3),
                                                                                 ('The Catcher in the Rye', 'J. D. Salinger', 'Little, Brown and Company', '9780316769174', 1951, 2),
                                                                                 ('The Hobbit', 'J. R. R. Tolkien', 'Allen & Unwin', '9780547928227', 1937, 6),
                                                                                 ('Fahrenheit 451', 'Ray Bradbury', 'Ballantine Books', '9781451673319', 1953, 3),
                                                                                 ('The Lord of the Rings', 'J. R. R. Tolkien', 'Allen & Unwin', '9780544003415', 1954, 4),
                                                                                 ('Harry Potter and the Philosopher''s Stone', 'J. K. Rowling', 'Bloomsbury', '9780747532699', 1997, 7),
                                                                                 ('The Da Vinci Code', 'Dan Brown', 'Doubleday', '9780307474278', 2003, 5),
                                                                                 ('The Alchemist', 'Paulo Coelho', 'HarperTorch', '9780061122415', 1988, 4),
                                                                                 ('The Hunger Games', 'Suzanne Collins', 'Scholastic', '9780439023481', 2008, 6),
                                                                                 ('The Girl with the Dragon Tattoo', 'Stieg Larsson', 'Norstedts', '9780307269751', 2005, 3),
                                                                                 ('Gone Girl', 'Gillian Flynn', 'Crown Publishing', '9780307588364', 2012, 4),
                                                                                 ('The Shining', 'Stephen King', 'Doubleday', '9780385121675', 1977, 3),
                                                                                 ('Brave New World', 'Aldous Huxley', 'Chatto & Windus', '9780060850524', 1932, 2),
                                                                                 ('The Kite Runner', 'Khaled Hosseini', 'Riverhead Books', '9781594631931', 2003, 4),
                                                                                 ('The Book Thief', 'Markus Zusak', 'Picador', '9780375831003', 2005, 5),
                                                                                 ('Life of Pi', 'Yann Martel', 'Knopf Canada', '9780151008117', 2001, 3),
                                                                                 ('The Martian', 'Andy Weir', 'Crown Publishing', '9780553418026', 2014, 4);

-------------------------------------------------------------
-- LIBRARIANS
-------------------------------------------------------------
INSERT INTO librarians (name, email, password) VALUES
                                                   ('Ana Silva', 'ana.silva@biblioteca.com', 'senha123'),
                                                   ('Carlos Oliveira', 'carlos.oliveira@biblioteca.com', 'biblioteca2024'),
                                                   ('Maria Santos', 'maria.santos@biblioteca.com', 'mariabiblio'),
                                                   ('João Pereira', 'joao.pereira@biblioteca.com', 'jp@12345'),
                                                   ('Fernanda Costa', 'fernanda.costa@biblioteca.com', 'fer@biblio99'),
                                                   ('Ricardo Almeida', 'ricardo.almeida@biblioteca.com', 'ricardo123'),
                                                   ('Juliana Martins', 'juliana.martins@biblioteca.com', 'juliana2024'),
                                                   ('Pedro Henrique', 'pedro.henrique@biblioteca.com', 'phbiblio'),
                                                   ('Camila Rodrigues', 'camila.rodrigues@biblioteca.com', 'camila@bib'),
                                                   ('Lucas Ferreira', 'lucas.ferreira@biblioteca.com', 'lucasferr');

-------------------------------------------------------------
-- STUDENTS
-------------------------------------------------------------
INSERT INTO students (name, course, email, phone) VALUES
                                                      ('Pedro Almeida', 'Engenharia de Software', 'pedro.almeida@edu.br', '(11) 99999-1111'),
                                                      ('Juliana Mendes', 'Ciência da Computação', 'juliana.mendes@edu.br', '(11) 99999-2222'),
                                                      ('Ricardo Souza', 'Administração', 'ricardo.souza@edu.br', '(11) 99999-3333'),
                                                      ('Camila Rodrigues', 'Direito', 'camila.rodrigues@edu.br', '(11) 99999-4444'),
                                                      ('Lucas Ferreira', 'Medicina', 'lucas.ferreira@edu.br', '(11) 99999-5555'),
                                                      ('Amanda Lima', 'Psicologia', 'amanda.lima@edu.br', '(11) 99999-6666'),
                                                      ('Bruno Martins', 'Engenharia Civil', 'bruno.martins@edu.br', '(11) 99999-7777'),
                                                      ('Fernanda Costa', 'Arquitetura', 'fernanda.costa@edu.br', '(11) 99999-8888'),
                                                      ('Diego Oliveira', 'Design Gráfico', 'diego.oliveira@edu.br', '(11) 99999-9999'),
                                                      ('Patrícia Silva', 'Enfermagem', 'patricia.silva@edu.br', '(11) 99999-0000');

-------------------------------------------------------------
-- LOAN (SEM ID!)
-------------------------------------------------------------
INSERT INTO loan (loan_date, due_date, return_date, status, students_id) VALUES
                                                                             ('2024-01-15 10:30:00', '2024-02-15 10:30:00', NULL, 'ACTIVE', 1),
                                                                             ('2024-01-20 14:15:00', '2024-02-20 14:15:00', '2024-02-18 09:45:00', 'CONCLUDED', 2),
                                                                             ('2024-02-05 16:40:00', '2024-03-05 16:40:00', NULL, 'ACTIVE', 3),
                                                                             ('2024-02-10 09:10:00', '2024-03-10 09:10:00', '2024-03-05 14:30:00', 'CONCLUDED', 4),
                                                                             ('2024-02-15 13:25:00', '2024-03-15 13:25:00', NULL, 'ACTIVE', 5),
                                                                             ('2024-02-20 15:50:00', '2024-03-20 15:50:00', NULL, 'ACTIVE', 6),
                                                                             ('2024-02-25 10:05:00', '2024-03-25 10:05:00', '2024-03-20 11:15:00', 'CONCLUDED', 7),
                                                                             ('2024-03-01 12:30:00', '2024-04-01 12:30:00', NULL, 'ACTIVE', 8),
                                                                             ('2024-03-05 14:55:00', '2024-04-05 14:55:00', NULL, 'ACTIVE', 9);

-------------------------------------------------------------
-- LOAN_ITEMS (IDs automáticos)
-- IMPORTANTE: loan_id começa em 1 na ordem dos INSERTS de loan
-------------------------------------------------------------
INSERT INTO loan_items (books_id, loan_id, condition_on_loan, condition_on_return) VALUES
                                                                                       (1, 1, 'Good', NULL),
                                                                                       (2, 2, 'Good', 'Good'),
                                                                                       (3, 2, 'Good', 'Good'),
                                                                                       (4, 3, 'Good', NULL),
                                                                                       (5, 4, 'Good', 'Good'),
                                                                                       (6, 4, 'Good', 'ripped'),
                                                                                       (7, 5, 'Good', NULL),
                                                                                       (8, 6, 'Good', NULL),
                                                                                       (9, 6, 'Good', NULL),
                                                                                       (10, 7, 'Good', 'Good'),
                                                                                       (11, 8, 'Good', NULL),
                                                                                       (12, 9, 'Good', NULL),
                                                                                       (13, 9, 'Good', NULL);
