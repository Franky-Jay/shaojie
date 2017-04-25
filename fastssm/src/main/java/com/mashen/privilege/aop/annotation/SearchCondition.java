package com.mashen.privilege.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 查询条件封装类型
 * @author liushd
 *
 */
@Target(ElementType.PARAMETER)  
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SearchCondition {
	SearchConditionType value();
}
