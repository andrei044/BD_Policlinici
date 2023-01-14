drop database policlinica;
create database policlinica;
use policlinica;

#unitate
create table unitate(id_unitate int primary key auto_increment, denumire varchar(30) NOT NULL,adresa varchar(100) NOT NULL); 

#program unitate
create table program_unitate(id_unitate int, mon_start time, mon_stop time, tues_start time, tues_stop time, wed_start time, wed_stop time, thurs_start time, thurs_stop time, fri_start time, fri_stop time, sat_start time, sat_stop time, sun_start time, sun_stop time);
alter table program_unitate add foreign key (id_unitate) references unitate(id_unitate);

#date_user
create table date_user(id_user int primary key auto_increment,nume varchar(30) NOT NULL,prenume varchar(30) NOT NULL,CNP char(13) NOT NULL,adresa varchar(70) NOT NULL,tel char(12) NOT NULL, email varchar(30) NOT NULL);

#admin
create table admin(id_admin int);
alter table admin add foreign key (id_admin) references date_user(id_user);

#superadmin
create table superadmin(id_superadmin int);
alter table superadmin add foreign key (id_superadmin) references admin(id_admin);

#login
create table login(id_user int,username varchar(30) NOT NULL unique, password varchar(30) NOT NULL);
alter table login add foreign key (id_user) references date_user(id_user);

#angajat
create table angajat(id_angajat int, IBAN char(34) NOT NULL, functie varchar(15) NOT NULL, data_angajare date NOT NULL,nr_contract int auto_increment primary key,salariu_brut int,salariu_net int);
alter table angajat add foreign key (id_angajat) references date_user(id_user);

#program_angajat_generic
create table program_angajat_generic(id_angajat int, mon_start time, mon_stop time, mon_id_unitate int, tues_start time, tues_stop time, tues_id_unitate int, wed_start time, wed_stop time, wed_id_unitate int, thurs_start time, thurs_stop time, thurs_id_unitate int, fri_start time, fri_stop time, fri_id_unitate int, sat_start time, sat_stop time, sat_id_unitate int, sun_start time, sun_stop time, sun_id_unitate int);
alter table program_angajat_generic add foreign key (id_angajat) references angajat(id_angajat);
alter table program_angajat_generic add foreign key (mon_id_unitate) references unitate(id_unitate);
alter table program_angajat_generic add foreign key (tues_id_unitate) references unitate(id_unitate);
alter table program_angajat_generic add foreign key (wed_id_unitate) references unitate(id_unitate);
alter table program_angajat_generic add foreign key (thurs_id_unitate) references unitate(id_unitate);
alter table program_angajat_generic add foreign key (fri_id_unitate) references unitate(id_unitate);
alter table program_angajat_generic add foreign key (sat_id_unitate) references unitate(id_unitate);
alter table program_angajat_generic add foreign key (sun_id_unitate) references unitate(id_unitate);

#program_angajat_specific
create table program_angajat_specific(id_angajat int, data_specifica date,timp_start time,timp_stop time, id_unitate int);
alter table program_angajat_specific add foreign key (id_angajat) references angajat(id_angajat);
alter table program_angajat_specific add foreign key (id_unitate) references unitate(id_unitate);

#program_angajat_bonus

#concediu
create table concediu(id_angajat int, zi_concediu date primary key);
alter table concediu add foreign key (id_angajat) references angajat(id_angajat);

#asistent
create table asistent(id_asistent int, grad varchar(20) NOT NULL, tip varchar(20) NOT NULL);
alter table asistent add foreign key (id_asistent) references angajat(id_angajat);

#medic
create table medic(id_medic int, parafa varchar(20) NOT NULL,titlu_stiintific varchar(20), post_didactic varchar(20));
alter table medic add foreign key (id_medic) references angajat(id_angajat);

#deleted
create table deleted(id_user int);
alter table deleted add foreign key (id_user) references date_user(id_user);

#specializare
create table specializare(id_medic int,grad varchar(20) NOT NULL,denumire_specializare varchar(30) NOT NULL, id_specializare int auto_increment primary key);
alter table specializare add foreign key (id_medic) references medic(id_medic);

#competenta
create table competenta(id_specializare int, denumire_competenta varchar(30) NOT NULL,id_competenta int auto_increment primary key);
alter table competenta add foreign key (id_specializare) references specializare(id_specializare);

#serviciu_medical
create table serviciu_medical(id_serviciu int, pret int,durata int);
alter table serviciu_medical add foreign key (id_serviciu) references competenta(id_competenta);

#pacient
create table pacient(id_pacient int);
alter table pacient add foreign key (id_pacient) references date_user(id_user);

#programare
create table programare(id_programare int auto_increment primary key, id_pacient int, id_serviciu int,id_receptioner int, data_programare date, programare_start time, programare_stop time);
alter table programare add foreign key (id_pacient) references pacient(id_pacient);
alter table programare add foreign key (id_serviciu) references serviciu_medical(id_serviciu);
alter table programare add foreign key (id_receptioner) references angajat(id_angajat);


#istoric
create table istoric(id_istoric int, id_asistent int, id_raport int,id_analize int);
alter table istoric add foreign key (id_istoric) references programare(id_programare);
alter table istoric add foreign key (id_asistent) references asistent(id_asistent);

#analize
create table analize(id_analize int auto_increment primary key, wbc decimal(10,3),lymph decimal(10,3),neut decimal(10,3),mono decimal(10,3),hct decimal(10,3));

#raport
create table raport(id_raport int auto_increment primary key, istoric_raport varchar(300), simptome varchar(300),diagnostic varchar(300), recomandari varchar(300)); 
alter table istoric add foreign key (id_raport)references raport(id_raport);
alter table istoric add foreign key(id_analize)references analize(id_analize);


#factura
create table factura(id_factura int, id_receptioner int, data_factura timestamp);
alter table factura add foreign key (id_factura) references istoric(id_istoric);
alter table factura add foreign key (id_receptioner) references angajat(id_angajat);

