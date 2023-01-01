package notepadApp;

import java.awt.Font;

import javax.swing.*;

public class About extends JFrame {

    About(){
        setBounds(100, 100, 500, 400);
        setTitle("About Notepad Application");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel aboutText = new JLabel("<html>Erdogan Baran Hazar</html>");
        aboutText.setBounds(0,0,400,300);
        aboutText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        add(aboutText);
    }

    public static void main(String[] args) {
        new About().setVisible(true);

    }
}