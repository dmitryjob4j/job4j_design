package ru.job4j.find;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * 2.Уровень-Джуниор.Блок.2.Ввод-вывод.Контрольные вопросы.
 * Поиск файлов по критерию [#289015].
 * TEST ArgFind Обрабатываем входные параметры для посика
 **/
public class ArgFindTest {
    @Test
    public void allArgumentTest() {
        String[] args = new String[]{
                "-d",
                "c:/",
                "-n",
                "?pp*.java",
                "-m",
                "-o",
                "findFile.log"
        };
        ArgFind argFind = new ArgFind(args);
        assertThat(argFind.directory(), is("c:/"));
        assertThat(argFind.search(), is("?pp*.java"));
        assertThat(argFind.paramSearch(), is("-m"));
        assertThat(argFind.output(), is("findFile.log"));
    }

    @Test
    public void paramSearchFArgumentTest() {
        String[] args = new String[]{
                "-d",
                "c:/",
                "-n",
                "?pp*.java",
                "-f",
                "-o",
                "findFile.log"
        };
        ArgFind argFind = new ArgFind(args);
        assertThat(argFind.paramSearch(), is("-f"));
    }

    @Test
    public void paramSearchRArgumentTest() {
        String[] args = new String[]{
                "-d",
                "c:/",
                "-n",
                "?pp*.java",
                "-r",
                "-o",
                "findFile.log"
        };
        ArgFind argFind = new ArgFind(args);
        assertThat(argFind.paramSearch(), is("-r"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void argsParamIsEmptu() {
        String[] args = new String[]{"-d"};
        ArgFind argFind = new ArgFind(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void argsParamDerictoryIllegal() {
        String[] args = new String[]{
                "-d",
                "cpf",
                "-n",
                "?pp*.java",
                "-m",
                "-o",
                "findFile.log"
        };
        ArgFind argFind = new ArgFind(args);
        argFind.valid();
    }

    @Test(expected = IllegalArgumentException.class)
    public void argsParamMaskIllegal() {
        String[] args = new String[]{
                "-d",
                "c:/",
                "-n",
                "",
                "-m",
                "-o",
                "findFile.log"
        };
        ArgFind argFind = new ArgFind(args);
        argFind.valid();
    }

    @Test(expected = IllegalArgumentException.class)
    public void argsParamSearchIllegal() {
        String[] args = new String[]{
                "-d",
                "c:/",
                "-n",
                "*java*",
                "",
                "-o",
                "findFile.log"
        };
        ArgFind argFind = new ArgFind(args);
        argFind.valid();
    }

    @Test(expected = IllegalArgumentException.class)
    public void argsParamFileSaveIllegal() {
        String[] args = new String[]{
                "-d",
                "c:/",
                "-n",
                "*java*",
                "",
                "-o",
                ""
        };
        ArgFind argFind = new ArgFind(args);
        argFind.valid();
    }
}
