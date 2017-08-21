package cyh.dao;

import cyh.vo.user;

public interface userMapper {
    int deleteByPrimaryKey(String id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
    
    user selectByName(String name);
    
    user selectByEmail(String email);
    
    user selectByTel(String tel);
    
}