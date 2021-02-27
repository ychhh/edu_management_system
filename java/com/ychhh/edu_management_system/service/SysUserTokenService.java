/**
 * Copyright 2018 navict
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ychhh.edu_management_system.service;


import com.ychhh.edu_management_system.constants.RedisKeys;
import com.ychhh.edu_management_system.entity.SysUser;
import com.ychhh.edu_management_system.utils.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
public class SysUserTokenService {

    @Autowired
    RedisUtils<SysUser> redisUtils;

    /**用户登陆过期时间*/
    private int expireInMinutes = 60;

    private ThreadLocal<String> currentUserToken;

    /**
     * 把用户token存入ThreadLocal
     * @param token
     */
    public void setTokenToThread(String token){
        if(StringUtils.isBlank(token)) return;
        if(currentUserToken == null) currentUserToken = new ThreadLocal<>();
        currentUserToken.set(token);
    }

    /**
     * 从ThreadLocal中获取当前用户的token
     * @return
     */
    public String getTokenFromThread(){
        if(currentUserToken == null) return null;
        return currentUserToken.get();
    }

    /**
     * 从ThreadLocal中清除当前用户的token
     */
    public void clearTokenFromThread(){
        if(currentUserToken == null) return;
        currentUserToken.remove();
    }

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    public SysUser getUserByToken(String token) {
        String key = RedisKeys.USER_TOKEN_PREFIX+token;
        return redisUtils.get(key);
    }

    /**
     * 获取当前线程下的用户信息
     * @return
     */
    public SysUser getUser(){
        String token = getTokenFromThread();
        if(StringUtils.isBlank(token)) return null;
        return getUserByToken(token);
    }


    /**
     * 刷新登陆过期时间
     * @param token
     */
    public void refreshLoginExpire(String token){
        String key = RedisKeys.USER_TOKEN_PREFIX+token;
        redisUtils.expire(key,expireInMinutes,TimeUnit.MINUTES);
    }

    /**
     * 创建用户token,保存用户session
     * @param user
     * @return
     */
    public String createToken(SysUser user) {
        String token = generateToken();
        saveUser(token,user);
        return token;
    }

    private void saveUser(String token ,SysUser user){
        if(StringUtils.isBlank(token) || user == null) return;
        String key = RedisKeys.USER_TOKEN_PREFIX+token;
        redisUtils.set(key,user);
        redisUtils.expire(key,expireInMinutes,TimeUnit.MINUTES);
    }

    /**
     * 退出登陆状态
     * @param token
     */
    public void expireToken(String token){
        redisUtils.delete(RedisKeys.USER_TOKEN_PREFIX+token);
    }

    private String generateToken(){
        return UUID.randomUUID().toString().replace("-", "");
    }


    public int getExpireInMinutes() {
        return expireInMinutes;
    }

    public void setExpireInMinutes(int expireInMinutes) {
        this.expireInMinutes = expireInMinutes;
    }
}
