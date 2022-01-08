/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1.loginForm;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

import ortherLayout.panelHistoryPage;
import ortherLayout.panelProfilePage;
import ortherLayout.panelQrCodePage;
import ortherLayout.panelUpdatePage;
import waypoint.EventWaypoint;
import waypoint.MyWaypoint;
import waypoint.WaypointRender;

/**
 *
 * @author nhatnguyen
 */
public class HomePage extends javax.swing.JFrame implements Runnable, ThreadFactory{
    private Socket socket;
    public account user = new account();
    private panelHomePage homePage = new panelHomePage();

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    private final Set<MyWaypoint> waypoints = new HashSet<>();
    private EventWaypoint event;
    /**
     * Creates new form HomePage
     */
    public HomePage(Socket socket,account user) throws IOException {
//        setLocation(null);
        this.user = user;
        this.socket = socket;
        initComponents();
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY);
        menuClicked(panelHomePage);
        this.firstName.setText(this.user.getFirstName());
        this.idUser.setText(this.user.getIdUser());  
//        receivedMeessageFromServer(this.user);
    }

    public HomePage(){}

    private void init(ArrayList<LocationOfF0> listLocationOfF0){
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer1.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition(21.022819, 105.840568);
        jXMapViewer1.setAddressLocation(geo);
        jXMapViewer1.setZoom(4);

        MouseInputListener mouse = new PanMouseInputListener(jXMapViewer1);
        jXMapViewer1.addMouseListener(mouse);
        jXMapViewer1.addMouseMotionListener(mouse);
        jXMapViewer1.addMouseWheelListener((new ZoomMouseWheelListenerCenter(jXMapViewer1)));
        if(!listLocationOfF0.isEmpty()){
            for(int i = 0; i < listLocationOfF0.size(); i++){    
                addWaypoint(new MyWaypoint(listLocationOfF0.get(i).getLocation(), event, new GeoPosition(Float.parseFloat(listLocationOfF0.get(i).getLongitude()), Float.parseFloat(listLocationOfF0.get(i).getLatitude()))));
            }
        }

//        addWaypoint(new MyWaypoint("Test 001", event, new GeoPosition(21.005082, 105.843500)));
//        addWaypoint(new MyWaypoint("Test 002", event, new GeoPosition(21.003439, 105.833705)));
//        event = getEvent();
    }
    
    private void addWaypoint(MyWaypoint waypoint) {
        for (MyWaypoint d : waypoints) {
            jXMapViewer1.remove(d.getButton());
        }
        waypoints.add(waypoint);
        initWaypoint();
    }

    private void initWaypoint() {
        WaypointPainter<MyWaypoint> wp = new WaypointRender();
        wp.setWaypoints(waypoints);
        jXMapViewer1.setOverlayPainter(wp);
        for (MyWaypoint d : waypoints) {
            jXMapViewer1.add(d.getButton());
        }
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idUser = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();
        logOutbtn = new javax.swing.JButton();
        paneNotification = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        paneHome = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        paneProfile = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        paneQrCode = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        paneHistory = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        paneMap = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        paneUpdate = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelNotificationPage = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        waringMessage = new javax.swing.JLabel();
        panelHomePage = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        panelProfilePage = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        fullName = new javax.swing.JLabel();
        cardId = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        birthDay = new javax.swing.JLabel();
        numberPhone = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        state = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        panelQrCodePage = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        camera = new javax.swing.JPanel();
        qrBtn = new javax.swing.JButton();
        panelHistoryPage = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        historyScroll = new javax.swing.JScrollPane();
        tableHistory = new javax.swing.JTable();
        panelMap = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jXMapViewer1 = new org.jxmapviewer.JXMapViewer();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        panelUpdatePage = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        firstNameUpdate = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        lastNameUpdate = new javax.swing.JTextField();
        cardIdInformationUpdate = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        birthDayUpdate = new javax.swing.JTextField();
        numberPhoneUpdate = new javax.swing.JTextField();
        emailUpdate = new javax.swing.JTextField();
        addressUpdate = new javax.swing.JTextField();
        sendInformationUpdate = new javax.swing.JButton();
        nuBtnUpdate = new javax.swing.JRadioButton();
        namBtnUpdate = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepane.setBackground(new java.awt.Color(116, 214, 193));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-protect-128 (3).png")); // NOI18N
        sidepane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 12, -1, -1));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("PC COVID");
        sidepane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 12, -1, -1));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setForeground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        sidepane.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 70, 390, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-user-128.png")); // NOI18N
        jLabel4.setText("jLabel4");
        sidepane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 127, 112));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("ID:");
        sidepane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        idUser.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        idUser.setForeground(java.awt.Color.white);
        sidepane.add(idUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 93, 29));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Name:");
        sidepane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        firstName.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        firstName.setForeground(java.awt.Color.white);
        sidepane.add(firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 107, 29));

        logOutbtn.setBackground(java.awt.Color.white);
        logOutbtn.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        logOutbtn.setForeground(new java.awt.Color(116, 214, 193));
        logOutbtn.setText("Log out");
        logOutbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logOutbtnMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutbtnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutbtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutbtnMouseEntered(evt);
            }
        });
        sidepane.add(logOutbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 770, 170, 52));

        paneNotification.setBackground(new java.awt.Color(152, 234, 217));
        paneNotification.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        paneNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneNotificationMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paneNotificationMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneNotificationMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneNotificationMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneNotificationMouseEntered(evt);
            }
        });
        paneNotification.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Desktop/icons8-notification-60 (1).png")); // NOI18N
        jLabel63.setText("jLabel7");
        paneNotification.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 49, -1));

        jLabel66.setFont(new java.awt.Font("Ubuntu", 1, 27)); // NOI18N
        jLabel66.setForeground(java.awt.Color.white);
        jLabel66.setText("Notification");
        paneNotification.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        sidepane.add(paneNotification, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 380, 60));

        paneHome.setBackground(new java.awt.Color(152, 234, 217));
        paneHome.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        paneHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneHomeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paneHomeMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneHomeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneHomeMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneHomeMouseEntered(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-home-50 (1).png")); // NOI18N
        jLabel7.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 27)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Home");

        javax.swing.GroupLayout paneHomeLayout = new javax.swing.GroupLayout(paneHome);
        paneHome.setLayout(paneHomeLayout);
        paneHomeLayout.setHorizontalGroup(
            paneHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneHomeLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addGap(0, 161, Short.MAX_VALUE))
        );
        paneHomeLayout.setVerticalGroup(
            paneHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        sidepane.add(paneHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 380, 60));

        paneProfile.setBackground(new java.awt.Color(152, 234, 217));
        paneProfile.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        paneProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneProfileMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paneProfileMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneProfileMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneProfileMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneProfileMouseEntered(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-information-64 (1).png")); // NOI18N

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 27)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Profile");

        javax.swing.GroupLayout paneProfileLayout = new javax.swing.GroupLayout(paneProfile);
        paneProfile.setLayout(paneProfileLayout);
        paneProfileLayout.setHorizontalGroup(
            paneProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneProfileLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel10)
                .addGap(0, 147, Short.MAX_VALUE))
        );
        paneProfileLayout.setVerticalGroup(
            paneProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(paneProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        sidepane.add(paneProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 380, 60));

        paneQrCode.setBackground(new java.awt.Color(152, 234, 217));
        paneQrCode.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        paneQrCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneQrCodeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paneQrCodeMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneQrCodeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneQrCodeMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneQrCodeMouseEntered(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-qr-code-64 (1).png")); // NOI18N

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 27)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("QR Code");

        javax.swing.GroupLayout paneQrCodeLayout = new javax.swing.GroupLayout(paneQrCode);
        paneQrCode.setLayout(paneQrCodeLayout);
        paneQrCodeLayout.setHorizontalGroup(
            paneQrCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneQrCodeLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        paneQrCodeLayout.setVerticalGroup(
            paneQrCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneQrCodeLayout.createSequentialGroup()
                .addGroup(paneQrCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneQrCodeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        sidepane.add(paneQrCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 380, 60));

        paneHistory.setBackground(new java.awt.Color(152, 234, 217));
        paneHistory.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        paneHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneHistoryMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paneHistoryMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneHistoryMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneHistoryMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneHistoryMouseEntered(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-history-64 (1).png")); // NOI18N

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 27)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setText("History");

        javax.swing.GroupLayout paneHistoryLayout = new javax.swing.GroupLayout(paneHistory);
        paneHistory.setLayout(paneHistoryLayout);
        paneHistoryLayout.setHorizontalGroup(
            paneHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneHistoryLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel13)
                .addGap(36, 36, 36)
                .addComponent(jLabel14)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        paneHistoryLayout.setVerticalGroup(
            paneHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(paneHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        sidepane.add(paneHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 380, 60));

        paneMap.setBackground(new java.awt.Color(152, 234, 217));
        paneMap.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        paneMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneMapMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paneMapMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneMapMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneMapMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneMapMouseEntered(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/netbean/mavenproject1/src/main/java/icon/icons8-map-64 (1) (1).png")); // NOI18N
        jLabel15.setText("jLabel15");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 29)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText("Map");

        javax.swing.GroupLayout paneMapLayout = new javax.swing.GroupLayout(paneMap);
        paneMap.setLayout(paneMapLayout);
        paneMapLayout.setHorizontalGroup(
            paneMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMapLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel16)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        paneMapLayout.setVerticalGroup(
            paneMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMapLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(paneMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)))
        );

        sidepane.add(paneMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 380, 60));

        jLabel20.setBackground(java.awt.Color.white);
        jLabel20.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setText("KHAI BÁO Y TẾ - GIẢM THIỂU LÂY LAN");
        sidepane.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 47, -1, 17));

        paneUpdate.setBackground(new java.awt.Color(152, 234, 217));
        paneUpdate.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        paneUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneUpdateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paneUpdateMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneUpdateMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneUpdateMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneUpdateMouseEntered(evt);
            }
        });

        jLabel71.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-update-left-rotation-50 (1).png")); // NOI18N
        jLabel71.setText("jLabel15");

        jLabel74.setFont(new java.awt.Font("Ubuntu", 1, 27)); // NOI18N
        jLabel74.setForeground(java.awt.Color.white);
        jLabel74.setText("Update");

        javax.swing.GroupLayout paneUpdateLayout = new javax.swing.GroupLayout(paneUpdate);
        paneUpdate.setLayout(paneUpdateLayout);
        paneUpdateLayout.setHorizontalGroup(
            paneUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneUpdateLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel74)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        paneUpdateLayout.setVerticalGroup(
            paneUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneUpdateLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(paneUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)))
        );

        sidepane.add(paneUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, -1));

        jPanel1.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 840));

        jPanel4.setBackground(java.awt.Color.white);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelNotificationPage.setBackground(new java.awt.Color(220, 153, 141));
        panelNotificationPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelNotificationPage.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 213, 1013, -1));

        jLabel67.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/pngwing.com (1).png")); // NOI18N
        panelNotificationPage.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 12, -1, -1));

        jLabel68.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-protect-100.png")); // NOI18N
        panelNotificationPage.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 47, -1, -1));

        jLabel69.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel69.setForeground(java.awt.Color.white);
        jLabel69.setText("PC COVID");
        panelNotificationPage.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 56, -1, -1));

        jLabel70.setBackground(java.awt.Color.white);
        jLabel70.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 18)); // NOI18N
        jLabel70.setForeground(java.awt.Color.white);
        jLabel70.setText("KHAI BÁO Y TẾ - GIẢM THIỂU LÂY LAN");
        panelNotificationPage.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 110, -1, 17));

        jLabel72.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 36)); // NOI18N
        jLabel72.setForeground(java.awt.Color.white);
        jLabel72.setText("Thông báo");
        panelNotificationPage.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        jLabel73.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Desktop/icons8-notification-94.png")); // NOI18N
        panelNotificationPage.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jPanel13.setBackground(java.awt.Color.white);

        waringMessage.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        waringMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        waringMessage.setAlignmentX(5.0F);
        waringMessage.setAlignmentY(5.0F);
        waringMessage.setBorder(new javax.swing.border.LineBorder(java.awt.Color.red, 3, true));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(waringMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(waringMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelNotificationPage.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 720, 460));

        jPanel2.add(panelNotificationPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 1013, 840));

        panelHomePage.setBackground(new java.awt.Color(220, 153, 141));
        panelHomePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelHomePage.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 213, 1013, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/pngwing.com (1).png")); // NOI18N
        panelHomePage.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 12, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-protect-100.png")); // NOI18N
        panelHomePage.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 47, -1, -1));

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel19.setForeground(java.awt.Color.white);
        jLabel19.setText("PC COVID");
        panelHomePage.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 56, -1, -1));

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("KHAI BÁO Y TẾ - GIẢM THIỂU LÂY LAN");
        panelHomePage.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 110, -1, 17));

        jLabel21.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/—Pngtree—cegah dan tangkal covid-19 dengan_6011555 (2).png")); // NOI18N
        panelHomePage.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        jLabel22.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 36)); // NOI18N
        jLabel22.setForeground(java.awt.Color.white);
        jLabel22.setText("Thực hiện quy định 5K");
        panelHomePage.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        jLabel37.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-attention-96.png")); // NOI18N
        panelHomePage.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jPanel2.add(panelHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 1013, 840));

        panelProfilePage.setBackground(new java.awt.Color(220, 153, 141));
        panelProfilePage.setPreferredSize(new java.awt.Dimension(991, 888));
        panelProfilePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelProfilePage.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 213, 991, -1));

        jLabel38.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/pngwing.com (1).png")); // NOI18N
        panelProfilePage.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 12, -1, -1));

        jLabel39.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-protect-100.png")); // NOI18N
        panelProfilePage.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 47, -1, -1));

        jLabel40.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel40.setForeground(java.awt.Color.white);
        jLabel40.setText("PC COVID");
        panelProfilePage.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 56, -1, -1));

        jLabel41.setBackground(java.awt.Color.white);
        jLabel41.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 18)); // NOI18N
        jLabel41.setForeground(java.awt.Color.white);
        jLabel41.setText("KHAI BÁO Y TẾ - GIẢM THIỂU LÂY LAN");
        panelProfilePage.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 110, -1, 17));

        jLabel42.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 48)); // NOI18N
        jLabel42.setForeground(java.awt.Color.white);
        jLabel42.setText("Thông tin cơ bản");
        panelProfilePage.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 246, -1, -1));

        jLabel43.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel43.setForeground(java.awt.Color.white);
        jLabel43.setText("Trạng thái dịch tễ:");
        panelProfilePage.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 700, -1, -1));

        jLabel44.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel44.setForeground(java.awt.Color.white);
        jLabel44.setText("Họ và tên:");
        panelProfilePage.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 391, -1, -1));

        jLabel45.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel45.setForeground(java.awt.Color.white);
        jLabel45.setText("Số CCCD:");
        panelProfilePage.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, -1));

        jLabel46.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel46.setForeground(java.awt.Color.white);
        jLabel46.setText("Ngày sinh:");
        panelProfilePage.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 591, -1, -1));

        jLabel47.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel47.setForeground(java.awt.Color.white);
        jLabel47.setText("Giới tính:");
        panelProfilePage.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 700, -1, -1));

        jLabel48.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel48.setForeground(java.awt.Color.white);
        jLabel48.setText("Số điện thoại:");
        panelProfilePage.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, -1));

        jLabel49.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel49.setForeground(java.awt.Color.white);
        jLabel49.setText("Email:");
        panelProfilePage.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 494, -1, -1));

        jLabel50.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel50.setForeground(java.awt.Color.white);
        jLabel50.setText("Địa chỉ:");
        panelProfilePage.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 591, -1, -1));

        fullName.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 22)); // NOI18N
        fullName.setForeground(java.awt.Color.white);
        panelProfilePage.add(fullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 273, 35));

        cardId.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 22)); // NOI18N
        cardId.setForeground(java.awt.Color.white);
        panelProfilePage.add(cardId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 283, 30));

        gender.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 22)); // NOI18N
        gender.setForeground(java.awt.Color.white);
        panelProfilePage.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 700, 186, 30));

        birthDay.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 22)); // NOI18N
        birthDay.setForeground(java.awt.Color.white);
        panelProfilePage.add(birthDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 196, 30));

        numberPhone.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 22)); // NOI18N
        numberPhone.setForeground(java.awt.Color.white);
        panelProfilePage.add(numberPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 293, 35));

        email.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 22)); // NOI18N
        email.setForeground(java.awt.Color.white);
        panelProfilePage.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 368, 40));

        address.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 22)); // NOI18N
        address.setForeground(java.awt.Color.white);
        panelProfilePage.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, 342, 40));

        state.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 22)); // NOI18N
        state.setForeground(java.awt.Color.white);
        panelProfilePage.add(state, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 700, 206, 30));

        jPanel9.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panelProfilePage.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 322, 412, -1));

        jLabel51.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-list-100.png")); // NOI18N
        panelProfilePage.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 246, -1, -1));

        jPanel2.add(panelProfilePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 1013, -1));

        panelQrCodePage.setBackground(new java.awt.Color(220, 153, 141));
        panelQrCodePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelQrCodePage.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 213, 1013, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/pngwing.com (1).png")); // NOI18N
        panelQrCodePage.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 12, -1, -1));

        jLabel54.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-protect-100.png")); // NOI18N
        panelQrCodePage.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 47, -1, -1));

        jLabel55.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel55.setForeground(java.awt.Color.white);
        jLabel55.setText("PC COVID");
        panelQrCodePage.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 56, -1, -1));

        jLabel56.setBackground(java.awt.Color.white);
        jLabel56.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 18)); // NOI18N
        jLabel56.setForeground(java.awt.Color.white);
        jLabel56.setText("KHAI BÁO Y TẾ - GIẢM THIỂU LÂY LAN");
        panelQrCodePage.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 110, -1, 17));

        jLabel58.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 36)); // NOI18N
        jLabel58.setForeground(java.awt.Color.white);
        jLabel58.setText("Quét QR  để thực hiện khai báo y tế");
        panelQrCodePage.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jLabel59.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-qr-code-100.png")); // NOI18N
        panelQrCodePage.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 112, 135));

        camera.setBackground(java.awt.Color.white);
        camera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        qrBtn.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Desktop/6498715_application_code_mobile_qr_smartphone_icon (1) (1).png")); // NOI18N
        qrBtn.setBorder(null);
        qrBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qrBtnMouseClicked(evt);
            }
        });
        qrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qrBtnActionPerformed(evt);
            }
        });
        camera.add(qrBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 420));

        panelQrCodePage.add(camera, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        jPanel2.add(panelQrCodePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 1013, 850));

        panelHistoryPage.setBackground(new java.awt.Color(220, 153, 141));

        jPanel11.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jLabel57.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/pngwing.com (1).png")); // NOI18N

        jLabel60.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-protect-100.png")); // NOI18N

        jLabel61.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel61.setForeground(java.awt.Color.white);
        jLabel61.setText("PC COVID");

        jLabel62.setBackground(java.awt.Color.white);
        jLabel62.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 18)); // NOI18N
        jLabel62.setForeground(java.awt.Color.white);
        jLabel62.setText("KHAI BÁO Y TẾ - GIẢM THIỂU LÂY LAN");

        jLabel64.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 36)); // NOI18N
        jLabel64.setForeground(java.awt.Color.white);
        jLabel64.setText("Lịch sử di chuyển của bạn:");

        jLabel65.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Desktop/5728208_flight_route_tourism_transmit_travel_icon.png")); // NOI18N

        historyScroll.setBackground(java.awt.Color.white);
        historyScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        historyScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        historyScroll.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        tableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location", "Time"
            }
        ));
        historyScroll.setViewportView(tableHistory);

        javax.swing.GroupLayout panelHistoryPageLayout = new javax.swing.GroupLayout(panelHistoryPage);
        panelHistoryPage.setLayout(panelHistoryPageLayout);
        panelHistoryPageLayout.setHorizontalGroup(
            panelHistoryPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHistoryPageLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHistoryPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel57)
                .addGap(124, 124, 124))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelHistoryPageLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel65)
                .addGap(18, 18, 18)
                .addGroup(panelHistoryPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(historyScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHistoryPageLayout.setVerticalGroup(
            panelHistoryPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoryPageLayout.createSequentialGroup()
                .addGroup(panelHistoryPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHistoryPageLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panelHistoryPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addGroup(panelHistoryPageLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelHistoryPageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel57)))
                .addGap(21, 21, 21)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelHistoryPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHistoryPageLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel64)
                        .addGap(34, 34, 34)
                        .addComponent(historyScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelHistoryPageLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel65)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel2.add(panelHistoryPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 1013, -1));

        panelMap.setBackground(new java.awt.Color(220, 153, 141));
        panelMap.setPreferredSize(new java.awt.Dimension(991, 888));
        panelMap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelMap.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1010, -1));

        jLabel75.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/pngwing.com (1).png")); // NOI18N
        panelMap.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 12, -1, -1));

        jLabel76.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-protect-100.png")); // NOI18N
        panelMap.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 47, -1, -1));

        jLabel77.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel77.setForeground(java.awt.Color.white);
        jLabel77.setText("PC COVID");
        panelMap.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 56, -1, -1));

        jLabel78.setBackground(java.awt.Color.white);
        jLabel78.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 18)); // NOI18N
        jLabel78.setForeground(java.awt.Color.white);
        jLabel78.setText("KHAI BÁO Y TẾ - GIẢM THIỂU LÂY LAN");
        panelMap.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 17));

        javax.swing.GroupLayout jXMapViewer1Layout = new javax.swing.GroupLayout(jXMapViewer1);
        jXMapViewer1.setLayout(jXMapViewer1Layout);
        jXMapViewer1Layout.setHorizontalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jXMapViewer1Layout.setVerticalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXMapViewer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXMapViewer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelMap.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 940, 500));

        jLabel79.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 36)); // NOI18N
        jLabel79.setForeground(java.awt.Color.white);
        jLabel79.setText("Bản đồ địa điểm Covid 19");
        panelMap.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        jLabel80.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-map-64.png")); // NOI18N
        panelMap.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 60));

        jPanel2.add(panelMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 1013, -1));

        panelUpdatePage.setBackground(new java.awt.Color(220, 153, 141));
        panelUpdatePage.setPreferredSize(new java.awt.Dimension(991, 888));
        panelUpdatePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        panelUpdatePage.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1010, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/pngwing.com (1).png")); // NOI18N
        panelUpdatePage.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 12, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-protect-100.png")); // NOI18N
        panelUpdatePage.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 47, -1, -1));

        jLabel25.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel25.setForeground(java.awt.Color.white);
        jLabel25.setText("PC COVID");
        panelUpdatePage.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 56, -1, -1));

        jLabel26.setBackground(java.awt.Color.white);
        jLabel26.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 18)); // NOI18N
        jLabel26.setForeground(java.awt.Color.white);
        jLabel26.setText("KHAI BÁO Y TẾ - GIẢM THIỂU LÂY LAN");
        panelUpdatePage.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 17));

        jLabel27.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 48)); // NOI18N
        jLabel27.setForeground(java.awt.Color.white);
        jLabel27.setText("Update thông tin ");
        panelUpdatePage.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 246, -1, -1));

        jLabel29.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel29.setForeground(java.awt.Color.white);
        jLabel29.setText("Tên đầu:");
        panelUpdatePage.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        jLabel30.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel30.setForeground(java.awt.Color.white);
        jLabel30.setText("Số CCCD:");
        panelUpdatePage.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, -1, -1));

        jLabel31.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel31.setForeground(java.awt.Color.white);
        jLabel31.setText("Ngày sinh:");
        panelUpdatePage.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, -1, -1));

        jLabel32.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel32.setForeground(java.awt.Color.white);
        jLabel32.setText("Giới tính:");
        panelUpdatePage.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 650, -1, -1));

        jLabel33.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel33.setForeground(java.awt.Color.white);
        jLabel33.setText("Số điện thoại:");
        panelUpdatePage.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, -1));

        jLabel34.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel34.setForeground(java.awt.Color.white);
        jLabel34.setText("Email:");
        panelUpdatePage.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, -1, -1));

        jLabel35.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel35.setForeground(java.awt.Color.white);
        jLabel35.setText("Địa chỉ:");
        panelUpdatePage.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, -1, -1));

        jPanel7.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panelUpdatePage.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 322, 425, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon("/home/nhatnguyen/Downloads/icons8-list-100.png")); // NOI18N
        panelUpdatePage.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 246, -1, -1));

        firstNameUpdate.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        panelUpdatePage.add(firstNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 251, 35));

        jLabel52.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        jLabel52.setForeground(java.awt.Color.white);
        jLabel52.setText("Tên cuối:");
        panelUpdatePage.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        lastNameUpdate.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        panelUpdatePage.add(lastNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 251, 35));

        cardIdInformationUpdate.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        panelUpdatePage.add(cardIdInformationUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 251, 35));

        jLabel53.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel53.setForeground(java.awt.Color.white);
        jLabel53.setText("(dd-mm-yyyy)");
        panelUpdatePage.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 690, -1, -1));

        birthDayUpdate.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        panelUpdatePage.add(birthDayUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 650, 251, 35));

        numberPhoneUpdate.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        panelUpdatePage.add(numberPhoneUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 251, 35));

        emailUpdate.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        panelUpdatePage.add(emailUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 251, 35));

        addressUpdate.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        panelUpdatePage.add(addressUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 560, 251, 35));

        sendInformationUpdate.setFont(new java.awt.Font("Ubuntu", 1, 30)); // NOI18N
        sendInformationUpdate.setForeground(new java.awt.Color(220, 153, 141));
        sendInformationUpdate.setText("Send your information");
        sendInformationUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendInformationUpdateMouseClicked(evt);
            }
        });
        panelUpdatePage.add(sendInformationUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 730, 430, 80));

        nuBtnUpdate.setBackground(java.awt.Color.white);
        buttonGroup1.add(nuBtnUpdate);
        nuBtnUpdate.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        nuBtnUpdate.setForeground(java.awt.Color.white);
        nuBtnUpdate.setText("Nữ");
        panelUpdatePage.add(nuBtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 650, -1, -1));

        namBtnUpdate.setBackground(java.awt.Color.white);
        buttonGroup1.add(namBtnUpdate);
        namBtnUpdate.setFont(new java.awt.Font("Noto Serif CJK TC", 1, 24)); // NOI18N
        namBtnUpdate.setForeground(java.awt.Color.white);
        namBtnUpdate.setText("Nam");
        panelUpdatePage.add(namBtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 650, -1, -1));

        jPanel2.add(panelUpdatePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 1013, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1025, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 1010, 840));

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

    private void logOutbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutbtnMouseClicked
        // TODO add your handling code here:
//        closeWebcam();
//        if(this.webcam.isOpen()==true){
//            webcam.close();
//        }       
        int result = JOptionPane.showConfirmDialog(panelHomePage,
                        "Bạn đã có muốn thoát PC COVID?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            dispose();
            try {
                sendMessageToServer("5",socket);
            } catch (Exception e) {
                System.out.println("can't send choice(5) to Server");
            }

            NewSignUp login = null;
            login = new NewSignUp("");
            try {

                login.startLayout();
            } catch (Exception e) {
                System.out.println("can't start NewSignUp layout");
            }
        }              
    }//GEN-LAST:event_logOutbtnMouseClicked

    private void paneHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHomeMouseEntered
        paneHome.setBackground(new Color(220,153,141));// TODO add your handling code here:
    }//GEN-LAST:event_paneHomeMouseEntered

    private void paneHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHomeMouseExited
        // TODO add your handling code here:
        paneHome.setBackground(new Color(152,234,217));
    }//GEN-LAST:event_paneHomeMouseExited

    private void paneHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHomeMousePressed
        // TODO add your handling code here:
        paneHome.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneHomeMousePressed

    private void paneHomeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHomeMouseReleased
        // TODO add your handling code here:
        paneHome.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneHomeMouseReleased

    private void paneProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneProfileMouseEntered
        // TODO add your handling code here:
        paneProfile.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneProfileMouseEntered

    private void paneProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneProfileMouseExited
        // TODO add your handling code here:
        paneProfile.setBackground(new Color(152,234,217));
    }//GEN-LAST:event_paneProfileMouseExited

    private void paneProfileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneProfileMousePressed
        // TODO add your handling code here:
        paneProfile.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneProfileMousePressed

    private void paneProfileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneProfileMouseReleased
        // TODO add your handling code here:
        paneProfile.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneProfileMouseReleased

    private void paneQrCodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneQrCodeMouseEntered
        // TODO add your handling code here:
        paneQrCode.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneQrCodeMouseEntered

    private void paneQrCodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneQrCodeMouseExited
        // TODO add your handling code here:
        paneQrCode.setBackground(new Color(152,234,217));
    }//GEN-LAST:event_paneQrCodeMouseExited

    private void paneQrCodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneQrCodeMousePressed
        // TODO add your handling code here:
        paneQrCode.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneQrCodeMousePressed

    private void paneQrCodeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneQrCodeMouseReleased
        // TODO add your handling code here:
        paneQrCode.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneQrCodeMouseReleased

    private void paneHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHistoryMouseEntered
        // TODO add your handling code here:
        paneHistory.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneHistoryMouseEntered

    private void paneHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHistoryMouseExited
        // TODO add your handling code here:
        paneHistory.setBackground(new Color(152,234,217));
    }//GEN-LAST:event_paneHistoryMouseExited

    private void paneHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHistoryMousePressed
        // TODO add your handling code here:
        paneHistory.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneHistoryMousePressed

    private void paneHistoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHistoryMouseReleased
        // TODO add your handling code here:
        paneHistory.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneHistoryMouseReleased

    private void paneMapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMapMouseEntered
        // TODO add your handling code here:
        paneMap.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneMapMouseEntered

    private void paneMapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMapMouseExited
        // TODO add your handling code here:
        paneMap.setBackground(new Color(152,234,217));
    }//GEN-LAST:event_paneMapMouseExited

    private void paneMapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMapMousePressed
        // TODO add your handling code here:
        paneMap.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneMapMousePressed

    private void paneMapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMapMouseReleased
        // TODO add your handling code here:
        paneMap.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneMapMouseReleased

    private void paneHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHomeMouseClicked
        // TODO add your handling code here:
        try {
            menuClicked(panelHomePage);
            if(webcam.isOpen()){
                closeWebcam();
            } 
        } catch (Exception e) {
            System.out.println("can't start layout paneHomeMouseClicked");
        }
        
    }//GEN-LAST:event_paneHomeMouseClicked

    private void paneProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneProfileMouseClicked
        // TODO add your handling code here:
        try {
            menuClicked(panelProfilePage);          
            sendMessageToServer("1",socket);
            InputStream istream = null;
            try {
                istream = socket.getInputStream();
            } catch (IOException ex) {
                Logger.getLogger(NewSignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream), 1024);
            try {
                checkOutPut(receiveRead,socket,this.user);
            } catch (Exception e) {
                System.out.println("can't check out put");
            }
            setInformationUser();
            setTextNameAndId(user);
            if(webcam.isOpen()){
                closeWebcam();
            } 
        } catch (Exception e) {
            System.out.println("can't start layout paneProfileMouseClicked");
        }
    }//GEN-LAST:event_paneProfileMouseClicked

    private void paneMapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMapMouseClicked
        // TODO add your handling code here:
        try {           
            menuClicked(panelMap);        
//            init();
            sendMessageToServer("7", socket);
            InputStream istream = null;
            try {
                istream = socket.getInputStream();
            } catch (IOException ex) {
                Logger.getLogger(NewSignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream), 1024);
            try {
                checkOutPutStringLocation(receiveRead,socket);
            } catch (Exception e) {
                System.out.println("can't check out put");
            }
            if(webcam.isOpen()){
                webcam.close();
            } 
        } catch (Exception e) {
            System.out.println("can't start layout paneMapClicked\n"+ e);
            
        }
    }//GEN-LAST:event_paneMapMouseClicked

    private void paneQrCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneQrCodeMouseClicked
        // TODO add your handling code here:
        try {
            menuClicked(panelQrCodePage);
            initWebcam();
        } catch (Exception e) {
            System.out.println("can't start layout paneQrCodeMouseClicked");
        }
    }//GEN-LAST:event_paneQrCodeMouseClicked

    private void logOutbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutbtnMouseEntered
        // TODO add your handling code here:
        logOutbtn.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_logOutbtnMouseEntered

    private void logOutbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutbtnMouseExited
        // TODO add your handling code here:
        logOutbtn.setBackground(Color.WHITE);
    }//GEN-LAST:event_logOutbtnMouseExited

    private void logOutbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutbtnMousePressed
        // TODO add your handling code here:
        logOutbtn.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_logOutbtnMousePressed

    private void logOutbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutbtnMouseReleased
        // TODO add your handling code here:
        logOutbtn.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_logOutbtnMouseReleased

    private void sendInformationUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendInformationUpdateMouseClicked
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(jLabel3,
                        "Bạn muốn update thông tin cá nhân như trên?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            try {
                sendMessageToServer("4", socket);
                String messageUpdate = createInforUpdateAccount();
                sendMessageToServer(messageUpdate, socket);
                String receivedMessage;
                InputStream istream = socket.getInputStream();
                BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream), 1024);
                receivedMessage = getMessageFromServer(receiveRead,socket);
                if(!receivedMessage.equals("")){
                    JOptionPane.showMessageDialog(jLabel3,
                    receivedMessage,
                    "From Server",
                    JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println("can't send update information");
            }            
        }        
    }//GEN-LAST:event_sendInformationUpdateMouseClicked

    private void qrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qrBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qrBtnActionPerformed

    private void qrBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qrBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_qrBtnMouseClicked

    private void paneHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneHistoryMouseClicked
        // TODO add your handling code here:
        try {
            menuClicked(panelHistoryPage);
            sendMessageToServer("3", socket);
            showHistory();
            closeWebcam();          
        } catch (Exception e) {
            System.out.println("can't start layout paneHistoryMouseClicked");
        }
    }//GEN-LAST:event_paneHistoryMouseClicked

    private void paneNotificationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneNotificationMousePressed
        // TODO add your handling code here:
        paneNotification.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneNotificationMousePressed

    private void paneNotificationMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneNotificationMouseReleased
        // TODO add your handling code here:
        paneNotification.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneNotificationMouseReleased

    private void paneNotificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneNotificationMouseClicked
        // TODO add your handling code here:
        try {
            menuClicked(panelNotificationPage);
            sendMessageToServer("6", socket);
            receivedMeessageWaringFromServer();
//            showHistory();
            if(webcam.isOpen()){
                closeWebcam();
            }            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_paneNotificationMouseClicked

    private void paneNotificationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneNotificationMouseExited
        // TODO add your handling code here:
        paneNotification.setBackground(new Color(152,234,217));
    }//GEN-LAST:event_paneNotificationMouseExited

    private void paneNotificationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneNotificationMouseEntered
        // TODO add your handling code here:
        paneNotification.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneNotificationMouseEntered

    private void paneUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneUpdateMousePressed
        // TODO add your handling code here:
        paneUpdate.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneUpdateMousePressed

    private void paneUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneUpdateMouseReleased
        // TODO add your handling code here:
        paneUpdate.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneUpdateMouseReleased

    private void paneUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneUpdateMouseClicked
        // TODO add your handling code here:
        try {
            menuClicked(panelUpdatePage);
            setInformationUpdateAccount();
            if(webcam.isOpen()){
                closeWebcam();
            }            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_paneUpdateMouseClicked

    private void paneUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneUpdateMouseExited
        // TODO add your handling code here:
        paneUpdate.setBackground(new Color(152,234,217));
    }//GEN-LAST:event_paneUpdateMouseExited

    private void paneUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneUpdateMouseEntered
        // TODO add your handling code here:
        paneUpdate.setBackground(new Color(220,153,141));
    }//GEN-LAST:event_paneUpdateMouseEntered

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HomePage().setVisible(true);
//            }
//        });
//    }

    private void showHistory(){
        try {
            String receivedMessage;
            InputStream istream = socket.getInputStream();
            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream), 1024);
            receivedMessage = getMessageFromServer(receiveRead,socket);
            if(!receivedMessage.equals("")){
                inputLocationAndTime(receivedMessage);
            }
        } catch (Exception e) {
        }
        
    }
   
    private void inputLocationAndTime(String receiveMessage) {
            int str_lent = 0;           
            ArrayList<String[]> locationAndTimeList = new ArrayList<String[]>();
            char c = '_';
            for(int i =0; i < receiveMessage.length(); i++){
                if(receiveMessage.charAt(i) == c){
                    str_lent++;
                }
            }
            if(str_lent==0){
                System.out.println("----------Lich su di chuyen cua ban----------");
                System.out.println("Khong co lich su di chuyen");
//                historyScroll.add(receiveMessage, new JLabel("Khong co lich su di chuyen"));
            }else{
                System.out.println("co di chuyen");
                
                String[] listHistory = receiveMessage.split("_");
                for(int i =0; i < (str_lent+1); i+=2){
                    locationAndTime index = new locationAndTime();
                    index.setLocation(listHistory[i]);
                    index.setTime(listHistory[i+1]);
                    locationAndTimeList.add(new String[]{index.getLocation(),index.getTime()});
                }
                System.out.println("----------Lich su di chuyen cua ban----------");
                System.out.println("Location"+"\t\t\t\t\t\t\t"+"Time");
//                tableHistory.setRowHeight(0,80);
                tableHistory.setRowHeight(60);
                ArrayList<String> columns = new ArrayList<String>();
                columns.add("Location");
                columns.add("Time");              
                TableModel tableModel = new DefaultTableModel(locationAndTimeList.toArray(new Object[][]{}),columns.toArray());
//                model.addRow();
                tableHistory.setModel(tableModel);
                
//                for (int i = 0; i < locationAndTimeList.size(); i++){
//                    System.out.print(locationAndTimeList.get(i).getLocation()+"\t\t\t\t\t"+locationAndTimeList.get(i).getTime());                  
//                    System.out.println("");
//                }
                
                locationAndTimeList.clear();
            }

    } 


    private void setInformationUpdateAccount(){
        firstNameUpdate.setText(user.getFirstName());
        lastNameUpdate.setText(user.getLastname());
        cardIdInformationUpdate.setText(user.getCardId());
        birthDayUpdate.setText(user.getBirthOfDay());
        if(user.getGender().equals("Nam")){
            namBtnUpdate.setSelected(true);
        }else{
            nuBtnUpdate.setSelected(true);
        }
        numberPhoneUpdate.setText(user.getNumberPhone());
        emailUpdate.setText(user.getEmail());
        addressUpdate.setText(user.getAddress());
    }

    private String createInforUpdateAccount(){
        String iduser = user.getIdUser();
        String firstName = firstNameUpdate.getText();
        String lastName = lastNameUpdate.getText();
        String cardId = cardIdInformationUpdate.getText();
        String birthDay = birthDayUpdate.getText();
        String gender;
        if(namBtnUpdate.isSelected()){
            gender = "Nam";
        }else{
            gender = "Nu";
        }
        String numberPhone = numberPhoneUpdate.getText();
        String email = emailUpdate.getText();
        String address = addressUpdate.getText();
        String message = createInforAccountMessage(iduser,firstName,lastName,cardId,birthDay,gender,numberPhone,email,address,"normal");
        return message;
    }

    private String createInforAccountMessage(String idUser, String firstName, String lastName, String cardId, String birthday, String gender, String numberPhone,String email, String address, String state){
        return idUser + "_" + firstName + "_" + lastName + "_" + cardId + "_" + birthday + "_" + gender + "_" + numberPhone + "_" +email + "_" + address + "_" + state;
    }

    private void setInformationUser(){
        fullName.setText(user.getLastname() +" "+ user.getFirstName());
        gender.setText(user.getGender());
        cardId.setText(user.getCardId());
        birthDay.setText(user.getBirthOfDay());
        numberPhone.setText(user.getNumberPhone());
        email.setText(user.getEmail());
        address.setText(user.getAddress());
        state.setText(user.getState());
        if(user.getState().equals("F1")){
            state.setForeground(Color.YELLOW);
        }else if(user.getState().equals("F0")){
            state.setForeground(Color.RED);
        }       
    }
    

    private void sendMessageToServer(String str, Socket sock) throws IOException {
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(str);       // sending to server
        pwrite.flush();            // flush the data
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
   
    public void startLayout(Socket socket, account user){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HomePage(socket,user).setVisible(true);                    
                } catch (Exception e) {
                }              
            }
        });
    }

    public void menuClicked(JPanel jpanel) throws IOException{
//        setTextNameAndId(this.user);
        panelMap.setVisible(false);
        panelHomePage.setVisible(false);
        panelProfilePage.setVisible(false);
        panelUpdatePage.setVisible(false);
        panelQrCodePage.setVisible(false);
        panelHistoryPage.setVisible(false);
        panelNotificationPage.setVisible(false);
 
        jpanel.setVisible(true);
    }

    private void closeWebcam(){
        if(webcam.isOpen()){
            System.out.println("dong webcam");
           webcam.close();
        }
    }

    public void receivedMeessageWaringFromServer(){
        InputStream istream = null;
        try {
            istream = socket.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(NewSignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader receiveReadWaring = new BufferedReader(new InputStreamReader(istream), 1024);
        try {
                checkOutPutWaring(receiveReadWaring,socket);
        } catch (Exception e) {
                System.out.println("can't check out put receivedMeessageFromServer");
        }
    }


    private void checkOutPutWaring(BufferedReader receiveRead, Socket socket) throws IOException {
        String receiveWaringMessage;
        receiveWaringMessage = String.valueOf(receiveRead.readLine());
        receiveWaringMessage = removeNonAscii(receiveWaringMessage);
        receiveWaringMessage = replaceUnreadable(receiveWaringMessage);
        if(!Objects.equals(receiveWaringMessage, "0")) //receive from server
        {
            System.out.print("from server: ");
            System.out.println(receiveWaringMessage);
            waringMessage.setText(receiveWaringMessage); // displaying at DOS prompt
//            JOptionPane.showMessageDialog(panelHomePage,
//                    receiveWaringMessage,
//                    "From Server",
//                    JOptionPane.INFORMATION_MESSAGE);
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
                checkOutPut(receiveRead,socket,user);
        } catch (Exception e) {
                System.out.println("can't check out put receivedMeessageFromServer");
        }
    }

    private void checkOutPutStringLocation(BufferedReader receiveRead, Socket socket) throws IOException {
        String receiveMessage;
        receiveMessage = String.valueOf(receiveRead.readLine());
        receiveMessage = removeNonAscii(receiveMessage);
        receiveMessage = replaceUnreadable(receiveMessage);
        if(!Objects.equals(receiveMessage, "0")) //receive from server
        {
            System.out.print("from server: ");
            System.out.println(receiveMessage); // displaying at DOS prompt
            inputTheLocationOfF0(receiveMessage);
        }
    }

    private void inputTheLocationOfF0(String receiveMessage) {
        ArrayList<LocationOfF0> listLocationOfF0 = new ArrayList<LocationOfF0>();
        if(receiveMessage.equals("khong co dia diem")){
            init(listLocationOfF0);
        }else{
            int index = 0;
            for(int i = 0; i < receiveMessage.length(); i++){
               if(receiveMessage.charAt(i)=='_'){
                   index++;
                }
            }

            String[] listInfor = receiveMessage.split("_");
            for(int i = 0; i < (index+1); i++){
                LocationOfF0 locationIndex = new LocationOfF0();
                String[] longitude = listInfor[i].split("@");
                locationIndex.setLocation(longitude[0]);
                String[] latitude = longitude[1].split("!");
                locationIndex.setLongitude(latitude[0]);
                locationIndex.setLatitude(latitude[1]);
                listLocationOfF0.add(locationIndex);
            }
            init(listLocationOfF0);
        }
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
            inputTheUser(receiveMessage, user);
        }else{
            ArrayList<LocationOfF0> listLocationOfF0 = new ArrayList<LocationOfF0>();
            init(listLocationOfF0);
        }
    }

    private String getMessageFromServer(BufferedReader receiveRead, Socket socket) throws IOException {
        String receiveMessage;
        receiveMessage = String.valueOf(receiveRead.readLine());
        receiveMessage = removeNonAscii(receiveMessage);
        receiveMessage = replaceUnreadable(receiveMessage);
        if(!Objects.equals(receiveMessage, "0")) //receive from server
        {
            System.out.print("from server: ");
            System.out.println(receiveMessage); // displaying at DOS prompt
        }
        return receiveMessage;
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
        setTextNameAndId(user);
    }

    private void setTextNameAndId(account user){
        firstName.setText(user.getFirstName());
        idUser.setText(user.getIdUser());
    }


    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        camera.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 420));

        executor.execute(this);
    }

    private void sendQrCodeToserver(String qrcode){
        try {
            LocalDateTime timeInLocation = LocalDateTime.now();
            int result = JOptionPane.showConfirmDialog(jLabel3,
                        "Bạn đã đến đây vào "+timeInLocation+" ?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                sendMessageToServer("2",socket);
                sendMessageToServer(createAccountMessage(qrcode,String.valueOf(timeInLocation)), socket);
                String receivedMessage;
                InputStream istream = socket.getInputStream();
                BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream), 1024);
                receivedMessage = getMessageFromServer(receiveRead,socket);
                try {
                    if(!receivedMessage.equals("")){
                    JOptionPane.showMessageDialog(jLabel3,
                    receivedMessage,
                    "From Server",
                    JOptionPane.INFORMATION_MESSAGE);
                }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println("can't get time");
        }
            
    }
    

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                System.out.println(result.getText());
                sendQrCodeToserver(result.getText());
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    private String createAccountMessage(String name, String password){
        return name+ "_" +password;
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTextField addressUpdate;
    private javax.swing.JLabel birthDay;
    private javax.swing.JTextField birthDayUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel camera;
    private javax.swing.JLabel cardId;
    private javax.swing.JTextField cardIdInformationUpdate;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailUpdate;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextField firstNameUpdate;
    private javax.swing.JLabel fullName;
    private javax.swing.JLabel gender;
    private javax.swing.JScrollPane historyScroll;
    private javax.swing.JLabel idUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private org.jxmapviewer.JXMapViewer jXMapViewer1;
    private javax.swing.JTextField lastNameUpdate;
    private javax.swing.JButton logOutbtn;
    private javax.swing.JRadioButton namBtnUpdate;
    private javax.swing.JRadioButton nuBtnUpdate;
    private javax.swing.JLabel numberPhone;
    private javax.swing.JTextField numberPhoneUpdate;
    private javax.swing.JPanel paneHistory;
    private javax.swing.JPanel paneHome;
    private javax.swing.JPanel paneMap;
    private javax.swing.JPanel paneNotification;
    private javax.swing.JPanel paneProfile;
    private javax.swing.JPanel paneQrCode;
    private javax.swing.JPanel paneUpdate;
    private javax.swing.JPanel panelHistoryPage;
    private javax.swing.JPanel panelHomePage;
    private javax.swing.JPanel panelMap;
    private javax.swing.JPanel panelNotificationPage;
    private javax.swing.JPanel panelProfilePage;
    private javax.swing.JPanel panelQrCodePage;
    private javax.swing.JPanel panelUpdatePage;
    private javax.swing.JButton qrBtn;
    private javax.swing.JButton sendInformationUpdate;
    private javax.swing.JPanel sidepane;
    private javax.swing.JLabel state;
    private javax.swing.JTable tableHistory;
    private javax.swing.JLabel waringMessage;
    // End of variables declaration//GEN-END:variables
}
