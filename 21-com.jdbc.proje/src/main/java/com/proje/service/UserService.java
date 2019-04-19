package com.proje.service;

import java.util.List;

import com.proje.model.Usermy;
/**
 * @author MetinKalinsaz
 */
public interface UserService {

	Usermy saveUser(Usermy usermy); // user'� kaydedecegiz ve Bastak� users dan gelen return bilgilerin� baska
									// sayfada kullanab�l�r�z

	Usermy updateUser(Usermy usermy); // Bir user bilgilerini g�ncelliyoruz

	boolean deleteUser(int userId); // Bir user siliyoruz

	Usermy findUserById(int userId); // Bir user� buluyoruz

	List<Usermy> findUsers();
}
