package pe.com.sgs.appsgs.util;

public class Constantes {
	
	//SERVICIOS REST
	
	//public static final String REST_URL								= "http://192.168.30.53:8080/";			//PRUEBAS
	public static final String REST_URL		 							= "http://192.168.30.80:8080/";
	public static final String REST_GRABAR								= REST_URL + "RestSGS/services/sincronizacion/grabaSincronizacion";
	public static final String REST_VALIDAR_USUARIO						= REST_URL + "RestSGS/services/login/validaUsuario";
	public static final String REST_LISTA_TAREA							= REST_URL + "RestSGS/services/tarea/listaTarea";
	public static final String REST_LISTA_ORDEN							= REST_URL + "RestSGS/services/orden/listaOrden";
	
	
	public static final String MAC_ADDRESS 								= "MAC ADDRESS : ";
	public static final String IMEI 									= "IMEI : ";
	public static final String USUARIO_INCORRECTO 						= "Usuario o Clave Incorrecta.";
	public static final String SELECCIONAR_ALTERNATIVA 					= "Seleccionar una alternativa.";
	public static final String SELECCIONAR_ALTERNATIVAS 				= "Seleccionar una o mas alternativas.";
	public static final String INGRESAR_COMENTARIO 						= "Ingresar comentario.";
	public static final String SIN_INTERNET 							= "No se cuenta con acceso a internet";
	public static final String SIN_DNI 									= "Ingresar documento de identidad.";
	public static final String PENDIENTE_SELECCION 						= "Pendiente de Selección";
	public static final String LOCALIZACION_GPS 						= "Localización GPS";
	public static final String GEO_REFERENCIA 							= "GeoReferencia";

	public static final String VERSION_APP_INSTALADA 					= "Versión App Instalada : ";
	public static final String VERSION_APP_VIGENTE 						= "Versión App Vigente : ";
	public static final String VERSION_USUARIOS 						= "Versión Usuarios : ";
	public static final String VERSION_OPERADOR 						= "Versión Operador : ";
	public static final String VERSION_CONDICION 						= "Versión Condición : ";
	public static final String VERSION_ASISTENCIA_TECNICA 				= "Versión Asistencia Tecnica : ";
	public static final String VERSION_CAMPANIA_SALUD 					= "Versión Campaña de Salud : ";
	public static final String VERSION_UBIGEO 							= "Versión Ubigeo : ";
	public static final String VERSION_MODALIDAD_PAGO 					= "Versión Modalidad Pago : ";
	public static final String VERSION_LOCAL_PAGO 						= "Versión Local Pago : ";
	public static final String VERSION_PUNTO_PAGO 						= "Versión Punto de Pago : ";
	public static final String VERSION_TECHO 							= "Versión Techo : ";
	public static final String VERSION_PARED 							= "Versión Pared : ";
	public static final String VERSION_COCINA 							= "Versión Cocina : ";
	public static final String VERSION_AGUA 							= "Versión Agua : ";
	public static final String VERSION_SANEAMIENTO 						= "Versión Saneamiento : ";
	public static final String VERSION_LUZ 								= "Versión Luz : ";
	public static final String VERSION_SABERES_TIPOLOGIA 				= "Versión Saberes Tipología : ";
	public static final String VERSION_SABERES_TEMA						= "Versión Saberes Tema : ";
	public static final String VERSION_SABERES_NIVEL 					= "Versión Saberes Nivel : ";
	public static final String VERSION_SABERES_GRADO 					= "Versión Saberes Grado : ";
	public static final String VERSION_TIPO_DISCAPACIDAD 				= "Versión tipo discapacidad : ";
	public static final String VERSION_TIPO_DISCAPACIDAD_SABERES 		= "Versión tipo discapacidad saberes : ";
	public static final String VERSION_TIPO_CAMPANIA 					= "Versión tipo campaña : ";
	
