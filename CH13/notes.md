a new chapter new start - Work on Your swing

this chapter we will learn about Sing components and layout manager

all components extend *JComponent*

we can fit any component into any 

## four steps to make GUI

make a window (*JFrame*)

    
    JFrame frame = new JFrame();
 make a component(*JButton*, textfield)
    
    
    JButton button = new JButtone("i m a button");
 Add the compnent to frame
    
    frame.getContentPane().add(BorderLayout.EAST, button);
Display it
    
    frame.setSize(300,300);
    frame.setVisible(true);
    
## Layout managers..
layout manager is a object that control the components within the compoent the manager associated with
like [Frame [Panel [Button ]]]
here there is the frame holding the panel and the panel hodling the button
so the layout manager of the frame will conntrol the positionng of the panel and the layout manager of the panel will control the positioning odf the button

by holing means *add* in them
    
    myPanel.add(button);
so the hierarchy of control is one level
there are different layout manager each of them have their different policies

the big three layout manager
1. BorderLayout
2. FlowLayout
3. BoxLayout

border  layout is the default for the frmae
in border layout the background component divided into five part

flow layout is like word processor that each compoent is added left to right and if it wont fit it gets into the necxt line
flow layout is default for the panel

box layout is like flow layout only difference is we can put it vertical and force the commponent to start the new line

## brain barbell
i guess about the height i think it take the 100% of the window or the size allowed by the above compoeneny

and the factor are otally depend an the compoent in which it is stored

i totally get the working of the borderlayout

## sharpen your pencil
i think all three will lined side by side each other

## there are no dumb qquestions
cool we can set the content pane of the fram by using our panel
    
    frame.setContentPane(panel);
we can put compoent by ourselves also but it will be a long run to hard code everuthong
    
    panel.setLayout(null);
