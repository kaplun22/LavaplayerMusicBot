package kaplun.musicbot.command.defaut;

import kaplun.musicbot.command.Command;
import kaplun.musicbot.command.CommandMap;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class HelpCommand {

    private final CommandMap commandMap;

    public HelpCommand(CommandMap commandMap) {
        this.commandMap = commandMap;
    }

    @Command(name = "help", type = Command.ExecutorType.USER, description = "Commands list")
    private void help(User user, MessageChannel channel, Guild guild) {


        channel.sendMessage(user.getAsMention() + "\n=play + link to youtube/soundcloud/bandcamp.\n = search youtube + song name \n =skip to skip track \n =clear to clear the playlist \n" +
                "").queue();

    }
}

