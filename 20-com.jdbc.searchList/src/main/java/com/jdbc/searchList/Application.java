package com.jdbc.searchList;

import java.util.List;

public class Application {

	/**
	 * @author MetinKalinsaz
	 */

	public static void main(String[] args) {

		PStatementBatch pStatementBatch = new PStatementBatch();
		List<Personel> personels = pStatementBatch.findPersonels();
		personels.forEach(System.out::println);

	}
}
