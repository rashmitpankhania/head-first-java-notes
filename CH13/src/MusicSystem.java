import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MusicSystem {
    String[] instruments = {"Bass Drum", "Closed Hi-Hat",
            "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga"};
    int[] instrumentCode = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    ArrayList<JCheckBox> checkBoxes;
    Sequencer sequencer;
    Sequence sequence;
    JFrame frame;
    JPanel mainPanel;
    Track track;

    public static void main(String[] args) {
        MusicSystem musicSystem = new MusicSystem();
        musicSystem.go();
    }

    void buildGUI() {
        frame = new JFrame("BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();
        JPanel background = new JPanel(borderLayout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxes = new ArrayList<>();

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

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String instrument : instruments) {
            nameBox.add(new Label(instrument));
        }

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

    void go() {
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
            sequencer.setTempoInBPM((float)(temp*1.03));
        }
    }

    private class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            float temp = sequencer.getTempoFactor();
            sequencer.setTempoInBPM((float)(temp* .97));
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
