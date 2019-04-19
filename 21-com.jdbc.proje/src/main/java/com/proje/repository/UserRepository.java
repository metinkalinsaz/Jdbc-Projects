package com.proje.repository;

import java.util.List;

import com.proje.model.Usermy;
/**
 * @author MetinKalinsaz
 */
public interface UserRepository {

	Usermy saveUser(Usermy usermy); // user'� kaydedecegiz ve Bastak� users dan gelen return bilgilerin� baska
									// sayfada kullanab�l�r�z

	Usermy updateUser(Usermy usermy); // Bir user bilgilerini g�ncelliyoruz

	boolean deleteUser(int id); // Bir user siliyoruz

	Usermy findUserById(int id); // Bir user� buluyoruz

	List<Usermy> findUser(); // T�m user'lar�n listesini al�yoruz
}
