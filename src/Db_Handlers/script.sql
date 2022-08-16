CREATE TABLE users(
    username TEXT PRIMARY KEY,
    paswword_us TEXT,
    role_us TEXT
);

CREATE TABLE preferenceProfile(
    nom_complet TEXT,
    email TEXT,
    GroupeSanguin TEXT,
    username TEXT PRIMARY KEY,
    image TEXT,
    CONSTRAINT fk_pref FOREIGN KEY(username) REFERENCES users(username)
);
CREATE TABLE Hopital(
    hopital_id INTEGER PRIMARY KEY ,
    hopital_name TEXT
);

CREATE TABLE banque(
   banque_id INTEGER PRIMARY KEY ,
   banque_name TEXT
);

CREATE TABLE demandeRDV(
    date_rdv TEXT,
    hopital_id INTEGER,
    demander_par TEXT,
    etat_demande TEXT,
    PRIMARY KEY (date_rdv,hopital_id),
    CONSTRAINT fk_dr FOREIGN KEY (hopital_id) REFERENCES Hopital(hopital_id),
    CONSTRAINT fk_dr2 FOREIGN KEY (demander_par) REFERENCES users(username)
);

CREATE TABLE donneur(
    nom_complet TEXT,
    adresse TEXT,
    contact INTEGER,
    GroupeSanguin groupe_sanguin TEXT,
    date_naissance TEXT,
    genre TEXT,
    remarques TEXT,
    constraint pk_donneur PRIMARY KEY (nom_complet)
);

CREATE TABLE stock(
    num_paquet INTEGER PRIMARY KEY ,
    donne_par TEXT,
    date_de_Don TEXT,
    type_donnation TEXT,
    CONSTRAINT fk_stock FOREIGN KEY (donne_par) REFERENCES donneur(nom_complet)
);

Create table Don(
    num_don INTEGER PRIMARY KEY ,
    date_don TEXT,
    id_hopital INTEGER,
    nom_complet TEXT,
    CONSTRAINT fk_don1 FOREIGN KEY (id_hopital) REFERENCES Hopital(hopital_id) ,
    CONSTRAINT fk_don2 FOREIGN KEY (nom_complet) REFERENCES donneur(nom_complet)
);

Create table demandeOragnisation(
    num_demande INTEGER PRIMARY KEY AUTOINCREMENT,
    oragniser_par TEXT,
    date TEXT,
    h_debut TEXT,
    h_fin TEXT,
    location TEXT,
    CONSTRAINT fk_do1 FOREIGN KEY (oragniser_par) REFERENCES donneur(nom_complet)
);



INSERT INTO Don VALUES (1,date('2021-03-23'),1,'Geoffrey Hull');
INSERT INTO Don VALUES (2,date('2021-02-09'),2,'Tate Tate');
INSERT INTO Don VALUES (3,date('2021-02-28'),4,'Myles Hull');
INSERT INTO Don VALUES (4,date('2021-01-23'),3,'Finn Rivas');
INSERT INTO Don VALUES (5,date('2021-01-15'),1,'Brady Fitzpatrick');
INSERT INTO Don VALUES (6,date('2021-03-03'),1,'Murphy Cooper');
INSERT INTO Don VALUES (7,date('2021-04-01'),3,'Jonah Vang');
INSERT INTO Don VALUES (8,date('2021-03-11'),4,'Murphy Cooper');
INSERT INTO Don VALUES (9,date('2021-04-02'),3,'Tyrone Elliott');
INSERT INTO Don VALUES (10,date('2021-03-26'),2,'Beau Riddle');

INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Tate Tate',date('2021-08-11'),time('11:00'),time('16:00'),'Mustapha bacha');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Finn Rivas',date('2022-04-04'),time('12:00'),time('17:00'),'Hopital de blida');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Jonah Vang',date('2021-05-10'),time('10:00'),time('17:00'),'Mustapha bacha');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Tyrone Elliott',date('2022-10-14'),time('12:00'),time('17:00'),'Hopital de blida');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Edan Farmer',date('2022-11-22'),time('11:00'),time('16:00'),'Mustapha bacha');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Dane Pittman',date('2022-09-11'),time('11:00'),time('13:00'),'Douera');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Myles Baker',date('2022-01-01'),time('9:00'),time('15:00'),'Mustapha bacha');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Jonah Vang',date('2021-11-21'),time('11:00'),time('17:00'),'chu beb el oued');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Beau Riddle',date('2021-05-30'),time('9:00'),time('16:00'),'Hopital de blida');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Murphy Cooper',date('2021-06-13'),time('11:00'),time('12:00'),'chu beb el oued');
INSERT INTO demandeOragnisation(oragniser_par, date,h_debut,h_fin,location ) VALUES('Stephen Gonzalez',date('2022-05-06'),time('12:00'),time('13:00'),'chu beb el oued');