	public static final String VERSION 									= "Versiones : ";
	public static final String ESPERAR_LOCALICACION 					= "Espere un momento, obteniendo coordenadas GPS";
	public static final String SIN_GEOREFERENCIA 						= "Registros sin geoReferencia.";
	public static final String SINCRONIZAR_ENCUESTAS 					= "Desea sincronizar las encuestas realizadas?";
	public static final String SINCRONIZAR_VISITAS 						= "Desea sincronizar las visitas realizadas?";
	public static final String PROCESAR_PADRON 							= "Desea procesar el archivo seleccionado?";
	public static final String SINCRONIZANDO_ENCUESTAS 					= "Sincronizando registros, por favor espere...";
	public static final String SINCRONIZANDO 							= "Sincronizando";
	public static final String SIN_ENCUESTA 							= "No hay encuestas activas.";
	public static final String SIN_INTERNET_SINCRONIZACION 				= "No se puede realizar la sincronización porque no se cuenta con acceso a internet.";
	public static final String ARCHIVO_INCORRECTO 						= "El archivo no cumple con el estandar";
	public static final String SALIR_VISITA 							= "Desea salir del registro de visita?";
	public static final String SALIR_SABERES 							= "Desea salir del registro de saberes productivos?";
	public static final String SALIR_REPORTE_CONSOLIDADO 				= "Desea salir del reporte consolidado?";
	public static final String SALIR_BITACORA 							= "Desea salir del registro de bitácora?";
	public static final String SALIR_ASISTENCIA_TECNICA 				= "Desea salir del registro de asistencia técnica?";
	public static final String SALIR_CAMPANIA_SALUD 					= "Desea salir del registro de campaña de salud?";
	public static final String SALIR_GEO_PUNTO_PAGO 					= "Desea salir del registro de Georeferencia de Punto de Pago?";
	public static final String SALIR_ACTORES_LOCALES 					= "Desea salir del registro de Actores Locales?";
	public static final String SALIR_ACTIVIDADES 						= "Desea salir del registro de Actividades?";
	public static final String SALIR_PROCESAR_PADRON 					= "Desea salir del proceso de padrón?";
	public static final String SALIR_DIALOGO_SABERES 					= "Desea salir del registro de Diálogo de Saberes?";
	public static final String SALIR_DISCAPACIDAD 						= "Desea salir del registro de Discapacidad?";
	public static final String SALIR_REPORTE_DISTRITO 					= "Desea salir del reporte mensual de distrito?";
	public static final String SALIR_TRANSMISION_INTERGENERACIONAL 		= "Desea salir del registro de Transmisión Intergeneracional?";
	public static final String SALIR_REGISTRO_SABERES 					= "Desea salir del registro de Registro de Saberes?";
	public static final String CONDICION_GRABAR_VISITA 					= "El documento de identidad a grabar no existe en el padrón, Desea grabar?";
	public static final String DNI_NO_EXISTE 							= "El documento de identidad no existe en padrón.";
	public static final String DNI_YA_EXISTE 							= "El documento de identidad ya existe en padrón.";
	public static final String SALIR_REPORTE_USUARIOS 					= "Desea salir del reporte de usuarios?";
	public static final String SALIR_MODULO_UNIVERSAL 					= "Desea salir del Módulo Universal?";
	public static final String SALIR_ENCUENTRO_MAGICO 					= "Desea salir del registro de Encuentro Mágico?";
	public static final String EXISTE_DNI_ENCUESTA 						= "El Dni ya se registro anteriormente en la encuesta";
	public static final String SINCRONIZANDO_INFORMACION 				= "Sincronizando Información...";
	public static final String REALIZANDO_CONSULTA 						= "Realizando Consulta, espere por favor ...";
	public static final String EXPORTANDO_INFORMACION 					= "Exportando Información...";
	public static final String EXPORTACION_ENCUESTAS_PENDIENTES 		= "Exportación de Encuestas Pendientes";
	public static final String MENSAJE_ACTUALIZAR 						= "Se recomienda actualizar la aplicación.";
	public static final String MENSAJE_NO_SINCRONIZACION 				= "No se pudo realizar la sincronización, intentelo nuevamente o comuniquese a la Central Telefónica 705-2900.";
	
	public static final String[] codigoDepartamento 					= {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};
	public static final String[] nombreDepartamento 					= {"AMAZONAS", "ANCASH", "APURIMAC", "AREQUIPA", "AYACUCHO", "CAJAMARCA", "CALLAO", "CUSCO", "HUANCAVELICA", "HUANUCO", "ICA", "JUNIN", "LA LIBERTAD", "LAMBAYEQUE", "LIMA", "LORETO", "MADRE DE DIOS", "MOQUEGUA", "PASCO", "PIURA", "PUNO", "SAN MARTIN", "TACNA", "TUMBES", "UCAYALI"};
	
