INSERT INTO filmdatabase.film VALUES (DEFAULT,"The Dark Knight",150,2008,"2008-07-18","Joker doing joker thing","Kino"),
(DEFAULT,"Gifted",100,2017,"2007-04-12","Gifted kid","Kino"),(DEFAULT,"Deadpool",150,2016,"2016-02-12","Deadpool doing stuff","Video"),
(DEFAULT,"Captain America",124,2011,"2011-07-22","First avenger","Video");

INSERT INTO filmdatabase.film VALUES(DEFAULT,"Star Wars Ep9",150,2019,"2019-12-20","Rise of skywalker","Video"), (DEFAULT,"The thing",100,1982,"1982-06-25","shape shifting dude","Video"),
(DEFAULT,"Mr bean's holiday",90,2007,"2007-08-24","mr bean on holiday","Video"),(DEFAULT,"Rush hour",98,1998,"1998-09-18","chris and jackie","Video"), 
(DEFAULT,"Rush hour 2",90,2001,"2001-08-03","chris and jackie take2","Video"),(DEFAULT,"Rush hour 3",91,2007,"2007-08-07","chris and jackie take3","Video");


INSERT INTO filmdatabase.filmperson VALUES(DEFAULT,"Chris Evans","Skuespiller","1981-06-13","USA"),(DEFAULT,"Christian Bale","Skuespiller","1974-01-30","UK"),
(DEFAULT,"Ryan Reynolds","Skuespiller","1976-10-23","Canada");
INSERT INTO filmdatabase.tilknyttettil VALUES (1,2,"Bruce Wayne"),(2,1,"Frank Adler"),(3,3,"Wade Wilson"),(4,1, "Steve Rogers");

INSERT INTO filmdatabase.sjanger VALUES(DEFAULT, "Action","spenning"),(DEFAULT, "Grøsser","spooky"),(DEFAULT, "Komedie","morsom"),(DEFAULT, "SciFi","high tech");
INSERT INTO filmdatabase.filmsjanger VALUES(1,1),(2,3),(3,1),(4,1),(5,4),(6,2),(7,3),(8,3),(9,3),(10,3);

INSERT INTO filmdatabase.selskap VALUES(DEFAULT, "www.123.no","gate1","norge"),(DEFAULT, "www.asd.no","gate2","sverige"),(DEFAULT, "www.qwe.no","gate3","danmark");

INSERT INTO filmdatabase.filmselskap VALUES (1,1),(2,1),(3,1),(4,2),(5,3),(6,3),(7,1),(8,1),(9,2),(10,2);