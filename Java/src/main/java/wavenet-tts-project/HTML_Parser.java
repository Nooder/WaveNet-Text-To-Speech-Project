package wavenet_tts_project;

import java.util.ArrayList;
// JSoup imports
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTML_Parser {
    public Document returnedHtml;
    public ArrayList<String> listParagraphs;
    public String stringParagraphs;

    public  HTML_Parser() {
        listParagraphs = new ArrayList<String>();
    }

    public void parse_html(String html) {
        try {
            Elements paragraphs = returnedHtml.getElementsByTag("p");
            for (Element paragraph : paragraphs) {
                listParagraphs.add(paragraph.text());
            }
            stringParagraphs = String.join("\n\n", listParagraphs);
        } catch (Exception e) {
            System.out.println("Could not parse html: " + e.toString());
        }
    }

    public void get_url(String url) {
        try {
            this.returnedHtml = Jsoup.connect(url)
            .timeout(0).get();
        } catch (Exception e) {
            System.out.println("Could not get url: " + e.toString());
        }
    }
}