insert into date_user(nume,prenume,CNP,adresa,tel, email) values ('Gigel','Popescu','1111111111002','Aleea Lalelelor Nr 12', '+40232025010','gigelp@mymail.com');
insert into angajat(id_angajat,IBAN,functie,data_angajare) values (1,'1321','admin','2022-01-10');
insert into admin(id_admin)values('1');
insert into superadmin(id_superadmin)values('1');
insert into login(id_user,username,password) values (1,'','');
insert into unitate(denumire,adresa) values ('unitate1','strada 1');
insert into program_unitate(id_unitate,mon_start, mon_stop, tues_start, tues_stop, wed_start, wed_stop, thurs_start, thurs_stop , fri_start, fri_stop, sat_start , sat_stop , sun_start, sun_stop)values
(1,'05:00','23:00','05:00','23:00','05:00','23:00','05:00','23:00','05:00','23:00','08:00','19:00','08:00','19:00');
insert into unitate(denumire,adresa) values ('unitate2','strada 2');
insert into program_unitate(id_unitate,mon_start, mon_stop, tues_start, tues_stop, wed_start, wed_stop, thurs_start, thurs_stop , fri_start, fri_stop, sat_start , sat_stop , sun_start, sun_stop)values
(2,'05:00','23:00','05:00','23:00','05:00','23:00','05:00','23:00','05:00','23:00','08:00','19:00','08:00','19:00');
insert into program_angajat_generic(id_angajat,mon_start, mon_stop, mon_id_unitate, tues_start, tues_stop, tues_id_unitate, wed_start, wed_stop, wed_id_unitate , thurs_start, thurs_stop , thurs_id_unitate , fri_start, fri_stop, fri_id_unitate , sat_start , sat_stop , sat_id_unitate , sun_start, sun_stop, sun_id_unitate) values
(1,'07:00','07:00','1','07:00','07:00','1','07:00','07:00','1','07:00','07:00','1','07:00','07:00','1','07:00','07:00','1','07:00','07:00','1');

DROP PROCEDURE IF EXISTS login;
DELIMITER //
CREATE PROCEDURE login(user varchar(30), pas varchar(30))
BEGIN
    SELECT * from login where username=user and password=pas;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS insert_user;
DELIMITER //
CREATE PROCEDURE create_user(user varchar(30), pas varchar(30),new_nume varchar(30),new_prenume varchar(30),new_CNP char(30),new_adresa varchar(70),new_tel char(12), new_email varchar(20),OUT id_user int)
BEGIN
    insert into date_user(nume,prenume,CNP,adresa,tel,email) values (new_nume,new_prenume,new_CNP,new_adresa,new_tel,new_email);
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS cautaAngajatProcedure;
DELIMITER //
CREATE PROCEDURE cautaAngajatProcedure(IN nume varchar(30),IN prenume varchar(30))
BEGIN
	SET @nume_cautat=nume, @prenume_cautat=prenume;
    IF(@nume_cautat='' AND @prenume_cautat='')then
		select angajat.id_angajat, date_user.nume, date_user.prenume 
		from angajat inner join date_user 
		on angajat.id_angajat=date_user.id_user and angajat.id_angajat not in(select id_user from deleted);
    ELSEIF (@nume_cautat<>'' AND @prenume_cautat='')then
		select angajat.id_angajat, date_user.nume, date_user.prenume 
		from angajat inner join date_user 
		on angajat.id_angajat=date_user.id_user and date_user.nume like CONCAT('%',@nume_cautat,'%')
        and angajat.id_angajat not in(select id_user from deleted);
    ELSEIF (@nume_cautat='' AND @prenume_cautat<>'')then
		select angajat.id_angajat, date_user.nume, date_user.prenume 
		from angajat inner join date_user 
		on angajat.id_angajat=date_user.id_user and date_user.prenume like CONCAT('%',@prenume_cautat,'%')
        and angajat.id_angajat not in(select id_user from deleted);
    ELSE
		select angajat.id_angajat, date_user.nume, date_user.prenume 
		from angajat inner join date_user 
		on angajat.id_angajat=date_user.id_user and date_user.nume like CONCAT('%',@nume_cautat,'%') and date_user.prenume like CONCAT('%',@prenume_cautat,'%')
        and angajat.id_angajat not in(select id_user from deleted);
    end if;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS cautaPacientProcedure;
DELIMITER //
CREATE PROCEDURE cautaPacientProcedure(IN nume varchar(30),IN prenume varchar(30))
BEGIN
	SET @nume_cautat=nume, @prenume_cautat=prenume;
    IF(@nume_cautat='' AND @prenume_cautat='')then
		select distinct pacient.id_pacient, date_user.nume, date_user.prenume 
		from pacient inner join date_user 
		on pacient.id_pacient=date_user.id_user and pacient.id_pacient not in(select id_user from deleted);
    ELSEIF (@nume_cautat<>'' AND @prenume_cautat='')then
		select distinct pacient.id_pacient, date_user.nume, date_user.prenume 
		from pacient inner join date_user 
		on pacient.id_pacient=date_user.id_user and date_user.nume like CONCAT('%',@nume_cautat,'%') and pacient.id_pacient not in(select id_user from deleted);
    ELSEIF (@nume_cautat='' AND @prenume_cautat<>'')then
		select distinct pacient.id_pacient, date_user.nume, date_user.prenume 
		from pacient inner join date_user 
		on pacient.id_pacient=date_user.id_user and date_user.prenume like CONCAT('%',@prenume_cautat,'%') and pacient.id_pacient not in(select id_user from deleted);
    ELSE
		select distinct pacient.id_pacient, date_user.nume, date_user.prenume 
		from pacient inner join date_user 
		on pacient.id_angajat=date_user.id_user and date_user.nume like CONCAT('%',@nume_cautat,'%') and date_user.prenume like CONCAT('%',@prenume_cautat,'%') and pacient.id_pacient not in(select id_user from deleted);
    end if;
END //
DELIMITER ;

DROP VIEW IF EXISTS detaliiAngajatView;
DELIMITER //
CREATE VIEW detaliiAngajatView AS
	select date_user.id_user, date_user.nume,date_user.prenume,date_user.CNP,date_user.adresa,date_user.tel,date_user.email,angajat.IBAN,angajat.functie,angajat.data_angajare,angajat.nr_contract 
    from date_user inner join angajat on date_user.id_user=id_user and angajat.id_angajat=date_user.id_user;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS veziDetaliiAngajat;
DELIMITER //
CREATE PROCEDURE veziDetaliiAngajat(id_user int)
BEGIN
    select * from detaliiAngajatView inner join program_angajat_generic 
    on detaliiAngajatView.id_user=id_user and detaliiAngajatView.id_user=program_angajat_generic.id_angajat;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS cautaServiciuProcedure;