	public static final String SELECCIONAR 								= "...:::SELECCIONAR:::...";
	public static final String MENSAJE_PLACA 							= "Ingrese Placa.";
	public static final String MENSAJE_TITULO 							= "Ingrese Titulo.";
	public static final String MENSAJE_PLACA_LONGITUD 					= "El Placa debe de ser de 7 digitos.";
	public static final String MENSAJE_KILOMETRAJE 						= "Ingrese Kilometraje.";
	public static final String MENSAJE_MONTO 							= "Ingrese Monto.";
	public static final String MENSAJE_GRIFO 							= "Ingrese Grifo.";
	public static final String MENSAJE_USU_MASCULINO 					= "Ingrese Nro.Usuarios Masculino.";
	public static final String MENSAJE_USU_FEMENINO 					= "Ingrese Nro.Usuarios Femenino.";
	public static final String MENSAJE_CODIGO_MODULAR 					= "Ingrese Código Modular.";
	public static final String MENSAJE_NOMBRE_IE 						= "Ingrese Nombre de Institución Educativa.";
	public static final String MENSAJE_TIPOLOGIA_SABER 					= "Seleccionar Tipología Saber.";
	public static final String MENSAJE_SUB_TIPOLOGIA_SABER 				= "Seleccionar Sub Tipología Saber.";
	public static final String MENSAJE_SABERES_TEMA 					= "Seleccionar Tema.";
	public static final String MENSAJE_SABERES_SUB_TEMA_1 				= "Seleccionar Sub Tema 1.";
	public static final String MENSAJE_SABERES_SUB_TEMA_2 				= "Seleccionar Sub Tema 2.";
	public static final String MENSAJE_SABERES_NIVEL 					= "Seleccionar Nivel.";
	public static final String MENSAJE_SABERES_GRADO 					= "Seleccionar Grado.";
	public static final String MENSAJE_NRO_NINOS 						= "Ingrese Nro.Niños.";
	public static final String MENSAJE_NRO_NINAS 						= "Ingrese Nro.Niñas.";
	public static final String MENSAJE_OBS_COMENTARIO 					= "Ingrese Detalle del Saber.";
	public static final String MENSAJE_DISCAPACIDAD_VISUAL 				= "Seleccionar discapacidad visual.";
	public static final String MENSAJE_DISCAPACIDAD_OIR 				= "Seleccionar discapacidad para oír.";
	public static final String MENSAJE_DISCAPACIDAD_HABLAR 				= "Seleccionar discapacidad para hablar.";
	public static final String MENSAJE_DISCAPACIDAD_BRAZOS 				= "Seleccionar discapacidad para usar brazos y manos.";
	public static final String MENSAJE_DISCAPACIDAD_PIES 				= "Seleccionar discapacidad para usar piernas y pies.";
	public static final String MENSAJE_DISCAPACIDAD_MENTAL				= "Seleccionar discapacidad mental o intelectual.";
	public static final String MENSAJE_CODIGO_SISFOH_VACIO 				= "Ingrese Código S100.";
	public static final String MENSAJE_CODIGO_SISFOH_LONGITUD 			= "El Código S100 debe de ser de 7 digitos.";
	public static final String MENSAJE_DNI_VACIO 						= "Ingrese DNI.";
	public static final String MENSAJE_DNI_LONGITUD 					= "El DNI debe de ser de 8 digitos.";
	public static final String MENSAJE_FECHA_VALIDA 					= "Ingrese Fecha.";
	public static final String MENSAJE_FECHA_TRANSFERENCIA_VALIDA 		= "Ingrese Fecha.";
	public static final String MENSAJE_PUNTOS_FOCALES 					= "Ingrese Nro. de puntos focales activos.";
	public static final String MENSAJE_USUARIOS_ATENDIDOS_MAYOR 		= "Los usuarios atendidos debe ser menor igual que los usuarios programados.";
	public static final String MENSAJE_USUARIOS_FALLECIDOS_MAYOR 		= "Los usuarios fallecidos debe ser menor igual que los usuarios programados.";
	public static final String MENSAJE_USUARIOS_TOTAL_MAYOR 			= "La suma de usuarios atendidos y fallecidos debe ser menor igual que los usuarios programados.";
	public static final String MENSAJE_USUARIOS_ATENDIDOS 				= "Ingrese usuarios atendidos.";
	public static final String MENSAJE_USUARIOS_FALLECIDOS 				= "Ingrese usuarios fallecidos.";
	public static final String MENSAJE_HORA_FIN 						= "Ingrese hora fin.";
	public static final String MENSAJE_HORA_INICIO 						= "Ingrese hora inicio.";
	public static final String MENSAJE_HORA_FIN_2 						= "Ingrese hora fin 2.";
	public static final String MENSAJE_HORA_INICIO_2 					= "Ingrese hora inicio 2.";
	public static final String MENSAJE_NRO_VARONES 						= "Ingrese Nro. de varones.";
	public static final String MENSAJE_NRO_MUJERES 						= "Ingrese Nro. de mujeres.";
	public static final String MENSAJE_NRO_INSTITUCIONES 				= "Ingrese Nro. de instituciones educativas.";
	public static final String MENSAJE_NRO_ACTORES 						= "Ingrese Nro. de otros actores locales.";
	public static final String MENSAJE_FECHA_ENCUENTRO_VALIDA 			= "Ingrese Fecha.";
	public static final String MENSAJE_INVERSION						= "Ingrese inversión aproximado del mes.";
	public static final String MENSAJE_CODIGO_SABERES					= "Ingrese Código (Registro).";
	public static final String MENSAJE_APELLIDO_PATERNO 				= "Ingrese Apellido Paterno.";
	public static final String MENSAJE_APELLIDO_MATERNO 				= "Ingrese Apellido Materno.";
	public static final String MENSAJE_NOMBRES 							= "Ingrese Nombres.";
	public static final String MENSAJE_EDAD 							= "Ingrese la edad.";
	public static final String MENSAJE_SELECCIONAR_OCURRENCIAS 			= "Seleccione Condición Beneficiario Ocurrencias.";
	public static final String MENSAJE_SELECCIONAR_TIPO_DISCAPACIDAD 	= "Seleccione el Tipo de Discapacidad.";
	public static final String MENSAJE_SELECCIONAR_VISITAS 				= "Seleccione Condición Beneficiario Visitas.";
	public static final String MENSAJE_DISTRITO 						= "Ingrese Distrito.";
	public static final String MENSAJE_CENTRO_POBLADO 					= "Ingrese Centro Poblado.";
	public static final String MENSAJE_LUGAR_ATENCION 					= "Ingrese Lugar de Atención.";
	public static final String MENSAJE_LUGAR 							= "Ingrese Lugar.";
	public static final String MENSAJE_ENTIDAD 							= "Ingrese Entidad.";
	public static final String MENSAJE_OBSERVACION 						= "Ingrese Observación.";
	public static final String MENSAJE_OBSERVACION_SABERES 				= "Ingrese detalles del encuentro de saberes productivos.";
	public static final String MENSAJE_FECHA_FALLECIMIENTO 				= "Ingrese Fecha de Fallecimiento.";
	public static final String MENSAJE_ASISTENCIA 						= "Seleccionar Asistencia.";
	public static final String MENSAJE_LOCAL_PAGO 						= "Seleccionar Local de Pago.";
	public static final String MENSAJE_MODALIDAD_PAGO 					= "Seleccionar Modalidad de Pago.";
	public static final String MENSAJE_PUNTO_PAGO 						= "Seleccionar Punto de Pago.";
	public static final String MENSAJE_SELECCIONAR_DISTRITO 			= "Seleccionar Distrito.";
	public static final String MENSAJE_SELECCIONAR_TIPO_CAMPANIA		= "Seleccionar Tipo de Campaña.";
	public static final String MENSAJE_UBIGEO 							= "Ingrese Ubigeo.";
	public static final String MENSAJE_CARGO 							= "Ingrese Cargo.";
	public static final String MENSAJE_UBIGEO_LONGITUD 					= "El Ubigeo debe de ser de 6 digitos.";
	public static final String MENSAJE_CANTIDAD_USUARIOS 				= "Ingrese cantidad de usuarios";
	public static final String MENSAJE_DNI_55555555 					= "Las actividades deben de ser registrados en el Modulo de Actividades";
	public static final String MENSAJE_PARTICIPANTE 					= "Debe agregar 1 o más participantes..";
	public static final String MENSAJE_UN_PARTICIPANTE 					= "Debe agregar 1 participante";
	public static final String MENSAJE_ACCION_MAPA 						= "Que filtro de mapa quiere visualizar?";
	public static final String MENSAJE_ACCION 							= "Que acción quiere realizar?";
	public static final String MENSAJE_MODIFICAR 						= "Modificar";
	public static final String MENSAJE_ELIMINAR 						= "Eliminar";
	public static final String MENSAJE_ACEPTAR 							= "Aceptar";
	public static final String MENSAJE_CANCELAR 						= "Cancelar";
	public static final String MENSAJE_ELIMINAR_VISITA 					= "Quiere eliminar la visita registrada?";
	public static final String MENSAJE_SI 								= "Si";
	public static final String MENSAJE_NO 								= "No";
	public static final String MENSAJE_DNI 								= "DNI : ";
	public static final String MENSAJE_NOMBRE_USUARIO 					= "Nombre : ";
	public static final String MENSAJE_PLACA_ALERTA 					= "PLACA : ";
	public static final String MENSAJE_CAMPANIA 						= "UBIGEO : ";
	public static final String MENSAJE_NOMBRE 							= "NOMBRES : ";
	public static final String MENSAJE_CONDICION 						= "CONDICION : ";
	public static final String MENSAJE_PTO_PAGO 						= "PUNTO DE PAGO : ";
	public static final String MENSAJE_FECHA 							= "FECHA : ";
	public static final String MENSAJE_ENCUENTRO_TITULO 				= "TITULO : ";
	public static final String SIN_PUNTO_PAGO 							= "SIN PUNTO DE PAGO";
	public static final String MENSAJE_GPS_DESACTIVADO 					= "El sistema GPS esta desactivado.";
	public static final String MENSAJE_SELECCIONAR_FECHA	 			= "Seleccione la fecha";
	
