package kaplun.musicbot.event;

import kaplun.musicbot.command.CommandMap;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class BotListener implements EventListener {

    private final CommandMap commandMap;

    public BotListener(CommandMap commandMap){
        this.commandMap = commandMap;
    }

    @Override
    public void onEvent(Event event) {
        System.out.println(event.getClass().getSimpleName());
        if(event instanceof MessageReceivedEvent) onMessage((MessageReceivedEvent)event);
        else if(event instanceof GuildMemberJoinEvent) onGuildMemberJoin((GuildMemberJoinEvent) event);
        else if(event instanceof GuildMemberLeaveEvent) onGuildMemberLeave((GuildMemberLeaveEvent) event);
    }

    private void onMessage(MessageReceivedEvent event){
        if(event.getAuthor().equals(event.getJDA().getSelfUser())) return;

        String message = event.getMessage().getContentRaw();
        if(message.startsWith(commandMap.getTag())){
            message = message.replaceFirst(commandMap.getTag(), "");
            if(commandMap.commandUser(event.getAuthor(), message, event.getMessage())){
                if(event.getTextChannel() != null && event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_MANAGE)){
                    event.getMessage().delete().queue();
                }
            }
        }
    }

    private void onGuildMemberJoin(GuildMemberJoinEvent event){
        event.getGuild().getDefaultChannel().sendMessage(event.getUser().getAsMention()+" Добро пожаловать в бар").queue();
    }

    private void onGuildMemberLeave(GuildMemberLeaveEvent event){
        event.getGuild().getDefaultChannel().sendMessage(event.getUser().getAsMention()+" Свалил из бара нахуй").queue();
    }

}
