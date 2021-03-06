package kaplun.musicbot.music;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.filter.ValueNode;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import kaplun.musicbot.command.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;

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
        try {


            String[] arr = command.split(" ", 2);
            String query = arr[1];
            YouTubeData youTubeData = new YouTubeData();
            String jsonVideoId = youTubeData.search(query);
            String jsonExp = "$.id.videoId";
            String videoID = JsonPath.read(jsonVideoId, jsonExp);

            if (guild == null) return;


            if (!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()) {
                VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
                if (voiceChannel == null) {
                    textChannel.sendMessage("Please enter the voice chanel").queue();
                    return;
                }
                guild.getAudioManager().openAudioConnection(voiceChannel);
            }

            manager.loadTrack(textChannel, "https://www.youtube.com/watch?v=" + videoID);
        }catch (Exception e){
            e.printStackTrace();
        }
        }
    @Command(name="summon",type = Command.ExecutorType.USER)
    private void summon (Guild guild, TextChannel textChannel, User user ,String command){
        VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
        guild.getAudioManager().openAudioConnection(voiceChannel);
    }



    @Command(name = "disconnect", type = Command.ExecutorType.USER)
    private  void disconnect (Guild guild ,TextChannel textChannel , User user,String command){
        guild.getAudioManager().closeAudioConnection();
    }
    @Command(name="vol",type =Command.ExecutorType.USER)
    private void volume (Guild guild ,TextChannel textChannel , User user,String command){
        String[] vol = command.split(" ");
        int volu = Integer.parseInt(vol[1]);
        manager.getPlayer(guild).getAudioPlayer().setVolume(volu);
    }

    @Command(name="pause",type =Command.ExecutorType.USER)
    private void pause (Guild guild ,TextChannel textChannel , User user,MusicPlayer player,String command){
      manager.getPlayer(guild).getAudioPlayer().setPaused(true);
    }
    @Command(name="unpause",type =Command.ExecutorType.USER)
    private void unPause (Guild guild ,TextChannel textChannel , User user,MusicPlayer player,String command){
        manager.getPlayer(guild).getAudioPlayer().setPaused(false);
    }


}

