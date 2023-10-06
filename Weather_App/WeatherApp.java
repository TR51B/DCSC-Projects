import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {
    private JFrame frame;
    private JTextArea textArea;
    private JButton fetchButton;
    private WeatherPanel weatherPanel;

    public WeatherApp() {

    }

    private String fetchDataFromAPI() {
        try {

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            //new WeatherApp();
        }
    });
}
}

class WeatherPanel extends JPanel {

}



