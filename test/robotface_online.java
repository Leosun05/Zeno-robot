package com.mycompany.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.robokind.api.motion.Robot.RobotPositionMap;
import org.robokind.api.motion.messaging.RemoteRobot;
import org.robokind.client.basic.Robokind;


public class robot_online {
        private static RobotPositionMap myGoalPositions;
        private static RemoteRobot myRobot;
        private static int timeFrame;
        public static void main(String[] args) throws IOException {
        String robotID = "myRobot";
        String robotIP = "192.168.0.194";
        // set addresses
        SetSettings settings = new SetSettings(robotID, robotIP);
        // make connection
        myRobot = Robokind.connectRobot();
        double eye_open_value = 0.5;
        //double  Facial_action[] = {0.1,0.9,0,0.9,0.5,0.9,0.9};
        ServerSocket serverSocket = new ServerSocket(65432, 10);
        if (myRobot.isConnected()) 
            {
            Expression expression = new Expression();
            expression.setExpressionJoints(myRobot);
            expression.blink(110, myRobot);
            while(true){
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                //OutputStream os = socket.getOutputStream();
                if (is.available() != 0)
                {
                
                // Receiving
                byte[] lenBytes = new byte[4];
                is.read(lenBytes, 0, 4);
                int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                          ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
                byte[] receivedBytes = new byte[len];
                is.read(receivedBytes, 0, len);
                String received = new String(receivedBytes, 0, len);
                //System.out.println(received);   
                    Expression expression = new Expression();
                    expression.setExpressionJoints(myRobot);
                    // expression test
                    //expression.setExpressionDefaults(10, myRobot);
                    //Robokind.sleep(500);
                   //expression.smile(10,myRobot);
                   //float gaze = Float.parseFloat(received.charAt(0));
                    double gaze_value = (Integer.parseInt(String.valueOf(received.charAt(0)))-10)/(-10d);
                    double brow_value = Integer.parseInt(String.valueOf(received.charAt(1)))/10d;
                    double head_turn_value = Integer.parseInt(String.valueOf(received.charAt(2)))/10d;
                    double head_updown_value = Integer.parseInt(String.valueOf(received.charAt(3)))/10d;
                    double smile_value = Integer.parseInt(String.valueOf(received.charAt(4)))/10d;
                    double mouth_value = Integer.parseInt(String.valueOf(received.charAt(5)))/10d;
                    eye_open_value = (Integer.parseInt(String.valueOf(received.charAt(6)))/10d+eye_open_value)/2;
                    double [] Facial_action = {eye_open_value,gaze_value,smile_value,head_updown_value,head_turn_value,brow_value,mouth_value};

                    expression.Facial_Expression_display(1,Facial_action ,myRobot);
                   Robokind.sleep(33);


                //lenBytes = new byte[4];
                }
                //receivedBytes = new byte[l];
            }
            // Sending
        
        }
        //socket.close();
        //serverSocket.close();
        
        
    }
}