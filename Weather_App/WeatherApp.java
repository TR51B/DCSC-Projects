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
        frame = new JFrame("Weather App");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        fetchButton = new JButton("Fetch Weather");
        

        weatherPanel = new WeatherPanel();
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(textArea, BorderLayout.CENTER);
        frame.add(fetchButton, BorderLayout.SOUTH);
        frame.add(weatherPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private String fetchDataFromAPI() {
        try {
            String result = "yes";
                return result;
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WeatherApp();
            }
        });
    }
}

class WeatherPanel extends JPanel {

}



