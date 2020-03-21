package br.com.siberius.siberiusevent.model.enums;

public enum StatusInscricao {
	
	DEFERIDO("deferido"),
	INDEFERIDO("indeferido"),
	CANCELADO("cancelado");
	

	private String status;

	private StatusInscricao(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
	
