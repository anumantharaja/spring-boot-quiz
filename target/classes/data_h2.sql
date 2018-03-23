create table quiz(id int auto_increment primary key, question varchar(100), expected varchar(50), answer varchar(50));
insert into quiz(question, expected, answer) values 
								('h2-q1', 'a1', 'a'), 
								('h2-q2', 'a2', 'b'),
								('h2-q3', 'a3', 'c'),
								('h2-q4', 'a4', 'd'),
								('h2-q5', 'a5', 'e');
