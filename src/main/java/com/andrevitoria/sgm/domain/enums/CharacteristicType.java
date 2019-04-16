package com.andrevitoria.sgm.domain.enums;

public enum CharacteristicType {
	TEXT(1, "Texto"), 
	CURRENCY(2, "Moeda"),
	INTERGER(3, "Inteiro");
	
	private int id;
	private String val;

	private CharacteristicType(int id, String val) {
		this.id = id;
		this.val = val;
	}

	public int getId() {
		return id;
	}

	public String getVal() {
		return val;
	}

	public static CharacteristicType toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (CharacteristicType x : CharacteristicType.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido" + id);
	}
}
