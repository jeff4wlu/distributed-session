package com.neo.service.impl;

import com.neo.entity.UserInfo;
import com.neo.repository.UserInfoRepository;
import com.neo.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoRepository userInfoRepository;

    @Transactional(readOnly=true)
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }

}