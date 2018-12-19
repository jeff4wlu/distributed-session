package com.neo.repository;

import com.neo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    /** 通过username查找用户信息 **/
    public UserInfo findByUsername(String username);

}
