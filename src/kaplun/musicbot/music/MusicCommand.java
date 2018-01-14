package kaplun.musicbot.music;

import kaplun.musicbot.command.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MusicCommand {

    private final MusicManager manager = new MusicManager();

    @Command(name = "play", type = Command.ExecutorType.USER)
    private void play(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, command.replaceFirst("play ", ""));
    }

    @Command(name = "skip", type = Command.ExecutorType.USER)
    private void skip(Guild guild, TextChannel textChannel, User user) {

        String author = guild.getMember(user).toString();
        String[] getNickname = author.split(":");
        String[] nickname = getNickname[1].split(" ");

        if (user.getName().contains("OBJEZD")) {
            textChannel.sendMessage("МАКС ПОШЕЛ НАХУЙ").queue();
            return;
        }
        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            textChannel.sendMessage("Skipped.").queue();
            return;
        }

        manager.getPlayer(guild).skipTrack();
        textChannel.sendMessage("track skipped.").queue();
    }

    @Command(name = "clear", type = Command.ExecutorType.USER)
    private void clear(TextChannel textChannel) {
        MusicPlayer player = manager.getPlayer(textChannel.getGuild());

        if (player.getListener().getTracks().isEmpty()) {
            textChannel.sendMessage("Clear.").queue();
            return;
        }

        player.getListener().getTracks().clear();
        textChannel.sendMessage("clear").queue();
    }


    @Command(name = "КтоТутГлавный", type = Command.ExecutorType.USER)
    private void IAMINCHARGENOW(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "E:\\MusicBotDiscord\\SoundTest\\IAMINCHARGENOW.mp3");
    }

    @Command(name = "МинусУши", type = Command.ExecutorType.USER)
    private void noEars(Guild guild, TextChannel textChannel, User user, String command) {


        String author = guild.getMember(user).toString();
        String[] getNickname = author.split(":");
        String[] nickname = getNickname[1].split(" ");


        System.out.println(author);
        System.out.println(nickname[0]);

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
            textChannel.sendMessage(nickname + " ПОШЕЛ НАХУЙ").queue();
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

    @Command(name = "Objezd", type = Command.ExecutorType.USER)
    private void Objezd(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "E:\\MusicBotDiscord\\SoundTest\\Dejavu.mp3");
    }

    /*@Command(name="FatePukan",type = ExecutorType.USER)
    private void FatePukan(Guild guild, TextChannel textChannel, User user, String command){

        if(guild == null) return;


        if(!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()){
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if(voiceChannel == null){
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel,"F:\\MusicBotDiscord\\SoundTest\\fate.mp3");
    }*/
    @Command(name = "ragnaros", type = Command.ExecutorType.USER)
    private void ragnaros(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "E:\\MusicBotDiscord\\SoundTest\\ragna.mp3");
    }

    @Command(name = "illidan", type = Command.ExecutorType.USER)
    private void illidan(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "E:\\MusicBotDiscord\\SoundTest\\youarenotpreapared.mp3");
    }

    @Command(name = "Mccree", type = Command.ExecutorType.USER)
    private void mccree(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "E:\\MusicBotDiscord\\SoundTest\\McCree.mp3");
    }

    @Command(name = "violin", type = Command.ExecutorType.USER)
    private void violin(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "E:\\MusicBotDiscord\\SoundTest\\sadViolin.mp3");
    }

    @Command(name = "face", type = Command.ExecutorType.USER)
    private void face(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=-jenlSf2E8o&index=6&list=PLjjBW5U8Y2R_kFIoNwqPjeQ8v3csELfXk");
    }

    @Command(name = "GETINHERE", type = Command.ExecutorType.USER)
    private void GETINHERE(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "E:\\MusicBotDiscord\\SoundTest\\Grim - Patron.mp3");
    }


    @Command(name = "сука", type = Command.ExecutorType.USER)
    private void suka(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "E:\\MusicBotDiscord\\SoundTest\\cerf.mp3");
    }


    @Command(name = "лирой", type = Command.ExecutorType.USER)
    private void liroy(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "E\\MusicBotDiscord\\SoundTest\\лирой.mp3");
    }


    @Command(name = "ПОКАЙСЯ", type = Command.ExecutorType.USER)
    private void pokaysja(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=XKBJPnu89zA");
    }

    @Command(name = "house of air", type = Command.ExecutorType.USER)
    private void houseofair(Guild guild, TextChannel textChannel, User user, String command) {

        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=agdB3bIQmi4");
    }


    @Command(name = "search", type = Command.ExecutorType.USER)
    private void searchForVideos(Guild guild, TextChannel textChannel, User user, String command) throws Exception {

        Document doc = Jsoup.connect("https://www.google.com/search?q=" + command).userAgent("Mozilla/5.0").timeout(5000).get();

        Element el = doc.getElementsByAttributeValue("class","kv").first();


        if (guild == null) return;


        if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if (voiceChannel == null) {
                textChannel.sendMessage("Bot connected.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, el.text());

    }
    @Command(name = "disconnect", type = Command.ExecutorType.USER)
    private  void disconnect (Guild guild ,TextChannel textChannel , User user,String command){
        guild.getAudioManager().closeAudioConnection();
    }
    @Command(name="volume",type =Command.ExecutorType.USER)
    private void volume (Guild guild ,TextChannel textChannel , User user,String command){
        String[] vol = command.split(" ");
        int volu = Integer.parseInt(vol[1]);
        manager.getPlayer(guild).getAudioPlayer().setVolume(volu);
    }


}

