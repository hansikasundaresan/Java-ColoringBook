//graphics example for arcs

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.*;
import java.awt.event.*;

public class penguin extends Canvas
{
    public Frame mainFrame;
    private Panel drawingPanel;
    private int frameXSize=1000, frameYSize=800;
    private int canvasXSize=600, canvasYSize=600;;
    private int earDiameter = 10;
    Color leftEarColor = Color.WHITE;
    Color rightEarColor = Color.WHITE;
    private int faceDiameter = 200;
    Color faceColor = Color.WHITE;
    private int innerFaceCurveLength =170;
    private int innerFaceHeartTop = 85;
    private int innerFaceHeartNumber =2;
    Color innerFaceColor = Color.WHITE;
    private int eyeDiameter = 50;
    private int eyeNumber =2;
    Color eyeColor = Color.WHITE;
    private int pupilLength = 25;
    private int pupilNumber = 2;
    Color pupilColor = Color.WHITE;
    private int noseLength=10;
    Color noseColor = Color.WHITE;
    private int mouthLength= 50;
    private int mouthLine = 40;
    Color mouthColor = Color.WHITE;
    private int bodyCurveLength = 20;
    private int bodyCurveLengthNumber = 4;
    private int curvedInsideBodyLength = 200;
    private int curvedInsideBodyWidth = 150;
    Color outerBodyColor = Color.WHITE;
    Color innerBodyColor = Color.WHITE;//150?
    //window.drawRoundRect(115,210,70,90,10,10)
    private int finArcLength= 100;
    private int finNumber = 2;
    private int finCurveLength = 30;
    private int FinCurveNumber = 2;
    Color bottomColor = Color.WHITE;
    Color rightArmColor = Color.WHITE;
    Color leftArmColor = Color.WHITE;
    private int bodyLineLength = 280;   
    
    private int earsX = 200;
    private int earsY = 80;
    private int FaceX = 270;
    private int FaceY = 100;
    private int innerFaceArcX = 296;
    private int innerFaceArcY=115;
    private int innerFaceHeartLeftX = 251;
    private int innerFaceHeartLeftY = 145;
    private int innerFaceHeartRightX = 141;
    private int innerFaceHeartRightY=115;
    private int eyeLeftX= 140;
    private int eyeLeftY = 130;
    private int eyeRightX= 160;
    private int eyeRightY = 130;
    private int noseX= 150;
    private int noseY = 145;
    private int mouthX = 150;
    private int mouthY = 160;
   
    private int bodyRectangleX = 270;
    private int bodyRectangleY = 275;
    private int innerBodyRectangleX=295;
    private int innerBodyRectangleY = 315;
    private int finLeftX=100;
    private int finLeftY=250;
    private int finRightX = 300;
    private int finRightY = 250;
    private int feet1X = 400;
    private int feet1Y = 400;
    private int feet2X= 400;
    private int feet2Y = 400;
    
    MyCanvas myPenguinCanvas = new MyCanvas();
    
    
    public penguin()
    {
           prepareMonkey();
    }

