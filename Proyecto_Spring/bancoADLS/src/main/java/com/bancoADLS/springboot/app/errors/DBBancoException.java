package com.bancoADLS.springboot.app.errors;

public class DBBancoException extends RuntimeException{
	
	private static final long serialVersionUID = -5066266045243902498L;;
			
	public DBBancoException() {
		super("Contacte con la administracion, error con la base de datos");
	}

}