DELIMITER //
CREATE PROCEDURE cautaServiciuProcedure(denumire_serviciu varchar(30))
BEGIN
	SET @denumire=denumire_serviciu;
    if(@denumire='')then
		select serviciu_medical.id_serviciu, competenta.denumire_competenta, CONCAT(date_user.nume,date_user.prenume) AS Nume, serviciu_medical.durata from serviciu_medical 
		join competenta on competenta.id_competenta=serviciu_medical.id_serviciu join specializare on competenta.id_specializare=specializare.id_specializare 
		join medic on medic.id_medic=specializare.id_medic join date_user on date_user.id_user=medic.id_medic
        and medic.id_medic not in (select deleted.id_user from deleted);
    else
		select serviciu_medical.id_serviciu, competenta.denumire_competenta, CONCAT(date_user.nume,date_user.prenume) AS Nume, serviciu_medical.durata from serviciu_medical 
		join competenta on competenta.id_competenta=serviciu_medical.id_serviciu join specializare on competenta.id_specializare=specializare.id_specializare 
		join medic on medic.id_medic=specializare.id_medic join date_user on date_user.id_user=medic.id_medic where competenta.denumire_competenta like CONCAT('%',denumire_serviciu,'%')
        and medic.id_medic not in (select deleted.id_user from deleted);
    end if;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getProgramPeData;
DELIMITER //
CREATE PROCEDURE getProgramPeData(IN id_serviciu_cautat int,IN data_programare date)
BEGIN
	SET @ZIUA=WEEKDAY(data_programare);
    #select @ID:=specializare.id_medic from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    #join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where serviciu_medical.id_serviciu=id_serviciu_cautat;
    
    IF(@ZIUA='0')then
		select mon_start,mon_stop from program_angajat_generic where id_angajat=(select specializare.id_medic from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where serviciu_medical.id_serviciu=id_serviciu_cautat limit 1);
    elseIF(@ZIUA='1')then
		select tues_start,tues_stop from program_angajat_generic where id_angajat=(select specializare.id_medic from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where serviciu_medical.id_serviciu=id_serviciu_cautat limit 1);
    elseIF(@ZIUA='2')then
		select wed_start,wed_stop from program_angajat_generic where id_angajat=(select specializare.id_medic from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where serviciu_medical.id_serviciu=id_serviciu_cautat limit 1);
    elseIF(@ZIUA='3')then
		select thurs_start,thurs_stop from program_angajat_generic where id_angajat=(select specializare.id_medic from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where serviciu_medical.id_serviciu=id_serviciu_cautat limit 1);
    elseIF(@ZIUA='4')then
		select fri_start,fri_stop from program_angajat_generic where id_angajat=(select specializare.id_medic from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where serviciu_medical.id_serviciu=id_serviciu_cautat limit 1);
    elseIF(@ZIUA='5')then
		select sat_start,sat_stop from program_angajat_generic where id_angajat=(select specializare.id_medic from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where serviciu_medical.id_serviciu=id_serviciu_cautat limit 1);
    else
		select sun_start,sun_stop from program_angajat_generic where id_angajat=(select specializare.id_medic from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where serviciu_medical.id_serviciu=id_serviciu_cautat limit 1);
    end if;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getProgramariPeData;
DELIMITER //
CREATE PROCEDURE getProgramariPeData(IN id_serviciu_programare int,IN data_prog date)
BEGIN
    select programare.programare_start,programare.programare_stop from programare join competenta on competenta.id_competenta=programare.id_serviciu
    join specializare on competenta.id_specializare=specializare.id_specializare where specializare.id_medic=(select specializare.id_medic from specializare join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=id_serviciu_programare) and programare.data_programare=data_prog;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getConcediuPeData;
DELIMITER //
CREATE PROCEDURE getConcediuPeData(IN id_serviciu_programare int,IN data_prog date)
BEGIN
    select zi_concediu from concediu where id_angajat=(select specializare.id_medic from specializare join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=id_serviciu_programare) and zi_concediu=data_prog;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getProgramSpecificPeData;
DELIMITER //
CREATE PROCEDURE getProgramSpecificPeData(IN id_serviciu_programare int,IN data_prog date)
BEGIN
    select timp_start,timp_stop from program_angajat_specific where id_angajat=(select specializare.id_medic from specializare join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=id_serviciu_programare) and data_specifica=data_prog;
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS getCurrentUserFunctie;
DELIMITER //
CREATE PROCEDURE getCurrentUserFunctie(IN id_user int)
BEGIN
    select functie from angajat where id_angajat=id_user;
END //
DELIMITER ;

DROP VIEW IF EXISTS programariAsistent;
DELIMITER //
CREATE VIEW programariAsistent AS
	select distinct programare.id_programare,CONCAT(date_user1.nume,' ',date_user1.prenume) as Pacient, CONCAT(date_user.nume,' ',date_user.prenume) as Medic,
    competenta.denumire_competenta,medic.id_medic, programare.data_programare,programare.programare_start,programare.programare_stop,istoric.id_raport,istoric.id_analize from programare join pacient on programare.id_pacient=pacient.id_pacient join date_user AS date_user1 on date_user1.id_user=pacient.id_pacient join competenta on
    competenta.id_competenta=programare.id_serviciu join specializare on competenta.id_specializare=specializare.id_specializare join medic on
    specializare.id_medic=medic.id_medic join date_user on date_user.id_user=medic.id_medic join istoric on istoric.id_istoric=programare.id_programare;
//
DELIMITER ;

DROP VIEW IF EXISTS getProgramariAziAsistent;
DELIMITER //
CREATE VIEW getProgramariAziAsistent AS
	select programare.id_programare,CONCAT(date_user1.nume,' ',date_user1.prenume) as Pacient, CONCAT(date_user.nume,' ',date_user.prenume) as Medic,
    competenta.denumire_competenta,medic.id_medic, programare.data_programare,programare.programare_start,programare.programare_stop,
    istoric.id_raport,istoric.id_analize from programare join pacient on programare.id_pacient=pacient.id_pacient join date_user AS date_user1 
    on date_user1.id_user=pacient.id_pacient join competenta on
    competenta.id_competenta=programare.id_serviciu join specializare on competenta.id_specializare=specializare.id_specializare join medic on
    specializare.id_medic=medic.id_medic join date_user on date_user.id_user=medic.id_medic join istoric on istoric.id_istoric=programare.id_programare where programare.data_programare=CURDATE();
//
DELIMITER ;




DROP PROCEDURE IF EXISTS programariMedic;
DELIMITER //
CREATE PROCEDURE programariMedic(IN id_user int)
BEGIN
    select * from programariAsistent where id_medic=id_user;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS programariMedicZiuaCurenta;
