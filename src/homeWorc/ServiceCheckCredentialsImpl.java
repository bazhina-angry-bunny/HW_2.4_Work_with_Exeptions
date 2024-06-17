package homeWorc;

import java.util.Objects;

public class ServiceCheckCredentialsImpl implements ServiceCheckCredentials {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    // private static final String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_";
    private String login;
    private String password;
    private String confirmPassword;

    public ServiceCheckCredentialsImpl(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "login " + login + " "
                + "password " + password + " "
                + "input password" + confirmPassword;

    }

    // ставим ! - знак отрицания, то есть если выражение, написанное после него становится обратным. с отрицанием "не".
    public void checkAgainstRequirements(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Количество символов в логине более 20");
        }
        if (!login.matches(REGEX)){
            throw new WrongLoginException("Логин содержит недопустимые символы");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Количество символов в пароле более 20");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Введен неверный пароль");
        }
    }


    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceCheckCredentialsImpl service = (ServiceCheckCredentialsImpl) o;
        return Objects.equals(login, service.login) && Objects.equals(password, service.password) && Objects.equals(confirmPassword, service.confirmPassword);
    }
    @Override
    public int hashCode() {
        return Objects.hash(login, password, confirmPassword);
    }
}

/*
- Критерии оценки
    - Статический метод принимает на вход три параметра
    - Метод принимает параметр Login , содержащий в себе только латинские буквы, цифры и знак подчеркивания
    - Метод принимает параметр Password , содержащий в себе только латинские буквы, цифры и знак подчеркивания
    - Если параметр Login содержит недопустимые символы или их длина больше 20 символов, то выбрасывается ошибка `WrongLoginException`
    - Если параметр Password содержит недопустимые символы или их длина больше 20 символов, то выбрасывается ошибка `WrongPasswordException`
    - Если параметры Password и confirmPassword  не равны, выбрасывается ошибка `WrongPasswordException`.
    - Исключения обработаны в multi-catch block.

1. Напишите статический метод, который принимает на вход три параметра: login, password и confirmPassword.
2. Параметр Login содержит в себе только латинские буквы, цифры и знак подчеркивания.
*Например, java_skypro_go.* У параметра login есть ограничение по длине – он должен быть равен или меньше 20 символов. Если login длиннее 20 символов или содержит в себе недопустимые
символы, то необходимо выбросить исключение – `WrongLoginException`.
3. Параметр Password содержит в себе только латинские буквы, цифры и знак подчеркивания. *Например, D_1hWiKjjP_9.* Если password длиннее 20 символов или содержит в себе недопустимые
символы, то необходимо выбросить исключение – `WrongPasswordException`.
4. Параметры password и confirmPassword должны быть равны. Если это требование не соблюдается, то нужно выбросить `WrongPasswordException`.
5. Для обработки исключений используйте multi-catch block.
6. Метод ничего не должен возвращать, если значения параметров подходят под ограничения,  или бросать исключение, если условия не выполняются.
7. При вызове метода необходимо обработать потенциальные исключения.

- Подсказка 1
Задание можно выполнить при помощи знаний, которые вы получили на данный момент: циклы и строки. Нужно задать строку/массив разрешенных символов, и, используя проверку в цикле, определить, содержит ли проверяемая строка неразрешенные символы.
А еще есть альтернативный способ решения — с помощью регулярных выражений. Но этот способ — продвинутый и не обязательный.

- Подсказка 2
    ```java
    *try {//Блок кода, в котором должны отслеживаться ошибки
    }catch (тип_исключения_1 объект_исключения) {
    	//Обработка исключения тип_исключения_1// }

    catch (тип_исключения_2 объект_исключения) {
    //Обработка исключения тип_исключения_2
    }
    // ...
    finally
    //блок кода, который должен быть непременно выполнен по завершении блока try
    }*
    ```
 */