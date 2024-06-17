package homeWorc;

public class Main {

    public static void main(String[] args) {

        ServiceCheckCredentials serviceCheckCredentials = new ServiceCheckCredentialsImpl("111","222","333");

        try {
            serviceCheckCredentials.checkAgainstRequirements("praha_&_1989","555_eOLЯYA","555_OLYA");
            System.out.println("Введены корректные данные.");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Неверный логин или пароль. Повторите ввод.");
            e.printStackTrace();
        }

    }
}

/*
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