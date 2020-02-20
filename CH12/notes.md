i dont know how but my last commit is i cannont find

now the regualr part
## sharpen your pencil
1. checkbox - actionPerformed, 
2. textfield - actionPerformed, keytyped, itemstatechenged
3. scrolling list - itemstatechenged, focusgained
4. button - actionPerformed, mousepressed, mouseexited
5. dialog box - windowclosing, 
6. radio button - itemstatechanged, actionPerformed, focusgained,
7. menu item - itemstatechanged, focusgainde 

## bullet points about the events

to make the gui start with a window usualky with a frame
 
     JFrame frame = new JFrame();
we can add widgets also
    
    frame.getContentPane().add(button);
its like we cannot add the components directly so we have to add it to its content pane
to make it visible
    
    frame.setSize(300,300);
    frame.setVisible(true);
to know when the user clicks the button we need to add the event listenor
and to listen an event we must reggister wiuth the event source
    
    button.addActionListener(this);
implement the listerner im=nterface by implen=menting all the methods
    
    public void action actionPerformed(ActionEvent e){
        button.setText("it cclicked!!");
    }
## now that we know about the event lets recap the graphics part
we can direclty draw the graphics directly on the widgets
we can draw a .gif or a .jpeg
to draw a grphic make subclass of Jpanel and override the paintcomponent methof
the paintcompoennt mehotd is  call by GUI system itself **you never call it by yourself**
typical methods are
    
    graphics.setColor(Color.blue);
    g.fillRect(20,20,100,100); // left,top, width, height
to draw a jpeg construc a jpecg and use drawImage method
    
    Image img = new ImageIcon("filename.jpeg").getImage();
    g.drawImage(img, 3,4,this);
use the Grpahics2d object which is subclass of graphics you can get it back by casting

    Graphics2D g2d = (Graphics2D) g;  