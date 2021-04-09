package com.shryne.processing;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.jupiter.api.Test;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

/**
 * Basic is a type of mapping where only {@link com.shryne.annotation.Map} is
 * used with the default setting. Example:
 * <pre>
 * {@code
 * @MapPartner(BClass.class)
 * public class AClass {
 *   @Map private int a;
 *   // getter & setter ...
 * }
 *
 * public class BClass {
 *   @Map private int a; // same name as in AClass
 *   // getter & setter ...
 * }
 * }
 * </pre>
 */
public final class BasicTest {
    @Test
    public void singleVariable() {
        final Compilation compilation = javac()
            .withProcessors(new MapPartnerProcessing())
            .compile(
                JavaFileObjects.forResource("basic/one-value/User.java"),
                JavaFileObjects.forResource("basic/one-value/Benutzer.java")
            );
        assertThat(compilation).succeeded();
        assertThat(compilation)
            .generatedSourceFile("com.ToUser")
            .hasSourceEquivalentTo(
                JavaFileObjects.forResource("basic/one-value/ToUser.java")
            );
        assertThat(compilation)
            .generatedSourceFile("com.ToBenutzer")
            .hasSourceEquivalentTo(
                JavaFileObjects.forResource("basic/one-value/ToBenutzer.java")
            );
    }
}
