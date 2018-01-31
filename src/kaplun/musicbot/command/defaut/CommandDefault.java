package kaplun.musicbot.command.defaut;

import kaplun.musicbot.App;
import kaplun.musicbot.command.Command;
import kaplun.musicbot.command.CommandMap;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;

import java.awt.*;

public class CommandDefault {
    private final App botDiscord;
    private final CommandMap commandMap;

    public CommandDefault(App botDiscord, CommandMap commandMap){
        this.botDiscord = botDiscord;
        this.commandMap = commandMap;
    }

    @Command(name="stop",type= Command.ExecutorType.CONSOLE)
    private void stop(){
        botDiscord.setRunning(false);
    }

    @Command(name="power",power=150)
    private void power(User user, MessageChannel channel, Message message, String[] args)
    {
        if(args.length == 0 || message.getMentionedUsers().size() == 0)
        {
            channel.sendMessage("power <Power> <@User>").queue();
            return;
        }

        int power = 0;
        try{
            power = Integer.parseInt(args[0]);
        }catch(NumberFormatException nfe){
            channel.sendMessage("").queue();
            return;
        }

        User target = message.getMentionedUsers().get(0);
        commandMap.addUserPower(target, power);
        channel.sendMessage(" "+target.getAsMention()+"  "+power).queue();
    }

    @Command(name="info",type= Command.ExecutorType.USER)
    private void info(User user, MessageChannel channel){
        if(channel instanceof TextChannel){
            TextChannel textChannel = (TextChannel)channel;
            if(!textChannel.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_EMBED_LINKS)) return;
        }

        EmbedBuilder builder = new EmbedBuilder();
        builder.setAuthor(user.getName(), null, user.getAvatarUrl()+"?size=256");
        builder.setTitle("");
        builder.setDescription(" "+channel.getName());
        builder.setColor(Color.green);

        channel.sendMessage(builder.build()).queue();
    }
}