	public static final int VALOR_ASISTENCIA 							= 1;
	public static final String NOMBRE_ASISTENCIA 						= "Asistencia Técnica";
	
	public static final int VALOR_BITACORA 								= 2;
	public static final String NOMBRE_BITACORA 							= "Bitácora";
	
	public static final int VALOR_VISITA 								= 3;
	public static final String NOMBRE_VISITA 							= "Visita";
	
	public static final int VALOR_CAMPANIA 								= 4;
	public static final String NOMBRE_CAMPANIA 							= "Campaña de Salud";
	
	public static final int VALOR_GEO_PUNTO_PAGO 						= 5;
	public static final String NOMBRE_GEO_PUNTO_PAGO 					= "Punto de Pago";
	
	public static final int VALOR_ACTIVIDADES 							= 6;
	public static final String NOMBRE_ACTIVIDADES 						= "Inicio/Fin de Actividades";
	
	public static final int VALOR_ENCUENTRO_MAGICO 						= 7;
	public static final String NOMBRE_ENCUENTRO_MAGICO 					= "Encuentro Mágico";
	
	public static final int VALOR_HOGAR 								= 8;
	public static final String NOMBRE_HOGAR 							= "Módulo Universal";
	
	public static final int VALOR_REPORTE_CONSOLIDADO_INDIVIDUAL 		= 9;
	public static final String NOMBRE_REPORTE_CONSOLIDADO_INDIVIDUAL 	= "Reporte Consolidado Individual";
	