INSERT INTO Donneur VALUES ('Geoffrey Hull','1061 Odio Avenue','16861103 3724','B-',date('1960-05-31'),'femme','non dui nec');
INSERT INTO Donneur VALUES ('Tate Tate','Ap #647-3427 Duis Rd.','16580323 3757','A+',date('1961-10-12'),'homme','Sed eu nibh');
INSERT INTO Donneur VALUES ('Myles Hull','438-6812 Eu Ave','16760504 1974','O+',date('1962-06-09'),'homme','eu augue porttitor');
INSERT INTO Donneur VALUES ('Finn Rivas','603-4796 Semper St.','16961116 1952','B+',date('1990-02-26'),'homme','ultricies ornare, elit');
INSERT INTO Donneur VALUES ('Jonah Vang','P.O. Box 377, 8077 Mollis. Road','16010526 4725','AB+',date('1975-08-04'),'femme','ac, fermentum vel,');
INSERT INTO Donneur VALUES ('Brady Fitzpatrick','550-8017 Ligula. Rd.','16320221 2514','B-',date('1984-03-04'),'femme','eleifend egestas. Sed');
INSERT INTO Donneur VALUES ('Murphy Cooper','P.O. Box 409, 6560 Arcu. St.','16170511 0771','O-',date('1954-03-26'),'femme','Proin ultrices. Duis');
INSERT INTO Donneur VALUES ('Daquan Garza','Ap #655-1763 Nulla Rd.','16210523 5556','O-',date('2005-03-10'),'femme','sollicitudin orci sem');
INSERT INTO Donneur VALUES ('Stephen Gonzalez','P.O. Box 803, 7614 Augue Rd.','16510930 6489','A+',date('1995-05-05'),'femme','viverra. Donec tempus,');
INSERT INTO Donneur VALUES ('Tyrone Elliott','P.O. Box 962, 5775 Adipiscing Av.','16670923 3826','O-',date('1999-05-29'),'homme','ut mi. Duis');
INSERT INTO Donneur VALUES ('Julian Castro','393 Neque. Street','16020305 0448','A+',date('1974-10-28'),'homme','sociis natoque penatibus');
INSERT INTO Donneur VALUES ('Beau Riddle','1936 Magnis Rd.','16510527 4855','A+',date('1991-06-16'),'femme','ridiculus mus. Proin');
INSERT INTO Donneur VALUES ('Edan Farmer','948-3885 Et St.','16600213 8649','A+',date('1958-02-23'),'homme','Quisque imperdiet, erat');
INSERT INTO Donneur VALUES ('Dane Pittman','819-4016 Velit. St.','16110826 5636','O-',date('1990-08-29'),'homme','nec, euismod in,');
INSERT INTO Donneur VALUES ('Charles Whitehead','361-1926 Erat Avenue','16730414 8062','A+',date('1999-09-26'),'homme','quis accumsan convallis,');
INSERT INTO Donneur VALUES ('Aladdin Le','P.O. Box 673, 2032 Lectus. Avenue','16630702 0880','AB+',date('2006-03-07'),'homme','tristique aliquet. Phasellus');
INSERT INTO Donneur VALUES ('Myles Baker','Ap #840-3776 Euismod Street','16320124 5895','B-',date('2006-08-28'),'homme','convallis ligula. Donec');
INSERT INTO Donneur VALUES ('Alec Nelson','8800 Pretium Road','16571209 3292','B-',date('1954-09-16'),'homme','lacus. Aliquam rutrum');
INSERT INTO Donneur VALUES ('Harrison Matthews','8935 Quis St.','16750709 7728','O+',date('1950-03-13'),'femme','Sed neque. Sed');
INSERT INTO Donneur VALUES ('Talon Christian','4017 Et Av.','16810213 7836','AB-',date('2001-06-30'),'homme','quis diam. Pellentesque');
INSERT INTO Donneur VALUES ('Amos Oconnor','P.O. Box 503, 2563 Diam. Ave','16250218 9356','B-',date('1953-06-14'),'femme','Donec luctus aliquet');