DELIMITER //
CREATE PROCEDURE programariMedicZiuaCurenta(IN id_user int)
BEGIN
    select * from programariAsistent where id_medic=id_user and data_programare=CURDATE();
END //
DELIMITER ;


DROP TRIGGER IF EXISTS creeazaIstoric;
DELIMITER //
CREATE TRIGGER creeazaIstoric after insert ON programare 
for each row begin
insert into istoric(id_istoric) values(new.id_programare);
insert into factura(id_factura)values(new.id_programare);
 END// 
DELIMITER ;

DROP PROCEDURE IF EXISTS parafeazaRaport;
DELIMITER //
CREATE PROCEDURE parafeazaRaport(IN newIstoricRaport varchar(300),IN newSimptome varchar(300),IN newDiagnostic varchar(300),IN newRecomandari varchar(300),IN idProgramare int)
BEGIN
	insert into raport(istoric_raport,simptome,diagnostic,recomandari)values(newIstoricRaport,newSimptome,newDiagnostic,newRecomandari);
    update istoric set id_raport=(select last_insert_id()) where id_istoric=idProgramare;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS valideazaAnalize;
DELIMITER //
CREATE PROCEDURE valideazaAnalize(IN newwbc decimal(10,3),IN newlymph decimal(10,3),IN newneut decimal(10,3),IN newmono decimal(10,3),IN newhct decimal(10,3), IN idProgramare int,IN idAsistent int)
BEGIN
	insert into analize(wbc,lymph,neut,mono,hct)values(newwbc,newlymph,newneut,newmono,newhct);
    update istoric set id_analize=(select last_insert_id()),id_asistent=idAsistent where id_istoric=idProgramare;
END //
DELIMITER ;



DROP PROCEDURE IF EXISTS getGradMedicByIdServ;
DELIMITER //
CREATE PROCEDURE getGradMedicByIdServ(IN id_serv int)
BEGIN
	select specializare.grad from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta where serviciu_medical.id_serviciu=id_serv;
END //
DELIMITER ;

DROP VIEW IF EXISTS getMedicGradServiciu;
DELIMITER //
CREATE VIEW getMedicGradServiciu AS
	select specializare.grad,serviciu_medical.id_serviciu from specializare join competenta on specializare.id_specializare=competenta.id_specializare 
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta;
//
DELIMITER ;

DROP TRIGGER IF EXISTS pretServiciu;
DELIMITER //
CREATE TRIGGER pretServiciu before insert ON serviciu_medical 
for each row begin
	if(strcmp('specialist',(select specializare.grad from specializare join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=new.id_serviciu limit 1)))then
		set new.pret=50;
	else
		set new.pret=80;
	end if;
    if(strcmp('doctor',(select medic.titlu_stiintific from medic join specializare on specializare.id_medic=medic.id_medic join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=new.id_serviciu limit 1)))then
		set new.pret=new.pret+30;
	elseif(strcmp('doctorand',(select medic.titlu_stiintific from medic join specializare on specializare.id_medic=medic.id_medic join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=new.id_serviciu limit 1)))then
		set new.pret=new.pret+10;
	end if;
	if(strcmp('preparator',(select medic.post_didactic from medic join specializare on specializare.id_medic=medic.id_medic join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=new.id_serviciu limit 1)))then
		set new.pret=new.pret+10;
    elseif(strcmp('asistent',(select medic.post_didactic from medic join specializare on specializare.id_medic=medic.id_medic join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=new.id_serviciu limit 1)))then
		set new.pret=new.pret+20;
    elseif(strcmp('lector',(select medic.post_didactic from medic join specializare on specializare.id_medic=medic.id_medic join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=new.id_serviciu limit 1)))then
		set new.pret=new.pret+30;
    elseif(strcmp('conferentiar',(select medic.post_didactic from medic join specializare on specializare.id_medic=medic.id_medic join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=new.id_serviciu limit 1)))then
		set new.pret=new.pret+40;
    elseif(strcmp('profesor',(select medic.post_didactic from medic join specializare on specializare.id_medic=medic.id_medic join competenta on competenta.id_specializare=specializare.id_specializare where competenta.id_competenta=new.id_serviciu limit 1)))then
		set new.pret=new.pret+50;
    end if;
 END// 
DELIMITER ;

DROP VIEW IF EXISTS getIstoricForFactura;
DELIMITER //
CREATE VIEW getIstoricForFactura AS
	select distinct programare.data_programare, programare.programare_start,programare.programare_stop, CONCAT(date_user.nume,' ',date_user.prenume) AS Pacient,CONCAT(date_user1.nume,' ',date_user1.prenume) AS Medic,
CONCAT(specializare.denumire_specializare,'(',competenta.denumire_competenta,')') AS Serviciu, serviciu_medical.pret,istoric.id_istoric, istoric.id_raport,istoric.id_analize,factura.data_factura from programare join competenta on programare.id_serviciu=competenta.id_competenta join specializare
on competenta.id_specializare=specializare.id_specializare join date_user AS date_user1 on date_user1.id_user=specializare.id_medic join date_user on programare.id_pacient=date_user.id_user
join istoric on istoric.id_istoric=programare.id_programare join serviciu_medical on programare.id_serviciu=serviciu_medical.id_serviciu join factura on factura.id_factura=programare.id_programare ORDER BY programare.data_programare;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS verifConcediu;
DELIMITER //
CREATE PROCEDURE verifConcediu(IN idAngajat int,IN data_start date,IN data_stop date)
BEGIN
	select * from concediu where id_angajat=idAngajat and zi_concediu>=data_start and zi_concediu<=data_stop;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getFirstIdServiciu;
DELIMITER //
CREATE PROCEDURE getFirstIdServiciu(IN idAngajat int)
BEGIN
	select competenta.id_competenta from competenta join specializare on specializare.id_specializare=competenta.id_specializare join medic on specializare.id_medic=medic.id_medic where medic.id_medic=idAngajat limit 1;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getProgramUnitatePeData;
