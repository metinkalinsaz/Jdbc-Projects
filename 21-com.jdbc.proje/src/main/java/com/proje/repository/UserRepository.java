package com.proje.repository;

import java.util.List;

import com.proje.model.Usermy;
/**
 * @author MetinKalinsaz
 */
public interface UserRepository {

	Usermy saveUser(Usermy usermy); // user'ý kaydedecegiz ve Bastaký users dan gelen return bilgileriný baska
									// sayfada kullanabýlýrýz

	Usermy updateUser(Usermy usermy); // Bir user bilgilerini güncelliyoruz

	boolean deleteUser(int id); // Bir user siliyoruz

	Usermy findUserById(int id); // Bir userý buluyoruz

	List<Usermy> findUser(); // Tüm user'larýn listesini alýyoruz
}
