package com.neo.config;


import org.springframework.cache.annotation.CachingConfigurerSupport;

import org.springframework.cache.annotation.EnableCaching;

import org.springframework.cache.interceptor.KeyGenerator;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.connection.RedisConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.serializer.StringRedisSerializer;

import org.springframework.session.SessionRepository;

import org.springframework.session.data.redis.RedisOperationsSessionRepository;




/**

 *  redis 配置

 *

 * @author WangBin

 * @version V1.0

 * @date 2017.12.05

 */

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**

     *  设置 redisTemplate 序列化方式

     * @param factory

     * @return

     */

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(factory);

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.afterPropertiesSet();

        return redisTemplate;

    }





    /**

     * 设置spring session redis 序列化方式

     * @param factory

     * @return

     */

    @Bean

    public SessionRepository sessionRepository(RedisConnectionFactory factory){

        RedisOperationsSessionRepository sessionRepository =  new RedisOperationsSessionRepository(redisTemplate(factory));

        sessionRepository.setDefaultMaxInactiveInterval(36000);

        return sessionRepository;

    }

}
