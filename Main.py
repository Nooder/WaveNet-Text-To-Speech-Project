# Main

import Request_URL, TTS_Client

url = "https://www.businessinsider.com/toyota-rav4-2019-suv-coolest-features-2019-4"

text = Request_URL.request_URL(url)
TTS_Client.getSpeech(text)