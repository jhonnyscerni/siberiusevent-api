package br.com.siberius.siberiusevent.model.enums;

public enum StatusEvento {
	
	LIBERADO("Liberado");

	private String status;

	private StatusEvento(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
	
