package com.shryne.processing;

import com.shryne.annotation.Map;
import com.shryne.annotation.MapPartner;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * Models the class that will map an object to another.
 */
public class MapClass {
    private final TypeElement element;
    private final MapPartner mapPartner;

    public MapClass(final TypeElement element) {
        this.element = element;
        mapPartner = element.getAnnotation(MapPartner.class);
    }

    public void write(final Filer filer) {
        final var enclosedElements = element.getEnclosedElements().
            stream().filter(it -> it.getAnnotation(Map.class) != null);

        final TypeSpec.Builder result = TypeSpec.classBuilder(
            "To" + mapPartner.value().getSimpleName()
        ).addModifiers(Modifier.PUBLIC)
        .addMethod(
            MethodSpec
                .constructorBuilder()
                .addModifiers(Modifier.PRIVATE)
                .build()
        );
    }
}
