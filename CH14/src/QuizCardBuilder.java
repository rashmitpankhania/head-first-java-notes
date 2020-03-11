import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuizCardBuilder {
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> quizCards;
    private JFrame frame;

    public static void main(String[] args) {
        QuizCardBuilder q = new QuizCardBuilder();
        q.go();
    }

    void go(){
        frame = new JFrame("Quiz Card Builder");
        JPanel panel =  new JPanel();
        Font bigFont = new Font("sansserif", Font.BOLD, 24);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        question = new JTextArea(6, 20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane scrollPane = new JScrollPane(question);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(5, 20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScrollPane = new JScrollPane(answer);
        aScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        aScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        quizCards = new ArrayList<>();

        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");
        JButton nextButton = new JButton("Next Card");

        panel.add(qLabel);
        panel.add(scrollPane);
        panel.add(aLabel);
        panel.add(aScrollPane);
        panel.add(nextButton);

        nextButton.addActionListener(new NextButtonActionListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
        menu.add(newMenuItem);
        menu.add(saveMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    private class SaveMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            quizCards.add(new QuizCard(question.getText(), answer.getText()));

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(frame);
            saveFile(fileChooser.getSelectedFile());

        }
    }

    private static class NewMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }

    private class NextButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            quizCards.add(new QuizCard(question.getText(), answer.getText()));
            clearText();
        }
    }

    void clearText(){
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    void saveFile(File f) {
        BufferedWriter b = null;
        try {
            b = new BufferedWriter(new FileWriter(f));
            for(QuizCard c: quizCards){
                b.write(c.getQuestion()+"/");
                b.write(c.getAnswer()+'\n');
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
