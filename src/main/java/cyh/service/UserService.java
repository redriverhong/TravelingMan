package cyh.service;

import cyh.vo.user;

public interface UserService {
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	public user getUserById(String id);
	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 */
	public user getUserByUserName(String name);
	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return (true:已存在)
	 */
	public boolean getUserByName(String name);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public void insertUser(String username,String password,String emailOrTel);
	/**
	 * 用户登录校验
	 * @param name
	 * @param password
	 * @return 
	 */
	public boolean checkUser(String name,String password);
	/**
	 * 检查邮箱是否已注册
	 * @param email
	 * @return (true:已注册)
	 */
	public boolean checkByEmail(String email);
	/**
	 * 邮箱或tel与验证码校验
	 * @param email
	 * @param code
	 * @return (true:验证通过)
	 */
	public boolean checkEmailOrTelCode(String emailOrTel,String code);
	/**
	 * 检查电话号码是否已注册
	 * @param email
	 * @return (true:已注册)
	 */
	public boolean checkByTel(String email);
	/**
	 * 跟新用户信息
	 * @param user
	 * @return 
	 */
	public void updateUser(user user);
}