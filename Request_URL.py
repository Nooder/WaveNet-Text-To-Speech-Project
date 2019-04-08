# Request a url and get parse the text to try to find the article

import requests, bs4

#url = "https://www.theverge.com/2019/4/7/18297500/huawei-cyber-us-china-hacking-espionage"
#url = "https://www.theverge.com/2019/4/6/18298146/netflix-confirms-it-yanked-airplay-support-wont-let-you-beam-shows-to-apple-tvs-anymore"
#url = "https://www.wired.com/story/robocalls-spam-fix-stir-shaken/"
#url = "https://www.wired.com/story/internet-week-215/"

def request_URL(url):
    res = requests.get(url)
    res.raise_for_status()

    html = bs4.BeautifulSoup(res.text, 'lxml')
    resultText = ""

    for paragraph in html.select('p'):
        text = paragraph.text
        if len(text) > 10:
            resultText += text
    return resultText