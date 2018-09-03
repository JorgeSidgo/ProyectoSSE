-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### SCRIPT BASE DE DATOS SISTEMA DE CONTROL DE SERVICIO SOCIAL ESTUDIANTIL  ITCA-FEPADE #####
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
/**
 * SIS12-B
 * Grupo N° 2 
 * Integrantes:
 *      - Francisco Montoya
 *      - Benjamín Ramírez
 *      - Abdiel Martínez
 *      - Jorge Sidgo
 * Fecha: 29/08/2018
 */

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### BD #####
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
drop database if exists sse;
create database if not exists sse;
use sse;

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### TABLAS #####
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table escuela(
	id int auto_increment primary key unique,
    nombreEscuela varchar(50),
    estado int default 1
);

create table carrera(
	id int auto_increment primary key unique,
    nombreCarrera varchar(50),
    estado int default 1,
    idEscuela int not null
);

create table grupo(
	id int auto_increment primary key unique,
    nombreGrupo varchar(50),
    estado int default 1,
    idCarrera int not null
);

create table usuario(
	id int auto_increment primary key unique,
    nomUsuario varchar(25) not null,
    pass varchar(128),
    estado int default 1,
    idRol int
);

create table rol(
	id int auto_increment primary key unique,
    descRol varchar(50)
);

create table materia(
	id int auto_increment primary key unique,
    nombreMateria varchar(50),
    estado int default 1,
    codMateria varchar(10)
);

create table materiasEstudiante(
	id int auto_increment primary key unique,
    idEstudiante int,
    idMateria int
);

create table hojaServicioSocial(
	id int auto_increment primary key unique,
    idEstudiante int,
    idInstitucion int,
    idCoordinador int,
    fechaInicio date,
    fechaFinalizacion date,
    nHoras int
);

create table horarioServicio(
	id int auto_increment primary key unique,
    idHojaServicioSocial int
);

create table detalleHorarioServicio(
    id int auto_increment primary key unique,
    nHoras int,
    diaSemana varchar(20),
    idHorarioServicio int
);

create table actividadesServicio(
    id int auto_increment primary key unique,
    idHojaServicioSocial int
);

create table detalleActividadesServicio(
    id int auto_increment primary key unique,
    actividad text,
    objetivos text,
    metas text,
    duracion text,
    idActividadesServicio int
);

create table institucion(
	id int auto_increment primary key unique,
    nombreInstitucion varchar(50),
    direccion text,
    correo varchar(50),
    telefono varchar(10),
    estado int default 1,
    idTipoInstitucion int
);

create table tipoInstitucion(
	id int auto_increment primary key unique,
    descTipoInstitucion varchar(15)
);

create table solicitud(
    id int auto_increment primary key unique,
    idEstudiante int not null,
    idCoordinador int not null,
    idInstitucion int not null,
    fecha date,
    comentarios text,
    estado int default 1
);

create table estadoSolicitud(
    id int auto_increment primary key unique,
    descEstado varchar(15)
);

create table estudiante(
	id int auto_increment primary key unique,
    carnet varchar(10) not null,
    nombres varchar(50),
    apellidos varchar(50),
    correo varchar(50),
    fechaIngreso date,
    idGrupo int not null,
    estado int default 1,
    idUsuario int not null
);

create table coordinador(
	id int auto_increment primary key unique,
    nombres varchar(50),
    apellidos varchar(50),
    correo varchar(125),
    estado int default 1,
    idUsuario int not null,
    idCarrera int not null
);

create table horarioAtencion(
	id int auto_increment primary key unique,
    idCoordinador int
);

create table detalleHorarioAtencion(
	id int auto_increment primary key unique,
    hora varchar(10),
    dia varchar(10),
    ubicacion varchar(10),
    idHorarioAtencion int
);

create table correo(
    id int auto_increment primary key unique,
    fecha date,
    titulo varchar(25),
    idCoordinador int,
    estado int default 1,
    idEstudiante int
);

