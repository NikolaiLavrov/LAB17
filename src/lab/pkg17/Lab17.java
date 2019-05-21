package lab.pkg17;

import java.awt.*;
import java.awt.event.*;

public class Lab17 extends Frame {
    private String key = "AWT GUI";
    private String mouse = "";
    private int mouseX = 30, mouseY = 30;

    public Lab17() {
        addKeyListener(new MyKeyAdapter(this));
        addWindowListener(new AwtWindowAdapter());
        addMouseListener(new MyMouseAdapter(this));
    }

    public static void main(String[] args) {
        Lab17 win1 = new Lab17();
        win1.setTitle("Exit");
        win1.setSize(300, 200);
        win1.setLocation(500, 250);

        Button OK = new Button("Выйти");
        OK.addActionListener((ActionEvent e) -> {
            Dialog();
        });
        
        Panel panel = new Panel();
        panel.add(OK);
        win1.add(panel);
        win1.setVisible(true);
    }

    public static void Dialog(){
        Lab17 win2 = new Lab17();
        win2.setTitle("Window");
        win2.setSize(200, 100);
        win2.setLocation(550, 300);
        
        Label l = new Label("Вы точно хотите выйти?");
        
        Button OK1 = new Button("OK");
        OK1.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        Button OK2 = new Button("Close");
        OK2.addActionListener((ActionEvent e) -> {
            win2.setVisible(false);
        });
        
        Panel pane2 = new Panel();
        pane2.add(l);
        pane2.add(OK1);
        pane2.add(OK2);
        win2.add(pane2);
        win2.setVisible(true);
    }

    class MyKeyAdapter extends KeyAdapter {
        Lab17 awtWindow;
        
        public MyKeyAdapter(Lab17 awtWindow) {
            this.awtWindow = awtWindow;
        }

        public void keyTyped(KeyEvent ke) {
            awtWindow.key +=ke.getKeyChar();
            awtWindow.repaint();
        }
    }

    class MyMouseAdapter extends MouseAdapter {
        Lab17 awtWindow;
        
        public MyMouseAdapter(Lab17 awtWindow) {
            this.awtWindow = awtWindow;
        }

        public void mousePressed(MouseEvent me) {
            awtWindow.mouseX = me.getX();
            awtWindow.mouseY = me.getY();
            awtWindow.mouse = "Mouse Down at " + awtWindow.mouseX + ", " + awtWindow.mouseY;
            awtWindow.repaint();
        }
    }
}

class AwtWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
        Lab17.Dialog();
    }
}
