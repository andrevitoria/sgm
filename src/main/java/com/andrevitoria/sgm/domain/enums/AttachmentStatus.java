package com.andrevitoria.sgm.domain.enums;

public enum AttachmentStatus {
	SENDED(1, "Enviado"), 
	APPROVED(2, "Aprovado"),
	REFUSED(3, "Recusado");
	
	private int id;
	private String val;

	private AttachmentStatus(int id, String val) {
		this.id = id;
		this.val = val;
	}

	public int getId() {
		return id;
	}

	public String getVal() {
		return val;
	}

	public static AttachmentStatus toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (AttachmentStatus x : AttachmentStatus.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido" + id);
	}
}
