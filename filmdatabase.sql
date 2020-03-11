CREATE DATABASE filmdatabase;
USE filmdatabase;

CREATE TABLE Film (
	FilmID INT NOT NULL AUTO_INCREMENT,
    Tittel varchar(255),
    Lengde INT NOT NULL,
    Utgivelsesår YEAR NOT NULL, -- YYYY 
    Lanseringsdato DATE NOT NULL, -- YYYY-MM-DD format
    Beskrivelse varchar(255) NOT NULL,
    Plattform varchar(255) NOT NULL, -- any combination of 'Streaming','Kino','TV','Video'
	CONSTRAINT Film_PK PRIMARY KEY (FilmID)
);

CREATE TABLE Filmperson(
	FilmpersonID INT NOT NULL AUTO_INCREMENT,
    Navn varchar(255),
    Jobb varchar(255), -- any combination of 'Manusforfatter','Skuespiller','Regissør'
    Fødselsår DATE,
    Fødselsland varchar(255),
    CONSTRAINT FilmpersonID_PK PRIMARY KEY (FilmpersonID)
);

CREATE TABLE TilknyttetTil(
	FilmID INT NOT NULL,
    FilmpersonID INT NOT NULL,
    Rolle varchar(255),
    CONSTRAINT TilknyttetTil_PK PRIMARY KEY (FilmID, FilmpersonID),
    CONSTRAINT TilknyttetTil_FK FOREIGN KEY (FilmpersonID)
        REFERENCES Film (FilmID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Selskap(
	SelskapID INT NOT NULL AUTO_INCREMENT,
    URL varchar(255),
    Adresse varchar(255),
    Land varchar(255),
    CONSTRAINT SelskapID_PK PRIMARY KEY (SelskapID)
);

CREATE TABLE Filmselskap(
	FilmID INT NOT NULL,
    SelskapID INT NOT NULL,
    CONSTRAINT Filmselskap_PK PRIMARY KEY (FilmID, SelskapID),
    CONSTRAINT Filmselskap_FK FOREIGN KEY (SelskapID)
        REFERENCES Film (FilmID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Bruker(
	BrukerID INT NOT NULL AUTO_INCREMENT,
    Navn varchar(255),
    Epost varchar(255),
    CONSTRAINT BrukerID_PK PRIMARY KEY (BrukerID)
);

CREATE TABLE Filmvurdering(
	FilmID INT NOT NULL,
    BrukerID INT NOT NULL,
    Rating DECIMAL(2,1),
    CHECK (Rating <=10 AND Rating >=0),
    Anmeldelse varchar(255),
    CONSTRAINT Filmvurdering_PK PRIMARY KEY (FilmID, BrukerID),
    CONSTRAINT Filmvurdering_FK FOREIGN KEY (BrukerID)
        REFERENCES Film (FilmID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Serie(
	SerieID INT NOT NULL AUTO_INCREMENT,
    Navn varchar(255),
    Beskrivelse varchar(255),
    CONSTRAINT SerieID_PK PRIMARY KEY (SerieID)
);

CREATE TABLE Sjanger(
	SjangerID INT NOT NULL AUTO_INCREMENT,
    Navn varchar(255),
    Beskrivelse varchar(255),
    CONSTRAINT SjangerID_PK PRIMARY KEY(SjangerID)
);

CREATE TABLE Filmsjanger(
	FilmID INT NOT NULL,
    SjangerID INT NOT NULL,
    CONSTRAINT Filmsjanger_PK PRIMARY KEY (FilmID, SjangerID),
    CONSTRAINT Filmsjanger_FK FOREIGN KEY (SjangerID)
        REFERENCES Film (FilmID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Musikk(
	MusikkID INT NOT NULL AUTO_INCREMENT,
    Komponist varchar(255),
    FramførtAv varchar(255),
    CONSTRAINT MusikkID PRIMARY KEY(MusikkID)
);

CREATE TABLE Filmmusikk(
	FilmID INT NOT NULL,
    MusikkID INT NOT NULL,
    CONSTRAINT Filmmusikk_PK PRIMARY KEY (FilmID, MusikkID),
    CONSTRAINT Filmmusikk_FK FOREIGN KEY (MusikkID)
        REFERENCES Film (FilmID)
        ON UPDATE CASCADE ON DELETE CASCADE
);