create table solvencia(
	id int auto_increment primary key unique,
    fecha date,
    idEstudiante int,
    idCoordinador int,
    estado int
);

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### LLAVES FORANEAS ######
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

alter table grupo add constraint fk_grupo_carrera foreign key (idCarrera) references carrera(id);
alter table carrera add constraint fk_carrera_escuela foreign key (idEscuela) references escuela(id);
alter table usuario add constraint fk_usuario_rol foreign key (idRol) references rol(id);
alter table estudiante add constraint fk_estudiante_usuario foreign key (idUsuario) references usuario(id);
alter table estudiante add constraint fk_estudiante_grupo foreign key (idGrupo) references grupo(id);
alter table coordinador add constraint fk_coordinador_usuario foreign key (idUsuario) references usuario(id);
alter table coordinador add constraint fk_coordinador_carrera foreign key (idCarrera) references carrera(id);
alter table horarioAtencion add constraint fk_horarioAtencion_coordinador foreign key (idCoordinador) references coordinador(id);
alter table detalleHorarioAtencion add constraint fk_detalleHorarioAtencion_horarioAtencion foreign key (idHorarioAtencion) references horarioAtencion(id);
alter table institucion add constraint fk_institucion_tipoInstitucion foreign key (idTipoInstitucion) references tipoInstitucion(id);
alter table solicitud add constraint fk_solicitud_estudiante foreign key (idEstudiante) references estudiante(id);
alter table solicitud add constraint fk_solicitud_coordinador foreign key (idCoordinador) references coordinador(id);
alter table solicitud add constraint fk_solicitud_institucion foreign key (idInstitucion) references institucion(id);
alter table solicitud add constraint fk_solicitud_estadoSolicitud foreign key (estado) references estadoSolicitud(id);
alter table materiasEstudiante add constraint fk_materiasEstudiante_materia foreign key (idMateria) references materia(id);
alter table materiasEstudiante add constraint fk_materiasEstudiante_estudiante foreign key (idEstudiante) references estudiante(id);
alter table hojaServicioSocial add constraint fk_hojaServicioSocial_estudiante foreign key (idEstudiante) references estudiante(id);
alter table hojaServicioSocial add constraint fk_hojaServicioSocial_institucion foreign key (idInstitucion) references institucion(id);
alter table hojaServicioSocial add constraint fk_hojaServicioSocial_coordinador foreign key (idCoordinador) references coordinador(id);
alter table horarioServicio add constraint fk_horarioServicio_hojaServicioSocial foreign key (idHojaServicioSocial) references hojaServicioSocial(id);
alter table actividadesServicio add constraint fk_actividadesServicio_hojaServicioSocial foreign key (idHojaServicioSocial) references hojaServicioSocial(id);
alter table detalleHorarioServicio add constraint fk_detalleHorarioServicio_horarioServicio foreign key (idHorarioServicio) references horarioServicio (id);
alter table detalleActividadesServicio add constraint fk_detalleActividadesServicio_horarioServicio foreign key (idActividadesServicio) references actividadesServicio (id);
alter table correo add constraint fk_correo_coordinador foreign key (idCoordinador) references coordinador (id);
alter table correo add constraint fk_correo_estudiante foreign key (idEstudiante) references estudiante (id);


-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### PROCEDIMIENTOS ALMACENADOS ######
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ==================================================================================================
### Usuario
-- ==================================================================================================
	
-- Mostrar Usuario por id
delimiter $$
create procedure mostrarIdUsuario(
	in idUsuario int
)
begin
	select * from usuario where id = idUsuario and estado = 1;
end
$$

-- Mostrar Usuario por Nombre
delimiter $$
create procedure mostrarNombreUsuario(
	in nombre varchar(50)
)
begin
	select * from usuario where nomUsuario = nombre and estado = 1;
end
$$

-- Registrar Usuario
delimiter $$
create procedure insertarUsuario(
	in nom varchar(50),
    in contra varchar(50),
    in rol int
)
begin
	insert into usuario values(null, nom, sha1(contra), default, rol);
end
$$


