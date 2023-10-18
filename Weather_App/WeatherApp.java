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
        frame = new JFrame(); //creates a frame
        frame.setTitle("JFrame title goes here"); //sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(false); // prevent file from being resized
        frame.setSize(420,420); // sets the x-dimention, and y-dimention of frame
        frame.setVisible(true); //make frame visible
    }
    private String FetchAPI(location){
        private String API_KEY = "YOUR_API_KEY";
        private String location = "London"
        private String APIurl = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid={API key}";
        URL url = new URL(APIurl  + cityName + "&appid=" + API_KEY);
        try{
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader rdr = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder res = new StringBuilder();
        }

    }

    private String fetchDataFromAPI(location) {
        try {

        } catch(Exception e){
            e.printStackTrace();
            return "Exception error!"
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



