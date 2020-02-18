import javax.sound.midi.*;

class MusicTest1 {
    public void play() {
        try {
            Sequencer seq = MidiSystem.getSequencer();
            seq.open();
            Sequence s = new Sequence(Sequence.PPQ, 4);
            Track t = s.createTrack();

            ShortMessage mes = new ShortMessage();
            mes.setMessage(ShortMessage.NOTE_ON, 1, 62, 100);
            MidiEvent ev = new MidiEvent(mes, 1);
            t.add(ev);
            mes = new ShortMessage();
            mes.setMessage(ShortMessage.NOTE_OFF, 1, 62, 100);
            ev = new MidiEvent(mes, 16);
            t.add(ev);
            mes.setMessage(ShortMessage.NOTE_ON, 1, 110, 100);
            ev = new MidiEvent(mes, 17);
            t.add(ev);
            mes = new ShortMessage();
            mes.setMessage(ShortMessage.NOTE_OFF, 1, 110, 100);
            ev = new MidiEvent(mes, 34);
            t.add(ev);
            mes.setMessage(ShortMessage.NOTE_ON, 1, 127, 100);
            ev = new MidiEvent(mes, 35);
            t.add(ev);
            mes = new ShortMessage();
            mes.setMessage(ShortMessage.NOTE_OFF, 1, 127, 100);
            ev = new MidiEvent(mes, 90);
            t.add(ev);
            seq.setSequence(s);
            seq.start();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.out.println("we handled!!");
        }
        System.out.println("we got an sequncer");
    }

    public void play(int i, int n){
        System.out.println(i+n);
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track t = seq.createTrack();

            ShortMessage mes = new ShortMessage();
            mes.setMessage(ShortMessage.PROGRAM_CHANGE, 1, i, 0);
            MidiEvent eve = new MidiEvent(mes, 1);
            t.add(eve);

            mes = new ShortMessage();
            mes.setMessage(ShortMessage.NOTE_ON, 1, n, 100);
            MidiEvent ev = new MidiEvent(mes, 1);
            t.add(ev);

            mes = new ShortMessage();
            mes.setMessage(ShortMessage.NOTE_OFF, 1, n, 100);
            ev = new MidiEvent(mes, 16);
            t.add(ev);

            player.setSequence(seq);
            player.start();
//            player.stop();

        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        MusicTest1 s = new MusicTest1();
        int inst = Integer.parseInt(args[0]);
        int not = Integer.parseInt(args[1]);
        s.play(inst, not);
    }
}