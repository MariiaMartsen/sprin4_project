import io.qameta.allure.Step;

public class Account {

    private String name;
    private int spaceCount;

    public Account(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
        if (name != null) {
            for (char c : name.toCharArray()) {
                if (c == ' ') {
                    spaceCount++;
                }
            }
        } else {
            this.spaceCount = 0;
        }
    }

    @Step("Check name for embossing tape")
    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name == null) {
            return false;
        }

        boolean hasRightNumberOfSymbols = (name.length() >= 3) && (name.length() <= 19);
        boolean hasSpacesNotAtStartAndEnd = (!name.startsWith(" ")) && (!name.endsWith(" "));
        boolean hasSingleSpace = spaceCount == 1;

        if (hasRightNumberOfSymbols & hasSingleSpace  & hasSpacesNotAtStartAndEnd) {
            return true;
        }
        return false;
    }
}