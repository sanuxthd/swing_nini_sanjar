import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Main extends JFrame {

    private int secretNumber;
    private int attempts = 0;

    private JLabel messageLabel;
    private JTextField inputField;
    private JButton checkButton;
    private JLabel attemptsLabel;

    public Main() {
        setTitle("Угадай число");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Загадать число
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;

        // Элементы интерфейса
        messageLabel = new JLabel("Введите число от 1 до 100", SwingConstants.CENTER);

        inputField = new JTextField();

        checkButton = new JButton("Проверить");

        attemptsLabel = new JLabel("Попыток: 0", SwingConstants.CENTER);

        // Layout
        setLayout(new GridLayout(4, 1, 10, 10));

        add(messageLabel);
        add(inputField);
        add(checkButton);
        add(attemptsLabel);

        // Обработка кнопки
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = inputField.getText();

                try {
                    int guess = Integer.parseInt(text);
                    attempts++;

                    if (guess < secretNumber) {
                        messageLabel.setText("Больше!");
                    } else if (guess > secretNumber) {
                        messageLabel.setText("Меньше!");
                    } else {
                        messageLabel.setText("Угадал!");
                        checkButton.setEnabled(false);
                    }

                    attemptsLabel.setText("Попыток: " + attempts);

                } catch (NumberFormatException ex) {
                    messageLabel.setText("Введите число!");
                }

                inputField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main game = new Main();
            game.setVisible(true);
        });
    }
}