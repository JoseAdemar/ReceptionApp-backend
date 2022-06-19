
    create table RegisterVisitation (
       id bigint not null auto_increment,
        checkinTime datetime(6),
        checkoutTime datetime(6),
        department varchar(255),
        reasonForVisit varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table TBL_REGISTER_VISITOR (
       id bigint not null auto_increment,
        birthDate varchar(255),
        email varchar(255),
        name varchar(255),
        phone varchar(255),
        primary key (id)
    ) engine=InnoDB;
INSERT INTO TBL_REGISTER_VISITOR              (name,birthDate,phone,email)             VALUES('Mara','18/06/1988','98547414','maria@domain.com');
INSERT INTO TBL_REGISTER_VISITOR              (name,birthDate,phone,email)             VALUES('Pedro','18/06/1990','88547415','pedro@domain.com');
INSERT INTO TBL_REGISTER_VISITOR              (name,birthDate,phone,email)             VALUES('Ana','18/06/1988','8985474159','ana@domain.com');
