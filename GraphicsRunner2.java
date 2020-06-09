//graphics frame to run graphics examples

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class GraphicsRunner2 extends JFrame
{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 80;
    private static GraphicsRunner2 draw = new GraphicsRunner2();
    private static Panel chooseDrawing;
    private static penguin myOwnPenguin = new penguin();
    private static Pizza myOwnPizza = new Pizza();
    private static IceCream myOwnIceCream = new IceCream();
    

    public GraphicsRunner2()
    {
        super("Graphics Runner");
    }
    
    public static void main( String args[] )
    {
        draw.setSize(WIDTH,HEIGHT);
        draw.setLayout(new FlowLayout());
        draw.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });

        chooseDrawing = new Panel();
        chooseDrawing.setLayout(new FlowLayout());
        draw.getContentPane().add(chooseDrawing);
        
        draw.setVisible(true);
        draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createAndShowGUI();
    }

    private static void createAndShowGUI()
    {
        Button penguinButton = new Button("Robot Monkey");
        penguinButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                myOwnPenguin.showMyPenguin();
            }
        });
        
        Button pizzaButton = new Button("Pizza");
        pizzaButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                myOwnPizza.showMyPizza();
            }
        });
        
        Button iceCreamButton = new Button("IceCream");
        iceCreamButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                myOwnIceCream.showMyIceCream();
            }
        });
        
        Button quitButton = new Button("QUIT");
        quitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(myOwnPenguin.mainFrame.isDisplayable())
                    myOwnPenguin.mainFrame.dispose();
                if(myOwnPizza.mainFrame.isDisplayable())
                    myOwnPizza.mainFrame.dispose();
                if(draw.isDisplayable())
                    draw.dispose();
            }
        });
        
        draw.add(penguinButton);
        draw.add(pizzaButton);
        draw.add(iceCreamButton);
        draw.add(quitButton);
    }

}