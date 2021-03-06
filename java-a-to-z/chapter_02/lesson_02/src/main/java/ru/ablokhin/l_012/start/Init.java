package ru.ablokhin.l_012.start;

/**
 * Class Init инициализирует работу с заявками
 * @author ablokhin
 * @since 24.08.2016
 * @version 3
 */
public class Init {

    /* инициализация ключа действия пользователя*/
    private int key;

    /**
     * Метод init() инициализирует работу с заявками
     */
    void init(){

        /* Инициализация трекера*/
        Tracker tracker = new Tracker();

        /* Инициализация ввода*/
        ConsoleInput consoleInput = new ValidateInput();

        /* Инициализация меню*/
        Menu menu = new Menu(consoleInput, tracker);

        /* Приветствие*/
        System.out.println(menu.getGreeting());

        /* Описание программы*/
        System.out.println(menu.getDescription());

        /* Заполнение меню массивом действий пользователя*/
        UserAction[] actionRange = menu.fillActions();
        UserAction someAction = new UserAction() {
            @Override
            public int key() {
                return 3;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                //some execute
            }

            @Override
            public String info() {
                return "8. Some Action";
            }
        };
        menu.addAction(someAction);
        do {
            /* Вывод меню*/
            menu.show();

            /* Осуществление действия по выбору пользователя*/
            key = consoleInput.ask("Enter The Number 0-7 To Select The Menu Item, Please: ", actionRange);
            menu.select(key);

        }while( key != 0 );
    }
}
