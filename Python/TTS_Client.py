# Test implementation of Google's WaveNet TTS API

from google.cloud import texttospeech
import os

def getSpeech(message):
    # Import Google Service Credentials
    os.environ['GOOGLE_APPLICATION_CREDENTIALS'] = 'Text to Speech Project-02d00975225a.json'

    # Instantiates a client
    client = texttospeech.TextToSpeechClient()

    # Set the input to be synthesized
    synthesis_input = texttospeech.types.SynthesisInput(text=message)

    # Build the voice request, select the language code ("en-US") and the
    # ssml voice generator ("neutral")
    voice = texttospeech.types.VoiceSelectionParams(
        language_code='en-US',
        name='en-US-Wavenet-C'
    )

    # Select the type of audio file we want returned
    audio_config = texttospeech.types.AudioConfig(
        audio_encoding=texttospeech.enums.AudioEncoding.MP3
    )

    # Perform the text to speech request on the text input with the selected
    # voice parameters and audio file type
    response = client.synthesize_speech(synthesis_input, voice, audio_config)

    # The response's audio_content is binary
    with open('output.mp3', 'wb') as out:
        # Write the response to the output file
        out.write(response.audio_content)
        print("Audio content written to: output.mp3")