-- Comprobar Contraseña
delimiter $$
create procedure compContra(
	in idUs int,
    in contra varchar(50)
)
begin
	select * from usuario where id = idUs and pass = sha1(contra) and estado = 1;
end
$$

-- Login
delimiter $$
create procedure login(
	in nom varchar(50),
    in contra varchar(50)
)
begin
	select * from usuario where nomUsuario = nom and pass = sha1(contra) and estado = 1;
end
$$

-- Editar Usuario
delimiter $
create procedure editarUsuario(
	in nom varchar(50),
    in contra varchar(50),
    in idR varchar(50),
    in idUsuario int
)
begin
	update usuario 
    set nomUsuario = nom, pass = sha1(contra), idRol = idR 
    where id = idUsuario;
end $

-- Eliminar Usuario
delimiter $
create procedure eliminarUsuario(
	in idU int
)
begin
	delete from usuario where id = idU;
end $

-- Borrado Lógico de Usuario
delimiter $
create procedure borradoLogicoUsuario(
	in idU int
)
begin
	update usuario 
    set estado = 0 
    where id = idU;
end $

-- Mostrar Usuarios
delimiter $
create procedure mostrarUsuarios()
begin
	select * from usuario where estado = 1;
end $

drop procedure mostrarUsuario;

-- Buscar Usuario por Nombre
delimiter $
create procedure buscarNombreUsuario(
	in nombre varchar(50)
)
begin
	select * from usuario where estado = 1 and nomUsuario like concat('%',nombre,'%');
end $

-- Mostrar Papelera de Usuarios
delimiter $
create procedure papeleraUsuario()
begin
	select * from usuario where estado = 0;
end $

-- Buscar en papelera de Usuario por id
delimiter $
create procedure buscarPapeleraIDUsuario(
	in idU int
)
begin 
	select * from usuario where estado = 0 and id = idU;
end $

-- Buscar en papelera de Usuario por Nombre
delimiter $
create procedure buscarPapeleraNombreUsuario(
	in nombre varchar(50)
)
begin
	select * from usuario where estado = 0 and nomUsuario like concat('%',nombre,'%');
end $
    
-- Restaurar Usuario
delimiter $
create procedure restaurarUsuario(
	in idU int
)
begin
	update usuario set estado = 1 where estado = 0 and id = idU;
end $

-- ==================================================================================================
### Institucion
-- ==================================================================================================

-- Insertar Institucion
delimiter $
create procedure insertarInstitucion(
    in nombreInstitucion varchar(50),
    in direccion text, 
    in correo varchar(50),
    in telefono varchar(10),
    in idTipoInstitucion int
)
begin
	insert into institucion values (null,nombreInstitucion,direccion,correo,telefono, default, idTipoInstitucion);
end $

-- Editar Institucion
delimiter $
create procedure editarInstitucion(
	in nombreInstitucion varchar(50),
    in direc text, 
    in corr varchar(50),
    in tel varchar(10),
    in idTipoInst int,
    in idInstitucion int
)
begin
	update institucion 
    set nombreInstitucion = nombreInstitucion, direccion = direc, correo = corr, telefono = tel, idTipoinstitucion = idTipoInst
	where id = idInstitucion;
end $

-- Eliminar Institucion
delimiter $
create procedure eliminarInstitucion(
	in idInstitucion int
)
begin 
	delete from institucion where id = idInstitucion;
end $

-- Borrado Logico Institucion
delimiter $
create procedure borradoLogicoInstitucion(
	in idInstitucion int
)
begin
	update institucion 
    set estado = 0 
    where id = idInstitucion;
end $

-- Mostrar Instituciones
delimiter $
create procedure mostrarInstitucion()
begin 
	select * from institucion where estado = 1;
end $

-- Buscar Institucion por id	
delimiter $
create procedure buscarIdInstitucion(
	in idI int
)
begin
	select * from institucion where id = idI and estado = 1;
end$



-- Buscar Institucion por Nombre	
delimiter $
create procedure buscarNombreInstitucion(
	in nombre varchar(50)
)
begin
	select * from institucion where nombreInstitucion like concat('%',nombre,'%') and estado = 1;