	public static final int VALOR_PROCESAR_ARCHIVO 						= 10;
	public static final String NOMBRE_PROCESAR_ARCHIVO 					= "Procesar Padrón";
	
	public static final int VALOR_PADRON_USUARIOS 						= 11;
	public static final String NOMBRE_PADRON_USUARIOS 					= "Reporte Usuarios";
	
	public static final int VALOR_SABERES_PRODUCTIVOS 					= 12;
	public static final String NOMBRE_SABERES_PRODUCTIVOS 				= "Saberes Productivos";
	
	public static final int VALOR_DIALOGO_SABERES 						= 13;
	public static final String NOMBRE_DIALOGO_SABERES 					= "Diálogo Saberes";
	
	public static final int VALOR_TRANSMISION_INTERGENERACIONAL 		= 14;
	public static final String NOMBRE_TRANSMISION_INTERGENERACIONAL 	= "Transmisión Intergeneracional";
	
	public static final int VALOR_REGISTRO_SABERES 						= 15;
	public static final String NOMBRE_REGISTRO_SABERES 					= "Registro Saberes";
	
	public static final int VALOR_REPORTE_DISTRITO 						= 16;
	public static final String NOMBRE_REPORTE_DISTRITO 					= "Reporte Mensual de Distrito";
	
	public static final int VALOR_DISCAPACIDAD 							= 17;
	public static final String NOMBRE_DISCAPACIDAD 						= "Discapacidad";

	public static final int VALOR_ACTORES_LOCALES						= 18;
	public static final String NOMBRE_ACTORES_LOCALES					= "Actores Locales";
	
