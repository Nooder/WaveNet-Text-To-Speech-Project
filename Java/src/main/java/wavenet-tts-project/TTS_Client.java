package wavenet_tts_project;

// Imports the Google Cloud client library
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.protobuf.ByteString;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TTS_Client {
    private void TTS_Client() {
        
    }

    public void Create_Client() throws Exception {
        // Credentials in $GOOGLE_APPLICATION_CREDENTIALS environment variable
        // Instantiates a client
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            // Set the text input to be synthesized
            SynthesisInput input = SynthesisInput.newBuilder()
            .setText("This is a test in java.")
            .build();

            // Build the voice request and set the language codes
            VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
            .setLanguageCode("en-US")
            .setName("en-US-Wavenet-C")
            .build();

            // Select the type of audio file you want returned
            AudioConfig audioConfig = AudioConfig.newBuilder()
            .setAudioEncoding(AudioEncoding.MP3)
            .build();

            // Perform the TTS request on the text input with
            // the selected voice parameters
            SynthesizeSpeechResponse response = textToSpeechClient
            .synthesizeSpeech(input, voice, audioConfig);

            // Get the audio contents from the response
            ByteString audioContents = response.getAudioContent();

            // Write the response to the output file
            try (OutputStream out = new FileOutputStream("output.mp3")) {
                out.write(audioContents.toByteArray());
                System.out.println("Audio content written to file: output.mp3");
            }
        }


    }    
}