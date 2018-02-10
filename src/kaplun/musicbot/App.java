package kaplun.musicbot;

import kaplun.musicbot.command.CommandMap;
import kaplun.musicbot.event.BotListener;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class App implements Runnable{

    private final JDA jda;
    private final CommandMap commandMap = new CommandMap(this);
    private final Scanner scanner = new Scanner(System.in);

    private boolean running;

    public App() throws LoginException, IllegalArgumentException, RateLimitedException {
        jda = new JDABuilder(AccountType.BOT).setToken("MjM3OTA0MTc1MDg4OTI2NzIx.DWBB5w.C_tgCwdL351QxV33XFUi3jSSKVk").buildAsync();
        jda.addEventListener(new BotListener(commandMap));
        jda.getPresence().setGame(Game.of("=help"));
        System.out.println("Bot connected.");
    }

    public JDA getJda() {
        return jda;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        running = true;

        while (running) {
            if(scanner.hasNextLine()) commandMap.commandConsole(scanner.nextLine());
        }

        scanner.close();
        System.out.println("Bot stopped.");
        jda.shutdown();
        commandMap.save();
        System.exit(0);
    }

    public static void main(String[] args) {
        try {
            App botDiscord = new App();
            new Thread(botDiscord, "bot").start();
        } catch (LoginException | IllegalArgumentException | RateLimitedException e) {
            e.printStackTrace();
        }
    }
}
