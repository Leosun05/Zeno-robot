/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

/**
 *
 * @author 123
 */
import org.robokind.api.common.position.NormalizedDouble;
import org.robokind.api.motion.Joint;
import org.robokind.api.motion.messaging.RemoteRobot;
import static org.robokind.api.motion.Robot.*;
import org.robokind.client.basic.Robokind;
import static org.robokind.client.basic.RobotJoints.*;

import org.robokind.api.speech.messaging.RemoteSpeechServiceClient  ;  





public class Expression {
    private static RobotPositionMap myGoalPositions;
    private static int timeFrame;
    private static JointId eyelids;
    private static JointId eyes_pitch;
    private static JointId left_eye_yaw;
    private static JointId right_eye_yaw;
    private static JointId left_smile;
    private static JointId right_smile;
    private static JointId jaw;
    private static JointId neck_pitch;
    private static JointId neck_yaw;
    private static JointId brows;
    private static JointId mouth;
    private static JointId left_elbow_yaw;
    private static JointId right_elbow_yaw;
    
    private static JointId left_elbow_pitch;
    
    
    private static JointId left_shoulder_roll;
    private static JointId right_shoulder_roll;

    private static JointId left_shoulder_pitch;
    private static JointId right_shoulder_pitch;



    
    private static JointId left_wrist_yaw;
    private static JointId right_wrist_yaw;
    
    private static JointId left_hand_grasp;
    private static JointId right_hand_grasp;
        
    private static JointId left_ankle_roll;
    private static JointId right_ankle_roll;
    
    
    private static JointId left_ankle_pitch;
    private static JointId right_ankle_pitch;
    
      
           
    private static JointId left_knee_pitch;
    private static JointId right_knee_pitch;
    
      
    private static JointId left_hip_yaw;
    private static JointId right_hip_yaw;
    
    private static JointId left_hip_roll;
    private static JointId right_hip_roll;
        
    private static JointId waist;
    
    
    
    //*************************************************************
    
    private static RemoteSpeechServiceClient mySpeaker ;
    
    
    //*************************************************************

    private static double Open_eye_angle_value;
    private static double Turn_eye_angle_value;
    private static double mouth_angle_value;
    private static double head_pitch_angle_value;
    private static double head_yaw_angle_value;
    private static double brows_angle_value;
    private static double jaw_angle_value;
    private static double [] Facial_Expression_array;
    private static double [] body_action_array;
    
    
    private static double left_elbow_yaw_value;
    private static double right_elbow_yaw_value;
    
    private static double left_elbow_pitch_value;
    
    
    
    
    private static double left_shoulder_roll_value;
    private static double right_shoulder_roll_value;
    
    private static double left_shoulder_pitch_value;
    private static double right_shoulder_pitch_value;
    
    
    
    
    
    private static double left_wrist_yaw_value;
    private static double right_wrist_yaw_value;
    
    private static double left_hand_grasp_value;
    private static double right_hand_grasp_value;    
    
    private static double left_ankle_roll_value;
    private static double right_ankle_roll_value;    
        
    
    
    private static double left_ankle_pitch_value;
    private static double right_ankle_pitch_value;    
        
        
    
    
    private static double left_knee_pitch_value;
    private static double right_knee_pitch_value;    
        
    private static double left_hip_yaw_value;
    private static double right_hip_yaw_value;
            
    private static double left_hip_roll_value;
    private static double right_hip_roll_value;
      

    private static double waist_value;



    
    
    
    /**
     * Default constructor
     */
    public Expression() {
        
    }
    
