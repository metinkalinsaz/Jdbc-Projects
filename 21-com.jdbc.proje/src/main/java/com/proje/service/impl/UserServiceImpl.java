package com.proje.service.impl;

import java.util.List;

import com.proje.model.Usermy;
import com.proje.repository.UserRepository;
import com.proje.repository.impl.UserRepositoryImpl;
import com.proje.service.UserService;
/**
 * @author MetinKalinsaz
 */
public class UserServiceImpl implements UserService {

	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public Usermy saveUser(Usermy usermy) {

		return userRepository.saveUser(usermy);
	}

	@Override
	public Usermy updateUser(Usermy usermy) {
		return userRepository.updateUser(usermy);
	}

	@Override
	public boolean deleteUser(int userId) {
		return userRepository.deleteUser(userId);
	}

	@Override
	public Usermy findUserById(int userId) {
		return userRepository.findUserById(userId);
	}

	@Override
	public List<Usermy> findUsers() {
		return userRepository.findUser();
	}

}