INSERT INTO stock VALUES (1,'Geoffrey Hull',date('2021-03-03'),'plasma');
INSERT INTO stock VALUES (2,'Geoffrey Hull',date('2021-01-05'),'plaquette');
INSERT INTO stock VALUES (3,'Tate Tate',date('2021-03-11'),'plasma');
INSERT INTO stock VALUES (4,'Myles Hull',date('2021-02-21'),'Concentre Globule Rouge');
INSERT INTO stock VALUES (5,'Tate Tate',date('2021-01-10'),'plasma');
INSERT INTO stock VALUES (6,'Brady Fitzpatrick',date('2021-03-10'),'plaquette');
INSERT INTO stock VALUES (7,'Stephen Gonzalez',date('2021-02-04'),'plasma');
INSERT INTO stock VALUES (8,'Edan Farmer',date('2021-03-21'),'Concentre Globule Rouge');
INSERT INTO stock VALUES (9,'Stephen Gonzalez',date('2021-03-23'),'Concentre Globule Rouge');
INSERT INTO stock VALUES (10,'Myles Baker',date('2021-03-20'),'total');
INSERT INTO stock VALUES (11,'Amos Oconnor',date('2021-03-31'),'Concentre Globule Rouge');
INSERT INTO stock VALUES (12,'Aladdin Le',date('2021-03-18'),'plaquette');
INSERT INTO stock VALUES (13,'Amos Oconnor',date('2021-03-23'),'plaquette');
INSERT INTO stock VALUES (14,'Stephen Gonzalez',date('2021-02-16'),'plasma');
INSERT INTO stock VALUES (15,'Stephen Gonzalez',date('2021-03-08'),'Concentre Globule Rouge');
INSERT INTO stock VALUES (16,'Tyrone Elliott',date('2021-03-24'),'Concentre Globule Rouge');
INSERT INTO stock VALUES (17,'Tyrone Elliott',date('2021-03-14'),'plaquette');
INSERT INTO stock VALUES (18,'Beau Riddle',date('2021-02-13'),'plasma');
INSERT INTO stock VALUES (19,'Beau Riddle',date('2021-03-17'),'plaquette');
INSERT INTO stock VALUES (20,'Alec Nelson',date('2021-03-26'),'total');
INSERT INTO stock VALUES (21,'Tate Tate',date('2021-02-14'),'total');
INSERT INTO stock VALUES (22,'Geoffrey Hull',date('2021-03-01'),'total');
INSERT INTO stock VALUES (23,'Myles Hull',date('2021-03-10'),'total');
INSERT INTO stock VALUES (24,'Finn Rivas',date('2021-03-14'),'total');
INSERT INTO stock VALUES (25,'Jonah Vang',date('2021-03-26'),'total');
INSERT INTO stock VALUES (26,'Brady Fitzpatrick',date('2021-03-23'),'total');
INSERT INTO stock VALUES (27,'Murphy Cooper',date('2021-03-06'),'total');
INSERT INTO stock VALUES (28,'Edan Farmer',date('2021-03-09'),'total');
INSERT INTO stock VALUES (29,'Dane Pittman',date('2021-03-14'),'total');



INSERT INTO users VALUES('chakibu','chakibxd','admin');
INSERT INTO users VALUES('amdjed','amdjedxd','user');
INSERT INTO users VALUES('nassim','nassimxd','user');


INSERT INTO preferenceProfile VALUES ('Chakib Boudjema','chakibboudjema@gmail.com','A+','chakibu','');
INSERT INTO preferenceProfile VALUES ('Amdjed Bouras','BourasmohamedAmdjed@gmail.com','O+','amdjed','');
INSERT INTO preferenceProfile VALUES ('Mazri Nassim','mazri-said@outlook.com','B+','nassim','');

INSERT INTO Hopital(hopital_name) VALUES ('Mustapha bacha');
INSERT INTO Hopital(hopital_name) VALUES ('Douera');
INSERT INTO Hopital(hopital_name) VALUES ('Hopital de blida');
INSERT INTO Hopital(hopital_name) VALUES ('chu beb el oued');

INSERT INTO banque(banque_name) VALUES ('BS alger centre');
INSERT INTO banque(banque_name) VALUES ('BS oran');

INSERT INTO demandeRDV values (date('2021-11-10'),1,'amdjed','');
INSERT INTO demandeRDV values (date('2021-06-25'),2,'amdjed','accepter');
INSERT INTO demandeRDV values (date('2021-8-10'),3,'nassim','');
INSERT INTO demandeRDV values (date('2020-06-15'),4,'amdjed','accepter');
INSERT INTO demandeRDV values (date('2021-2-10'),3,'nassim','accepter');