import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherGUI extends JFrame {
    private JFrame frame;
    private JLabel weatherLabel;
    private JLabel conditionLabel;
    private JButton refreshButton;
    private JTextField cityTextField;

    public WeatherGUI() {
        super("Weather App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);//center window
        setLayout(null);

        cityTextField = new JTextField();
        cityTextField.setBounds(10, 10, 120, 25);
        add(cityTextField);

        weatherLabel = new JLabel("Weather: ");
        weatherLabel.setBounds(10, 45, 300, 25);
        System.out.print();
        add(weatherLabel);

        conditionLabel = new JLabel();
        conditionLabel.setBounds(10, 70, 100, 100);
        add(conditionLabel);

        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(140, 10, 100, 25);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshWeather();
            }
        });
        add(refreshButton);

        refreshWeather(); // Fetch and display weather data on app launch

        setResizable(false);

        
    }

    private void refreshWeather() {
        String city = cityTextField.getText();
        String weatherData = WeatherAPI.getWeatherData(city);

        weatherLabel.setText(weatherData);
        
        /*String[] weatherInfo = weatherData.split(",");
        if (weatherInfo.length == 2) {
            weatherLabel.setText("Weather: " + weatherInfo[0]);
            conditionLabel.setIcon(new ImageIcon(weatherInfo[1]));
        } else {
            weatherLabel.setText("City not found");
            conditionLabel.setIcon(null);
        }*/
    }
}
