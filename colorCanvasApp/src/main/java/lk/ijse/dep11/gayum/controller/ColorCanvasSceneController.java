package lk.ijse.dep11.gayum.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class ColorCanvasSceneController {
    public JFXSlider slrRed;
    public JFXSlider slrGreen;
    public JFXSlider slrBlue;
    public Rectangle shpPreview;
    public JFXButton btnCopyMe;
    public JFXSlider slrAlpha;
    public JFXTextField txtRed;
    public JFXTextField txtGreen;
    public JFXTextField txtBlue;
    public JFXTextField txtAlpha;
    public JFXTextField txtColorCode;

    public void initialize(){
        for (JFXTextField textField : new JFXTextField[]{txtRed, txtBlue, txtGreen, txtAlpha}) {
            textField.setText("50");
        }
        Color initialFill = Color.rgb(50, 50, 50, 50 / 255.0);
        shpPreview.setFill(initialFill);
        txtRed.setTooltip(new Tooltip("Red value"));
        txtBlue.setTooltip(new Tooltip("Blue value"));
        txtGreen.setTooltip(new Tooltip("Green value"));
        txtAlpha.setTooltip(new Tooltip("Alpha value"));
        txtColorCode.setTooltip(new Tooltip("Pick my color code"));

        slrRed.valueProperty().addListener(e->{
            txtRed.setText(String.format("%.0f",slrRed.getValue()));
            updateColor();
        });
        slrBlue.valueProperty().addListener(e->{
            txtBlue.setText(String.format("%.0f",slrBlue.getValue()));
            updateColor();
        });
        slrGreen.valueProperty().addListener(e->{
            txtGreen.setText(String.format("%.0f",slrGreen.getValue()));
            updateColor();
        });
        slrAlpha.valueProperty().addListener(e->{
            txtAlpha.setText(String.format("%.0f",slrAlpha.getValue()));
            updateColor();
        });
    }

    private void updateColor() {
        int red = Integer.parseInt(txtRed.getText());
        int blue = Integer.parseInt(txtBlue.getText());
        int green = Integer.parseInt(txtGreen.getText());
        int alpha = Integer.parseInt(txtAlpha.getText());
        Color colorRef = Color.rgb(red, green, blue, alpha / 255.0);
        shpPreview.setFill(colorRef);
        txtColorCode.setText("#"+colorRef.toString().substring(2).toUpperCase());
    }

    public void btnCopyMeOnAction(ActionEvent actionEvent) {
        if (!txtColorCode.getText().isEmpty()){
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(txtColorCode.getText());
            clipboard.setContent(clipboardContent);
        }else return;
    }
}
