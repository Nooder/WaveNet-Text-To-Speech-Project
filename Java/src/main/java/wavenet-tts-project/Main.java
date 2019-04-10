package wavenet_tts_project;

public class Main {
    public static void main(String[] args) {
        TTS_Client tts_client = new TTS_Client();
        try {
            tts_client.Create_Client();
        }
        catch (Exception e) {
            System.out.println("An error occured: " + e.toString());
        }
    }
}