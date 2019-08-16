package com.test.restaurant.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.restaurant.bean.User;
import com.test.restaurant.bean.Userpassword;
import com.test.restaurant.dao.UserMapper;
import com.test.restaurant.dao.UserpasswordMapper;
import com.test.restaurant.error.BusinessException;
import com.test.restaurant.error.EmError;
import com.test.restaurant.service.UserService;
import com.test.restaurant.util.Md5;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserpasswordMapper userpasswordMapper;
	
	@Override
	@Transactional
	public int addUser(User user, String password) throws BusinessException {
		if(userMapper.insertSelective(user)==1) {
			Userpassword userpassword = new Userpassword();
			userpassword.setUserid(user.getUserid());
			userpassword.setPassword(Md5.encodePassword(password, user.getEmail()));
			return userpasswordMapper.insertSelective(userpassword);
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}

	@Override
	public List<User> queryUser() {
		return userMapper.queryuser();
	}

	@Override
	@Transactional
	public int deleteByPrimaryKey(User user) throws BusinessException {
		if(userpasswordMapper.deleteByUserID(user.getUserid())==1) {
			userMapper.deleteByPrimaryKey(user.getUserid());
			return 1;
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}

	@Override
	public User getuserbyid(int userid) {
		return userMapper.getuserbyid(userid);
	}

	@Override
	public int updateuser(User user) throws BusinessException {
		if(userMapper.updateByPrimaryKeySelective(user)==1) {
			return 1;
		}else {
			throw new BusinessException(EmError.UNKNOWN_ERROR);
		}
	}

	@Override
	public List<User> getuserquery(String username) {
		String username1="%"+username+"%";
		return userMapper.getuserquery(username1);
	}

	@Override
	public String getPasswordByEmail(String email) {
		User user = userMapper.selectByEmail(email);
		if(user==null) {
			return null;
		}
		Userpassword userpassword = userpasswordMapper.selectByUserID(user.getUserid());
		return userpassword==null ? null : userpassword.getPassword();
	}
}
