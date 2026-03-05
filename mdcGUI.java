package Algoritmafinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mdcGUI extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JLabel statusLabel;
    String currentUser = "";

    Color background = new Color(18,18,18);
    Color sidebarColor = new Color(30,30,30);
    Color buttonColor = new Color(45,45,45);
    Color accent = new Color(0,120,215);

    public mdcGUI() {

        setTitle("MDC Police Tablet System");
        setSize(420,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(background);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(background);

        JLabel logo = new JLabel("POLICE MDC",SwingConstants.CENTER);
        logo.setFont(new Font("Segoe UI",Font.BOLD,26));
        logo.setForeground(Color.WHITE);
        logo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel form = new JPanel(new GridLayout(4,2,10,10));
        form.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        form.setBackground(background);

        JLabel userLabel = new JLabel("Kullanıcı Adı");
        userLabel.setForeground(Color.WHITE);

        JLabel passLabel = new JLabel("Şifre");
        passLabel.setForeground(Color.WHITE);

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        usernameField.setFont(new Font("Segoe UI",Font.PLAIN,14));
        passwordField.setFont(new Font("Segoe UI",Font.PLAIN,14));

        loginButton = new JButton("Giriş Yap");
        loginButton.setBackground(accent);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Segoe UI",Font.BOLD,14));

        statusLabel = new JLabel("",SwingConstants.CENTER);
        statusLabel.setForeground(Color.RED);

        form.add(userLabel);
        form.add(usernameField);
        form.add(passLabel);
        form.add(passwordField);
        form.add(new JLabel(""));
        form.add(loginButton);
        form.add(statusLabel);

        panel.add(logo,BorderLayout.NORTH);
        panel.add(form,BorderLayout.CENTER);

        add(panel);

        loginButton.addActionListener(e -> {

            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if(user.equals("Murat") && pass.equals("123mrt123")){
                currentUser = user;
                openMainPanel();
                dispose();
            }
            else{
                statusLabel.setText("Hatalı giriş!");
            }

        });

        setVisible(true);
    }


    private void openMainPanel(){

        JFrame frame = new JFrame("MDC Tablet - " + currentUser);
        frame.setSize(1000,650);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(8,1,8,8));
        sidebar.setBackground(sidebarColor);
        sidebar.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));
        sidebar.setPreferredSize(new Dimension(220,0));

        JLabel logo = new JLabel("MDC",SwingConstants.CENTER);
        logo.setFont(new Font("Segoe UI",Font.BOLD,24));
        logo.setForeground(Color.WHITE);

        JButton suspectBtn = createButton("Şüpheli Sorgu");
        JButton plakaBtn = createButton("Plaka Sorgu");
        JButton raporBtn = createButton("Rapor Yaz");
        JButton gorevBtn = createButton("Görev Ver");
        JButton userBtn = createButton("Kullanıcı Ekle");

        sidebar.add(logo);
        sidebar.add(new JLabel());
        sidebar.add(suspectBtn);
        sidebar.add(plakaBtn);
        sidebar.add(raporBtn);
        sidebar.add(gorevBtn);
        sidebar.add(userBtn);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(background);

        JLabel title = new JLabel("POLICE DATABASE SYSTEM",SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI",Font.BOLD,30));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));

        JPanel dashboard = new JPanel(new GridLayout(2,2,20,20));
        dashboard.setBorder(BorderFactory.createEmptyBorder(40,80,40,80));
        dashboard.setBackground(background);

        dashboard.add(createCard("Aktif Görevler","3"));
        dashboard.add(createCard("Bugünkü Rapor","12"));
        dashboard.add(createCard("Aranan Şahıs","5"));
        dashboard.add(createCard("Kayıtlı Araç","248"));

        content.add(title,BorderLayout.NORTH);
        content.add(dashboard,BorderLayout.CENTER);

        frame.add(sidebar,BorderLayout.WEST);
        frame.add(content,BorderLayout.CENTER);

        suspectBtn.addActionListener(e->suspectSorgu());
        plakaBtn.addActionListener(e->plakaSorgu());
        raporBtn.addActionListener(e->raporEkle());
        gorevBtn.addActionListener(e->gorevBelirle());
        userBtn.addActionListener(e->kullaniciEkle());

        frame.setVisible(true);

    }


    private JButton createButton(String text){

        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setBackground(buttonColor);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Segoe UI",Font.BOLD,14));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return b;
    }


    private JPanel createCard(String title,String value){

        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(40,40,40));
        card.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel t = new JLabel(title);
        t.setForeground(Color.LIGHT_GRAY);
        t.setFont(new Font("Segoe UI",Font.BOLD,14));

        JLabel v = new JLabel(value);
        v.setForeground(Color.WHITE);
        v.setFont(new Font("Segoe UI",Font.BOLD,32));

        card.add(t,BorderLayout.NORTH);
        card.add(v,BorderLayout.CENTER);

        return card;
    }


    private void suspectSorgu(){

        String tc = JOptionPane.showInputDialog("TC Kimlik gir");

        if(tc==null) return;

        if(tc.equals("12345678901")){

            JOptionPane.showMessageDialog(this,
                    "Ad: Ahmet Yılmaz\n"
                            +"Suç: Hırsızlık\n"
                            +"Durum: ARANIYOR");

        }
        else{

            JOptionPane.showMessageDialog(this,"Kayıt bulunamadı");

        }

    }


    private void plakaSorgu(){

        String plaka = JOptionPane.showInputDialog("Plaka gir");

        if(plaka==null) return;

        if(plaka.equalsIgnoreCase("34ABC123")){

            JOptionPane.showMessageDialog(this,
                    "Araç: BMW\n"
                            +"Sahip: Cem Karaca\n"
                            +"Durum: Temiz");

        }
        else{

            JOptionPane.showMessageDialog(this,"Araç bulunamadı");

        }

    }


    private void raporEkle(){

        String rapor = JOptionPane.showInputDialog("Olay raporu yaz");

        JOptionPane.showMessageDialog(this,"Rapor kaydedildi");

    }


    private void gorevBelirle(){

        String polis = JOptionPane.showInputDialog("Polis adı");

        JOptionPane.showMessageDialog(this,
                "TELSİZ:\nMemur " + polis + " görevlendirildi.");

    }


    private void kullaniciEkle(){

        String user = JOptionPane.showInputDialog("Yeni kullanıcı");

        JOptionPane.showMessageDialog(this,"Kullanıcı eklendi: " + user);

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new mdcGUI());

    }

}