DELIMITER //
CREATE PROCEDURE getProgramUnitatePeData(IN id_unitate_cautata int,IN data_programare date)
BEGIN
	SET @ZIUA=WEEKDAY(data_programare);
    
    IF(@ZIUA='0')then
		select mon_start,mon_stop from program_unitate where id_unitate=id_unitate_cautata;
    elseIF(@ZIUA='1')then
		select tues_start,tues_stop from program_unitate where id_unitate=id_unitate_cautata;
    elseIF(@ZIUA='2')then
		select wed_start,wed_stop from program_unitate where id_unitate=id_unitate_cautata;
    elseIF(@ZIUA='3')then
		select thurs_start,thurs_stop from program_unitate where id_unitate=id_unitate_cautata;
    elseIF(@ZIUA='4')then
		select fri_start,fri_stop from program_unitate where id_unitate=id_unitate_cautata;
    elseIF(@ZIUA='5')then
		select sat_start,sat_stop from program_unitate where id_unitate=id_unitate_cautata;
    else
		select sun_start,sun_stop from program_unitate where id_unitate=id_unitate_cautata;
    end if;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS calculeaza_net;
DELIMITER //
CREATE TRIGGER calculeaza_net before insert ON angajat 
FOR EACH ROW BEGIN set new.salariu_net=(new.salariu_brut)*0.57;
 END// 
DELIMITER ;

DROP VIEW IF EXISTS getVenituriMediciServiciu;
DELIMITER //
CREATE VIEW getVenituriMediciServiciu AS
	select date_user.id_user AS ID,date_user.nume AS NUME,date_user.prenume AS PRENUME,competenta.denumire_competenta AS SERVICIU,
    serviciu_medical.pret AS VENIT,
    serviciu_medical.pret*0.7 AS SALARIU_BRUT_MEDIC
    , serviciu_medical.pret- serviciu_medical.pret*0.7 AS PROFIT,programare.data_programare AS DATA
	from date_user join medic on date_user.id_user=medic.id_medic
    join specializare on specializare.id_medic=medic.id_medic join competenta on competenta.id_specializare=specializare.id_specializare
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta join programare on programare.id_serviciu=serviciu_medical.id_serviciu
    join istoric on istoric.id_istoric=programare.id_programare
    join factura on istoric.id_istoric=factura.id_factura
    where factura.data_factura is not null group by serviciu_medical.id_serviciu;
    #and programare.data_programare BETWEEN NOW() - INTERVAL 30 DAY AND NOW()
//
DELIMITER ;


DROP VIEW IF EXISTS getVenituriMediciAllTime;
DELIMITER //
CREATE VIEW getVenituriMediciAllTime AS
	select ID,NUME,PRENUME,SUM(VENIT) AS VENIT,SUM(SALARIU_BRUT_MEDIC) AS BRUT,SUM(SALARIU_BRUT_MEDIC)*0.9 AS NET from getVenituriMediciServiciu group by ID,NUME,PRENUME; 
//
DELIMITER ;


DROP PROCEDURE IF EXISTS getVenitMedic;
DELIMITER //
CREATE PROCEDURE getVenitMedic(IN numeMedic varchar(30),IN prenumeMedic varchar(30),IN data_start date,IN data_stop date)
BEGIN
	select ID,NUME,PRENUME,VENIT,SALARIU_BRUT_MEDIC AS BRUT,SALARIU_BRUT_MEDIC*0.9 AS NET,DATA,SERVICIU from getVenituriMediciServiciu where 
    DATA>=data_start and DATA<=data_stop and NUME LIKE CONCAT('%',numeMedic,'%') and PRENUME LIKE CONCAT('%',prenumeMedic,'%');

END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getVenitMedicProfit;
DELIMITER //
CREATE PROCEDURE getVenitMedicProfit(IN numeMedic varchar(30),IN prenumeMedic varchar(30),IN data_start date,IN data_stop date)
BEGIN
	select ID,NUME,PRENUME,SERVICIU,SUM(VENIT),SUM(SALARIU_BRUT_MEDIC) AS BRUT,SUM(SALARIU_BRUT_MEDIC)*0.9 AS NET,SUM(PROFIT) from getVenituriMediciServiciu where 
    DATA>=data_start and DATA<=data_stop and NUME LIKE CONCAT('%',numeMedic,'%') and PRENUME LIKE CONCAT('%',prenumeMedic,'%') group by ID;

END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getVenitMedicByID;
DELIMITER //
CREATE PROCEDURE getVenitMedicByID(IN idMedic int)
BEGIN
	select * from getVenituriMedici where ID=idMedic;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getSalariuAngajatById;
DELIMITER //
CREATE PROCEDURE getSalariuAngajatById(IN idAngajat int,IN data_start date,IN data_stop date)
BEGIN
	if(idAngajat=(select id_medic from medic where id_medic=idAngajat limit 1))then
		select ID,NUME,PRENUME,SERVICIU,VENIT,SALARIU_BRUT_MEDIC AS BRUT,SALARIU_BRUT_MEDIC*0.8 AS NET,DATA from getVenituriMediciServiciu where DATA>=data_start and DATA<=data_stop and ID=idAngajat;
    else
		select angajat.id_angajat AS ID,date_user.nume AS NUME,date_user.prenume AS PRENUME,angajat.functie,datediff(data_stop,data_start)*salariu_brut/30 AS BRUT,datediff(data_stop,data_start)*salariu_net/30 AS NET from angajat
		join date_user on date_user.id_user=angajat.id_angajat where angajat.id_angajat=idAngajat;
    end if;
END //
DELIMITER ;

#call getSalariuAngajatById('2','2023-01-01','2023-01-13');


DROP PROCEDURE IF EXISTS getSalariuAngajat;
DELIMITER //
CREATE PROCEDURE getSalariuAngajat(IN numeAngajat varchar(30),IN prenumeAngajat varchar(30),IN functie varchar(30),IN data_start date,IN data_stop date)
BEGIN
	
	select ID,NUME,PRENUME,'Medic' AS Functie,SALARIU_BRUT_MEDIC AS BRUT,SALARIU_BRUT_MEDIC*0.9 AS NET from getVenituriMediciServiciu where 
    DATA>=data_start and DATA<=data_stop and NUME LIKE CONCAT('%',numeAngajat,'%') and PRENUME LIKE CONCAT('%',prenumeAngajat,'%') and 'Medic' like CONCAT('%',functie,'%')
    UNION
    select angajat.id_angajat AS ID,date_user.nume AS NUME,date_user.prenume AS PRENUME,angajat.functie,datediff(data_stop,data_start)*salariu_brut/30 AS BRUT,datediff(data_stop,data_start)*salariu_net/30 AS NET from angajat
	join date_user on date_user.id_user=angajat.id_angajat where NUME LIKE CONCAT('%',numeAngajat,'%') and PRENUME LIKE CONCAT('%',prenumeAngajat,'%') and angajat.salariu_net<>-1 and angajat.functie like CONCAT('%',functie,'%');
	
