import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {

    MusicPlayer() {
        Platform.startup(() -> {
        });
    }

    static void playPauseMusic() {
        new MusicPlayer();
        Platform.runLater(() -> {
            String songUrl = "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview221/v4/6a/23/cf/6a23cf87-d067-9840-0684-e7ec61b7713a/mzaf_14688371171493941255.plus.aac.p.m4a";

            Media media = new Media(songUrl);

            MediaPlayer mediaPlayer = new MediaPlayer(media);

            mediaPlayer.play();
        });

    }

    public static void main(String[] args) {
        playPauseMusic();
    }
}