	public static final int RESOLUCION_VGA_WIDTH 						= 640;
	public static final int RESOLUCION_VGA_HEIGHT 						= 480;
	
	public static final int RESOLUCION_SVGA_WIDTH 						= 800;
	public static final int RESOLUCION_SVGA_HEIGHT 						= 600;
	
	public static final int RESOLUCION_XVGA_WIDTH 						= 1024;
	public static final int RESOLUCION_XVGA_HEIGHT 						= 768;
	
	public static final String DNI 										= "DNI";
	public static final String APELLIDO_PATERNO 						= "A.Paterno";
	public static final String APELLIDO_MATERNO 						= "A.Materno";
	public static final String NOMBRES 									= "Nombres";
	public static final String FECHA_NACIMIENTO 						= "Fec.Nacimiento";
	public static final String FALLECIDO 								= "Fallecido : ";
	public static final String DISCAPACIDAD 							= "Discapacidad : ";
	public static final String GESTANTE 								= "Gestante : ";
	public static final String DEPARTAMENTO 							= "Departamento";
	public static final String PROVINCIA 								= "Provincia";
	public static final String DISTRITO 								= "Distrito";
	public static final String DIRECCION 								= "Dirección : ";
	public static final String EDAD 									= "Edad";
	public static final String PEROPE 									= "U.Pago";

	public static final String TELEFONO_CONTACTO						= "T.Contacto";
	public static final String PERSONA_CONTACTO							= "P.Contacto";
	
	public static final String SDIRECCION 								= "S.Dirección";
	public static final String DDIRECCION 								= "D.Dirección";
	public static final String PDIRECCION 								= "P.Dirección";
	public static final String CONDICION 								= "Condición";
	public static final String FECHA_VISITA 							= "F.Visita";

	public static final String MENSAJE_DNI_REGISTRADO 					= "DNI ya se encuentra agregado.";
	public static final String MENSAJE_FECHA_NACIMIENTO 				= "Seleccione Fecha de Nacimiento.";
	public static final String SALIR_MIEMBRO 							= "Desea salir del registro de mienbro de hogar?";
	public static final String SALIR_PREGUNTA 							= "Desea salir de la pregunta?";
	public static final String MENSAJE_SELECCIONAR_COCINA 				= "Seleccione Tipo de Cocina.";
	public static final String MENSAJE_SELECCIONAR_AGUA 				= "Seleccione Calidad de Agua.";
	public static final String MENSAJE_SELECCIONAR_SANEAMIENTO 			= "Seleccione Saneamiento.";
	public static final String MENSAJE_SELECCIONAR_LUZ 					= "Seleccione Luz.";
	public static final String MENSAJE_SIN_MIEMBROS_HOGAR 				= "Debe de registrar Miembros de Hogar.";
	public static final String SALIR_HOGAR 								= "Desea salir del registro de hogar?";
	public static final String COCINA 									= "Tipo de Cocina : ";
	public static final String AGUA 									= "Calidad de Agua : ";
	public static final String SANEAMIENTO 								= "Saneamiento : ";
	public static final String LUZ 										= "Luz : ";
	
	public static final int RCI_CODIGO_VERIFICACIONES 					= 1;
	public static final String RCI_NOMBRE_VERIFICACIONES 				= "Verificaciones";
	
	public static final int RCI_CODIGO_CONSULTA_SISFOH 					= 2;
	public static final String RCI_NOMBRE_CONSULTA_SISFOH 				= "Consulta SISFOH";
	
	public static final int RCI_CODIGO_CONSULTA_DDJJ 					= 3;
	public static final String RCI_NOMBRE_CONSULTA_DDJJ 				= "Consulta de Declaraciones Juradas";
	
	public static final int RCI_CODIGO_HISTORICO_PAGADURIAS 			= 4;
	public static final String RCI_NOMBRE_HISTORICO_PAGADURIAS 			= "Historico de Pagadurias";
	
	public static final int RCI_CODIGO_HISTORICO_CAMBIO_CONDICION 		= 5;
	public static final String RCI_NOMBRE_HISTORICO_CAMBIO_CONDICION 	= "Historico de Cambio de Condición";
	
	public static final int RCI_CODIGO_REFERENCIA_SISFOH 				= 6;
	public static final String RCI_NOMBRE_REFERENCIA_SISFOH 			= "Referencia SISFOH";
	
