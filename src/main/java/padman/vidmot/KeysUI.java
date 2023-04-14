package padman.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import padman.vinnsla.SampleHolder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class KeysUI implements Initializable {
    @FXML
    private GridPane fxGrid;
    @FXML
    private Button fxZ, fxX, fxC, fxV, fxB, fxN, fxM, fxComma, fxDot, fxÞ, fxA, fxS, fxD, fxF, fxG, fxH, fxJ, fxK, fxL, fxÆ, fxQ, fxW, fxE, fxR, fxT, fxY, fxU, fxI, fxO, fxP, fx1, fx2, fx3, fx4, fx5, fx6, fx7, fx8, fx9, fx0;
    private Button[] buttons;
    @FXML
    private Button fxNoteNames;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new Button[] { fxZ, fxX, fxC, fxV, fxB, fxN, fxM, fxComma, fxDot, fxÞ, fxA, fxS, fxD, fxF, fxG, fxH, fxJ, fxK, fxL, fxÆ, fxQ, fxW, fxE, fxR, fxT, fxY, fxU, fxI, fxO, fxP, fx1, fx2, fx3, fx4, fx5, fx6, fx7, fx8, fx9, fx0};
        SampleHolder.setSamplesFromFolder("src/main/resources/padman/vidmot/Audio/Diatonic");
        setStyleClasses();
        fxNoteNames.setFocusTraversable(false);
    }

    private void setStyleClasses(){
        for (int i = 0; i < 10; i++) { buttons[i].getStyleClass().add("oct1"); }
        for (int i = 10; i < 20; i++) { buttons[i].getStyleClass().add("oct2"); }
        for (int i = 20; i < 30; i++) { buttons[i].getStyleClass().add("oct3"); }
        for (int i = 30; i < 40; i++) { buttons[i].getStyleClass().add("oct4"); }
    }

    private void setButtonTxt(String mode) {
        String[] buttonText = new String[40];
        if (mode.equals("notesDiatonic")) {
            buttonText = new String[]{"C2", "D2", "E2", "F2", "G2", "A2", "B2", "C3", "D3", "E3", "C3", "D3", "E3", "F3", "G3", "A3", "B3", "C4", "D4", "E4", "C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5", "D5", "E5", "C5", "D5", "E5", "F5", "G5", "A5", "B5", "C6", "D6", "E6"};
        }
        else if (mode.equals("notesChromatic")) {
            //buttonText = new String[]{"Z\nC", "X\nC#", "C\nD", "V\nD#", "B\nE", "N\nF", "M\nF#", ",\nG", ".\nG#", "Þ\nA", "A\nA#", "S\nB", "D\nC", "F\nC#", "G\nD", "H\nD#", "J\nE", "K\nF", "L\nF#", "Æ\nG", "Q\nG#", "W\nA", "E\nA#", "R\nB", "T\nC", "Y\nC#", "U\nD", "I\nD#", "O\nE", "P\nF", "1\nF#", "2\nG", "3\nG#", "4\nA", "5\nA#", "6\nB", "7\nC", "8\nC#", "9\nD", "0\nD#"};
            buttonText = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#"};
        }
        else if (mode.equals("keyboard")) {
            buttonText = new String[]{"Z", "X", "C", "V", "B", "N", "M", ",", ".", "Þ", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Æ", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(buttonText[i]);
        }
    }

    @FXML
    private void keyPressedSample(KeyEvent e) {
        int keyIndex = -1;
      /*  for (int oct = 0; oct < 4; oct++) {
            for (keyIndex = 0; keyIndex < 8; keyIndex++) {
                if (e.getCode() == KeyCode.DIGIT0 )  */
        switch(e.getCode()) {
            case DIGIT1: keyIndex = 21; break;
            case DIGIT2: keyIndex = 22; break;
            case DIGIT3: keyIndex = 23; break;
            case DIGIT4: keyIndex = 24; break;
            case DIGIT5: keyIndex = 25; break;
            case DIGIT6: keyIndex = 26; break;
            case DIGIT7: keyIndex = 27; break;
            case DIGIT8: keyIndex = 28; break;
            case DIGIT9: keyIndex = 29; break;
            case DIGIT0: keyIndex = 30; break;
            case Q: keyIndex = 14; break;
            case W: keyIndex = 15; break;
            case E: keyIndex = 16; break;
            case R: keyIndex = 17; break;
            case T: keyIndex = 18; break;
            case Y: keyIndex = 19; break;
            case U: keyIndex = 20; break;
            case I: keyIndex = 21; break;
            case O: keyIndex = 22; break;
            case P: keyIndex = 23; break;
            case A: keyIndex = 7; break;
            case S: keyIndex = 8; break;
            case D: keyIndex = 9; break;
            case F: keyIndex = 10; break;
            case G: keyIndex = 11; break;
            case H: keyIndex = 12; break;
            case J: keyIndex = 13; break;
            case K: keyIndex = 14; break;
            case L: keyIndex = 15; break;
            case SEMICOLON: keyIndex = 16; break;
            case Z: keyIndex = 0; break;
            case X: keyIndex = 1; break;
            case C: keyIndex = 2; break;
            case V: keyIndex = 3; break;
            case B: keyIndex = 4; break;
            case N: keyIndex = 5; break;
            case M: keyIndex = 6; break;
            case COMMA: keyIndex = 7; break;
            case PERIOD: keyIndex = 8; break;
            case SLASH: keyIndex = 9; break; // / (slash)
        }
        if (keyIndex != -1) {
            SampleHolder.playMedia(keyIndex);
            for(Button b : buttons){
            b.getStyleClass().remove("buttonPressed");
            }
            // buttons[keyIndex].requestFocus();
            buttons[keyIndex].getStyleClass().add("buttonPressed");
        }
    }

    @FXML
    private void onButtonFxUI (ActionEvent e) throws IOException {
        FxUI.loadFxUI();
    }



    @FXML
    private void mousePressedSample(MouseEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource().equals(buttons[i])) {
                SampleHolder.playMedia(i);
                break;
            }
        }
        for (int i = 10; i < 20; i++) {
            if (e.getSource().equals(buttons[i])) {
                SampleHolder.playMedia(i-3);
                break;
            }
        }
        for (int i = 20; i < 30; i++) {
            if (e.getSource().equals(buttons[i])) {
                SampleHolder.playMedia(i-6);
                break;
            }
        }
        for (int i = 30; i < 40; i++) {
            if (e.getSource().equals(buttons[i])) {
                SampleHolder.playMedia(i-9);
                break;
            }
        }
    }

    @FXML
    private void onDragOver(DragEvent e) {
        if (e.getDragboard().hasFiles()) {
            e.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void onDragDropped(DragEvent e) throws FileNotFoundException {
        Button targetButton = (Button) e.getGestureTarget();
        int key = Arrays.asList(buttons).indexOf(targetButton);
        SampleHolder.handleDragDropped(e, key);
    }

    public void noteNamesHandler(MouseEvent e) {
        if (e.getSource().equals(fxNoteNames)) {
            if (fxNoteNames.getText().equals("Notes")) {
                setButtonTxt("notesDiatonic");
                fxNoteNames.setText("Keyboard");
            } else {
                setButtonTxt("keyboard");
                fxNoteNames.setText("Notes");
            }
        }
    }
}
