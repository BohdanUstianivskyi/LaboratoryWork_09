import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise_1 {
    private JFrame frame;
    private JTextField radiusField;
    private JTextField velocityField;
    private JTextField accelerationField;
    private JButton calculateButton;
    private JLabel unitLabel;

    public Exercise_1() {
        frame = new JFrame("Розрахунок прискорення тіла при руху по колу");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel radiusLabel = new JLabel("Радіус (R):");
        radiusField = new JTextField();
        JLabel velocityLabel = new JLabel("Лінійна швидкість (v):");
        velocityField = new JTextField();
        JLabel accelerationLabel = new JLabel("Прискорення (a):");
        accelerationField = new JTextField();
        calculateButton = new JButton("Обчислити");
        unitLabel = new JLabel();

        panel.add(radiusLabel);
        panel.add(radiusField);
        panel.add(velocityLabel);
        panel.add(velocityField);
        panel.add(accelerationLabel);
        panel.add(accelerationField);
        panel.add(calculateButton);
        panel.add(unitLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void calculate() {
        try {
            String radiusText = radiusField.getText();
            String velocityText = velocityField.getText();
            String accelerationText = accelerationField.getText();

            if (!radiusText.isEmpty() && !velocityText.isEmpty()) {
                double radius = Double.parseDouble(radiusText);
                double velocity = Double.parseDouble(velocityText);

                double acceleration = Math.pow(velocity, 2) / radius;

                accelerationField.setText(String.valueOf(acceleration));
                unitLabel.setText("Одиниця вимірювання: м/с^2");
            } else if (!radiusText.isEmpty() && !accelerationText.isEmpty()) {
                double radius = Double.parseDouble(radiusText);
                double acceleration = Double.parseDouble(accelerationText);

                double velocity = Math.sqrt(acceleration * radius);

                velocityField.setText(String.valueOf(velocity));
                unitLabel.setText("Одиниця вимірювання: м/с");
            } else if (!velocityText.isEmpty() && !accelerationText.isEmpty()) {
                double velocity = Double.parseDouble(velocityText);
                double acceleration = Double.parseDouble(accelerationText);

                double radius = Math.pow(velocity, 2) / acceleration;

                radiusField.setText(String.valueOf(radius));
                unitLabel.setText("Одиниця вимірювання: м");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Помилка: некоректні дані", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exercise_1();
            }
        });
    }
}
