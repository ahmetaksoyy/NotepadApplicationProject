package notepadApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotepadApplication extends JFrame implements ActionListener {

    //menu bar
    JMenuBar menubar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");

    // "file" inner menu
    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem exit = new JMenuItem("Exit");

    // "edit" inner menu
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectall = new JMenuItem("Select All");
    JMenuItem info = new JMenuItem("info");

    // "help" inner menu
    JMenuItem about = new JMenuItem("About");

    //textArea
    public JTextArea textArea = new JTextArea();



    NotepadApplication(){
        setTitle("Notepadd Application");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add(menubar);
        setJMenuBar(menubar);

        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        edit.add(info);


        help.add(about);

        // scroll pane
        JScrollPane scrollpane = new JScrollPane(textArea);
        add(scrollpane);

        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollpane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Adding Listeners
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        about.addActionListener(this);
        info.addActionListener(this);


    }


    public static void main(String[] args) throws Exception {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NotepadApplication().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("New")) {
            textArea.setText(null);

        }
        else if(e.getActionCommand().equalsIgnoreCase("Open")) {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("sadece txt olabilir","txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            int action = fileChooser.showOpenDialog(null);
            if (action != JFileChooser.APPROVE_OPTION){
                return;
            }else{
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                    textArea.read(reader,null);
                }catch (IOException ee){
                    ee.printStackTrace();
                }
            }


        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter textFilter = new FileNameExtensionFilter("sadece txt olabilir","txt");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(textFilter);
                //kaydetme ekrani
                int action =fileChooser.showSaveDialog(null);
                if (action != JFileChooser.APPROVE_OPTION){
                    return;
                }else{
                    String fileName =fileChooser.getSelectedFile().getAbsolutePath().toString();
                    if (!fileName.contains(".txt")){    //dosyanin sonuna .txt eklenmis mi onu inceliyor.
                        fileName = fileName+".txt";
                    }
                    try{
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                        textArea.write(writer);         //kaydediyoruz
                    }catch (IOException ee){
                        ee.printStackTrace();
                    }
                }
        }
        else if(e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);
        }
        else if(e.getActionCommand().equalsIgnoreCase("Cut")) {
            textArea.cut();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Copy")) {
            textArea.copy();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Paste")) {
            textArea.paste();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Select All")) {
            textArea.selectAll();
        }
        else if(e.getActionCommand().equalsIgnoreCase("About")) {
            new About().setVisible(true);
        }
        else if(e.getActionCommand().equalsIgnoreCase("info")) {

            Welcome a = new Welcome.Builder().ders("oop").build();

            textArea.setText(a.degis());
        }

    }

}