END //
DELIMITER ;
#call getSalariuAngajat('','','i','2022-12-20','2023-01-20');

DROP VIEW IF EXISTS getVenituriMediciSpecializare;
DELIMITER //
CREATE VIEW getVenituriMediciSpecializare AS
	select date_user.id_user AS ID,CONCAT(date_user.nume,' ',date_user.prenume)AS NUME,specializare.denumire_specializare AS SPECIALIZARE,
    serviciu_medical.pret AS VENIT,
    serviciu_medical.pret*0.7 AS SALARIU_BRUT_MEDIC
	,serviciu_medical.pret- serviciu_medical.pret*0.7 AS PROFIT
    ,programare.data_programare AS DATA
	from date_user join medic on date_user.id_user=medic.id_medic
    join specializare on specializare.id_medic=medic.id_medic join competenta on competenta.id_specializare=specializare.id_specializare
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta join programare on programare.id_serviciu=serviciu_medical.id_serviciu
    join istoric on istoric.id_istoric=programare.id_programare
    join factura on istoric.id_istoric=factura.id_factura
    where factura.data_factura is not null group by serviciu_medical.id_serviciu;
    #and programare.data_programare BETWEEN NOW() - INTERVAL 30 DAY AND NOW()
//
DELIMITER ;

DROP VIEW IF EXISTS getVenituriMediciGroupBySpecializare;
DELIMITER //
CREATE VIEW getVenituriMediciGroupBySpecializare AS
	select SPECIALIZARE,SUM(VENIT) AS VENIT,SUM(SALARIU_BRUT_MEDIC) AS BRUT,SUM(PROFIT)AS PROFIT from getVenituriMediciSpecializare group by SPECIALIZARE; 
//
DELIMITER ;

DROP PROCEDURE IF EXISTS getVenituriSpecializari;
DELIMITER //
CREATE PROCEDURE getVenituriSpecializari(IN denumire varchar(30),IN data_start date,IN data_stop date)
BEGIN
	select SPECIALIZARE,SUM(VENIT) AS VENIT,SUM(SALARIU_BRUT_MEDIC) AS BRUT,SUM(PROFIT)AS PROFIT from getVenituriMediciSpecializare
    where DATA>=data_start AND DATA<=data_stop and SPECIALIZARE like CONCAT('%',denumire,'%') group by SPECIALIZARE; 
	
END //
DELIMITER ;

DROP VIEW IF EXISTS getVenituriMediciUnitate;
DELIMITER //
CREATE VIEW getVenituriMediciUnitate AS
	select IF(dayofweek(programare.data_programare)=0,program_angajat_generic.mon_id_unitate,
    IF(dayofweek(programare.data_programare)=1,program_angajat_generic.tues_id_unitate,
    IF(dayofweek(programare.data_programare)=2,program_angajat_generic.wed_id_unitate,
    IF(dayofweek(programare.data_programare)=3,program_angajat_generic.thurs_id_unitate,
    IF(dayofweek(programare.data_programare)=4,program_angajat_generic.fri_id_unitate,
    IF(dayofweek(programare.data_programare)=5,program_angajat_generic.sat_id_unitate,program_angajat_generic.sun_id_unitate
    ))))))AS ID_UNITATE,programare.data_programare AS DATA,serviciu_medical.pret,medic.id_medic from serviciu_medical join programare on programare.id_serviciu=serviciu_medical.id_serviciu
	join factura on factura.id_factura=programare.id_programare join competenta on competenta.id_competenta=serviciu_medical.id_serviciu
    join specializare on specializare.id_specializare=competenta.id_specializare join medic on medic.id_medic=specializare.id_medic
    join program_angajat_generic on program_angajat_generic.id_angajat=medic.id_medic
    where factura.data_factura is not null group by serviciu_medical.id_serviciu;
    #and programare.data_programare BETWEEN NOW() - INTERVAL 30 DAY AND NOW()
//
DELIMITER ;

DROP PROCEDURE IF EXISTS temp_procedure0;
DELIMITER //
CREATE PROCEDURE temp_procedure0(IN data_start date,IN data_stop date)
BEGIN
	create table temp_table(ID_UNITATE int, DATA_rec date,pret int,id_medic int);
    insert into temp_table(ID_UNITATE, DATA_rec,pret,id_medic)
	select IF(dayofweek(programare.data_programare)=0,program_angajat_generic.mon_id_unitate,
    IF(dayofweek(programare.data_programare)=1,program_angajat_generic.tues_id_unitate,
    IF(dayofweek(programare.data_programare)=2,program_angajat_generic.wed_id_unitate,
    IF(dayofweek(programare.data_programare)=3,program_angajat_generic.thurs_id_unitate,
    IF(dayofweek(programare.data_programare)=4,program_angajat_generic.fri_id_unitate,
    IF(dayofweek(programare.data_programare)=5,program_angajat_generic.sat_id_unitate,program_angajat_generic.sun_id_unitate
    ))))))AS ID_UNITATE,programare.data_programare AS DATA,serviciu_medical.pret,medic.id_medic from serviciu_medical join programare on programare.id_serviciu=serviciu_medical.id_serviciu
	join factura on factura.id_factura=programare.id_programare join competenta on competenta.id_competenta=serviciu_medical.id_serviciu
    join specializare on specializare.id_specializare=competenta.id_specializare join medic on medic.id_medic=specializare.id_medic
    join program_angajat_generic on program_angajat_generic.id_angajat=medic.id_medic
    where factura.data_factura is not null  and programare.data_programare>=data_start and programare.data_programare<=data_stop group by serviciu_medical.id_serviciu;
	
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getFinanciarUnitati;
DELIMITER //
CREATE PROCEDURE getFinanciarUnitati(IN data_start date,IN data_stop date)
BEGIN
	call temp_procedure0(data_start,data_stop);
    select ID_Unitate,SUM(pret)AS VENITURI,SUM(PRET)*0.7 AS CHELTUIELI,SUM(PRET)*0.3 AS PROFIT from temp_table group by ID_UNITATE;
	drop table temp_table;
END //
DELIMITER ;
#call getFinanciarUnitati('2023-01-01','2023-01-29');


DROP VIEW IF EXISTS getVenituriMediciUnitateSUM;
DELIMITER //
CREATE VIEW getVenituriMediciUnitateSUM AS
	select ID_UNITATE,SUM(pret),SUM(pret)*0.7,SUM(pret)*0.3 from getVenituriMediciUnitate group by ID_UNITATE;
	
//
DELIMITER ;

