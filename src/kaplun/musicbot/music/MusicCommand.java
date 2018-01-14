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

