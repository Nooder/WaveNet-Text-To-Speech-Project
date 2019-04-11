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
        // request.get_request(url);
        HTML_Parser html_parser = new HTML_Parser();
        html_parser.get_url(url);
        html_parser.parse_html(html_parser.returnedHtml.text());
        String paragraphs = html_parser.stringParagraphs;
        System.out.println(paragraphs);
    }
}