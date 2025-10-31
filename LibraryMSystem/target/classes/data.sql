ALTER TABLE books ALTER COLUMN id RESTART WITH 1;



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

INSERT INTO librarians (id, name, email, password) VALUES
                                                       (1, 'Ana Silva', 'ana.silva@biblioteca.com', 'senha123'),
                                                       (2, 'Carlos Oliveira', 'carlos.oliveira@biblioteca.com', 'biblioteca2024'),
                                                       (3, 'Maria Santos', 'maria.santos@biblioteca.com', 'mariabiblio'),
                                                       (4, 'João Pereira', 'joao.pereira@biblioteca.com', 'jp@12345'),
                                                       (5, 'Fernanda Costa', 'fernanda.costa@biblioteca.com', 'fer@biblio99'),
                                                       (6, 'Ricardo Almeida', 'ricardo.almeida@biblioteca.com', 'ricardo123'),
                                                       (7, 'Juliana Martins', 'juliana.martins@biblioteca.com', 'juliana2024'),
                                                       (8, 'Pedro Henrique', 'pedro.henrique@biblioteca.com', 'phbiblio'),
                                                       (9, 'Camila Rodrigues', 'camila.rodrigues@biblioteca.com', 'camila@bib'),
                                                       (10, 'Lucas Ferreira', 'lucas.ferreira@biblioteca.com', 'lucasferr');

INSERT INTO students (id, name, course, email, phone) VALUES
                                                          (1, 'Pedro Almeida', 'Engenharia de Software', 'pedro.almeida@edu.br', '(11) 99999-1111'),
                                                          (2, 'Juliana Mendes', 'Ciência da Computação', 'juliana.mendes@edu.br', '(11) 99999-2222'),
                                                          (3, 'Ricardo Souza', 'Administração', 'ricardo.souza@edu.br', '(11) 99999-3333'),
                                                          (4, 'Camila Rodrigues', 'Direito', 'camila.rodrigues@edu.br', '(11) 99999-4444'),
                                                          (5, 'Lucas Ferreira', 'Medicina', 'lucas.ferreira@edu.br', '(11) 99999-5555'),
                                                          (6, 'Amanda Lima', 'Psicologia', 'amanda.lima@edu.br', '(11) 99999-6666'),
                                                          (7, 'Bruno Martins', 'Engenharia Civil', 'bruno.martins@edu.br', '(11) 99999-7777'),
                                                          (8, 'Fernanda Costa', 'Arquitetura', 'fernanda.costa@edu.br', '(11) 99999-8888'),
                                                          (9, 'Diego Oliveira', 'Design Gráfico', 'diego.oliveira@edu.br', '(11) 99999-9999'),
                                                          (10, 'Patrícia Silva', 'Enfermagem', 'patricia.silva@edu.br', '(11) 99999-0000');


INSERT INTO loan (id, loan_date, due_date, return_date, status, students_id ) VALUES
                                                                                         (1,  '2024-01-15 10:30:00', '2024-02-15 10:30:00', NULL, 'ACTIVE', 1),
                                                                                         (2,  '2024-01-20 14:15:00', '2024-02-20 14:15:00', '2024-02-18 09:45:00', 'CONCLUDED',2),
                                                                                         (3,  '2024-02-05 16:40:00', '2024-03-05 16:40:00', NULL, 'ACTIVE',3),
                                                                                         (5,  '2024-02-10 09:10:00', '2024-03-10 09:10:00', '2024-03-05 14:30:00', 'CONCLUDED',4),
                                                                                         (6,  '2024-02-15 13:25:00', '2024-03-15 13:25:00', NULL, 'ACTIVE',5),
                                                                                         (7,  '2024-02-20 15:50:00', '2024-03-20 15:50:00', NULL, 'ACTIVE',6),
                                                                                         (8,  '2024-02-25 10:05:00', '2024-03-25 10:05:00', '2024-03-20 11:15:00', 'CONCLUDED',7),
                                                                                         (9,  '2024-03-01 12:30:00', '2024-04-01 12:30:00', NULL, 'ACTIVE',8),
                                                                                         (10, '2024-03-05 14:55:00', '2024-04-05 14:55:00', NULL, 'ACTIVE',9);

INSERT INTO LOAN_ITEMS (BOOKS_ID, LOAN_ID, CONDITION_ON_LOAN, CONDITION_ON_RETURN) VALUES
-- Loan 1 (ativo) -> Livro 1
(1, 1, 'Good', null),

-- Loan 2 (concluído) -> Livro 2 e 3
(2, 2, 'Good', 'Good'),
(3, 2, 'Good', 'Good'),

-- Loan 3 (ativo) -> Livro 4
(4, 3, 'Good', null),

-- Loan 5 (concluído) -> Livro 5 e 6
(5, 5, 'Good', 'Good'),
(6, 5, 'Good', 'ripped'),

-- Loan 6 (ativo) -> Livro 7
(7, 6, 'Good', null),

-- Loan 7 (ativo) -> Livro 8 e 9
(8, 7, 'Good', null),
(9, 7, 'Good', null),

-- Loan 8 (concluído) -> Livro 10
(10, 8, 'Good', 'Good'),

-- Loan 9 (ativo) -> Livro 11
(11, 9, 'Good', null),

-- Loan 10 (ativo) -> Livro 12 e 13
(12, 10, 'Good', null),
(13, 10, 'Good', null);




