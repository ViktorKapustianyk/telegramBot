package org.example.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class BotMenuHandler {
    public InlineKeyboardMarkup getMainMenu() {
        return createMenu(new String[][] {{"Кнопка 1", "Кнопка 1"},
                {"Кнопка 2", "Кнопка 2"},
                {"Далі", "Далі"}});
    }

    public InlineKeyboardMarkup getSecondMenu() {
        return createMenu(new String[][] {{"Кнопка 1", "Кнопка 1"},
                {"Кнопка 2", "Кнопка 2"},
                {"Назад", "Назад"}});
    }

    private InlineKeyboardMarkup createMenu(String[][] buttons) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        for (String[] button : buttons) {
            rows.add(createButtonRow(button[0], button[1]));
        }
        markup.setKeyboard(rows);
        return markup;
    }

    private List<InlineKeyboardButton> createButtonRow(String buttonText, String callbackData) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(buttonText);
        button.setCallbackData(callbackData);

        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);
        return row;
    }
}