end $

-- Mostrar Papelera de Institucion
delimiter $
create procedure papeleraInstitucion()
begin
	select * from institucion where estado = 0;
end $

-- Buscar Institucion en papelera por id
delimiter $
create procedure buscarPapeleraIDInstitucion(
	in idInstitucion int
)
begin
	select * from institucion where estado = 0 and id = idInstitucion;
end $

-- Buscar Institucion en papelera por nombre
delimiter $
create procedure buscarPapeleraNombreInstitucion(
	in nombre varchar(50)
)
begin
	select * from institucion where estado = 0 and nombreInstitucion like concat('%',nombre,'%');
end $

-- Restaurar Institucion
delimiter $
create procedure restaurarInstitucion(
	in idInstitucion int
)
begin
	update institucion set estado = 1 where id = idInstitucion and estado = 0;
end $


-- ==================================================================================================
### Hoja de Servicio Social
-- ==================================================================================================

-- Insertar Hoja de Servicio Social
delimiter $
create procedure insertarHojaServicio(	
    in idEstudiante int, 
    in idInstituicion int, 
    in idCoordinador int, 
    in fechaInicio date, 
    in fechaFinalizacion date,
    in horas int
)
begin 
	insert into hojaServicioSocial values (null,idEstudiante,idInstitucion,idCoordinador,fechaInicio,fechaFinalizacion, horas);
end $

-- Editar Hoja de Servicio Social
delimiter $
create procedure editarHojaServicio(
    in idEs int, 
    in idInst int, 
    in idCo int, 
    in fechaInicio date, 
    in fechaFin date,
    in idHoja int,
    in horas int
)
begin
	update hojaServicioSocial set idEstudiante = idEs, idInstitucion = idInst, idCoordinador = idCo, fechaInicio = fechaInicio, fechaFinalizacion = fechaFin, nHoras = horas
    where id = idHoja;
end $

-- Mostrar Hojas de Servicio
delimiter $
create procedure mostrarHojaServicio()
begin 
	select * from hojaServicioSocial;
end $

-- Eliminar Hoja de servicio Social --
delimiter $
create procedure eliminarHojaServicio(
	in idHS int
)
begin
	delete from hojaServicioSocial where id = idHS;
end $

-- Borrado Logico Hoja de Servicio Social --
delimiter $
create procedure borradoLogioHojaServicio(
	in idHS int
)
begin
	update hojaServicioSocial set estado = 0 where id = idHs;
end $

-- Buscar por fecha de Inicio Exacta Hoja de servicio social --
delimiter $
create procedure buscarFechaInicioExactaHojaServicio(
	in fechaEx date
)
begin
	select * from hojaServicioSocial where fechaInicio like cast(concat('%',fechaEx,'%') as date);
end $

-- Buscar por fecha de Finalizacion Exacta Hoja de servicio social --
delimiter $
create procedure buscarFechaFinalizacionExactaHojaServicio(
	in fechaEx date
)
begin
	select * from hojaServicioSocial where fechaFinalizacion like cast(concat('%',fechaEx,'%') as date);
end $

-- Buscar por año en fecha inicio Hoja de Servicio Social --
delimiter $
create procedure buscarAnioInicioHojaServicio(
	in anio year
)
begin
	select * from hojaServicioSocial where year(fechaFinalizacion) like concat('%',anio,'%');
end $

-- buscar por mes en fecha inicio hoja de Servicio Social --
delimiter $
create procedure buscarMesInicioHojaServicio(
	in mes varchar(2)
)
begin
	select * from hojaServicioSocial where month(fechaFinalizacion) like concat('%',mes,'%');
end $


-- ==================================================================================================
### Solicitud
-- ==================================================================================================
	
-- Insertar Solicitud
delimiter $
create procedure insertarSolicitud(
    in idEstudiante int, 
    in idCoordinador int, 
    in idInstituicion int, 
    in fecha date    
)
begin 
	insert into solicitud values (null,idEstudiante,idCoordinador,idInstitucion,fecha,'', default);
