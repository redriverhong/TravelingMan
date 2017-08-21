package cyh.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cyh.dao.userMapper;

import cyh.redis.RedisDao;
import cyh.service.UserService;
import cyh.util.CheckUtil;
import cyh.util.RandomId;
import cyh.util.SHAUtil;
import cyh.vo.user;

@Service("userService")
public class UserServiceImpl implements UserService {
	private userMapper userMapper;
	public userMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(userMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public user getUserById(String id) {
		user u=userMapper.selectByPrimaryKey(id);
		return u;
	}
	@Override
	public boolean getUserByName(String name) {
		boolean b=false;
		user u=userMapper.selectByName(name);
		if(u!=null){
			b=true;
		}
		return b;
	}
	@Override
	public void insertUser(String username,String password,String emailOrTel) {
		user u=userMapper.selectByName(username);
		if(u==null){
			user user=new user();
			user.setId(RandomId.getId());
			user.setName(username);
			user.setPassword(SHAUtil.getEncrypted(password));
			user.setCreatetime(CheckUtil.getStringDate(new Date()));
			if(CheckUtil.CheckEmail(emailOrTel)){
				user.setEmail(emailOrTel);
			}else{
				user.setTel(emailOrTel);
			}
			userMapper.insertSelective(user);
		}
	}
	@Override
	public boolean checkUser(String name, String password) {
		boolean b=false;
		user u=userMapper.selectByName(name);
		if(u!=null){
			if(SHAUtil.getEncrypted(password).equals(u.getPassword())){
				b=true;
			}
		}
		return b;
	}
	@Override
	public boolean checkByEmail(String email) {
		user u=userMapper.selectByEmail(email);
		if(u!=null){
			return true;
		}
		return false;
	}
	@Override
	public boolean checkByTel(String tel) {
		user u = userMapper.selectByTel(tel);
		if(u!=null){
			return true;
		}
		return false;
	}
	@Override
	public boolean checkEmailOrTelCode(String emailOrTel, String code) {
		if(code!=null||code!=""){
			String ecode=SHAUtil.getEncrypted(code);
			if(ecode.equals(RedisDao.getCode(emailOrTel))){
				return true;
			}
		}
		return false;
	}
	@Override
	public user getUserByUserName(String name) {
		user u=userMapper.selectByName(name);
		return u;
	}
	@Override
	public void updateUser(user user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
}
