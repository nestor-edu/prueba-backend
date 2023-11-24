# prueba-backend
Prueba técnica de preselección - RestAPI &amp; Base de datos Activo Fijo 
QUERIES
SELECT * FROM activos_fijos;

insert into activos_fijos (id_activo_fijo, codigo, tipo_activo_id, descripcion)
values (6, 'RDS10123', 8, 'Redragon S101 Gaming Keyboard');

select * from activos_fijos where codigo = 'RDS10123';

select id_asignaciones, nombres, nombre as area, codigo, descripcion from activos_fijos af
join activo_fijo.asignaciones a on af.id_activo_fijo = a.activos_fijos_id
join activo_fijo.personas p on p.id_persona = a.personas_id
join activo_fijo.areas_trabajo t on t.id_areas_trabajo = p.areas_trabajo_id;

insert into asignaciones (personas_id, activos_fijos_id)
values (4, 7);