end $

-- Editar Solicitud
delimiter $
create procedure editarSolicitud(
	in idSolicitud int, 
    in idEs int, 
    in idCo int, 
    in idInst int, 
    in fecha date, 
    in com text
)
begin
	update solicitud 
    set idEstudiante = idEs, idCoordinador = idCo, idInstitucion = idInst, fecha = fecha, comentarios = com
    where id = idSolicitud;
end $

-- Eliminar Solicitud
delimiter $
create procedure eliminarSolicitud(
	in idSolicitud int
)
begin 
	delete from solicitud where id = idSolicitud;
end $

-- Mostrar Solicitud
delimiter $
create procedure mostrarSolicitud()
begin 
	select * from solicitud;
end $

-- ==================================================================================================
### Coordinador
-- ==================================================================================================

-- Registrar Coordinador
delimiter $$
create procedure insertarCoordinador(
	in nom varchar(50),
    in ape varchar(50),
    in corr varchar(124),
    in nomU varchar(50),
    in contra varchar(50),
    in carrera int
)
begin
	declare idUsuario int;
	call insertarUsuario(nomU, contra, 4);
    set idUsuario = (select max(id) from usuario);
    insert into coordinador values(null, nom, ape, corr, default, idUsuario, carrera);
end
$$

-- Editar Coordinador

create procedure editarCoordinador(
	in nom varchar(50),
    in ape varchar(50),
    in corr varchar(124),
    in nomU varchar(50),
    in contra varchar(50),
    in carrera int,
    in idCo int
)
begin
	declare idUs int;
    set idUs = (select idUsuario from carrera where estado = 1 and id = idCo);
    
    update coordinador
    set nombres = nom, apellidos = ape, correo = corr, idCarrera = carrera
    where id = idCo;
    
    update usuario
    set nomUsuario = nomU, pass = sha1(contra)
    where id = idUs;
end
$$

-- Borrado Lógico Coordinador
delimiter $$
create procedure borradoLogicoCoordinador(
	in idCo int
)
begin
	declare idUs int;
    set idUs = (select idUsuario from coordinador where id =  idCo);
    
    update coordinador
    set estado = 0
    where id = idCo;
    
    update usuario
    set estado = 0
    where id = idUs;
end
$$

-- Eliminar Coordinador
delimiter $$
create procedure eliminarCoordinador(
	in idCo int
)
begin
	declare idUs int;
    set idUs = (select idUsuario from coordinador where id =  idCo);
    
	delete from coordinador where id = idCo;
    delete from usuario where id = idUs;
end
$$

-- Cambiar Rol de Coordinador -- Lógico

delimiter $$
create procedure cambiarRolCoordinador(
	in idCo int,
    in idR int
)
begin
	declare idUs int;
    set idUs = (select idUsuario from coordinador where id =  idCo);
    
    update usuario
    set idRol = idR
    where id = idUs;
	
    delete from coordinador where id = idR;
end
$$

-- Mostrar Coordinador

delimiter $$
create procedure mostrarCoordinadores()
begin
	select * from coordinador where estado = 1;
end
$$

-- ==================================================================================================
### Carrera
-- ==================================================================================================


-- Insertar Carrera --
delimiter $
create procedure insertarCarrera(
	in nomCar varchar(50),
    in idEsc int
)
begin
	insert into carrera values(null,nomCar,default,idEsc);
end $

-- Modificar Carrera --
delimiter $
create procedure modificarCarrera(
	in idCar int,
    in nomCar varchar(50),
    in idEsc int
)
begin
	update carrera set id = idCar, nombreCarrera = nomCar, idEscuela = idEsc;
end $

-- Eliminar Carrera
delimiter $
create procedure eliminarCarrera(
	in idCar int
)
begin
	delete from carrera where id = idCar;
end $

-- Borrado Lógico --
delimiter $
create procedure borradoLogicoCarrera(
	in idCar int
)
begin
	update carrera set estado = 0;
end $

-- Mostrar Carrera --
delimiter $
create procedure mostrarCarrera()
begin
	select * from carrera where estado = 1;
