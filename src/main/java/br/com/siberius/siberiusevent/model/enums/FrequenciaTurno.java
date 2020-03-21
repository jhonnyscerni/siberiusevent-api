package br.com.siberius.siberiusevent.model.enums;

public enum FrequenciaTurno {

	MANHA("Manha"),
	TARDE("Tarde"),
	NOITE("Noite");

	private String turno;

	private FrequenciaTurno(String turno) {
		this.turno = turno;
	}
	
	public String getTurno() {
		return turno;
	}

}
