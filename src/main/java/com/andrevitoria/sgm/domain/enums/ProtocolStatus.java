package com.andrevitoria.sgm.domain.enums;

public enum ProtocolStatus {
	OPENED(1, "Protocolo Aberto"), CLOSED(2, "Protocolo Encerrado");
	private int id;
	private String val;

	private ProtocolStatus(int id, String val) {
		this.id = id;
		this.val = val;
	}

	public int getId() {
		return id;
	}

	public String getVal() {
		return val;
	}

	public static ProtocolStatus toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (ProtocolStatus x : ProtocolStatus.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido" + id);
	}
}
