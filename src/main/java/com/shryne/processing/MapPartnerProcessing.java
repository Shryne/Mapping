package com.shryne.processing;

import com.shryne.annotation.Map;
import com.shryne.annotation.MapPartner;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import java.util.Set;

@SupportedAnnotationTypes("com.something.Processing.MapPartner")
@SupportedSourceVersion(SourceVersion.RELEASE_0)
public final class MapPartnerProcessing extends AbstractProcessor {
    @Override
    public boolean process(
        final Set<? extends TypeElement> annotations,
        final RoundEnvironment roundEnv
    ) {
        final var filer = processingEnv.getFiler();
        final var elements = roundEnv.getElementsAnnotatedWith(
            MapPartner.class
        );

        for (final Element e : elements) {
            if (e instanceof TypeElement) {
                final var annotated = (TypeElement) e;
                try {
                    final Class<?> clazz = annotated.getAnnotation(
                        MapPartner.class
                    ).value();
                } catch (final MirroredTypeException mte) {
                    final var partnerType = (TypeElement) processingEnv
                        .getTypeUtils()
                        .asElement(mte.getTypeMirror());
                    new MapClass(partnerType).write(filer);
                }
            }
        }

        return false;
    }
}