    public void prepareMonkey()
    {
       mainFrame = new Frame("My Own Robot Monkey");
        mainFrame.setSize(frameXSize, frameYSize);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
            });
           drawingPanel = new Panel();
           drawingPanel.setLayout(new FlowLayout());
        
        mainFrame.add(drawingPanel);
        //mainFrame.setVisible(true);
        }
        
    public void showMyPenguin()
    {
        mainFrame.setVisible(true);
        
        final Choice partsChoice = new Choice();
        partsChoice.add("Left Ear");
        partsChoice.add("Right Ear");
        partsChoice.add("Outside Face");
        partsChoice.add("Inside Face");
        partsChoice.add("Eye(not pupil)");
        partsChoice.add("Eye(pupil)");
        partsChoice.add("Nose");
        partsChoice.add("Mouth");
        partsChoice.add("Outside Body");
        partsChoice.add("Inner Body");
        partsChoice.add("Right Arm");
        partsChoice.add("Left Arm");
        partsChoice.add("Bottom Bot Holder");
        
        final Choice colorChoice = new Choice();
        colorChoice.add("WHITE");
        colorChoice.add("RED");
        colorChoice.add("YELLOW");
        colorChoice.add("GREEN");
        colorChoice.add("PINK");
        colorChoice.add("BLUE");
        colorChoice.add("BLACK");
        colorChoice.add("CYAN");
        colorChoice.add("ORANGE");
        
        Button showButton = new Button("Show");

        showButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {     
                Color newColor=Color.GRAY;
                String partsSelected = partsChoice.getItem(partsChoice.getSelectedIndex());
                String colorSelected = colorChoice.getItem(colorChoice.getSelectedIndex());

                if(colorSelected=="WHITE")
                    newColor=Color.WHITE;
                    else if(colorSelected=="RED")
                        newColor=Color.RED;
                    else if(colorSelected=="YELLOW")
                        newColor=Color.YELLOW;
                    else if(colorSelected=="GREEN")
                        newColor=Color.GREEN;
                    else if(colorSelected=="PINK")
                        newColor=Color.PINK;
                    else if(colorSelected=="BLUE")
                        newColor=Color.BLUE;
                    else if(colorSelected=="BLACK")
                        newColor=Color.BLACK;
                    else if(colorSelected=="CYAN")
                        newColor=Color.CYAN;
                        else if (colorSelected == "ORANGE")
                        newColor=Color.ORANGE;  
                
                if(partsSelected=="Left Ear")
                    leftEarColor=newColor;
                else if(partsSelected=="Right Ear")
                        rightEarColor=newColor;
                else if(partsSelected=="Outside Face")
                        faceColor=newColor;
                else if(partsSelected=="Inside Face")
                        innerFaceColor=newColor;
                else if(partsSelected=="Eye(not pupil)")
                        eyeColor=newColor;
                else if(partsSelected=="Eye(pupil)")
                        pupilColor=newColor;
                else if(partsSelected=="Nose")
                        noseColor=newColor;
                else if(partsSelected=="Mouth")
                        mouthColor=newColor;
                else if(partsSelected=="Outside Body")
                        outerBodyColor=newColor;
                else if(partsSelected=="Inner Body")
                        innerBodyColor=newColor;
                else if(partsSelected=="Right Arm")
                        rightArmColor=newColor;
                else if(partsSelected=="Left Arm")
                        leftArmColor=newColor;        
                else if(partsSelected=="Bottom Bot Holder")
                        bottomColor=newColor; 
               
                myPenguinCanvas.repaint();
            }
        }); 
        Button resetButton = new Button("Reset");

        resetButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                leftEarColor=Color.WHITE;
                rightEarColor=Color.WHITE;
                faceColor=Color.WHITE;
                eyeColor=Color.WHITE;
                pupilColor=Color.WHITE;
                noseColor =Color.WHITE;
                mouthColor =Color.WHITE;
                outerBodyColor=Color.WHITE;
                innerBodyColor=Color.WHITE;
                rightArmColor =Color.WHITE;
                leftArmColor=Color.WHITE;
                bottomColor=Color.WHITE;

               myPenguinCanvas.repaint();
               
            }
        });

        Button quitButton = new Button("Quit");
        quitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                drawingPanel.removeAll();
                mainFrame.validate();
                mainFrame.dispose();
            }
        });
        
        drawingPanel.add(partsChoice);
        drawingPanel.add(colorChoice);
        drawingPanel.add(showButton);
        drawingPanel.add(resetButton);
        drawingPanel.add(quitButton);
        
        drawingPanel.add(myPenguinCanvas);
        mainFrame.setVisible(true);  
         
    }
    class MyCanvas extends Canvas
    {
         public MyCanvas () 
        {
            setBackground (Color.white);
            setSize(canvasXSize, canvasYSize);
        }
        public void paint (Graphics g) 
        {
            Graphics2D g2;
            g2 = (Graphics2D) g;
            int yOffset=0, temp=0;

            g2.drawString ("My Own Robot Monkey!!!", 70, 20);
            g2.setColor(outerBodyColor);
            g2.fillRoundRect(bodyRectangleX,bodyRectangleY,200,bodyLineLength,bodyCurveLength,bodyCurveLength);
            g2.setColor(Color.BLACK);
            g2.drawRoundRect(bodyRectangleX,bodyRectangleY,200,bodyLineLength,bodyCurveLength,bodyCurveLength);
            g2.setColor(innerBodyColor);
            g2.fillRoundRect(innerBodyRectangleX, innerBodyRectangleY, curvedInsideBodyWidth, curvedInsideBodyLength, 25,25);
            g2.setColor(Color.black);
            g2.drawRoundRect(innerBodyRectangleX, innerBodyRectangleY, curvedInsideBodyWidth, curvedInsideBodyLength, 25,25);
            g2.setColor(leftEarColor);
            g2.fillArc(earsX+45, earsY+75, earDiameter+80,35+35+15, 90,180);
            g2.setColor(rightEarColor);
            g2.fillArc(earsX+208, earsY+75, earDiameter+80,35+35+15, 270,180);
            g2.setColor(Color.BLACK);
            g2.drawArc(earsX+45, earsY+75, earDiameter+80,35+35+15, 90,180);
            g2.drawArc(earsX+208, earsY+75, earDiameter+80,35+35+15, 270,180);
            g2.setColor(faceColor);
            g2.fillOval(FaceX,FaceY,faceDiameter, faceDiameter);
            g2.setColor(Color.BLACK);
            g2.drawOval(FaceX,FaceY,faceDiameter, faceDiameter);
            g2.setColor(Color.BLACK);
            g2.drawArc(innerFaceArcX, innerFaceArcY-35, 150, innerFaceCurveLength+40,180,180);
            g2.drawArc(innerFaceHeartLeftX+45, innerFaceHeartLeftY, innerFaceHeartTop,90,0,180);
            g2.drawArc(innerFaceHeartLeftX+110, innerFaceHeartLeftY, innerFaceHeartTop,90,0,180);
            g2.setColor(innerFaceColor);
            g2.fillArc(innerFaceArcX, innerFaceArcY-35, 150, innerFaceCurveLength+40,180,180);
            g2.fillArc(innerFaceHeartLeftX+45, innerFaceHeartLeftY, innerFaceHeartTop,90,0,180);
            g2.fillArc(innerFaceHeartLeftX+110, innerFaceHeartLeftY, innerFaceHeartTop,90,0,180);
            g2.setColor(eyeColor);
            g2.fillOval(eyeLeftX+182, eyeLeftY+40,35, eyeDiameter-5); 
            g2.fillOval(eyeLeftX+243, eyeLeftY+40,35, eyeDiameter-5);
            g2.setColor(Color.BLACK);
            g2.drawOval(eyeLeftX+182, eyeLeftY+40,35, eyeDiameter-5); 
            g2.drawOval(eyeLeftX+243, eyeLeftY+40,35, eyeDiameter-5);
            
            g2.setColor(pupilColor);
            g2.fillOval(eyeLeftX+187, eyeLeftY+57, 25,30);
            g2.fillOval(eyeLeftX+187+61, eyeLeftY+57, 25,30);
            g2.setColor(Color.BLACK);
            g2.drawOval(eyeLeftX+187, eyeLeftY+57, 25,30);
            g2.drawOval(eyeLeftX+187+61, eyeLeftY+57, 25,30);
            int[] x = {eyeLeftX+227, eyeLeftX+232, eyeLeftX+237};
            int[] y = {eyeLeftY+100, eyeLeftY+110, eyeLeftY+100};
            g2.setColor(noseColor);
            g2.fillPolygon(x,y,3);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(x,y,3);
            g2.setColor(mouthColor);
            g2.fillArc(eyeLeftX+220, eyeLeftY+110, 25,30, 180,180);
            g2.setColor(Color.BLACK);
            g2.drawArc( eyeLeftX+220, eyeLeftY+110, 25,30, 180,180);
            g2.setColor(rightArmColor);
            g2.fillArc(finLeftX+105, finLeftY+35, finCurveLength+100, finArcLength+100, 90,180);
            g2.setColor(leftArmColor);
            g2.fillArc(finLeftX+305, finLeftY+35, finCurveLength+100, finArcLength+100, 270,180);
            g2.setColor(Color.BLACK);
            g2.drawArc(finLeftX+105, finLeftY+35, finCurveLength+100, finArcLength+100, 90,180);
            g2.drawArc(finLeftX+305, finLeftY+35, finCurveLength+100, finArcLength+100, 270,180);
            g2.setColor(Color.WHITE);
            g2.fillArc(finLeftX+330, finLeftY+80, finCurveLength+50, finArcLength+50, 270,180);
            g2.fillArc(finLeftX+130, finLeftY+80, finCurveLength+50, finArcLength+50, 90,180);
            g2.setColor(Color.black);
            g2.drawArc(finLeftX+330, finLeftY+80, finCurveLength+50, finArcLength+50, 270,180);
            g2.drawArc(finLeftX+130, finLeftY+80, finCurveLength+50, finArcLength+50, 90,180);
            g2.setColor(bottomColor);
            g2.fillArc(feet1X-95, feet1Y+155, finCurveLength+100, finArcLength+100, 0,180);
            g2.setColor(Color.black);
            g2.drawArc(feet1X-95, feet1Y+155, finCurveLength+100, finArcLength+100, 0,180);
            g2.drawLine(feet1X-85, feet1Y+199, feet1X+22,feet1Y+199);
           
        }
        public void update(Graphics g) 
        {
            paint(g);
        }
    }
}