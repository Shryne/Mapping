package com.shryne.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies for which class the mappers shall be created. This results in the
 * generation of two classes: One to map the annotated class to the class
 * given in {@link #value()} and one to map from this class. Example:
 * <pre>
 * {@code
 * @MapPartner(BClass.class)
 * public class AClass { ... }
 *
 * // results in two new classes: ToBClass, ToAClass
 * }
 * </pre>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapPartner {
    /**
     * Specifies from and to which class this class shall be mapped to.
     * @return The class to generate mappers for.
     */
    Class<?> value();
}