    /**
     * Set joints used for expression class
     * @param myRobot the connected remoteRobot 
     */
    public void setExpressionJoints(RemoteRobot myRobot) {
        this.eyelids = new JointId(myRobot.getRobotId(), new Joint.Id(EYELIDS)); 
        this.eyes_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(EYES_PITCH)); 
        this.left_eye_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_EYE_YAW)); 
        this.right_eye_yaw  = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_EYE_YAW));
        this.left_smile = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SMILE));
        this.jaw = new JointId(myRobot.getRobotId(), new Joint.Id(JAW));
        this.right_smile = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SMILE));
        this.neck_pitch  = new JointId(myRobot.getRobotId(), new Joint.Id(NECK_PITCH));
        this.neck_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(NECK_YAW));
        this.brows = new JointId(myRobot.getRobotId(), new Joint.Id(BROWS));
        this.left_elbow_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ELBOW_YAW));
        this.right_elbow_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_ELBOW_YAW));
        
        this.left_elbow_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ELBOW_PITCH));
        
        
        
        
        this.left_shoulder_roll = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SHOULDER_ROLL));
        this.right_shoulder_roll = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SHOULDER_ROLL));
        
        this.left_shoulder_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SHOULDER_PITCH));
        this.right_shoulder_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SHOULDER_PITCH));
      
        this.left_wrist_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_WRIST_YAW));  
        this.right_wrist_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_WRIST_YAW));  
        
        //this.shoulder_angle_value = new
        
        this.left_hand_grasp = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_HAND_GRASP));  
        this.right_hand_grasp = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_HAND_GRASP));   
        
        this.right_ankle_roll = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_ANKLE_ROLL));  
        this.left_ankle_roll = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ANKLE_ROLL));   
               
        
        this.left_ankle_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_ANKLE_PITCH));   
        this.right_ankle_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_ANKLE_PITCH));  

        this.left_knee_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_KNEE_PITCH));  
        this.right_knee_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_KNEE_PITCH));   
        
        
        this.left_hip_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_HIP_YAW));  
        this.right_hip_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_HIP_YAW));   
                               
        
        this.left_hip_roll = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_HIP_ROLL));  
        this.right_hip_roll = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_HIP_ROLL));   
         
        
        
        this.waist = new JointId(myRobot.getRobotId(), new Joint.Id(WAIST));     
        
        
        

    }
    
 
    
    
    
    
    
    
      // ?? ??
    
    public void left_hip_roll_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.left_hip_roll, new NormalizedDouble(0.9));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
     //????
    
    
    public void right_hip_roll_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.right_hip_roll, new NormalizedDouble(1));
        myRobot.move(this.myGoalPositions, this.timeFrame);
        
    }
       
  
    
   
    
    
    
    
    
    
    
    
      // ?? ELBOW YAW
    
    public void left_hip_yaw_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.left_hip_yaw, new NormalizedDouble(1));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
     //??elbow_yaw_move
    
    
    public void right_hip_yaw_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.right_hip_yaw, new NormalizedDouble(1));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
       
  
    
   
    
    
    // ?? ELBOW YAW
    
    public void left_elbow_yaw_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.left_elbow_yaw, new NormalizedDouble(0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
     //??elbow_yaw_move
    
    
    public void right_elbow_yaw_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.right_elbow_yaw, new NormalizedDouble(0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
       
        
    // ?? WRIST ??? 
    
    public void left_wrist_yaw_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.left_wrist_yaw, new NormalizedDouble(0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
     //   ?? WRIST ??? 
    
    public void right_wrist_yaw_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.right_wrist_yaw, new NormalizedDouble(0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
    
    
    
        // ?? PITCH
    
    public void left_elbow_pitch_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.left_elbow_pitch, new NormalizedDouble(0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
    
    
    
    
    
 //?? shoulder
    
    public void left_shoulder_roll_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.left_hand_grasp, new NormalizedDouble(0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
 // ??shoulder 
    
    public void right_shoulder_roll_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.right_hand_grasp, new NormalizedDouble(1));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    /*
    //??0-90  ?? 
    
       public void left_shoulder_roll_move2(int timeFrame, double shoulder_angle_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.shoulder_angle_value = shoulder_angle_value;
        this.myGoalPositions.put(this.left_shoulder_roll, new NormalizedDouble(this.shoulder_angle_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    */
    
    
     
    //???   ???     not working
    
    public void left_hand_grasp_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.left_hand_grasp, new NormalizedDouble(0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
        
       //?feet       not working
        
    public void right_ankle_roll_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.right_ankle_roll, new NormalizedDouble(1));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
    
    
    //?? 
    
    public void left_ankle_roll_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.left_ankle_roll, new NormalizedDouble(1));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
        
       //??
        
    public void right_hand_grasp_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.right_hand_grasp, new NormalizedDouble(1));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
        
    //? KNEE
    
    public void left_knee_pitch_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.left_knee_pitch, new NormalizedDouble(0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
        
       //? KNEE
        
    public void right_knee_pitch_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.right_knee_pitch, new NormalizedDouble(1));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
    
    
    
    
    
      
    // ?????? working
    
        
    public void waist_move(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.myGoalPositions.put(this.waist, new NormalizedDouble(0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
       
  
//************************************************************************************************************************************          
//************************************************************************************************************************************    
//************************************************************************************************************************************    

// ??????        
  
    // ???? ?? 
    
    public void waist_angle(int timeFrame, double waist_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.waist_value = waist_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.waist, new NormalizedDouble(this.waist_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
     // ??welbow  ?? ?? 
    
    public void left_elbow_yaw_angle(int timeFrame, double left_elbow_yaw_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.left_elbow_yaw_value = left_elbow_yaw_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_elbow_yaw, new NormalizedDouble(this.left_elbow_yaw_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
     // ??elbow ?? ?? 
    
    public void right_elbow_yaw_angle(int timeFrame, double right_elbow_yaw_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.right_elbow_yaw_value = right_elbow_yaw_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.right_elbow_yaw, new NormalizedDouble(this.right_elbow_yaw_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
     
   // ????  ?? ??    
    
    public void left_wrist_yaw_angle(int timeFrame, double left_wrist_yaw_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.left_wrist_yaw_value = left_wrist_yaw_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_wrist_yaw, new NormalizedDouble(this.left_wrist_yaw_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
    
    // ??????  ?? ??    
 
    
        
    public void right_wrist_yaw_angle(int timeFrame, double right_wrist_yaw_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.right_wrist_yaw_value = right_wrist_yaw_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.right_wrist_yaw, new NormalizedDouble(this.right_wrist_yaw_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
       // ? shoulder  ?? ??    
    
    public void left_shoulder_roll_angle(int timeFrame, double left_shoulder_roll_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.left_shoulder_roll_value = left_shoulder_roll_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_shoulder_roll, new NormalizedDouble(this.left_shoulder_roll_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
           // right shoulder  ?? ??   
    
    public void right_shoulder_roll_angle(int timeFrame, double right_shoulder_roll_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.right_shoulder_roll_value = right_shoulder_roll_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.right_shoulder_roll, new NormalizedDouble(this.right_shoulder_roll_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
           // ? shoulder pitch  ?? ??    
    
    public void left_shoulder_pitch_angle(int timeFrame, double left_shoulder_pitch_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.left_shoulder_pitch_value = left_shoulder_pitch_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_shoulder_pitch, new NormalizedDouble(this.left_shoulder_pitch_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
               // ? shoulder pitch  ?? ??    
    
    public void right_shoulder_pitch_angle(int timeFrame, double right_shoulder_pitch_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.right_shoulder_pitch_value = right_shoulder_pitch_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.right_shoulder_pitch, new NormalizedDouble(this.right_shoulder_pitch_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    //left  wheels rotation 
    public void left_hip_yaw_angle(int timeFrame, double left_hip_yaw_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.left_hip_yaw_value = left_hip_yaw_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_hip_yaw, new NormalizedDouble(this.left_hip_yaw_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
   
    // wheels rotation of code  but not work 
  
    public void right_hip_yaw_angle(int timeFrame, double right_hip_yaw_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.right_hip_yaw_value = right_hip_yaw_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.right_hip_yaw, new NormalizedDouble(this.right_hip_yaw_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
   // rigjht wheels rotation 
  
     public void left_knee_pitch_angle(int timeFrame, double left_knee_pitch_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.left_knee_pitch_value = left_knee_pitch_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_knee_pitch, new NormalizedDouble(this.left_knee_pitch_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
     // not work 
     public void right_knee_pitch_angle(int timeFrame, double right_knee_pitch_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.right_knee_pitch_value = right_knee_pitch_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.right_knee_pitch, new NormalizedDouble(this.right_knee_pitch_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
  
     
     //WLAK  WORKING
     
     public void left_hip_roll_angle(int timeFrame, double left_hip_roll_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.left_hip_roll_value = left_hip_roll_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_hip_roll, new NormalizedDouble(this.left_hip_roll_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
     
     
     public void left_ankle_pitch_angle(int timeFrame, double left_ankle_pitch_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.left_ankle_pitch_value = left_ankle_pitch_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_ankle_pitch, new NormalizedDouble(this.left_ankle_pitch_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
     
     
     
     public void right_ankle_pitch_angle(int timeFrame, double right_ankle_pitch_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.right_ankle_pitch_value = right_ankle_pitch_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.right_ankle_pitch, new NormalizedDouble(this.right_ankle_pitch_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
    
    
 
 //************************************************************************************************************************************          
 //************************************************************************************************************************************           
/*
left_shoulder_pitch_value
right_shoulder_pitch_value   
left_shoulder_roll_value  
right_shoulder_roll_value
left_elbow_yaw_value      
right_elbow_yaw_value        
left_wrist_yaw_value       
right_wrist_yaw_value   
   */ 
    
    public void body_action_display(int timeFrame, double [] body_action_array,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.left_shoulder_pitch_value = body_action_array[0];
        this.right_shoulder_pitch_value = body_action_array[1];
        this.left_shoulder_roll_value = body_action_array[2];
        this.right_shoulder_roll_value = body_action_array[3];
        this.left_elbow_yaw_value = body_action_array[4];
        this.right_elbow_yaw_value = body_action_array[5];
        this.left_wrist_yaw_value = body_action_array[6];
        this.right_wrist_yaw_value = body_action_array[7];
        this.waist_value = body_action_array[8];

        
        
        
        
        this.myGoalPositions.put(this.left_shoulder_pitch, new NormalizedDouble(this.left_shoulder_pitch_value));
        this.myGoalPositions.put(this.right_shoulder_pitch, new NormalizedDouble(this.right_shoulder_pitch_value));
        this.myGoalPositions.put(this.left_shoulder_roll, new NormalizedDouble(this.left_shoulder_roll_value));
        //this.myGoalPositions.put(this.neck_pitch, new NormalizedDouble(this.head_pitch_angle_value));
        this.myGoalPositions.put(this.right_shoulder_roll, new NormalizedDouble(this.right_shoulder_roll_value));
       
        this.myGoalPositions.put(this.left_elbow_yaw, new NormalizedDouble(this.left_elbow_yaw_value));
        this.myGoalPositions.put(this.right_elbow_yaw, new NormalizedDouble(this.right_elbow_yaw_value));
        
        this.myGoalPositions.put(this.left_wrist_yaw, new NormalizedDouble(this.left_wrist_yaw_value));
        this.myGoalPositions.put(this.right_wrist_yaw, new NormalizedDouble(this.right_wrist_yaw_value));
        this.myGoalPositions.put(this.waist, new NormalizedDouble(this.waist_value));
    

        myRobot.move(this.myGoalPositions, this.timeFrame);    
        
    }
        
 //************************************************************************************************************************************          
 //************************************************************************************************************************************           
      

    
    
    
    
    
    
    
    
    
    
    /**
     * Method to make robot smile
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */
    public void open_eye(int timeFrame, double Open_eye_angle_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.Open_eye_angle_value = Open_eye_angle_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.eyelids, new NormalizedDouble(this.Open_eye_angle_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    public void Jaw_move(int timeFrame, double jaw_angle_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.jaw_angle_value = jaw_angle_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.jaw, new NormalizedDouble(this.jaw_angle_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    public void Turn_eye(int timeFrame, double Turn_eye_angle_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.Turn_eye_angle_value = Turn_eye_angle_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_eye_yaw, new NormalizedDouble(this.Turn_eye_angle_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    public void mouth_open(int timeFrame, double mouth_angle_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.mouth_angle_value = mouth_angle_value;
        this.myGoalPositions.put(this.jaw, new NormalizedDouble(this.mouth_angle_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    
    
    public void Head_Pitch(int timeFrame, double head_pitch_angle_value ,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.head_pitch_angle_value = head_pitch_angle_value;
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(this.head_pitch_angle_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    public void Head_Yaw(int timeFrame, double head_yaw_angle_value ,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.head_yaw_angle_value = head_yaw_angle_value;
        this.myGoalPositions.put(neck_yaw, new NormalizedDouble(this.head_yaw_angle_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);    
    }    
    
    public void Forehead(int timeFrame, double brows_angle_value,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.brows_angle_value = brows_angle_value;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.brows, new NormalizedDouble(this.brows_angle_value));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    public void Facial_Expression_display(int timeFrame, double [] Facial_Expression_array,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.Open_eye_angle_value = Facial_Expression_array[0];
        this.Turn_eye_angle_value = Facial_Expression_array[1];
        this.mouth_angle_value = Facial_Expression_array[2];
        this.head_pitch_angle_value = Facial_Expression_array[3];
        this.head_yaw_angle_value = Facial_Expression_array[4];
        this.brows_angle_value = Facial_Expression_array[5];
        this.jaw_angle_value = Facial_Expression_array[6];

        this.myGoalPositions.put(this.eyelids, new NormalizedDouble(this.Open_eye_angle_value));
        this.myGoalPositions.put(this.left_eye_yaw, new NormalizedDouble(this.Turn_eye_angle_value));
        this.myGoalPositions.put(this.left_smile, new NormalizedDouble(this.mouth_angle_value));
        //this.myGoalPositions.put(this.neck_pitch, new NormalizedDouble(this.head_pitch_angle_value));
        this.myGoalPositions.put(this.neck_yaw, new NormalizedDouble(this.head_yaw_angle_value));
        this.myGoalPositions.put(this.brows, new NormalizedDouble(this.brows_angle_value));
        this.myGoalPositions.put(this.jaw, new NormalizedDouble(this.jaw_angle_value));

        myRobot.move(this.myGoalPositions, this.timeFrame);    
        
    }
    
    public void Facial_Expression_record(int timeFrame, double [] Facial_Expression_array,RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        this.Open_eye_angle_value = Facial_Expression_array[0];
        this.Turn_eye_angle_value = Facial_Expression_array[1];
        this.mouth_angle_value = Facial_Expression_array[2];
        this.head_yaw_angle_value = Facial_Expression_array[3];
        this.brows_angle_value = Facial_Expression_array[4];
        this.jaw_angle_value = Facial_Expression_array[5];

        this.myGoalPositions.put(this.eyelids, new NormalizedDouble(this.Open_eye_angle_value));
        this.myGoalPositions.put(this.left_eye_yaw, new NormalizedDouble(this.Turn_eye_angle_value));
        this.myGoalPositions.put(this.left_smile, new NormalizedDouble(this.mouth_angle_value));
        this.myGoalPositions.put(this.neck_yaw, new NormalizedDouble(this.head_yaw_angle_value));
        this.myGoalPositions.put(this.brows, new NormalizedDouble(this.brows_angle_value));
        this.myGoalPositions.put(this.jaw, new NormalizedDouble(this.jaw_angle_value));

        myRobot.move(this.myGoalPositions, this.timeFrame);    
        
    }
    
    public void smile(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(this.left_smile, new NormalizedDouble(1));
        //this.myGoalPositions.put(this.right_smile, new NormalizedDouble(1));
        this.myGoalPositions.put(this.brows, new NormalizedDouble(0.6));
        this.myGoalPositions.put(this.eyelids, new NormalizedDouble(0.5));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    /**
     * Method to make robot frown
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */
    public void frown(int timeFrame, RemoteRobot myRobot) {
        this.myGoalPositions = new RobotPositionHashMap();
        this.timeFrame = timeFrame;
        // manipulate the robot's eyes and mouth
        this.myGoalPositions.put(left_smile, new NormalizedDouble(0.2));
        this.myGoalPositions.put(right_smile, new NormalizedDouble(0.2));
        this.myGoalPositions.put(brows, new NormalizedDouble(0.0));
        this.myGoalPositions.put(jaw, new NormalizedDouble(0.2));
        this.myGoalPositions.put(eyelids, new NormalizedDouble(0.5));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
    }
    
    /**
     * Method to make robot close eyes
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */
    public void closeEyes(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(eyelids, new NormalizedDouble(0.0));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
    }
    
    /**
     * Method to make robot open eyes
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */
    public void openEyes(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(eyelids, new NormalizedDouble(0.7));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
    }

    /** 
     * Method to make robot blink
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */
    public void blink(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(eyelids, new NormalizedDouble(0.0));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
        //Robokind.sleep(50);
        this.myGoalPositions.put(eyelids, new NormalizedDouble(0.5));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
    }
    
    /** 
     * Method to make robot nod
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */    
    public void nod(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.8));
        myRobot.move(this.myGoalPositions, this.timeFrame);
        Robokind.sleep(300);
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.2));
        myRobot.move(this.myGoalPositions, this.timeFrame);
        Robokind.sleep(300);
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.5));
        myRobot.move(this.myGoalPositions, this.timeFrame);
        Robokind.sleep(300);        
    }

     /** 
     * Method to make robot shake it's head 
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */  
    public void shakeHead(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(neck_yaw, new NormalizedDouble(0.8));
        myRobot.move(this.myGoalPositions, this.timeFrame);
        Robokind.sleep(300);
        this.myGoalPositions.put(neck_yaw, new NormalizedDouble(0.2));
        myRobot.move(this.myGoalPositions, this.timeFrame);
        Robokind.sleep(300);
        this.myGoalPositions.put(neck_yaw, new NormalizedDouble(0.5));
        myRobot.move(this.myGoalPositions, this.timeFrame);
        Robokind.sleep(500);        
    }
    
     /** 
     * Method to make robot look up
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */    
    public void lookUp(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(1.0));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    /** 
     * Method to make robot look up slightly
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */    
    public void gentleLookUp(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.8));
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
    
    /** 
     * Method to make robot look down
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */ 
    public void lookDown(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.2));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
    }
    
    /** 
     * Method to make robot look down
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */ 
    public void gentleLookDown(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = new RobotPositionHashMap();
        this.myGoalPositions.put(neck_pitch, new NormalizedDouble(0.4));
        myRobot.move(this.myGoalPositions, this.timeFrame); 
    }
    
     /**
     * Method to make robot move to defaults
     * @param timeFrame the amount of time to move joint over (milliseconds)
     * @param myRobot the connected RemoteRobot
     */
    public void setExpressionDefaults(int timeFrame, RemoteRobot myRobot) {
        this.timeFrame = timeFrame;
        this.myGoalPositions = myRobot.getDefaultPositions();
        // push joints back to defaults
        myRobot.move(this.myGoalPositions, this.timeFrame);
    }
}