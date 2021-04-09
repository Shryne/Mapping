package com.shryne.processing;

import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * Models the method that will map the objects.
 */
public class MapMethod {
    private final TypeElement source;
    private final TypeElement target;

    public MapMethod(final TypeElement source, final TypeElement target) {
        this.source = source;
        this.target = target;
    }

    public void write(final Filer filer) {
        final var sourceName = source.getSimpleName();
        final var targetName = target.getSimpleName();

        MethodSpec.methodBuilder("map")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC);
    }
}