	public static final int RCI_CODIGO_ENVIADOS_COTEJO_MASIVO 			= 7;
	public static final String RCI_NOMBRE_ENVIADOS_COTEJO_MASIVO 		= "Enviados a Cotejo Masivo";
	
	public static final int RCI_CODIGO_SOLICITUD_REEVALUACION 			= 8;
	public static final String RCI_NOMBRE_SOLICITUD_REEVALUACION 		= "Solicitud de Reevaluación SocioEconomica";
	
	public static final int RCI_CODIGO_CUENTAS_VIGILADAS 				= 9;
	public static final String RCI_NOMBRE_CUENTAS_VIGILADAS 			= "Cuentas Vigiladas";
	
	/*VARIABLES REPORTE CONSOLIDADO VERIFICACIONES*/
	public static final String RC_VERIFICACION_DNI 						= "DNI";
	public static final String RC_VERIFICACION_NOMBRES 					= "Nombres";
	public static final String RC_VERIFICACION_UBIGEO 					= "Ubigeo";
	public static final String RC_VERIFICACION_ACTIVIDAD 				= "Actividad";
	public static final String RC_VERIFICACION_CONDICION 				= "Condicion";
	public static final String RC_VERIFICACION_SUSTENTO 				= "Sustento";
	public static final String RC_VERIFICACION_DDJJ 					= "DDJJ";
	public static final String RC_VERIFICACION_INDICADOR_CTA 			= "IndCta";
	public static final String RC_VERIFICACION_CTA_VIGILADA 			= "CtaVigilada";
	public static final String RC_VERIFICACION_ONP 						= "Onp";
	public static final String RC_VERIFICACION_SBS 						= "Sbs";
	public static final String RC_VERIFICACION_ESSALUD 					= "Essalud";
	public static final String RC_VERIFICACION_REINCORPORADO 			= "Reincorporado";
	public static final String RC_VERIFICACION_PRIORIZADO 				= "Priorizado";
	public static final String RC_VERIFICACION_VISITADO 				= "Visitado";
	public static final String RC_VERIFICACION_FOTO 					= "Foto";
	public static final String RC_VERIFICACION_GEOREFERENCIA 			= "GeoRef";
	public static final String RC_VERIFICACION_OBSERVACION 				= "Obs";
	
	/*VARIABLES REPORTE CONSOLIDADO CONSULTA SISFOH*/
	public static final String RC_CONSULTA_SISFOH_LISTA					= "Lista SISFOH";
	public static final String RC_CONSULTA_SISFOH_PATERNO 				= "Paterno";
	public static final String RC_CONSULTA_SISFOH_MATERNO 				= "Materno";
	public static final String RC_CONSULTA_SISFOH_NOMBRES 				= "Nombres";
	public static final String RC_CONSULTA_SISFOH_NACIMIENTO			= "Nacimiento";
	public static final String RC_CONSULTA_SISFOH_DEPARTAMENTO			= "Departamento";
	public static final String RC_CONSULTA_SISFOH_PROVINCIA				= "Provincia";
	public static final String RC_CONSULTA_SISFOH_DISTRITO	 			= "Distrito";
	public static final String RC_CONSULTA_SISFOH_DIRECCION 			= "Dirección";
	public static final String RC_CONSULTA_SISFOH_VIGENCIA_DESDE		= "Vigencia Desde";
	public static final String RC_CONSULTA_SISFOH_VIGENCIA_HASTA		= "Vigencia Hasta";
	public static final String RC_CONSULTA_SISFOH_DOCUMENTO 			= "Documento";
	public static final String RC_CONSULTA_SISFOH_LISTA_VIGENTE			= "Lista Vigente";
	
	/*VARIABLES REPORTE CONSOLIDADO DECLARACIONES JURADAS*/
	public static final String RC_DECLARACIONES_JURADAS_SEXO			= "Sexo";
	public static final String RC_DECLARACIONES_JURADAS_UBIGEO			= "Ubigeo";
	public static final String RC_DECLARACIONES_JURADAS_FECHA_DDJJ		= "Fecha DDJJ";
	public static final String RC_DECLARACIONES_JURADAS_DOCUMENTO		= "Documento";
	public static final String RC_DECLARACIONES_JURADAS_FECHA_REGISTRO	= "Fecha Registro";
	public static final String RC_DECLARACIONES_JURADAS_DDJJ_VALIDA		= "DDJJ Valida";
	
