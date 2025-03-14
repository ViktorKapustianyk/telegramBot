package org.example.bot;

import java.util.Optional;

public class BotConfig { public static final String BOT_USERNAME = "NewHWBot_bot";
    public static final String BOT_TOKEN = Optional.ofNullable(System.getenv("YOUR_BOT_TOKEN"))
            .orElseThrow(() -> new IllegalStateException("BOT_TOKEN не встановлено в оточенні"));
}