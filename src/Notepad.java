import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Notepad extends JFrame implements ActionListener {
    JTextArea textArea;
    JMenuBar menuBar;
    JMenu file;
    JMenuItem exit;
    JMenuItem create;
    JMenu open;
    JMenuItem openFrom;
    JMenuItem openLast;
    JMenu save;
    JMenuItem saveAs;
    JMenu edit;
    JMenuItem cancel;
    JMenuItem cut;
    JMenuItem copy;
    JMenuItem paste;
    JMenuItem delete;
    JMenu format;
    JMenuItem wrap;
    JMenuItem font;
    JMenu view;
    JMenuItem ststus;
    JMenu reference;
    JMenuItem look;
    JMenuItem about;
    JScrollPane scroll;
    JPanel jPanel;

    public Notepad() {
        setTitle("Notepad--");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(0);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                new Exit();
            }
        });

        jPanel = new JPanel();

        menuBar = new JMenuBar();

        textArea = new JTextArea();
        textArea.setSize(752,600);
        textArea.setLineWrap(true);
        textArea.setBackground(Color.darkGray);
        textArea.setForeground(Color.white);
        textArea.setFont(new Font("Book Antiqua", Font.BOLD, 18));

        scroll = new JScrollPane(jPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        file = new JMenu("Файл");
        create = new JMenuItem("Создать");
        open = new JMenu("Открыть");
        openFrom = new JMenuItem("Открыть из...");
        openLast = new JMenuItem("Открыть последний");
        save = new JMenu("Сохранить");
        saveAs = new JMenuItem("Сохранить как...");
        exit = new JMenuItem("Выход");

        edit = new JMenu("Правка");
        cancel = new JMenuItem("Отменить");
        cut = new JMenuItem("Вырезать");
        copy = new JMenuItem("Копировать");
        paste = new JMenuItem("Вставить");
        delete = new JMenuItem("Удалить");

        format = new JMenu("Формат");
        wrap = new JMenuItem("Перенос");
        font = new JMenuItem("Шрифт");

        view = new JMenu("Вид");
        ststus = new JMenuItem("Строка состояния");

        reference = new JMenu("Справка");
        look = new JMenuItem("Просмотреть справку");
        about = new JMenuItem("О программе");

        exit.addActionListener(this);

        open.add(openFrom);
        open.add(openLast);
        save.add(saveAs);

        file.add(create);
        file.add(save);
        file.add(open);
        file.add(exit);

        edit.add(cancel);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(delete);

        format.add(wrap);
        format.add(font);

        view.add(ststus);

        reference.add(look);
        reference.add(about);

        jPanel.add(textArea);
        jPanel.setBackground(Color.darkGray);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(format);
        menuBar.add(view);
        menuBar.add(reference);

        setJMenuBar(menuBar);

        add(scroll, BorderLayout.CENTER);
        setBackground(Color.DARK_GRAY);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exit)) {
            new Exit();
        }
    }
}
