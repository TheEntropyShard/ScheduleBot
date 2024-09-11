package me.theentropyshard.schedulebot;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class ScheduleBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    public ScheduleBot(String botToken) {
        this.telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {
        if (!update.hasMessage()) {
            return;
        }

        Message message = update.getMessage();

        if (!message.hasText()) {
            return;
        }

        String text = message.getText();

        SendMessage sendMessage = new SendMessage(Long.toString(message.getChatId()), text);
        try {
            this.telegramClient.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
