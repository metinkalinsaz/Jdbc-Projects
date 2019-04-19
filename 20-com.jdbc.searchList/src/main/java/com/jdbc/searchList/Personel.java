package com.jdbc.searchList;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 * @author MetinKalinsaz
 */
@Data
@Getter
@Setter
public class Personel {

	private int id;
	private String adi;
	private String soyadi;
	private int numarasi;

	public Personel() {

	}

	public Personel(int id, String adi, String soyadi, int numarasi) {
		super();
		this.id = id;
		this.adi = adi;
		this.soyadi = soyadi;
		this.numarasi = numarasi;
	}

	

	@Override
	public String toString() {
		return "Personel [id=" + id + ", adi=" + adi + ", soyadi=" + soyadi + ", numarasi=" + numarasi + "]";
	}

}
