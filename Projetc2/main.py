import re
# todo: import textract and use 
import textract
from urllib import request
import wordcloud
import operator
from tf import TermFrequencyList as tflist
from tfidf import TermFrequencyIDF as tfidflist
from wordcounter import WordCounter as counter

# extracting_text.py
def text_extractor(path):
    with open(path, 'rb') as f:
        pdf = PdfFileReader(f)
        # get the first page
        page = pdf.getPage(1)
        print(page)
        print('Page type: {}'.format(str(type(page))))
        text = page.extractText()
        print(text)

def main():

    html = request.urlopen("http://mimoza.marmara.edu.tr/~cigdem.erdem/research.html")
    html_doc = html.read()

    match = re.findall(b'\"(.*?\.pdf)\"', html_doc)

    articles = []
    article_names = []

    for i in range(len(match)):  # len(match)

        article_names.append(match[i].decode('utf-8').rsplit('/', 1)[1])
        url = "http://mimoza.marmara.edu.tr/~cigdem.erdem/" + match[i].decode('utf-8')
        request.urlretrieve(url, article_names[i])
        articles.append(textract.process(article_names[i])) 

    stopwords = open("stop_words.txt", "r").read().split()

    totalTermNumber = {}
    articleNumber = {}
    wordFlag = {}

    counter.counter(articles, totalTermNumber, wordFlag, articleNumber)
    tf = {}
    sorted_tf_list = sorted(totalTermNumber.items(), key=operator.itemgetter(1), reverse=True)
    
    tflist.write_to_file(sorted_tf_list)
    
    def build_cloud(text, flag):
        wc = WordCloud(background_color="white", max_words=50, max_font_size=50, width=480,
                    height=270).generate_from_frequencies(text)
        image = wc.to_image()
        if flag == 1:
            image.save("tf_WordCloud.pdf")
        else:
            image.save("tfidf_WordCloud.pdf")
    

    tfidf = {}

    tfidflist.write_to_file(tfidf, articles, totalTermNumber, articleNumber)
    
    #print(len(articleNumber))    

if __name__ == '__main__':
    main()
