import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SuccessAccountTest {

    private final String name;
    private final String errorMessage;


    public SuccessAccountTest(String name, String errorMessage) {
        this.name = name;
        this.errorMessage = errorMessage;
    }

    @Parameterized.Parameters(name = "Тестовые данные – {0} {1}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Имя Фамилия", "Unsuccess print with name with one space"},
                {"И Ф", "Unsuccess print with name with one space and min count - 3"}
        };
    }

    @DisplayName("Check success creation account with correct name")
    @Test
    public void SuccessCreation() {
        Account account = new Account(name);
        assertTrue(errorMessage, account.checkNameToEmboss());
    }


}
