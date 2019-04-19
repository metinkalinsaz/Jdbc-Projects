package com.proje.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author MetinKalinsaz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProduct {

	private Usermy userId;
	private Product productId; // birden fazla ürünümüz varsa onlarý listeliyoruz product turunden..
	private int existing;

}