end $

drop procedure mostrarCarrera;

-- Buscar Carrera por nombre --
delimiter $
create procedure buscarNombreCarrera(
	in nom varchar(50)
)
begin
	select * from carrera where nombreCarrera = nom  and estado = 1;
end $

-- buscar Carrera por ID --
delimiter $
create procedure buscarIDCarrera(
	in idCar int
)
begin
	select * from carrera where id = idCar and estado = 1;
end $

-- mostrar Papelera Carrera --
delimiter $
create procedure mostrarPapeleraCarrera()
begin
	select * from carrera where estado = 0;
end $

-- buscar en papelera carrera por nombre --
delimiter $
create procedure buscarNombrePapeleraCarrera(
	in nom varchar(50)
)
begin
	select * from carrera where nombreCarrera = nom and estado = 0;
end $

-- buscar en papelera carrera por id --
delimiter $
create procedure buscarIDPapeleraCarrera(
	in idCar int
)
begin
	select * from carrera where id = idCar and estado = 0;
end $

-- restaurar carrera en papelera --
delimiter $
create procedure restaurarCarrera(
	in idCar int
)
begin
	update carrera set estado = 1 where id = idCar;
end $

-- Solvencias --

-- mostrar candidatos a solvencia --
delimiter $
create procedure mostrarCandidatos()
begin
	select e.id, e.carnet, e.nombres, e.apellidos, i.nombreInstitucion, h.nHoras from estudiante e
    inner join hojaserviciosocial h on e.id = h.idEstudiante
    inner join institucion on i.id = h.idInstitucion;
end $

-- buscar candidatos a solvencia por nombre --
delimiter $
create procedure buscarNombreCandidatos(
	in nom varchar(50)
)
begin
	select e.id, e.carnet, e.nombres, e.apellidos, i.nombreInstitucion, h.nHoras from estudiante e
    inner join hojaserviciosocial h on e.id = h.idEstudiante
    inner join institucion on i.id = h.idInstitucion
    where e.nombres like concat('%',nom,'%');
end $

-- buscar candidatos a solvencias por carnet --
delimiter $
create procedure buscarCarnetCandidatos(
	in car varchar(10)
)
begin
	select e.id, e.carnet, e.nombres, e.apellidos, i.nombreInstitucion, h.nHoras from estudiante e
    inner join hojaserviciosocial h on e.id = h.idEstudiante
    inner join institucion on i.id = h.idInstitucion
    where e.carnet like concat('%',car,'%');
end $

-- ==================================================================================================
### Estudiante
-- ==================================================================================================

-- Insertar Estudiante --
delimiter $
create procedure insertarEstudiante(
	in carnet varchar(10),
    in nombres varchar(50),
    in apellidos varchar(50),
    in correo varchar(50),
    in fechaIngreso date,
    in idG int(11),
    in idU int(11)
)
begin
	insert into estudiante values(null,carnet,nombres,apellidos,correo,fechaIngreso,idG,null,default,idU);
end $

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### VISTAS ######
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### DATOS INICIALES ######
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Roles de canela papu ;v
insert into rol values(null, 'Desarrollador');
insert into rol values(null, 'Administrador');
insert into rol values(null, 'Invitado');
insert into rol values(null, 'Coordinador');
insert into rol values(null, 'Estudiante');

insert into escuela values (null, 'Escuela de Ingenieria en Computacion', 1);
insert into carrera values (null, 'Tecnico en Ingenieria de Sistemas', 1, 1);
insert into grupo values (null, 'SIS12-A', 1, 1);

call insertarUsuario('Jorge Sidgo', 'tugfa', 1);
call insertarUsuario('Benja Parker', '123', 1);
call insertarUsuario('Abdiel Martinez', '123', 1);
call insertarUsuario('Francisco Montoya', '123', 1);

call insertarCoordinador('Giovanni Ariel', 'Tzec Chavez', 'giovanni.tzec@gmail.com', 'GiovanniTzec', 'tugfa', 1);
