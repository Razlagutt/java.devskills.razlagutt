package ru.ablokhin.l_012.start;

/**
 * Class ValidateInput обрабатывает ввод пользовательских данных
 * @author ablokhin
 * @since 10.02.2017
 * @version 1
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Перегруженный унаследованный метод ask задает вопрос пользователю
     * @param question вопрос пользователю
     * @param actionRange массив ответов
     * @return возвращает ключ ответа из массива ответов
     */
    public int ask(String question, UserAction[] actionRange) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, actionRange);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("\nThere Is No This Item In The Menu!\n");
            } catch (NumberFormatException nfe){
                System.out.println("\nPlease Enter Validate Data Again!\n");
            }
        } while(invalid);
        return value;
    }
}
