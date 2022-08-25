/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

import org.robokind.api.motion.Robot.RobotPositionMap;
import org.robokind.api.motion.messaging.RemoteRobot;
import org.robokind.client.basic.Robokind;



import org.robokind.api.speech.messaging.RemoteSpeechServiceClient  ;  

/**
 *
 * @author 123
 */
public class ExpressionDemo {

    // class variables
    private static RobotPositionMap myGoalPositions;
    private static RemoteRobot myRobot;
    private static int timeFrame;
    private static RemoteSpeechServiceClient mySpeaker ;
    
    
   
    
    
    
    

    public static void main(String[] args) {
        String robotID = "myRobot";
        String robotIP = "192.168.0.116";
      //  String robotIP = "129.104.228.5";
        
        // set addresses
        SetSettings settings = new SetSettings(robotID, robotIP);
        // make connection
        myRobot = Robokind.connectRobot();
        //mySpeaker = Robokind.connectSpeechService() ; 
        
        //System.out.print(  myGoalPositions   );
        
        //Open_eye_angle_value = Facial_Expression_array[0];
        //this.Turn_eye_angle_value = Facial_Expression_array[1];
        //this.mouth_angle_value = Facial_Expression_array[2];
        //this.head_pitch_angle_value = Facial_Expression_array[3];up dpwon
        //this.head_yaw_angle_value = Facial_Expression_array[4];turn
        //this.brows_angle_value = Facial_Expression_array[5];
        //this.jaw_angle_value = Facial_Expression_array[6];

        double Facial_action[] = {0.6, 0.9, 0.3, 0.9, 0.8, 0.5, 0.9};
        double body_action[] = { 0.8,                                        //left_shoulder_pitch_value
                                  0.8,                                       //right_shoulder_pitch_value 
                                 0.85 ,                                       //left_shoulder_roll_value
                                 0.8 ,                                       //left_shoulder_roll_value
                                 0.8,                                        //left_elbow_yaw_value
                                 0.8,                                        //right_elbow_yaw_value
                                 0.8,                                        //left_wrist_yaw_value
                                 0.8 ,                                       //right_wrist_yaw_value
                                0.8                                        //waist
        } ; 
     
  
        
        
        
        // check if robot is connected
        if (myRobot.isConnected()) {
        
            
            Expression expression = new Expression();
            expression.setExpressionJoints(myRobot);
           // expression.blink(300, myRobot);
            //expression.setExpressionDefaults(500, myRobot);
          //Robokind.sleep(300);
            //myRobot::601=0.5, myRobot::510=0.5, myRobot::320=0.5017361111111112, myRobot::610=0.5, myRobot::322=0.15753424657534246, myRobot::420=0.4719626168224299, myRobot::100=0.5, myRobot::421=0.49850746268656715, myRobot::520=0.5015105740181269, myRobot::200=0.5023696682464455, myRobot::202=0.7784090909090909, myRobot::521=0.4979919678714859, myRobot::300=0.5020408163265306, myRobot::301=0.8729508196721312, myRobot::400=0.18503401360544217, myRobot::401=0.5006934812760055, myRobot::500=0.18421052631578946, myRobot::501=0.5035260930888575, myRobot::600=0.5, myRobot::311=0.5};
       //    myRobot.move(myRobot::410=0.5008517887563884, myRobot::601=0.5, myRobot::510=0.5, myRobot::320=0.5017361111111112, myRobot::610=0.5, myRobot::322=0.15753424657534246, myRobot::420=0.4719626168224299, myRobot::100=0.5, myRobot::421=0.49850746268656715, myRobot::520=0.5015105740181269, myRobot::200=0.5023696682464455, myRobot::202=0.7784090909090909, myRobot::521=0.4979919678714859, myRobot::300=0.5020408163265306, myRobot::301=0.8729508196721312, myRobot::400=0.18503401360544217, myRobot::401=0.5006934812760055, myRobot::500=0.18421052631578946, myRobot::501=0.5035260930888575, myRobot::600=0.5, myRobot::311=0.5,800);
             
            //System.out.print(myRobot.getCurrentPositions());
            
          //  expression.right_shoulder_pitch_angle(200,0.5, myRobot);
           expression.body_action_display(300, body_action, myRobot);
           
             Robokind.sleep(500);
          // expression.left_shoulder_pitch_angle(200,1, myRobot);
             //expression.blink(20, myRobot);
           // myRobot.move(myRobot.get(), 30);
            myRobot.move(myRobot.getDefaultPositions(),100);
           // System.out.print(myRobot.getGoalPositions());
          // expression.left_elbow_yaw_angle(200, 1, myRobot);
          // expression.left_shoulder_roll_angle(100, 0.9, myRobot);
          //  
            
            
        }
    }
}
