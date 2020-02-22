import javax.sound.midi.*;
import javax.swing.*;

class MiniMusicPlayer1 {
    static JFrame frame = new JFrame("My First Animation Panel");
    static MyAnimationPanel myAnimationPanel;

    public static void main(String[] args) {
        MiniMusicPlayer1 miniMusicPlayer1 = new MiniMusicPlayer1();
        miniMusicPlayer1.go();
    }

    public void setupGui(){
        myAnimationPanel = new MyAnimationPanel();
        frame.setContentPane(myAnimationPanel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
        setupGui();
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventArray = {127};
            sequencer.addControllerEventListener(myAnimationPanel, eventArray);

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            for (int i = 5; i < 100; i++) {
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(176,1,127,0,i));
                track.add(makeEvent(128, 1, i, 100, i + 3));
            }

            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        ShortMessage message = new ShortMessage();
        try {
            message.setMessage(cmd, chnl, one, two);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return new MidiEvent(message, tick);
    }
}
