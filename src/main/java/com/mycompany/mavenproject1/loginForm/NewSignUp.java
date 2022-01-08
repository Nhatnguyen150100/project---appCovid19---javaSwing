/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1.loginForm;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nhatnguyen
 */
public class NewSignUp extends javax.swing.JFrame {
    Socket socket;
    account user = new account();

    /**
     * @throws IOException
     */
    public NewSignUp() throws IOException {
        this.socket = new Socket("127.0.0.1", 9999);
        initComponents();
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY);
    }

    public NewSignUp(String str){
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        userName = new javax.swing.JTextField();
        userPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sign_upBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(116, 214, 193));

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Pictures/backgroud.png")); // NOI18N

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("KHAI BÁO Y TẾ - GIẢM THIỂU LÂY LAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel2)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(220, 153, 141));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userName.setBackground(new java.awt.Color(220, 153, 141));
        userName.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        userName.setForeground(java.awt.Color.white);
        userName.setText("UserName");
        userName.setToolTipText("User Name");
        userName.setBorder(null);
        userName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userNameFocusGained(evt);
            }
        });
        jPanel3.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 350, 60));

        userPassword.setBackground(new java.awt.Color(220, 153, 141));
        userPassword.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        userPassword.setForeground(java.awt.Color.white);
        userPassword.setText("Password");
        userPassword.setToolTipText("Password");
        userPassword.setBorder(null);
        userPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userPasswordFocusGained(evt);
            }
        });
        jPanel3.add(userPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 350, 50));

        jSeparator1.setBackground(java.awt.Color.white);
        jSeparator1.setForeground(java.awt.Color.white);
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 350, 30));

        jSeparator2.setBackground(java.awt.Color.white);
        jSeparator2.setForeground(java.awt.Color.white);
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 350, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Pictures/icons8-password-100 (1).png")); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 50, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Pictures/icons8-user-48.png")); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 50, 60));

        sign_upBtn.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        sign_upBtn.setText("Sign up");
        sign_upBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_upBtnActionPerformed(evt);
            }
        });
        jPanel3.add(sign_upBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 160, 40));

        loginBtn.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        jPanel3.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 160, 40));

        jLabel5.setFont(new java.awt.Font("URW Bookman", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Forget password?");
        jLabel5.setToolTipText("forget your password");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, -1, -1));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Welcome to PC COVID");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jCheckBox1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jCheckBox1.setForeground(java.awt.Color.white);
        jCheckBox1.setText("Remember me");
        jPanel3.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sign_upBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_upBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        SignUp sign_up;
        sign_up = new SignUp();
        sign_up.startLayout(socket);
    }//GEN-LAST:event_sign_upBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:            
    }//GEN-LAST:event_loginBtnActionPerformed

    private void userNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFocusGained
        userName.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFocusGained

    private void userPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPasswordFocusGained
        userPassword.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_userPasswordFocusGained

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
        // TODO add your handling code here:
        String userName = this.userName.getText();
        String password = this.userPassword.getText();      
        if("".equals(userName)){
           JOptionPane.showMessageDialog(jLabel3,
                "UserName không được để trống",
                "Error UserName",
                JOptionPane.ERROR_MESSAGE);
        }else if("".equals(password)){
           JOptionPane.showMessageDialog(jLabel3,
                "Password không được để trống",
                "Error Password",
                JOptionPane.ERROR_MESSAGE);
        }else{
//            System.out.println("check");
            String passwordHard = getSHAHash(password);
            String up = createAccountMessage(userName,passwordHard);
            try {
                sendMessageToServer("login",socket);
                sendMessageToServer(up,socket);
            } catch (Exception e) {
                System.out.println("can't send choice message");
            }          
            try {
                InputStream istream = null;
                istream = socket.getInputStream();
                BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream), 1024);
                checkOutPut(receiveRead,socket,user);
            } catch (IOException ex) {
                Logger.getLogger(NewSignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loginBtnMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewSignUp signUp = null;
                try {
                    signUp = new NewSignUp();
                } catch (IOException ex) {
                    Logger.getLogger(NewSignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                signUp.setVisible(true);
            }
        });
    }
    
    public static String getSHAHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            return convertByteToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertByteToHex(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public void startLayout() throws IOException{
        account user = new account();   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewSignUp signUp = null;
                try {
                    signUp = new NewSignUp();
                } catch (IOException ex) {
                    Logger.getLogger(NewSignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                signUp.setVisible(true);
            }
        });
    }

    private void sendMessageToServer(String str, Socket sock) throws IOException {
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(str);       // sending to server
        pwrite.flush();            // flush the data
    }

    private String createAccountMessage(String name, String password){
        return name+ "_" +password;
    }

    private static String removeNonAscii(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) < 128){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String replaceUnreadable(String s){
        return s.replaceAll("\\P{Print}", "");
    }

    private void checkOutPut(BufferedReader receiveRead, Socket socket, account user) throws IOException {
        String receiveMessage;
        receiveMessage = String.valueOf(receiveRead.readLine());
        receiveMessage = removeNonAscii(receiveMessage);
        receiveMessage = replaceUnreadable(receiveMessage);
        if(!Objects.equals(receiveMessage, "0")) //receive from server
        {
            System.out.print("from server: ");
            System.out.println(receiveMessage); // displaying at DOS prompt
            if(receiveMessage.equals("Login successfully: Welcome to PC COVID")){
                System.out.println("\n--HOME PAGE--");
//                dispose();
//                inputTheUser(receiveMessage, user1);
                account user1 = new account();
                receivedMeessageFromServer(user1);
                
                HomePage homePage = new HomePage();
                homePage.startLayout(socket,user1);
                dispose();
            }else{
                JOptionPane.showMessageDialog(jPanel3,
                    receiveMessage,
                    "From Server",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void receivedMeessageFromServer(account user){
        InputStream istream = null;
        try {
            istream = socket.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(NewSignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream), 1024);
        try {
                checkOutPut1(receiveRead,socket,user);
        } catch (Exception e) {
                System.out.println("can't check out put receivedMeessageFromServer");
        }
    }

    private void checkOutPut1(BufferedReader receiveRead, Socket socket, account user) throws IOException {
        String receiveMessage;
        receiveMessage = String.valueOf(receiveRead.readLine());
        receiveMessage = removeNonAscii(receiveMessage);
        receiveMessage = replaceUnreadable(receiveMessage);
        if(!Objects.equals(receiveMessage, "0")) //receive from server
        {
            System.out.print("from server: ");
            System.out.println(receiveMessage); // displaying at DOS prompt
            inputTheUser(receiveMessage, user);
        }
    }

    private void inputTheUser(String receiveMessage, account user) {
        String[] listInfor = receiveMessage.split("_");
        user.setIdUser(listInfor[0]);
        user.setFirstName(listInfor[1]);
        user.setLastname(listInfor[2]);
        user.setCardId(listInfor[3]);
        user.setBirthOfDay(listInfor[4]);
        user.setGender(listInfor[5]);
        user.setNumberPhone(listInfor[6]);
        user.setEmail(listInfor[7]);
        user.setAddress(listInfor[8]);
        user.setState(listInfor[9]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton sign_upBtn;
    private javax.swing.JTextField userName;
    private javax.swing.JPasswordField userPassword;
    // End of variables declaration//GEN-END:variables
}