DROP PROCEDURE IF EXISTS temp_procedure;
DELIMITER //
CREATE PROCEDURE temp_procedure(IN data_start date,IN data_stop date)
BEGIN
	
    CREATE table temp_table(venit decimal(16,2), cheltuieli decimal(16,2));
    insert into temp_table(venit,cheltuieli) select SUM(VENIT) AS VENIT,SUM(SALARIU_BRUT_MEDIC) AS CHELTUIELI from getVenituriMediciSpecializare
    where DATA>=data_start AND DATA<=data_stop
    UNION
    select 0 as VENIT,SUM(datediff(data_stop,data_start)*angajat.salariu_brut/30)AS CHELTUIELI from angajat where angajat.id_angajat not in
    (select id_user from deleted);
	
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS getStatusTotal;
DELIMITER //
CREATE PROCEDURE getStatusTotal(IN data_start date,IN data_stop date)
BEGIN
	call temp_procedure(data_start,data_stop);
	select SUM(venit) AS VENIT,SUM(cheltuieli)AS CHELTUIELI,SUM(venit)-SUM(cheltuieli)AS PROFIT from temp_table;
	drop table temp_table;
END //
DELIMITER ;
#call getStatusTotal('2023-01-01','2023-01-29');
DROP PROCEDURE IF EXISTS deleteUser;
DELIMITER //
CREATE PROCEDURE deleteUser(IN idUser int)
BEGIN
    insert into deleted(id_user)values (idUser);
	delete from login where id_user=idUser;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS cautaUser;
DELIMITER //
CREATE PROCEDURE cautaUser(IN nume1 varchar(30),IN prenume1 varchar(30))
BEGIN
    select date_user.id_user,date_user.nume,date_user.prenume,deleted.id_user from date_user
left join deleted on date_user.id_user=deleted.id_user where date_user.nume like CONCAT('%',nume1,'%')
and prenume like CONCAT('%',prenume1,'%');
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS cautaProgramariNecompletate;
DELIMITER //
CREATE PROCEDURE cautaProgramariNecompletate(IN data1 date,IN data2 date)
BEGIN
    select programare.id_programare,programare.data_programare,programare.programare_start,programare.programare_stop,CONCAT(date_user.nume,' ',date_user.prenume) AS NUME_PACIENT,competenta.denumire_competenta
    from programare join date_user on date_user.id_user=programare.id_pacient join competenta on programare.id_serviciu=competenta.id_competenta join istoric on istoric.id_istoric=programare.id_programare
    where programare.data_programare>=data1 and programare.data_programare<=data2 and istoric.id_raport is NULL and istoric.id_analize is NULL;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS stergeProgramare;
DELIMITER //
CREATE PROCEDURE stergeProgramare(IN idProgramare int)
BEGIN
    delete from factura where id_factura=idProgramare;
    delete from istoric where id_istoric=idProgramare;
    delete from programare where id_programare=idProgramare;
END //
DELIMITER ;

#---------------------------------------------------------------------------------------------------------------------------------#
select * from angajat;
select * from login
select * from specializare;
select * from competenta;
select * from serviciu_medical;
select id_specializare from specializare where id_medic=2 and denumire_specializare='ge2g2' order by id_specializare DESC;



select distinct * from programare join serviciu_medical on programare.id_serviciu=serviciu_medical.id_serviciu join factura on programare.id_programare=factura.id_factura
join competenta on competenta.id_competenta=serviciu_medical.id_serviciu
join specializare on competenta.id_specializare=specializare.id_specializare
join medic on specializare.id_medic=medic.id_medic where factura.data_factura is not null;
select * from medic order by id_medic;

select * from getVenituriMedici;
select * from factura;
select * from programare;
select * from serviciu_medical;
select * from competenta;
select * from specializare;
select * from medic;


DROP VIEW IF EXISTS getCheltuieli;
DELIMITER //
CREATE VIEW getCheltuieli AS
	select SUM(angajat.salariu_brut) AS Cheltuieli from angajat;
//
DELIMITER ;

DROP VIEW IF EXISTS getAdmini;
DELIMITER //
CREATE VIEW getCheltuieli AS
	select date_user.id_user,date_user.nume,date_user.prenume from date_user join admin on admin.id_admin=date_user.id_user;
//
DELIMITER ;




DROP VIEW IF EXISTS getStatusSpecialitate;
DELIMITER //
CREATE VIEW getStatusSpecialitate AS
	select specializare.id_specializare AS ID_Specializare,specializare.denumire_specializare as denumire,
    SUM(serviciu_medical.pret)AS VENIT,
    SUM(serviciu_medical.pret)*0.6 AS SALARII, SUM(serviciu_medical.pret)- SUM(serviciu_medical.pret)*0.6 AS PROFIT
	from specializre join competenta on specializare.id_specializare=competenta.id_competenta
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta
    join programare on 
    where program_angajat_specific.data_specifica BETWEEN NOW() - INTERVAL 30 DAY AND NOW() and factura.data_factura is not null
    UNION
    select specializare.id_specializare AS ID_Specializare,specializare.denumire_specializare as denumire,
    SUM(serviciu_medical.pret)AS VENIT,
    SUM(serviciu_medical.pret)*0.6 AS SALARII, SUM(serviciu_medical.pret)- SUM(serviciu_medical.pret)*0.6 AS PROFIT
	from program_angajat_generic join program_angajat_specific on program_angajat_generic.id_angajat=program_angajat_specific.id_angajat
    join specializare on specializare.id_medic=program_angajat_generic.id_angajat join competenta on competenta.id_specializare=specializare.id_specializare
    join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta join programare on programare.id_serviciu=serviciu_medical.id_serviciu
    join istoric on istoric.id_istoric=programare.id_programare
    join factura on istoric.id_istoric=factura.id_factura
    join angajat on angajat.id_angajat=program_angajat_generic.id_angajat
    join date_user on date_user.id_user=angajat.id_angajat
    where program_angajat_specific.data_specifica BETWEEN NOW() - INTERVAL 30 DAY AND NOW() and factura.data_factura is null;
//
DELIMITER ;

select * from specializare;

select serviciu_medical.pret,medic.id_medic from serviciu_medical join competenta on competenta.id_competenta=serviciu_medical.id_serviciu
join specializare on specializare.id_specializare=competenta.id_specializare join medic on medic.id_medic order by medic.id_medic
#select FLOOR(datediff(now(),NOW() - INTERVAL 30 DAY)/7);


