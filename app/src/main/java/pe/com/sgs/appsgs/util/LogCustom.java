package pe.com.sgs.appsgs.util;

import android.os.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.SimpleDateFormat;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.android.LogcatAppender;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;


public class LogCustom {
	
	private final static SimpleDateFormat sdfF = new SimpleDateFormat("dd/MM/yyyy");
	private final static SimpleDateFormat sdfH = new SimpleDateFormat("hh:mm:ss");
	
	public static void error(String clase, String usuario, String imei, Exception e)
	{
		configureLogbackDirectly();
		
		Logger LOG = LoggerFactory.getLogger(LogCustom.class);
	    //LOG.info("hello world");
		
		String msg 				= "";
		String logUsuario 		= usuario != null ? usuario : "";
		String logImei 			= imei;
		String logClase			= clase;
		String logFechaHora		= sdfF.format(new java.util.Date()) + " - " + sdfH.format(new java.util.Date());
		String logTipoError		= e.getClass().getSimpleName();
		String logCausaError	= e.getMessage();
		
		msg += "\n";
		msg += "Usuario           : " + logUsuario + "\n";
		msg += "Imei              : " + logImei + "\n";
		msg += "Clase             : " + logClase + "\n";
		msg += "Fecha y Hora      : " + logFechaHora + "\n";
		msg += "Tipo de error     : " + logTipoError + "\n";
		msg += "Causa del error   : " + logCausaError + "\n";
		
		StackTraceElement[] stackTrace = e.getStackTrace();
		
		if(stackTrace != null) 
		{
			msg += "Detalle del error : \n";
			StackTraceElement stackTraceElement = null;
			
			msg += e.getClass().getName() + ": " + e.getLocalizedMessage() + "\n";
			
			for (int i = 0; i < stackTrace.length; i++) {
				stackTraceElement = stackTrace[i];
				if(stackTraceElement.toString().contains("pe.com.pension65")){
					msg +=  "\t" + stackTraceElement.toString() + "\n";
				}
			}
		}
		
		LOG.info(msg);
		
	}
	
	private static void configureLogbackDirectly() {
		
		String baseDirSdCard1 = Environment.getExternalStorageDirectory().getAbsolutePath();
		
		try{
			String rutaLog = baseDirSdCard1 + File.separator + "Log" + File.separator + "Ayza.log";
			// reset the default context (which may already have been initialized)
		    // since we want to reconfigure it
			LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
		    lc.reset();
	
		    // setup FileAppender
		    PatternLayoutEncoder encoder1 = new PatternLayoutEncoder();
		    encoder1.setContext(lc);
		    encoder1.setPattern("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
		    encoder1.start();
		    
		    //String baseDirSdCard1 = Environment.getExternalStorageDirectory().getAbsolutePath();
		    
		    FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
		    fileAppender.setContext(lc);
		    //fileAppender.setFile(this.getFileStreamPath("app.log").getAbsolutePath());
		    //fileAppender.setFile("/data/data/pe.com.pension65.ayza.activity/log/ayza.log");
		    
		    fileAppender.setFile(rutaLog);
		    
		    fileAppender.setEncoder(encoder1);
		    fileAppender.start();
	
		    // setup LogcatAppender
		    PatternLayoutEncoder encoder2 = new PatternLayoutEncoder();
		    encoder2.setContext(lc);
		    encoder2.setPattern("[%thread] %msg%n");
		    encoder2.start();
	
		    LogcatAppender logcatAppender = new LogcatAppender();
		    logcatAppender.setContext(lc);
		    logcatAppender.setEncoder(encoder2);
		    logcatAppender.start();
	
		    // add the newly created appenders to the root logger;
		    // qualify Logger to disambiguate from org.slf4j.Logger
		    ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		    root.addAppender(fileAppender);
		    root.addAppender(logcatAppender);
		}catch(Exception ex){
		
			ex.printStackTrace();
		
		}
		
	}
}
