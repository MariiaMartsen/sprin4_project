import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test
    public void unSuccessCreationWithNull() {
        String name = null;
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void successCreation() {
        String name = "Имя Фамилия";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void successCreationWithMinimalCount() {
        String name = "И Ф";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void successCreationWithMaxCount() {
        String name = "Имя Фамсамсамсмасма";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void unSuccessCreationWithoutSpace() {
        String name = "ИмяФамилия";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void unSuccessCreationWithSpaceMoreOneSpace() {
        String name = "Имя Фам ил ия";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void unSuccessCreationWithSpaceOnStart() {
        String name = " ИмФамилия";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void unSuccessCreationWithSpaceOnEnd() {
        String name = "ИмФамилия ";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void unSuccessCreationWithNoSymbol() {
        String name = "";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void unSuccessCreationWithSymbolLess3() {
        String name = "ey";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test //10
    public void unSuccessCreationWithSymbolMore19() {
        String name = "Имя ФамилияИмяФамилия";
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        boolean expected = false;
        assertEquals(expected, actual);
    }

}
