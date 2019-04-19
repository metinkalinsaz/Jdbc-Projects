package com.proje.service;

import java.util.List;

import com.proje.model.Usermy;
/**
 * @author MetinKalinsaz
 */
public interface UserService {

	Usermy saveUser(Usermy usermy); // user'ý kaydedecegiz ve Bastaký users dan gelen return bilgileriný baska
									// sayfada kullanabýlýrýz

	Usermy updateUser(Usermy usermy); // Bir user bilgilerini güncelliyoruz

	boolean deleteUser(int userId); // Bir user siliyoruz

	Usermy findUserById(int userId); // Bir userý buluyoruz

	List<Usermy> findUsers();
}
