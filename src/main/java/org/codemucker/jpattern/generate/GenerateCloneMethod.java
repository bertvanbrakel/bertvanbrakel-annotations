package org.codemucker.jpattern.generate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@IsGeneratorConfig(defaultGenerator="org.codemucker.jmutate.generate.bean.CloneGenerator")
public @interface GenerateCloneMethod {

	boolean markGenerated() default true;

	boolean enabled() default true;

	/**
	 * If true inherit super class properties. Default false
	 * 
	 * TODO
	 */
	boolean inheritParentProperties() default false;
	
	/**
	 * Name of the clone method
	 */
	String methodName() default "newInstanceOf";

	/**
	 * The fields to match. Default is empty which means all
	 */
	String fieldNames() default "";

	/**
     * What to do if a builder method already exists which is not marked as under this generators control
     */
    ClashStrategy clashStrategy() default ClashStrategy.SKIP;
    
}
