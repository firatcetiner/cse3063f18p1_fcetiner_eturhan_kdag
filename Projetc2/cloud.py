from wordcloud import WordCloud
    @staticmethod
    def build_cloud(text, flag):
        wc = WordCloud(background_color="white", max_words=50, max_font_size=50, width=480,
                       height=270).generate_from_frequencies(text)
        image = wc.to_image()
        if flag == 1:
            image.save("tf_WordCloud.pdf")
        else:
            image.save("tfidf_WordCloud.pdf")
