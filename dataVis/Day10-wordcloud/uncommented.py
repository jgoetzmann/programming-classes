# Tasks 
# 0. Run installs
# 1.  Get the code working
# 2. Comment the code with what it does
# 3. Try changing the color palette of the wordcloud and/or the background color
# 4. Try scraping another site: can you parse the web to get the text you want?

# imports
from bs4 import BeautifulSoup   
import urllib.request                 
from wordcloud import WordCloud, STOPWORDS
import numpy as np
from PIL import Image
import matplotlib.pyplot as plt

# creates a str that words will be added to
msg = "hi \n" 


# URL page to get words
url = "https://en.wikipedia.org/wiki/List_of_terms_relating_to_algorithms_and_data_structures"

# specifies whaat webpage to get
headers = headers = {'user-agent':'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.3'}

# requests data from web
req = urllib.request.Request(url, headers=headers)
# opens web and gets data and sotres it in "data"
data = urllib.request.urlopen(req).read()

# creates soup object using data and an "html.parser" (which allows the data to
#  be read easily)
soup = BeautifulSoup(data, "html.parser")
# print(soup)
# looks for divs and grabs the words inside of them (since everything else is
#  useless)
main_content = soup.find("div", attrs={"id": "mw-content-text"})
# finds all links and adds it to a list
lists = main_content.find_all("li") 

# creates content string to be added to
content_str = ""

# for each item in list add the text to the content string
for list in lists:
    info = list.text
    content_str += info

# add STOPWORDS that will be ignored by word cloud
STOPWORDS.update(["commonword", "othercommonword"])

# creates a word cloud using the word cloud library
wordcloud = WordCloud(width=2200, height=200, # size 
                        # num words w/ stop waords
                        max_words=400, stopwords=STOPWORDS, 
                        # sets color and total num of colors
                        background_color="blue", random_state=2
                        ).generate(content_str) # generates using content_str
plt.imshow(wordcloud) # shows word cloud img
plt.axis("off") # removes axis?
plt.show() # shows the text blob 
wordcloud.to_file("wordcloud.png") # makes it a picture

# opens image
mask = np.array(Image.open("your\\path\\to\\star.png"))
# creates same word cloud above with the size changed
wordcloud = WordCloud(width=1600, height=1350, mask=mask,
                        max_words=400, stopwords=STOPWORDS,
                        background_color="blue", random_state=42
                        ).generate(content_str)                 
plt.imshow(wordcloud) # shows word cloud
plt.axis("off") # removes axis?
plt.show() # shows the text blob 
