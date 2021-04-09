package com.shryne.processing;

import com.shryne.annotation.Map;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;

/**
 * Models the property that will be mapped to another.
 */
public class MapProperty {
    /**
     * @param element The element that is anotated with
     * {@link com.shryne.annotation.Map}. Other elements will lead to an
     * {@link IllegalArgumentException}.
     */
    public MapProperty(final Element element) {
        final Map map = element.getAnnotation(Map.class);
        if (map == null) {
            throw new IllegalArgumentException(
                "The given argument must be annotated with the Map annotation."
            );
        }
    }

    public void write(final Filer filer) {

    }
}
