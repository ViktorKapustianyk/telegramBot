package org.example.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class HelloWorldBot extends TelegramLongPollingBot {
    private static final String MENU_1 = "MENU_1";
    private static final String MENU_2 = "MENU_2";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if ("/start".equals(messageText)) {
                sendMenu1(chatId);
            }
        } else if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            answerCallbackQuery(update.getCallbackQuery().getId());

            switch (callbackData) {
                case "btn1_menu1":
                case "btn1_menu2":
                    sendText(chatId, "Кнопка 1");
                    break;
                case "btn2_menu1":
                case "btn2_menu2":
                    sendText(chatId, "Кнопка 2");
                    break;
                case "next":
                    sendMenu2(chatId);
                    break;
                case "back":
                    sendMenu1(chatId);
                    break;
            }
        }
    }

    private void sendMenu1(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Меню 1:");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        rows.add(List.of(createButton("Кнопка 1", "btn1_menu1")));
        rows.add(List.of(createButton("Кнопка 2", "btn2_menu1")));
        rows.add(List.of(createButton("Далі", "next")));

        markup.setKeyboard(rows);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMenu2(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Меню 2:");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        rows.add(List.of(createButton("Кнопка 1", "btn1_menu2")));
        rows.add(List.of(createButton("Кнопка 2", "btn2_menu2")));
        rows.add(List.of(createButton("Назад", "back")));

        markup.setKeyboard(rows);
        message.setReplyMarkup(markup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendText(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void answerCallbackQuery(String callbackQueryId) {
        AnswerCallbackQuery answer = new AnswerCallbackQuery();
        answer.setCallbackQueryId(callbackQueryId);
        answer.setText(""); // Пустой ответ, чтобы Telegram не ожидал реакции
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private InlineKeyboardButton createButton(String text, String callbackData) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(callbackData);
        return button;
    }


    @Override
    public String getBotUsername() {
        return BotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }
}