	/*VARIABLES REPORTE CONSOLIDADO HISTORICO PAGADURIAS*/
	public static final String RC_HISTORICO_PAGADURIAS_PERIODO			= "Periodo";
	public static final String RC_HISTORICO_PAGADURIAS_TIPO_USUARIO		= "Tipo Usuario";
	public static final String RC_HISTORICO_PAGADURIAS_MODALIDAD_PAGO	= "Modalidad de Pago";
	public static final String RC_HISTORICO_PAGADURIAS_LUGAR_AGENCIA	= "Lugar de Agencia";
	public static final String RC_HISTORICO_PAGADURIAS_DEPOSITO			= "Deposito";
	
	/*VARIABLES REPORTE CONSOLIDADO CAMBIO CONDICION*/
	public static final String RC_CAMBIO_CONDICION_ANTERIOR				= "Anterior";
	public static final String RC_CAMBIO_CONDICION_ACTUAL				= "Actual";
	public static final String RC_CAMBIO_CONDICION_FECHA_MODIFICA		= "Fecha Modifica";
	public static final String RC_CAMBIO_CONDICION_USUARIO_MODIFICA		= "Usuario Modifica";
	public static final String RC_CAMBIO_CONDICION_FECHA_APRUEBA		= "Fecha Aprobacion";
	public static final String RC_CAMBIO_CONDICION_USUARIO_APRUEBA		= "Usuario Aprueba";
	public static final String RC_CAMBIO_CONDICION_MOTIVO				= "Motivo";
	public static final String RC_CAMBIO_CONDICION_DOCUMENTO			= "Documento";
		
	/*VARIABLES REPORTE CONSOLIDADO CAMBIO CONDICION*/
	public static final String RC_COTEJO_MASIVO_CONSECUTIVO				= "Consecutivo";
	public static final String RC_COTEJO_MASIVO_FECHA_PROCESO			= "Fecha Proceso";
	
	/*VARIABLES REPORTE CONSOLIDADO REEVALUACION SOCIOECONOMICA*/
	public static final String RC_REEVALUACION_SOCIOECONOMICA_REFERENCIA	= "Referencia";
	public static final String RC_REEVALUACION_SOCIOECONOMICA_FECHA_OFICIO	= "Fecha Oficio";
	
	/*VARIABLES REPORTE CONSOLIDADO CUENTAS VIGILADAS*/
	public static final String RC_CUENTAS_VIGILADAS_MOTIVO_VIGILANCIA	= "Motivo Vigilancia";
	public static final String RC_CUENTAS_VIGILADAS_DOCUMENTO_VIGILANCIA= "Documento Vigilancia";
	public static final String RC_CUENTAS_VIGILADAS_FECHA_DOCUMENTO		= "Fecha Documento";
	public static final String RC_CUENTAS_VIGILADAS_DOCUMENTO_LEVANTA	= "Documento Levanta Vigilancia";
	public static final String RC_CUENTAS_VIGILADAS_FECHA_LEVANTA		= "Fecha Levanta Vigilancia";
	public static final String RC_CUENTAS_VIGILADAS_OBSERVACION			= "Observación";
	
	public static final String MENSAJE_AGREGAR 							= "Agregar";
	public static final String MENSAJE_MAPA 							= "Ver en Mapa";
	
	public static final String MENSAJE_SP_FECHA 						= "Fecha";
	public static final String MENSAJE_SP_TEMA			 				= "Tema";
	public static final String MENSAJE_SP_NIVEL		 					= "Nivel";
	public static final String MENSAJE_SP_GRADO		 					= "Grado";
	public static final String MENSAJE_SP_NRO_NINOS 					= "Nro.Niños";
	public static final String MENSAJE_SP_NRO_NINAS 					= "Nro.Niñas";
	public static final String MENSAJE_SP_CODIGO_MODULAR				= "Código Modular";
	public static final String MENSAJE_SP_TIPOLOGIA_SABER				= "Tipología del Saber";
	public static final String MENSAJE_SP_CODIGO_REGISTRO				= "Código (Registro)";
	public static final String MENSAJE_SP_MES_REPORTE					= "Mes Reporte";
	
	public static final String AGREGAR_NUEVO_NO = "No se puede registrar un nuevo participante porque ya agrego a uno.";

	public static final String SALIR_REPORTE 							= "Desea salir del reporte?";
	public static final String SALIR_ACTIVIDAD 							= "Desea salir del registro de actividad?";
	public static final String SALIR_RENDICION 							= "Desea salir del registro de rendición de gastos?";
	public static final String MENSAJE		 							= "Mensaje";
}