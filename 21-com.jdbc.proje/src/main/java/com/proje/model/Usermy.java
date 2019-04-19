package com.proje.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author MetinKalinsaz
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usermy {

	private int usersId;
	private String firstName;
	private String lastName;
	private Date birthOfDate;
	private String userName;
}
