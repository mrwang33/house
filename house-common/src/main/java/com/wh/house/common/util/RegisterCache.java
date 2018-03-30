package com.wh.house.common.util;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RegisterCache {
    private final Cache<Object, Object> build = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(10, TimeUnit.MINUTES).build();

    /**
     * 构建url验证字符串
     *
     * @return
     */
    public String createVerifyUrl(String email) {
        String random = RandomStringUtils.randomAlphabetic(10);
        build.put(email,random);

        return random;
    }
}
