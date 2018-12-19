package com.neo.service;

import com.neo.entity.UserInfo;

public interface UserInfoService {

    public UserInfo findByUsername(String username);

}
