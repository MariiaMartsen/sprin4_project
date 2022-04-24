import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UnSuccessAccountTest {

    private final String name;
    private final String errorMessage;


    public UnSuccessAccountTest(String name, String errorMessage) {
        this.name = name;
        this.errorMessage = errorMessage;
    }

    @Parameterized.Parameters(name = "Тестовые данные – {0} {1}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {null, "Success print with null"},
                {"ИмяФамилия", "Success print without space"},
                {"Имя Фам ил ия", "Success print with 3 spaces"},
                {" ИмФамилия", "Success print with space on the start"},
                {"ИмФамилия ", "Success print with space in the end"},
                {"", "Success print with no symbols"},
                {"nj", "Success print with 2 symbols"},
                {"Имя ФамилияИмяФамилия", "Unsuccess print with name with one space and max count - 19"}
        };
    }

    @DisplayName("Check unsuccess creation account with uncorrect name")
    @Test
    public void unSuccessCreation() {
        Account account = new Account(name);
        assertFalse(errorMessage, account.checkNameToEmboss());
    }

}
