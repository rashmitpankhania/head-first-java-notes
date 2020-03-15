import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class MusicSystem {
    String[] instruments = {"Bass Drum", "Closed Hi-Hat",
            "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga"};
    int[] instrumentCode = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    // adding the chat system
    JList<String> incomingList;
    JTextField userMessage;
    Vector<String> listVector = new Vector<>();
    String userName;
    ObjectInputStream in;
    ObjectOutputStream out;
    HashMap<String, boolean[]> otherSeqMap = new HashMap<>();
    int nextNum;

    ArrayList<JCheckBox> checkBoxes;
    Sequencer sequencer;
    Sequence sequence;
    JFrame frame;
    JPanel mainPanel;
    Track track;

    public static void main(String[] args) {
        MusicSystem musicSystem = new MusicSystem();
//        args[0] = "Rashmit";
        musicSystem.go("RAshmit");
    }

    void buildGUI() {
        frame = new JFrame("BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();
        JPanel background = new JPanel(borderLayout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxes = new ArrayList<>();

        // button box start
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton saveTune = new JButton("Save Tune");
        saveTune.addActionListener(new SaveTuneListener());
        buttonBox.add(saveTune);

        JButton restoreTune = new JButton("Restore Tune");
        restoreTune.addActionListener(new RestoreTuneListener());
        buttonBox.add(restoreTune);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String instrument : instruments) {
            nameBox.add(new Label(instrument));
        }

        JButton sendMessage = new JButton("Send it!");
        sendMessage.addActionListener(new SendMessageListener());
        buttonBox.add(sendMessage);

        userMessage = new JTextField();
        buttonBox.add(userMessage);

        incomingList = new JList<>();
        incomingList.addListSelectionListener(new MyListSelectionListener());
        incomingList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JScrollPane theList = new JScrollPane(incomingList);
        buttonBox.add(theList);
        incomingList.setListData(listVector);

        // button box ends
        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

        GridLayout gridLayout = new GridLayout(16, 16);
        gridLayout.setVgap(1);
        gridLayout.setHgap(2);

        mainPanel = new JPanel(gridLayout);
        background.add(BorderLayout.CENTER, mainPanel);

        // creating check boxes
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxes.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        // end
        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    void go(String name) {
        userName = name;
        try {
            Socket socket = new Socket("127.0.0.1", 4242);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            Thread t = new Thread(new RemoteReader());
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("sorry play alone cant connect to network! :(");
        }
        buildGUI();
    }

    void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    private class RestoreTuneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(frame);

            boolean[] checklist;
            try {
                FileInputStream f = new FileInputStream(fileChooser.getSelectedFile());
                ObjectInputStream o = new ObjectInputStream(f);
                checklist = (boolean[]) o.readObject();
                for (int i = 0; i < 256; i++) {
                    JCheckBox checkBox = checkBoxes.get(i);
                    checkBox.setSelected(checklist[i]);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            sequencer.stop();
            buildTrackAndStart();
        }
    }

    private class SaveTuneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(frame);
            boolean[] checkList = new boolean[256];
            for (int i = 0; i < 256; i++) {
                checkList[i] = checkBoxes.get(i).isSelected();
            }

            try {
                FileOutputStream f = new FileOutputStream(fileChooser.getSelectedFile());
                ObjectOutputStream os = new ObjectOutputStream(f);
                os.writeObject(checkList);
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class MyStartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            buildTrackAndStart();
        }
    }

    private class MyStopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            sequencer.stop();
        }
    }

    private class MyUpTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            float temp = sequencer.getTempoFactor();
            sequencer.setTempoInBPM((float) (temp * 1.03));
        }
    }

    private class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            float temp = sequencer.getTempoFactor();
            sequencer.setTempoInBPM((float) (temp * .97));
        }
    }


    class SendMessageListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            boolean[] checkBoxState = new boolean[256];
            for (int i = 0; i < 256; i++) {
                checkBoxState[i] = checkBoxes.get(i).isSelected();
            }
            String messageToSend = userName + nextNum++ + " : " + userMessage.getText();
            try {
                out.writeObject(messageToSend);
                out.writeObject(checkBoxState);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("sorry message not sent");
            }
            userMessage.setText("");
        }
    }

    class MyListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            if (!listSelectionEvent.getValueIsAdjusting()) {
                String selected = incomingList.getSelectedValue();
                if (selected != null) {
                    boolean[] selectedState = otherSeqMap.get(selected);
                    changeSequence(selectedState);
                    sequencer.stop();
                    buildTrackAndStart();
                }
            }
        }
    }

    void changeSequence(boolean[] seq) {
        for (int i = 0; i < 256; i++) {
            checkBoxes.get(i).setSelected(seq[i]);
        }
    }

    class RemoteReader implements Runnable {
        boolean[] checkBoxState = null;
        String nameToShow = null;
        Object obj = null;

        @Override
        public void run() {
            try {
                while ((obj = in.readObject()) != null) {
                    System.out.println("got an object from server");
                    System.out.println(obj.getClass());
                    nameToShow = (String) obj;
                    checkBoxState = (boolean[]) in.readObject();
                    otherSeqMap.put(nameToShow, checkBoxState);
                    listVector.add(nameToShow);
                    incomingList.setListData(listVector);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    void buildTrackAndStart() {
        int[] trackList;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            int key = instrumentCode[i];

            for (int j = 0; j < 16; j++) {
                JCheckBox checkBox = checkBoxes.get(j + 16 * i);
                if (checkBox.isSelected())
                    trackList[j] = key;
                else
                    trackList[j] = 0;
            }
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }
        track.add(makeEvent(192, 9, 1, 0, 15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    void makeTracks(int[] trackArray) {
        for (int i = 0; i < 16; i++) {
            int key = trackArray[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 3));
            }
        }
    }

    MidiEvent makeEvent(int cmd, int chan, int key, int velocity, int tick) {
        MidiEvent event;
        ShortMessage message = new ShortMessage();
        try {
            message.setMessage(cmd, chan, key, velocity);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        event = new MidiEvent(message, tick);
        return event;
    }
}
