

package com.ychhh.edu_management_system.annotation;

import java.lang.annotation.*;

/**
 * 登录效验- 前台会员的登录注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
