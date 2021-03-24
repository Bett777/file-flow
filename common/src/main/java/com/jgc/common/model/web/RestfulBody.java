package com.jgc.common.model.web;

import java.lang.annotation.*;

/**
 * @author ThinkPad
 */
@Target({ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RestfulBody {
}
