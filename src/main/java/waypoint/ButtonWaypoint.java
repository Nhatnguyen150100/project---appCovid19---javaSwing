/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package waypoint;


import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author nhatnguyen
 */
public class ButtonWaypoint extends JButton {

    public ButtonWaypoint() {
        setContentAreaFilled(false);
        setIcon(new ImageIcon("/home/nhatnguyen/netbean/mavenproject1/src/main/java/icon/icons8-error-60.png"));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(50, 50));
    }
}
