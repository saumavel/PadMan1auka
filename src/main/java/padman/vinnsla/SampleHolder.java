package padman.vinnsla;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.input.DragEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SampleHolder {
    private static final int N = 31; // Max nr of MediaPlayers
    private static Media[] medias = new Media[31];
    //private static MediaPlayer[] mediaPlayers = new MediaPlayer[31];
    private static Map<Integer, MediaPlayer> mediaPlayers = new HashMap<>();

    private static void setSamples(String folderPath) {

        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name)
                -> name.endsWith(".wav") || name.endsWith(".mp3"));
        Arrays.sort(files);
        for (int i = 0; i < N; i++) {
            Media media = new Media(files[i].toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayers.put(i, mediaPlayer);
        }
        for (MediaPlayer mediaPlayer : mediaPlayers.values()) {
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.stop());
        }
    }

    public static void setSample(File keySample, int key) {
        if (!keySample.isFile() || !(keySample.getName().endsWith(".wav") || keySample.getName().endsWith(".mp3"))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Illegal Argument Exception");
            alert.setContentText("Sample needs to be wav or mp3");
            alert.showAndWait();
            throw new IllegalArgumentException("Sample needs to be wav or mp3");
        }
        Media media = new Media(keySample.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.stop());
        mediaPlayers.put(key, mediaPlayer);
    }

    public static void playMedia(int key) {
        MediaPlayer mediaPlayer = mediaPlayers.get(key);
        if (mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0.05), new KeyValue(mediaPlayer.volumeProperty(), 0)));
                timeline.setOnFinished(event -> {
                    mediaPlayer.stop();
                    mediaPlayer.play();
                    Timeline timeline2 = new Timeline(
                            new KeyFrame(Duration.seconds(0.001), new KeyValue(mediaPlayer.volumeProperty(), 1)));
                    timeline2.play();
                });
                timeline.play();
            } else {
                mediaPlayer.play();
            }
        }
    }
    /*
    public static void stopMedia(int key) {
        MediaPlayer mediaPlayer = mediaPlayers.get(key);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
    */
    public static void setSamplesFromFolder(String folderPath) {
        setSamples(folderPath);
    }

    public static void setSampleFromFile(File keySample, int key) {
        setSample(keySample, key);
    }

    public static void handleDragDropped(DragEvent e, int key) {
        File file = e.getDragboard().getFiles().iterator().next();
        setSample(file, key);
        e.setDropCompleted(true);
        e.consume();
    }
}