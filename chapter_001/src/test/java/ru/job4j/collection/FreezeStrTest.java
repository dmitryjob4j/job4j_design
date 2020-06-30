package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collectoin.FreezeStr;

import java.util.Date;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тестовые задания. Проверить две строчки на идентичность.
 * Проверить две строчки на идентичность.[#273008]
 * тесты
 *
 * @author DStepanov haoos@inbox.ru
 * @version 1
 * @since 29.06.2020.
 */
public class FreezeStrTest {
    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }

    @Test
    public void whenEqlonntString() {
        String left = "C:*Program Files*Java*jdk-14.0.1*bin*java.exe* -ea -Didea.test.cyclic.buffer.size=1048576 *-javaagent:C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*lib*idea_rt.jar=64661:C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*bin* -Dfile.encoding=UTF-8 -classpath *C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*lib*idea_rt.jar;C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*plugins*junit*lib*junit5-rt.jar;C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*plugins*junit*lib*junit-rt.jar;C:*projects*job4j_design*chapter_001*target*test-classes;C:*projects*job4j_design*chapter_001*target*classes;C:*Users*d.stepanov*.m2*repository*junit*junit*4.12*junit-4.12.jar;C:*Users*d.stepanov*.m2*repository*org*hamcrest*hamcrest-core*1.3*hamcrest-core-1.3.jar* com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 ru.job4j.collection.FreezeStrTest";
        String right = "C:*Program Files*Java*jdk-14.0.1bin**java.exe* -ea -Didea.test.cyclic.buffer.size=1048576 *-javaagent:C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*lib*idea_rt.jar=64661:C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*bin* -Dfile.encoding=UTF-8 -classpath *C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*lib*idea_rt.jar;C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*plugins*junit*lib*junit5-rt.jar;C:*Program Files*JetBrains*IntelliJ IDEA Community Edition 2019.3.3*plugins*junit*lib*junit-rt.jar;C:*projects*job4j_design*chapter_001*target*test-classes;C:*projects*job4j_design*chapter_001*target*classes;C:*Users*d.stepanov*.m2*repository*junit*junit*4.12*junit-4.12.jar;C:*Users*d.stepanov*.m2*repository*org*hamcrest*hamcrest-core*1.3*hamcrest-core-1.3.jar* com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 ru.job4j.collection.FreezeStrTest";
        assertThat(FreezeStr.eq(left, right), is(true));
    }
}
