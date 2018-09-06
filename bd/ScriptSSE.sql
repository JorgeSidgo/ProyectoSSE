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
    idEscuela int not null,
    idTipoCarrera int not null
);

create table tipoCarrera(
	id int auto_increment primary key unique,
    descTipoCarrera varchar(50)
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
    idSolicitud int
);

create table detalleHorarioServicio(
    id int auto_increment primary key unique,
    nHoras int,
    diaSemana varchar(20),
    idHorarioServicio int
);

create table actividadesServicio(
    id int auto_increment primary key unique,
    idSolicitud int
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
    estadoSolicitud varchar(50),
    idEstudiante int not null,
    idCoordinador int not null,
    idInstitucion int not null,
    fecha date,
    comentarios text,
    estado int default 1
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
    idUsuario int not null,
    idEstadoEstudiante int not null,
    idEstadoSS int not null
);

create table estadoEstudiante(
	id int auto_increment primary key unique,
    descEstado varchar(50)
);

create table estadoSS(
	id int auto_increment primary key unique,
    descEstado varchar(50)
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

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### LLAVES FORANEAS ######
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

alter table grupo add constraint fk_grupo_carrera foreign key (idCarrera) references carrera(id);
alter table carrera add constraint fk_carrera_escuela foreign key (idEscuela) references escuela(id);
alter table usuario add constraint fk_usuario_rol foreign key (idRol) references rol(id);
alter table estudiante add constraint fk_estudiante_usuario foreign key (idUsuario) references usuario(id);
alter table estudiante add constraint fk_estudiante_grupo foreign key (idGrupo) references grupo(id);
alter table estudiante add constraint fk_estudiante_estadoEstudiante foreign key (idEstadoEstudiante) references estadoEstudiante(id);
alter table estudiante add constraint fk_estudiante_estadoSS foreign key (idEstadoSS) references estadoSS(id);
alter table coordinador add constraint fk_coordinador_usuario foreign key (idUsuario) references usuario(id);
alter table coordinador add constraint fk_coordinador_carrera foreign key (idCarrera) references carrera(id);
alter table horarioAtencion add constraint fk_horarioAtencion_coordinador foreign key (idCoordinador) references coordinador(id);
alter table detalleHorarioAtencion add constraint fk_detalleHorarioAtencion_horarioAtencion foreign key (idHorarioAtencion) references horarioAtencion(id);
alter table institucion add constraint fk_institucion_tipoInstitucion foreign key (idTipoInstitucion) references tipoInstitucion(id);
alter table solicitud add constraint fk_solicitud_estudiante foreign key (idEstudiante) references estudiante(id);
alter table solicitud add constraint fk_solicitud_coordinador foreign key (idCoordinador) references coordinador(id);
alter table solicitud add constraint fk_solicitud_institucion foreign key (idInstitucion) references institucion(id);
alter table materiasEstudiante add constraint fk_materiasEstudiante_materia foreign key (idMateria) references materia(id);
alter table materiasEstudiante add constraint fk_materiasEstudiante_estudiante foreign key (idEstudiante) references estudiante(id);
alter table hojaServicioSocial add constraint fk_hojaServicioSocial_estudiante foreign key (idEstudiante) references estudiante(id);
alter table hojaServicioSocial add constraint fk_hojaServicioSocial_institucion foreign key (idInstitucion) references institucion(id);
alter table hojaServicioSocial add constraint fk_hojaServicioSocial_coordinador foreign key (idCoordinador) references coordinador(id);
alter table horarioServicio add constraint fk_horarioServicio_Solicitud foreign key (idSolicitud) references solicitud(id);
alter table actividadesServicio add constraint fk_actividadesServicio_Solicitud foreign key (idSolicitud) references solicitud(id);
alter table detalleHorarioServicio add constraint fk_detalleHorarioServicio_horarioServicio foreign key (idHorarioServicio) references horarioServicio (id);
alter table detalleActividadesServicio add constraint fk_detalleActividadesServicio_horarioServicio foreign key (idActividadesServicio) references actividadesServicio (id);
alter table correo add constraint fk_correo_coordinador foreign key (idCoordinador) references coordinador (id);
alter table correo add constraint fk_correo_estudiante foreign key (idEstudiante) references estudiante (id);

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### VISTAS ######
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

create view estudiantesPro as (
	select e.*, u.nomUsuario, c.nombreCarrera, g.nombreGrupo, s.descEstado as estadoSS, ee.descEstado as estadoEstudiante
    from estudiante e, grupo g, carrera c, estadoSS s, estadoEstudiante ee, usuario u
    where e.idUsuario = u.id and e.idGrupo = g.id and g.idCarrera = c.id and e.idEstadoEstudiante = ee.id and e.idEstadoSS = s.id
);

select * from estudiantesPro;

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

select * from usuario

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
	select u.id as N, u.nomUsuario as 'Nombre Usuario', r.descRol as Rol from usuario u inner join rol r on r.id=u.idRol where estado = 0;
end $

create procedure usuariorepo()
begin
	select u.id as N, u.nomUsuario as 'Nombre Usuario', r.descRol as Rol from usuario u inner join rol r on r.id=u.idRol where estado = 1;
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
	select i.id as ID, i.nombreInstitucion as Nombre, i.direccion, i.correo as Correo, i.telefono as telefono, t.descTipoInstitucion as Tipo from institucion i inner join tipoInstitucion t on i.idTipoInstitucion=t.id where estado = 0;
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

-- Mostrar String institucion --
delimiter $
create procedure stringInstitucion(in idI int)
begin
	select i.nombreInstitucion as Nombre from institucion i where i.id = idI and i.estado = true; 
end $

-- ==================================================================================================
### Hoja de Servicio Social
-- ==================================================================================================

-- Insertar Hoja de Servicio Social
delimiter $
create procedure insertarHojaServicio(	
    in idEs int, 
    in idIns int, 
    in idCoor int, 
    in inicio date, 
    in finalizacion date,
    in horas int
)
begin 
	declare totHoras int;
    declare tCarrera int;
	insert into hojaServicioSocial values (null,idEs,idIns, idCoor, inicio, finalizacion, horas);
    set totHoras = (select sum(nhoras) from hojaServicioSocial where idEstudiante = idEs);
    set tCarrera = (select c.idTipoCarrera from carrera c, grupo g, estudiante e where e.idGrupo = g.id and g.idCarrera = c.id and e.id = idEs);
    
    if (tCarrera = 1) then
		
        if (totHoras > 299) then
			update estudiante
			set idEstadoSS = 3
			where id = idEs;
		
        elseif (totHoras < 300) then
			update estudiante
			set idEstadoSS = 2
			where id = idEs;

		end if;
        
	elseif (tCarrera = 2) then
		if (totHoras > 499) then
			update estudiante
			set idEstadoSS = 3
			where id = idEs;
		
        elseif (totHoras < 500) then
			update estudiante
			set idEstadoSS = 2
			where id = idEs;
		end if;
	end if;

    
end $

call insertarHojaServicio(1,1,1,NOW(),null,100);

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
	drop procedure insertarSolicitud;
-- Insertar Solicitud
delimiter $
create procedure insertarSolicitud(
    in esta varchar(50),
    in idEstu int, 
    in idCo int, 
    in idIn int, 
    in fecha date,
    in come text
)
begin 
	insert into solicitud values (null,esta,idEstu,idCo,idIn,fecha,come, default);
end $

-- Editar Solicitud
delimiter $
create procedure editarSolicitud(
	in idSolicitud int, 
    in estado varchar(50),
    in com text
)
begin
	update solicitud 
    set estadoSolicitud = estado, comentarios = com
    where id = idSolicitud;
end $

-- Eliminar Fisico Solicitud
delimiter $
create procedure eliminarSolicitud(
	in idSolicitud int
)
begin 
	delete from solicitud where id = idSolicitud;
end $

-- Eliminar Logico Solicitud
delimiter $
create procedure ocultarSolicitud(
	in idSol int
)
begin 
	update solicitud set
    estado = false
    where id = idSol;
end $

-- Mostrar Solicitud
delimiter $
create procedure showSolicitud()
begin
	select * from solicitud where estado = true;
end $

delimiter $
create procedure repoSolicitud(in val varchar(20))
begin
	select concat(e.nombres,' ',e.apellidos) as nombre, i.nombreInstitucion,s.fecha, s.comentarios from solicitud s inner join estudiante e on s.idEstudiante=e.id inner join institucion i on i.id=s.idInstitucion where s.estado = true and s.estadoSolicitud=val;
end $

delimiter $
create procedure papeleraSolicitud()
begin
	select s.id, concat(e.nombres,' ',e.apellidos) as nombre, i.nombreInstitucion,s.fecha, s.comentarios from solicitud s inner join estudiante e on s.idEstudiante=e.id inner join institucion i on i.id=s.idInstitucion where s.estado = true;
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
    set idUs = (select idUsuario from coordinador where estado = 1 and id = idCo);
    
    update coordinador
    set nombres = nom, apellidos = ape, correo = corr, idCarrera = carrera
    where id = idCo;
    
    update usuario
    set nomUsuario = nomU, pass = sha1(contra)
    where id = idUs;
end
$$

-- Borrado Lógico Coordinador --
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

-- Mostrar Coordinador String
delimiter $
create procedure stringCoordinador(in idC int)
begin
	select c.nombres as Nombres from coordinador c where c.id = idC and c.estado = true;
end $
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
	select e.id, e.carnet, e.nombres, e.apellidos, c.nombreCarrera, g.nombreGrupo, s.descEstado as estadoSS, sum(h.nHoras) as numHoras from estudiante e
	inner join grupo g on e.idGrupo = g.id
	inner join carrera c on g.idCarrera = c.id
	inner join estadoSS s on e.idEstadoSS = s.id
	inner join hojaServicioSocial h on e.id = h.idEstudiante
    where e.idEstadoEstudiante = 2 and e.idEstadoSS = 3 group by e.id;
end $

-- buscar candidatos a solvencia por nombre --
delimiter $
create procedure buscarNombreCandidatos(
	in nom varchar(50)
)
begin
	select e.id, e.carnet, e.nombres, e.apellidos, c.nombreCarrera, g.nombreGrupo, s.descEstado as estadoSS, sum(h.nHoras) as horasSociales from estudiante e
	inner join grupo g on e.idGrupo = g.id
	inner join carrera c on g.idCarrera = c.id
	inner join estadoSS s on e.idEstadoSS = s.id
	inner join hojaServicioSocial h on h.idEstudiante = e.id
    where e.nombres like concat('%',nom,'%') and e.idEstadoEstudiante = 2 and e.idEstadoSS = 2;
end $

-- buscar candidatos a solvencias por carnet --
delimiter $
create procedure buscarCarnetCandidatos(
	in car varchar(10)
)
begin
	select e.id, e.carnet, e.nombres, e.apellidos, c.nombreCarrera, g.nombreGrupo, s.descEstado as estadoSS, sum(h.nHoras) as horasSociales from estudiante e
	inner join grupo g on e.idGrupo = g.id
	inner join carrera c on g.idCarrera = c.id
	inner join estadoSS s on e.idEstadoSS = s.id
	inner join hojaServicioSocial h on h.idEstudiante = e.id
    where e.carnet like concat('%',car,'%') and e.idEstadoEstudiante = 2 and e.idEstadoSS = 2;
end $

-- ==================================================================================================
### Estudiante
-- ==================================================================================================
call mostrarCandidatos();
-- Insertar Estudiante --
delimiter $
create procedure insertarEstudiante(
	in nomU varchar(50),
    in contra varchar(50),
	in car varchar(10),
    in nom varchar(50),
    in ape varchar(50),
    in corr varchar(50),
    in fecha date,
    in idG int(11)
)
begin
	declare idU int;
	call insertarUsuario(nomU, contra, 5);
    set idU = (select max(id) from usuario);
    insert into estudiante values(null, car, nom, ape, corr, fecha, idG, default, idU, 1, 1);
end $

-- Mostrar string estudiante --
delimiter $
create procedure stringEstudiante(in idE int)
begin
	select e.nombres as Nombres from estudiante e where e.id = idE and e.estado = true;
end $

-- devolver estudiante segun N° de Carnet
delimiter $$
create procedure getEstudianteCarnet(
	in car varchar(20)
)
begin
	select * from estudiante where carnet = car and estado = 1;
end
$$

delimiter $
create procedure estadoServicioSocial(in val varchar(20))
begin
	select * from estudiantesPro where estadoSS = val;
end $

-- Mostrar solicitudes estudiante

delimiter $$
create procedure solicitudesEstudiante(
	in car varchar(50),
    in idCoor int
)
begin
	declare idEs int;
    set idEs = (select id from estudiante where carnet = car);

	select s.* 
	from solicitud s, estudiante e
	where s.idEstudiante = e.id and s.estadoSolicitud = 'Aprobado' and e.idEstadoEstudiante = 2 and e.id = idEs and s.idCoordinador = idCoor;
end
$$


call solicitudesEstudiante('426017', 1);

-- call solicitudesEstudiante('426017');
-- ==================================================================================================
### MateriasEstudiante
-- ==================================================================================================

-- Inscribir Materias

delimiter $$
create procedure inscribirMaterias(
    in idEst int,
    in idMat int
)
begin
    declare nMaterias int;
    insert into materiasEstudiante values(null, idEst, idMat);    

    set nMaterias = (select count(idMateria) from materiasEstudiante where idEstudiante = idEst);

    if nMaterias > 0 then
        update estudiante
        set idEstadoEstudiante = 2
        where id = idEst;
    end if;

end
$$

-- ==================================================================================================
### Solvencia
-- ==================================================================================================

-- Insertar Solvencia
delimiter $
create procedure solventar(
    in idEs int
)
begin
    update estudiante set idEstadoEstudiante = 3 where id = idEs;
end $

-- call insertarSolvencia(1,1);
-- select*from solvencia;

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### DATOS INICIALES ######
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Roles de canela papu ;v
insert into rol values(null, 'Desarrollador');
insert into rol values(null, 'Administrador');
insert into rol values(null, 'Invitado');
insert into rol values(null, 'Coordinador');
insert into rol values(null, 'Estudiante');

insert into materia values(null, 'Desarrollo de Aplicaciones para la Web', 1, 'DAW-101');
insert into materia values(null, 'Desarrollo de Aplicaciones Utilizando Tecnologías Emergentes', 1, 'DAUTE-101');
insert into materia values(null, 'Fisica 1', 1, 'FIS-1');
insert into materia values(null, 'Fisica 2', 1, 'FIS-2');
insert into materia values(null, 'Prevencion de Accidentes y Enfermedades Ocupacionales', 1, 'PAEO-101');

insert into tipoCarrera values (null, 'Tecnico');
insert into tipoCarrera values (null, 'Ingenieria');

insert into escuela values (null, 'Escuela de Ingenieria en Computacion', 1);
insert into carrera values (null, 'Tecnico en Ingenieria de Sistemas', 1, 1, 1);

insert into escuela values (null, 'Escuela de Ingenieria Mecatrónica', 1);
insert into carrera values (null, 'Ingenieria Mecatronica', 1, 2, 2);

insert into grupo values (null, 'SIS12-A', 1, 1);

insert into grupo values (null, 'MEC01-A', 1, 2);

call insertarUsuario('Jorge Sidgo', 'tugfa', 1);
call insertarUsuario('Benja Parker', '123', 1);
call insertarUsuario('anb', '123', 1);
call insertarUsuario('Francisco Montoya', '123', 1);

insert into estadoEstudiante values(null, 'No apto para Servicio Social');
insert into estadoEstudiante values(null, 'Insolvente');
insert into estadoEstudiante values(null, 'Solvente');

insert into estadoSS values(null, 'No Iniciado');
insert into estadoSS values(null, 'En Ejecucion');
insert into estadoSS values(null, 'Completado');

-- intituciones son
	-- Pública
	-- ONG
    -- Privada

insert into tipoinstitucion values(null, 'Publica');
insert into tipoinstitucion values(null, 'Privada');
insert into tipoinstitucion values(null, 'ONG');
call insertarEstudiante('DonFrancisco', '123', '426017','Francisco Javier','Montoya Díaz','javicitoCasanova@gmail.com','2018-01-01',1); 
call insertarEstudiante('BenitínSinEneas', '123', '890617','Benito Carmelo','Guerra Solorzano','benitoKrmelo@gmail.com','2018-01-01',1); 
call insertarEstudiante('AquilesVoy', '123', '890617','Aquiles','Baesa','benitoKrmelo@gmail.com','2018-01-01',1); 
call insertarEstudiante('AquilesCorto', '123', '689917','Aquiles','Castro','benitoKrmelo@gmail.com','2018-01-01',1); 
call insertarEstudiante('BrisaPrrona', '123', '111117','Brisa Marina','de Guerra','benitoKrmelo@gmail.com','2018-01-01',1); 
call insertarEstudiante('NitalesJo', '123', '908017','Jorge','Nitales','benitoKrmelo@gmail.com','2018-01-01',1);
call insertarEstudiante('Shipiz', '123', '789117','Chepe','Trompo','benitoKrmelo@gmail.com','2018-01-01',1); 
call insertarEstudiante('Abdi', '123', '222217','ANtoni martinez','Montoya Díaz','javicitoCasanova@gmail.com','2018-01-01',1); 
call insertarInstitucion('Institucion 1','a la vuelta de la esquina','institucion1@gmail.com','2222-2222',1);
call insertarInstitucion('Institucion 2','Santa rosa','iburgues@gmail.com','2222-2222',1);
call insertarCoordinador('Giovanni Ariel', 'Tzec Chavez', 'giovanni.tzec@gmail.com', 'GiovanniTzec', 'tugfa', 1);
call insertarSolicitud('Aprobado',1,1,1,'2018-06-01','Ejemplo');
call insertarSolicitud('Aprobado',1,1,2,'2017-03-05','Ejemplo');
call insertarSolicitud('Aprobado',3,1,1,'2018-06-01','Ejemplo');
call insertarSolicitud('Aprobado',6,1,1,'2018-06-01','Ejemplo');


call insertarSolicitud('Negado',2,1,1,'2018-06-01','Ejemplo');
call insertarHojaServicio(1,1,1,'2018-01-01','2018-06-01',100);
call insertarHojaServicio(1,1,1,'2018-01-01','2018-06-01',100);
call insertarHojaServicio(3,1,1,'2018-01-01','2018-06-01',100);
call insertarHojaServicio(3,1,1,'2018-01-01','2018-06-01',100);
call insertarHojaServicio(3,1,1,'2018-01-01','2018-06-01',100);
call insertarHojaServicio(2,1,1,'2018-01-01','2018-06-01',300);
call insertarHojaServicio(3,1,1,'2018-01-01','2018-06-01',300);
call insertarHojaServicio(4,1,1,'2018-01-01','2018-06-01',300);
call insertarHojaServicio(5,1,1,'2018-01-01','2018-06-01',300);
call insertarHojaServicio(6,1,1,'2018-01-01','2018-06-01',300);
call insertarHojaServicio(7,1,1,'2018-01-01','2018-06-01',300);
call insertarHojaServicio(8,1,1,'2018-01-01','2018-06-01',300);

call inscribirMaterias(1, 1);
call inscribirMaterias(1, 2);
call inscribirMaterias(1, 3);

call getEstudianteCarnet('426017');
-- select * from estudiantesPro;
update estudiante set idEstadoEstudiante = 2 where id>2;
-- select * from estudiante;
