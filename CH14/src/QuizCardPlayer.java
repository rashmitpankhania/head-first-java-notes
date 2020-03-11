import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class QuizCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> quizCards;
    private QuizCard currentQuizCard;
    private boolean isShowAnswer;
    private int currentCardIndex;

    JFrame frame;
    private JButton nextButton;
    private JPanel mainPanel;

    public static void main(String[] args) {
        QuizCardPlayer quizCardPlayer = new QuizCardPlayer();
        quizCardPlayer.go();
    }

    void go(){
        frame = new JFrame("Quiz Card Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();

        Font bigFont  = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10, 20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640,500);
        frame.setVisible(true);
    }

    void showNextCard(){
        currentQuizCard = quizCards.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentQuizCard.getQuestion());
        nextButton.setText("Answer dika");
        isShowAnswer = true;
    }

    private class NextCardListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(isShowAnswer){
                display.setText(currentQuizCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            } else {
                if(currentCardIndex < quizCards.size())
                    showNextCard();
                else{
//                    display.setText("Akhri tha woo");
//                    nextButton.setEnabled(false);
                    currentCardIndex = 0;
                }
            }
        }
    }

    void makeCard(String l){
        String[] res = l.split("/");
        QuizCard q = new QuizCard(res[0], res[1]);
        quizCards.add(q);
        System.out.println("made it");
    }

    void loadFile(File f){
        quizCards = new ArrayList<>();
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String l = null;
            while((l = bfr.readLine()) != null){
                makeCard(l);
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class OpenMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(frame);
            loadFile(fileChooser.getSelectedFile());
        }
    }
}
