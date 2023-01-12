# Tasks 
# 0. Run installs
# 1.  Get the code working
# 2. Comment the code with what it does
# 3. Try changing the color palette of the wordcloud and/or the background color
# 4. Try scraping another site: can you parse the web to get the text you want?

# For installs
# Run this command, as you normally do:
#   pip install beautifulsoup4
# do a manual install of wordcloud:
#   - Download the .whl file from onenote 
#   - open that directory in  command prompt (or vscode terminal)
#   python -m pip install <filename>

# imports
from bs4 import BeautifulSoup   
import urllib.request                 
from wordcloud import WordCloud, STOPWORDS
import numpy as np
from PIL import Image
import matplotlib.pyplot as plt


msg = "hi \n" 



url = "https://en.wikipedia.org/wiki/List_of_terms_relating_to_algorithms_and_data_structures"

headers = headers = {'user-agent':'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.3'}

req = urllib.request.Request(url, headers=headers)
data = urllib.request.urlopen(req).read()

soup = BeautifulSoup(data, "html.parser")
main_content = soup.find("div", attrs={"id": "mw-content-text"})
lists = main_content.find_all("li") 

content_str = ""
for list in lists:
    info = list.text
    content_str += info

STOPWORDS.update(["commonword", "othercommonword"])

wordcloud = WordCloud(width=2200, height=200, 
                        max_words=400, stopwords=STOPWORDS,
                        background_color="white", random_state=42
                        ).generate(content_str)    
plt.imshow(wordcloud)
plt.axis("off")
plt.show()
wordcloud.to_file("wordcloud.png")


mask = np.array(Image.open("your\\path\\to\\star.png"))
wordcloud = WordCloud(width=1600, height=1350, mask=mask,
                        max_words=400, stopwords=STOPWORDS,
                        background_color="white", random_state=42
                        ).generate(content_str)                 
plt.imshow(wordcloud)
plt.axis("off")
plt.show()
