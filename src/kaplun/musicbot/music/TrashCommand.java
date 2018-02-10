package kaplun.musicbot.music;

import kaplun.musicbot.command.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;

public class TrashCommand {
    private final MusicManager manager = new MusicManager();

    @Command(name = "МинусУши", type = Command.ExecutorType.USER)
    private void noEars(Guild guild, TextChannel textChannel, User user, String command) {


        String author = guild.getMember(user).toString();
        String[] getNickname = author.split(":");
        String[] nickname = getNickname[1].split(" ");


        System.out.println(author);


        if (guild == null) return;

        if (author.contains("kaplun")) {
            if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
                VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
                if (voiceChannel == null) {
                    textChannel.sendMessage("Bot connected.").queue();
                    return;
                }
                guild.getAudioManager().openAudioConnection(voiceChannel);
            }


            manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=EKjkUvlm7Ng");
        } else {
            textChannel.sendMessage(user.getAsMention() + " ПОШЕЛ НАХУЙ").queue();
        }
    }


    @Command(name = "MLG", type = Command.ExecutorType.USER)
    private void MLG(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=Tqo-v-zeZ24");
    }

    @Command(name = "сука", type = Command.ExecutorType.USER)
    private void bitch(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=h2XxPtrFZVk");
    }
    @Command(name = "укупник", type = Command.ExecutorType.USER)
    private void ukupnik(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=hQppwPyu1Dg");
    }
    @Command(name = "уганда", type = Command.ExecutorType.USER)
    private void uganda(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=sgf5pRfTqMw");
    }
    @Command(name = "AVEMARIA", type = Command.ExecutorType.USER)
    private void deusVult(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=elSwxUwofRk");
    }
    @Command(name = "испанцы", type = Command.ExecutorType.USER)
    private void ispanci (Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=BU2NWMh9y7E");
    }
}
