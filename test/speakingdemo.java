 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

 


 
 //https://github.com/hideshis/robokindDemo/tree/master/src/main/java 
 //zeno GitHub åšä¸»çš„ç½‘å€
 




//import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.robokind.api.animation.Animation;
import org.robokind.api.animation.messaging.RemoteAnimationPlayerClient;
//import org.robokind.api.animation.player.AnimationJob;
import org.robokind.api.common.position.NormalizedDouble;
import org.robokind.api.motion.Joint;
import org.robokind.api.motion.messaging.RemoteRobot;
import org.robokind.api.speech.messaging.RemoteSpeechServiceClient;
import org.robokind.client.basic.*;
import static org.robokind.api.motion.Robot.*;
import static org.robokind.client.basic.RobotJoints.*;
// for audio
//import java.io.*;
//import javax.sound.sampled.*;

/**
 * VisitorDemo.java - class to show off our robot
 * @author Lianne Meah <lianne.meah@gmail.com>
 * @version 6.0
 */
public class speakingdemo extends JFrame {
    // variables for class
    private static RemoteRobot myRobot;
    private static RemoteAnimationPlayerClient myPlayer;
    private static RemoteSpeechServiceClient mySpeaker;
    private static RobotPositionMap myGoalPositions;
    
    public static void main(String[] args) {
        long animLen;
        VisitorDemo vd = new VisitorDemo();
        // config and settings - set robotID and IP 
        String robotID = "myRobot";
        String robotIP = "129.104.228.4";
        // set respective addresses
        SetSettings settings = new SetSettings(robotID, robotIP);
        // try to make connections
        myRobot = Robokind.connectRobot();
        myPlayer = Robokind.connectAnimationPlayer();
        mySpeaker = Robokind.connectSpeechService();
        
        // upon connecting successfully...
        if (myRobot.isConnected()) {
            JOptionPane.showMessageDialog(null, "Success! Connected to RoboKind robot.");
            mySpeaker.speak("Hello. My name is Zeeno."); //Wrong spelling so robot can pronounce it right!
            
            // draw a window; control panel for robot - extremely simple for now
            SwingUtilities.invokeLater(new Runnable() { // invoke later to stop hanging
                public void run() {
                    VisitorDemo vd = new VisitorDemo();
                    vd.setVisible(true);
                }
            });
            
            // make the robot smile and look up
            vd.zenoSmile();
                       
            // Animations to be used
            Animation introAnim = Robokind.loadAnimation("C:\\Users\\123\\Desktop\\ensta\\RoboKind-master\\animations\\avatar_wave.anim.xml");
            //Animation smile = Robokind.loadAnimation("RKM_smile.xml");
            // play the wave animation
            myPlayer.playAnimation(introAnim);
            animLen = introAnim.getLength();
            Robokind.sleep(1000 + animLen);
            // put default positions into hashmap
            JointId left_elbow_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ELBOW_YAW)); 
            JointId left_elbow_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ELBOW_PITCH));
            JointId left_shoulder_r = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SHOULDER_ROLL));
            myGoalPositions = new RobotPositionHashMap();
            myGoalPositions.put(left_elbow_yaw, new NormalizedDouble(0.38));
            myGoalPositions.put(left_elbow_pitch, new NormalizedDouble(0.99));
            myGoalPositions.put(left_shoulder_r, new NormalizedDouble(0.055555555555556));
            // move robot back to defaults
            myRobot.move(myGoalPositions, 1000);
            // booleans for commands, used later
            Boolean speak = false;
            Boolean dance = false;
            // ask user if (s)he wants Zeno to speak
            String speakCommand = JOptionPane.showInputDialog("Make Zeno speak? Y/N");
            speakCommand = speakCommand.toUpperCase();
            if (speakCommand.equals("Y")) {
                speak = true;
                String speech = JOptionPane.showInputDialog("Type something for him to say. Type 'intro' to hear an introduction.");
                // convert to lower case
                speech = speech.toLowerCase();
                if (speech.equals("intro")) {
                    // give the introduction speech: 99% copy pasted from HansonRobotics web page
                    mySpeaker.speak("Robots like me "
                    + "provide a wide range of research opportunities; from robotics, artificial intelligence"
                    + " and material science; to cognitive science and neuroscience; "
                    + "as well as autism treatment and education.");
                    Robokind.sleep(2000);
                }
                else {
                    // speak the phrase given by a user
                    mySpeaker.speak(speech);
                }
            } 
            // user gave some other input
            if (!(speakCommand.equals("Y") || speakCommand.equals("N"))) {
                JOptionPane.showMessageDialog(null, "Wrong input given.");
            }

            // play dance animation
            String danceCommand = JOptionPane.showInputDialog("Make Zeno dance? Y/N");
            danceCommand = danceCommand.toUpperCase();
            if (danceCommand.equals("Y")) {
                dance = true;
                //pick a dance animation - don't overwork the joints!
                String pickDance = JOptionPane.showInputDialog("Pick a dance (enter a number between 1 and 5)");
                if (pickDance.equals("1")) {
                    Animation danceAnim1 = Robokind.loadAnimation("C:\\Users\\123\\Desktop\\ensta\\RoboKind-master\\animations\\AZR50_Dancing_01.anim.xml");
                    myPlayer.playAnimation(danceAnim1);
                    animLen = danceAnim1.getLength();
                    Robokind.sleep(4000 + animLen);
                }
                else if (pickDance.equals("2")) {
                    Animation danceAnim2 = Robokind.loadAnimation("C:\\Users\\123\\Desktop\\ensta\\RoboKind-master\\animations\\AZR50_Dancing_02.anim.xml");
                    myPlayer.playAnimation(danceAnim2);
                    animLen = danceAnim2.getLength();
                    Robokind.sleep(4000 + animLen);
                }
                else if (pickDance.equals("3")) {
                    Animation danceAnim3 = Robokind.loadAnimation("C:\\Users\\123\\Desktop\\ensta\\RoboKind-master\\animations\\AZR50_Dancing_03.anim.xml");
                    myPlayer.playAnimation(danceAnim3);
                    animLen = danceAnim3.getLength();
                    Robokind.sleep(4000 + animLen);
                }

                else if (pickDance.equals("4")) {
                    Animation danceAnim4 = Robokind.loadAnimation("C:\\Users\\123\\Desktop\\ensta\\RoboKind-master\\animations\\AZR50_Dancing_04.anim.xml");
                    myPlayer.playAnimation(danceAnim4);
                    animLen = danceAnim4.getLength();
                    Robokind.sleep(4000 + animLen);
                }
                
                else if (pickDance.equals("5")) {
                    Animation danceAnim5 = Robokind.loadAnimation("C:\\Users\\123\\Desktop\\ensta\\RoboKind-master\\animations\\AZR50_Dancing_05.anim.xml");
                    myPlayer.playAnimation(danceAnim5);
                    animLen = danceAnim5.getLength();
                    Robokind.sleep(4000 + animLen);
                }
                
                else {
                    // some other input was entered
                    //mySpeaker.speak("You're not so good at following instructions, huh?");
                    //Robokind.sleep(5000);
                    JOptionPane.showMessageDialog(null, "That's not a number between 1 and 5!");
                }
            }
            // user gave some other input
            if (!(danceCommand.equals("Y") || danceCommand.equals("N"))) {
                JOptionPane.showMessageDialog(null, "Wrong input given.");
            }
            
            String extra;
            // said no to both dancing and speaking
            if (!dance && !speak) {
                // lol
                //mySpeaker.speak("You're pretty boring, aren't you?");
                //extra = JOptionPane.showInputDialog("Be less boring? Y/N");
                extra = JOptionPane.showInputDialog("Would you like to see anything else? Y/N");
            }
            else {
                mySpeaker.speak("Would you like to see anything else?");
                extra = JOptionPane.showInputDialog("One more demo? Y/N");
            }
            extra = extra.toUpperCase();
            if (extra.equals("Y")) {                
                mySpeaker.speak("Okay, I'll show you my victory pose.");
                Robokind.sleep(2000);
                // load/play the victory pose animation
                Animation victory = Robokind.loadAnimation("C:\\Users\\123\\Desktop\\ensta\\RoboKind-master\\animations\\AZR50_VictoryPose_02.anim.xml");
                myPlayer.playAnimation(victory);
                animLen = victory.getLength();
                Robokind.sleep(2000 + animLen);
                // final message
                JOptionPane.showMessageDialog(null, "Thanks for coming to see Zeno! You can press exit now.");
            }
            
            if (extra.equals("N")) {
                // load/play disappointed animation
                Animation dissapointed = Robokind.loadAnimation("C:\\Users\\123\\Desktop\\ensta\\RoboKind-master\\animations\\AZR50_Disappointed_01.anim.xml");
                myPlayer.playAnimation(dissapointed);
                animLen = dissapointed.getLength();
                Robokind.sleep(3000 + animLen);
                mySpeaker.speak("Okay, show's over. Thanks for visiting me.");
            }      
        }
    } 
    
    public speakingdemo() {
        // GUI window within it's own method
        controlPanel();
    }
    
    /*
     * method to draw Java Swing window
     * Acts as a control panel - very much unfinished
     */
    public final void controlPanel() {
        JPanel zenoPanel = new JPanel();
        getContentPane().add(zenoPanel);
        zenoPanel.setLayout(null);
        // draw exit button
        JButton button = new JButton("Exit");
        button.setBounds(50, 60, 80, 30);
        // text comes up when hovering over the button
        button.setToolTipText("Disconnects from the robot and exits the program");
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               // quit button pressed; disconnect and exit
               Robokind.disconnect();
               System.exit(0);
          }
       });
        zenoPanel.add(button);
        setTitle("Zeno Panel");
        setSize(200,200);
        setLocationRelativeTo(null); // centres the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /*
     * method to make Zeno smile
     * Use this on startup so he doesn't look so zoned out!
     */
    public static void zenoSmile() {
        String measure;
        double measureDouble = 0.5;
        // joints
        JointId left_smile = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SMILE));
        JointId right_smile = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SMILE));
        JointId neck_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(NECK_PITCH));
        // new position map
        myGoalPositions = new RobotPositionHashMap();
        // make the robot smile
        myGoalPositions.put(left_smile, new NormalizedDouble(0.9));
        myGoalPositions.put(right_smile, new NormalizedDouble(0.9));
        // makes the robot look up
        myGoalPositions.put(neck_pitch, new NormalizedDouble(0.7));
        myRobot.move(myGoalPositions, 1000);      
    }
}
 