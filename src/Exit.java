import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Exit extends JFrame {

    public Exit() {
        UIManager.put("OptionPane.background",new ColorUIResource(74, 74, 74));
        UIManager.put("Panel.background",new ColorUIResource(74, 74, 74));
        UIManager.put("OptionPane.messageForeground",new ColorUIResource(255, 255, 255));
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.yesButtonBackground",new ColorUIResource(74, 74, 74));

        int result = JOptionPane.showConfirmDialog(null,
                "Закрыть программу?",
                "Выход из программы",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
