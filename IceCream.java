
//hahaha kms 
//graphics example for arcs

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.*;
import java.awt.event.*;


public class IceCream extends Canvas
{ 
    public Frame mainFrame;
    private Panel drawingPanel;
    private int frameXSize = 1000, frameYSize=800;
    private int canvasXSize=600, canvasYSize=600;
    private int Cone = 50;
    private int firstScoopDiameter = 210;
    private int secondScoopDiameter = 120;
    private int CherryDiameter = 50; 
    private int CherryStemLength = 25;
    private int SprinklesNum = 50; 
    private int SprinklesMaxSize = 3; 
    private int CandyDiameter = 5;
    private int CandyNum = 10;
    private int toppingDiameter=110;
   
    private int firstScoopX = 190; 
    private int firstScoopY = 210;
    private int secondScoopX = 235;
    private int secondScoopY = 120; 
    private int CherryX = 260; 
    private int CherryY = 75; 
    private int SprinklesX = 90;
    private int SprinklesY = 90;
    private int CandyX = 120;
    private int CandyY = 120;
    int [] x = {200, 300,400};
    int []y = {400, 600, 400};
    
    Color ConeColor = Color.white;
    Color FirstScoopColor = Color.white;
    Color SecondScoopColor = Color.white;
    Color CherryColor = Color.white; 
    Color SprinklesColor = Color.white; 
    Color CandyColor = Color.white;
    private int centerX=canvasXSize/2;
    private int centerY=canvasYSize/2;
    
    
    MyCanvas myIceCreamCanvas = new MyCanvas();
    
   
  
    
    public IceCream()
    {
        prepareIceCream();
    }
   
    
    public void prepareIceCream () 
    {
         mainFrame = new Frame("My Own Ice Cream");
        mainFrame.setSize(frameXSize, frameYSize);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        })
            ;
           drawingPanel = new Panel();
           drawingPanel.setLayout(new FlowLayout());
        
        mainFrame.add(drawingPanel);
        //mainFrame.setVisible(true);
        }
        
    public void showMyIceCream()
    {
        mainFrame.setVisible(true);
        
        final Choice partsChoice = new Choice();
        partsChoice.add("Cone");
        partsChoice.add("First Scoop");
        partsChoice.add("Second Scoop");
        partsChoice.add("Cherry");
        
       // partsChoice.add("Sprinkles");
        //partsChoice.add("Candy");

        final Choice colorChoice = new Choice();
        colorChoice.add("WHITE");
        colorChoice.add("RED");
        colorChoice.add("YELLOW");
        colorChoice.add("GREEN");
        colorChoice.add("PINK");
        colorChoice.add("BLUE");
        colorChoice.add("BLACK");
        colorChoice.add("CYAN");
      
        Button showButton = new Button("Show");

        showButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                Color newColor =Color.GRAY;
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
                        
                if(partsSelected=="Cone")
                    ConeColor=newColor;
                    else if(partsSelected=="First Scoop")
                       FirstScoopColor=newColor;
                    else if(partsSelected=="Second Scoop")
                        SecondScoopColor=newColor;
                    else if(partsSelected=="Cherry")
                        CherryColor=newColor;
                    else if(partsSelected=="Candy")
                        CandyColor=newColor;
                    else if(partsSelected=="Sprinkles")
                        SprinklesColor =newColor;
                        
                 myIceCreamCanvas.repaint();
        }
    });
    Button resetButton = new Button("Reset");

    resetButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e) 
        {
            ConeColor=Color.WHITE;
            FirstScoopColor=Color.WHITE;
            SecondScoopColor=Color.WHITE;
            CherryColor=Color.WHITE;
            SprinklesColor=Color.WHITE;
            CandyColor=Color.WHITE;
              
            myIceCreamCanvas.repaint();
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
        
        drawingPanel.add(myIceCreamCanvas);
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

            g2.drawString ("My Own Ice Cream!!!", 70, 20);
            g2.setColor(Color.black);
            g2.drawArc(200, 388, 200, 20, 180,-180);
            g2.setColor(ConeColor);
            g2.fillArc(200, 388, 200, 20, 180,-180);
            //g2.drawOval(firstScoopX+150, firstScoopY+200, firstScoopDiameter, firstScoopDiameter);
            g2.setColor(SecondScoopColor);
            g2.fillOval(secondScoopX, secondScoopY, secondScoopDiameter, secondScoopDiameter);
            g2.setColor(Color.black);
            g2.drawOval(secondScoopX, secondScoopY, secondScoopDiameter, secondScoopDiameter);
            //g2.setColor(Color.black);
            g2.drawOval(CherryX, CherryY, CherryDiameter,CherryDiameter);
            //g2.setColor(Color.BLACK);
            g2.setColor(FirstScoopColor);
            g2.fillOval(firstScoopX, firstScoopY, firstScoopDiameter, firstScoopDiameter);
            g2.setColor(Color.black); 
            g2.drawOval(firstScoopX, firstScoopY, firstScoopDiameter, firstScoopDiameter);
            g2.setColor(SecondScoopColor);
            g2.fillOval(secondScoopX, secondScoopY, secondScoopDiameter, secondScoopDiameter);
            g2.setColor(Color.black);
            g2.drawOval(secondScoopX, secondScoopY, secondScoopDiameter, secondScoopDiameter);
            g2.setColor(Color.black);
            g2.drawOval(CherryX, CherryY, CherryDiameter,CherryDiameter);
            g2.setColor(CherryColor);
            g2.fillOval(CherryX, CherryY, CherryDiameter, CherryDiameter);
            g2.setColor(Color.black);
            g2.drawArc(CherryX-10, CherryY-10, 40, 100, 90,-45);
            g2.setColor(Color.black); 
            g2.drawPolygon(x,y,3);
            g2.setColor(ConeColor);
            g2.fillPolygon(x,y,3);
            
            g2.setColor(SprinklesColor);
            /*for(int i=0; i<SprinklesNum; i++)
            {
                g2.setColor(SprinklesColor);
                SprinklesX=100+(int)(toppingDiameter*Math.random());
                yOffset=(int)(Math.sqrt((toppingDiameter/2)*(toppingDiameter/2)-Math.abs((SprinklesX-centerX))*Math.abs((SprinklesX-centerX))));
                SprinklesY=((int)(yOffset*(Math.random())))*2+centerY-yOffset;
                g2.fillOval(SprinklesX, SprinklesY, (int)(SprinklesMaxSize*Math.random())+1, (int)(SprinklesMaxSize*Math.random())+1);
                
            } 
            
            for(int i=0; i<CandyNum; i++)
            {
                CandyX=85+(int)((toppingDiameter-5)*Math.random());
                yOffset=(int)(Math.sqrt(((toppingDiameter-5)/2)*((toppingDiameter-5)/2)-Math.abs((CandyX-centerX))*Math.abs((CandyX-centerX))));
                CandyY=((int)(yOffset*(Math.random())))*2+centerY-yOffset;
                g2.setColor(CandyColor);
                g2.fillOval(CandyX, CandyY, CandyDiameter, CandyDiameter);
                g2.setColor(Color.black);
                g2.drawOval(CandyX, CandyY, CandyDiameter, CandyDiameter);
            } */
            
            
        }

        public void update(Graphics g) 
        {
            paint(g);
        }
    }

}
