import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Jframetest extends javax.swing.JFrame {
    private static final String ADMIN_PIN = "1234";

    public Jframetest() {
        initComponents();
        resize();
        setLocationRelativeTo(null);
        applyConsistentDesign();
    }

    private void applyConsistentDesign() {
        getContentPane().setBackground(new Color(204, 204, 204));
        jPanel2.setBackground(new Color(204, 204, 204));
        jPanel1.setBackground(new Color(204, 255, 255));

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        jLabel1.setFont(labelFont);
        jLabel1.setForeground(Color.BLACK);

        styleButton(jButton1);
        styleButton(jButton2);

        jTextField1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jTextField1.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.DARK_GRAY),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.DARK_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.GRAY);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel2 = new JPanel(new BorderLayout());
        jPanel1 = new JPanel(); // Bottom cyan bar
        jLabel1 = new JLabel("PLEASE ENTER YOUR PIN");
        jTextField1 = new JTextField();
        jButton1 = new JButton("SUBMIT");
        jButton2 = new JButton("Return");
        jLabel2 = new JLabel(new ImageIcon(getClass().getResource("/IMAGES/admin_logo.png")));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Login");
        setPreferredSize(new Dimension(425, 530));
        setResizable(false);

        // === Top bar with Return button ===
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setOpaque(false);
        jButton2.addActionListener(evt -> {
            NewJFrame main = new NewJFrame();
            dispose();
            main.setVisible(true);
        });
        topPanel.add(jButton2);

        // === Center panel with everything centered ===
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        jLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel2.setPreferredSize(new Dimension(190, 180));
        jLabel2.setMaximumSize(new Dimension(190, 180));
        jLabel2.setMinimumSize(new Dimension(190, 180));

        jLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jTextField1.setMaximumSize(new Dimension(100, 26));
        jTextField1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButton1.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(jLabel2);
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(jLabel1);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(jTextField1);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(jButton1);

        // === Bottom bar ===
        jPanel1.setPreferredSize(new Dimension(425, 16));

        // === Add all to main panel ===
        jPanel2.add(topPanel, BorderLayout.NORTH);
        jPanel2.add(centerPanel, BorderLayout.CENTER);
        jPanel2.add(jPanel1, BorderLayout.SOUTH);

        getContentPane().add(jPanel2);
        pack();

        // Action for SUBMIT
        jButton1.addActionListener(evt -> {
            String enteredPin = jTextField1.getText();
            if (enteredPin.equals(ADMIN_PIN)) {
                JOptionPane.showMessageDialog(null,
                        "Login successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                JFrame adminFrame = new JFrame("Admin Dashboard");
                adminFrame.setSize(600, 400);
                adminFrame.setLocationRelativeTo(null);
                adminFrame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Invalid PIN. Please try again.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                jTextField1.setText("");
                jTextField1.requestFocus();
            }
        });
    }

    private void resize() {
        Icon i = jLabel2.getIcon();
        if (i != null) {
            ImageIcon icon = (ImageIcon) i;
            Image image = icon.getImage().getScaledInstance(
                jLabel2.getWidth(),
                jLabel2.getHeight(),
                Image.SCALE_SMOOTH);
            jLabel2.setIcon(new ImageIcon(image));
        }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            new Jframetest().setVisible(true);
        });
    }

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField jTextField1;
}
