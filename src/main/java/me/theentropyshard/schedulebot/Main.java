package me.theentropyshard.schedulebot;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
    public static void main(String[] args) {
        String botToken = System.getenv("BOT_TOKEN");

        if (botToken == null) {
            System.out.println("Environment variable BOT_TOKEN is not set");

            System.exit(1);
        }

        @SuppressWarnings("resource")
        TelegramBotsLongPollingApplication application = new TelegramBotsLongPollingApplication();

        try {
            application.registerBot(botToken, new ScheduleBot(botToken));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
