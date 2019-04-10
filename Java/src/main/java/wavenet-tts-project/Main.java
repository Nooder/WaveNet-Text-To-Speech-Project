package wavenet_tts_project;

public class Main {
    public static void main(String[] args) {
        /*
        TTS_Client tts_client = new TTS_Client();
        try {
            tts_client.Create_Client();
        }
        catch (Exception e) {
            System.out.println("An error occured: " + e.toString());
        }
        */
        String url = "https://www.theverge.com/2019/4/9/18301702/qualcomm-snapdragon-730-665-chips-announced-specs";
        Get_Request request = new Get_Request();
        request.get_request(url);
    }
}