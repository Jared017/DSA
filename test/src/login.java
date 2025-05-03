/**
 * This class can be used as a standalone login application or as a utility class.
 * For the NetBeans project, use NewJFrame.java as the main entry point.
 */
public class login {
    // Static method to verify admin credentials
    public static boolean verifyAdminPin(String pin) {
        return pin != null && pin.equals("1234");
    }
    
    // Main method allows this class to be run independently
    public static void main(String[] args) {
        // Create and display the NewJFrame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
}