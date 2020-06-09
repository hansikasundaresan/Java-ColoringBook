import java.awt.*;
import java.awt.event.*;

public class Pizza
{
    public Frame mainFrame;
    private Panel drawingPanel;
    private int frameXSize=1000, frameYSize=800;
    private int canvasXSize=600, canvasYSize=600;
    private int crustDiameter=500;
    private int sauceDiameter=440;
    private int cheeseNum=5000;
    private int toppingDiameter=430;
    private int cheeseMaxSize=10;
    private int pepperoniDiameter=50;
    private int pepperoniNum=30;
    private int salamiDiameter=10;
    private int salamiNum=200;
    private int sauceXStart=80;
    
    private int crustX=50;
    private int crustY=50;
    Color crustColor=Color.WHITE;
    //Color crustColor=Color.green;
    
    private int sauceX=80;
    private int sauceY=80;
    Color sauceColor=Color.WHITE;
    //Color sauceColor=Color.red;
    
    private int cheeseX=80;
    private int cheeseY=80;
    Color cheeseColor=Color.WHITE;
    //Color cheeseColor=Color.yellow;
    
    private int pepperoniX=80;
    private int pepperoniY=60;
    Color pepperoniColor=Color.WHITE;
    //Color pepperoniColor=Color.cyan;
    
    private int salamiX=120;
    private int salamiY=100;
    Color salamiColor=Color.WHITE;
    //Color salamiColor=Color.pink;
    
    private int centerX=canvasXSize/2;
    private int centerY=canvasYSize/2;
    
    MyCanvas myPizzaCanvas = new MyCanvas();

    
    public Pizza()
    {
        preparePizza();
    }
    
    private void preparePizza()
    {
        mainFrame = new Frame("My Own Pizza");
        mainFrame.setSize(frameXSize, frameYSize);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                mainFrame.dispose();
                //System.exit(0);
            }
        });
        
        drawingPanel = new Panel();
        drawingPanel.setLayout(new FlowLayout());
        
        mainFrame.add(drawingPanel);
        //mainFrame.setVisible(true);
    }
    
    public void showMyPizza()
    {
        mainFrame.setVisible(true);
        
        final Choice partsChoice = new Choice();
        partsChoice.add("Crust");
        partsChoice.add("Sauce");
        partsChoice.add("Cheese");
        partsChoice.add("Pepperoni");
        partsChoice.add("Salami");

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
                        
                if(partsSelected=="Crust")
                    crustColor=newColor;
                    else if(partsSelected=="Sauce")
                        sauceColor=newColor;
                    else if(partsSelected=="Cheese")
                        cheeseColor=newColor;
                    else if(partsSelected=="Pepperoni")
                        pepperoniColor=newColor;
                    else if(partsSelected=="Salami")
                        salamiColor=newColor;
                        
                myPizzaCanvas.repaint();
                
            }
        }); 

        Button resetButton = new Button("Reset");
        
        resetButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                crustColor=Color.WHITE;
                sauceColor=Color.WHITE;
                cheeseColor=Color.WHITE;
                pepperoniColor=Color.WHITE;
                salamiColor=Color.WHITE;
                
                myPizzaCanvas.repaint();
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
        
        drawingPanel.add(myPizzaCanvas);
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

            g2.drawString ("My Own Pizza!!!", 70, 20);
           
            g2.setColor(crustColor);
            g2.fillOval(crustX, crustY, crustDiameter, crustDiameter);
            g2.setColor(Color.black);
            g2.drawOval(crustX, crustY, crustDiameter, crustDiameter);
            g2.setColor(sauceColor);
            g2.fillOval(sauceX, sauceY, sauceDiameter, sauceDiameter);
            g2.setColor(Color.black);
            g2.drawOval(sauceX, sauceY, sauceDiameter, sauceDiameter);
            g2.setColor(cheeseColor);
            for(int i=0; i<cheeseNum; i++)
            {
                g2.setColor(cheeseColor);
                cheeseX=sauceXStart+(int)(toppingDiameter*Math.random())-5;
                yOffset=(int)(Math.sqrt((toppingDiameter/2)*(toppingDiameter/2)
                    -Math.abs((cheeseX-centerX))*Math.abs((cheeseX-centerX))));
                cheeseY=((int)(yOffset*(Math.random())))*2+centerY-yOffset-3;
                g2.fillOval(cheeseX, cheeseY, (int)(cheeseMaxSize*Math.random())+1,
                    (int)(cheeseMaxSize*Math.random())+1);
                //g2.setColor(Color.black);
                //g2.drawOval(cheeseX, cheeseY, (int)(cheeseMaxSize*Math.random())+1,
                //    (int)(cheeseMaxSize*Math.random())+1);
            }
            for(int i=0; i<pepperoniNum; i++)
            {
                pepperoniX=sauceXStart+(int)((toppingDiameter-pepperoniDiameter)*Math.random());
                yOffset=(int)(Math.sqrt(((toppingDiameter-pepperoniDiameter)/2)
                    *((toppingDiameter-pepperoniDiameter)/2)-Math.abs((pepperoniX-centerX))
                     *Math.abs((pepperoniX-centerX))));
                pepperoniY=((int)(yOffset*(Math.random())))*2+centerY-yOffset-30;
                g2.setColor(pepperoniColor);
                g2.fillOval(pepperoniX, pepperoniY, pepperoniDiameter, pepperoniDiameter);
                g2.setColor(Color.black);
                g2.drawOval(pepperoniX, pepperoniY, pepperoniDiameter, pepperoniDiameter);
            }
            
            for(int i=0; i<salamiNum; i++)
            {
                salamiX=sauceXStart+(int)((toppingDiameter-5)*Math.random());
                yOffset=(int)(Math.sqrt(((toppingDiameter-5)/2)*((toppingDiameter-5)/2)
                    -Math.abs((salamiX-centerX))*Math.abs((salamiX-centerX))));
                salamiY=((int)(yOffset*(Math.random())))*2+centerY-yOffset;
                g2.setColor(salamiColor);
                g2.fillOval(salamiX, salamiY, salamiDiameter, salamiDiameter);
                g2.setColor(Color.black);
                g2.drawOval(salamiX, salamiY, salamiDiameter, salamiDiameter);
            }
            
            g2.setColor(Color.black);
            temp=crustDiameter/2;
            g2.drawLine(centerX-temp, centerY, centerX+temp, centerY);
            g2.drawLine(centerX, centerY-temp, centerX, centerY+temp);
            temp=(int)Math.sqrt(temp*temp/2);
            g2.drawLine(centerX-temp, centerY-temp, centerX+temp, centerY+temp);
            g2.drawLine(centerX+temp, centerY-temp, centerX-temp, centerY+temp);
        }
            
        public void update(Graphics g) 
        {
            paint(g);
        }
    }

}