insert into program_angajat_specific(id_angajat, data_specifica,timp_start,timp_stop, id_unitate) values ('3','2023-01-05','17:00','20:00',1);
insert into program_angajat_specific(id_angajat, data_specifica,timp_start,timp_stop, id_unitate) values ('3','2023-01-05','21:15','22:45',1);
insert into concediu(id_angajat,zi_concediu)values('3','2023-01-05');
select * from istoric;
select * from raport;
select * from medic;
select * from programare;
select * from specializare;
select * from competenta;
select * from serviciu_medical;
insert into programare(id_pacient,id_serviciu,id_receptioner,data_programare,programare_start,programare_stop) values(2,5,4,'2023-01-05','09:00','10:30');
insert into programare(id_pacient,id_serviciu,id_receptioner,data_programare,programare_start,programare_stop) values(2,4,4,'2023-01-05','10:31','10:50');

call getProgramariPeData(3,'2023-01-06');

select * from program_angajat_generic where id_angajat='2';
select * from program_angajat_specific where id_angajat='2';
insert into program_unitate(id_unitate, mon_start, mon_stop, tues_start, tues_stop, wed_start, wed_stop, thurs_start, thurs_stop, fri_start, fri_stop, sat_start, sat_stop, sun_start, sun_stop)values
(1,'05:00','23:30','05:00','23:30','05:00','23:30','05:00','23:30','05:00','23:30','05:00','20:30','05:00','20:30');
DROP PROCEDURE IF EXISTS stergeSpecializariMedic;
DELIMITER //
CREATE PROCEDURE stergeSpecializariMedic(id_user int)
BEGIN
    delete from serviciu_medical where id_user=(select id_medic from specializare where id_medic=id_user);
END //
DELIMITER ;
select * from angajat;


select * from date_user;
select* from login;
select * from angajat;
select * from medic;
select * from specializare;
select * from competenta;
select * from serviciu_medical;
select * from program_angajat_generic;
select * from programare;
select * from pacient;


-- CREATE VIEW getVenituriMedici AS
-- 	select program_angajat_generic.id_angajat,CONCAT(date_user.nume,' ',date_user.prenume)AS NUME,((cast(time_to_sec(timediff(program_angajat_generic.mon_stop,program_angajat_generic.mon_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.tues_stop,program_angajat_generic.tues_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.wed_stop,program_angajat_generic.wed_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.thurs_stop,program_angajat_generic.thurs_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.fri_stop,program_angajat_generic.fri_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.sat_stop,program_angajat_generic.sat_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.sun_stop,program_angajat_generic.sun_start)) / (60 * 60) as decimal(10, 1)))*4*120
--     +SUM(
--     (cast(time_to_sec(timediff(program_angajat_specific.timp_stop,program_angajat_specific.timp_start)) / (60 * 60) as decimal(10, 1)))*serviciu_medical.pret
--     ))AS VENIT,
--     ((cast(time_to_sec(timediff(program_angajat_generic.mon_stop,program_angajat_generic.mon_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.tues_stop,program_angajat_generic.tues_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.wed_stop,program_angajat_generic.wed_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.thurs_stop,program_angajat_generic.thurs_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.fri_stop,program_angajat_generic.fri_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.sat_stop,program_angajat_generic.sat_start)) / (60 * 60) as decimal(10, 1))+
--     cast(time_to_sec(timediff(program_angajat_generic.sun_stop,program_angajat_generic.sun_start)) / (60 * 60) as decimal(10, 1)))*4*120
--     +SUM(
--     (cast(time_to_sec(timediff(program_angajat_specific.timp_stop,program_angajat_specific.timp_start) / (60 * 60) as decimal(10, 1)))*serviciu_medical.pret
--     ))*0.60 AS SALARIU_MEDIC
-- 	from program_angajat_generic join program_angajat_specific on program_angajat_generic.id_angajat=program_angajat_specific.id_angajat
--     join specializare on specializare.id_medic=program_angajat_generic.id_angajat join competenta on competenta.id_specializare=specializare.id_specializare
--     join serviciu_medical on serviciu_medical.id_serviciu=competenta.id_competenta join programare on programare.id_serviciu=serviciu_medical.id_serviciu
--     join istoric on istoric.id_istoric=programare.id_programare
--     join factura on istoric.id_istoric=factura.id_factura
--     join angajat on angajat.id_angajat=program_angajat_generic.id_angajat
--     join date_user on date_user.id_user=angajat.id_angajat
--     where program_angajat_specific.data_specifica BETWEEN NOW() - INTERVAL 30 DAY AND NOW() and factura.data_factura is not null;
--    --  UNION
-- --     (select program_angajat_generic.id_angajat,CONCAT(date_user.nume,' ',date_user.prenume),((cast(time_to_sec(timediff(program_angajat_generic.mon_stop,program_angajat_generic.mon_start)) / (60 * 60) as decimal(10, 1))+
-- --     cast(time_to_sec(timediff(program_angajat_generic.tues_stop,program_angajat_generic.tues_start)) / (60 * 60) as decimal(10, 1))+
-- --     cast(time_to_sec(timediff(program_angajat_generic.wed_stop,program_angajat_generic.wed_start)) / (60 * 60) as decimal(10, 1))+
-- --     cast(time_to_sec(timediff(program_angajat_generic.thurs_stop,program_angajat_generic.thurs_start)) / (60 * 60) as decimal(10, 1))+
-- --     cast(time_to_sec(timediff(program_angajat_generic.fri_stop,program_angajat_generic.fri_start)) / (60 * 60) as decimal(10, 1))+
-- --     cast(time_to_sec(timediff(program_angajat_generic.sat_stop,program_angajat_generic.sat_start)) / (60 * 60) as decimal(10, 1))+
-- --     cast(time_to_sec(timediff(program_angajat_generic.sun_stop,program_angajat_generic.sun_start)) / (60 * 60) as decimal(10, 1)))*4*25)
-- -- 	from program_angajat_generic 
-- --     join angajat on angajat.id_angajat=program_angajat_generic.id_angajat 
-- --     join date_user on angajat.id_angajat=date_user.id_user
-- --     where program_angajat_generic.id_angajat not in(select medic.id_medic from medic 
-- --     join specializare on medic.id_medic=specializare.id_medic
-- --     join competenta on competenta.id_specializare=specializare.id_specializare
-- --     join programare on programare.id_serviciu=competenta.id_competenta
-- --     join factura on factura.id_factura=programare.id_programare where factura.data_factura is not null));
-- //
-- DELIMITER ;
