#Fırat Çetiner - 150115047
#Erhan Turhan - 150111019
#Kübra Dağ - 150112066

import re


class WordCounter:

    @staticmethod
    def counter(articles, total_term_number, word_flag, article_number):
        stopwords = open("stop_words", "r").read().split()
        for article in articles:

            splitted_text = re.findall(r"[\w']+", article)

            clean_text = []

            for word in splitted_text:

                if not word.isdigit() and not len(word) < 2:
                    word = word.lower()
                    if word not in stopwords:
                        clean_text.append(word)

            for word in clean_text:

                if word in total_term_number:
                    total_term_number[word] += 1
                    if word_flag[word] == 1:
                        if word in article_number:
                            article_number[word] += 1
                        else:
                            article_number[word] = 1
                            word_flag[word] = 0

                else:
                    total_term_number[word] = 1
                    article_number[word] = 1
                    word_flag[word] = 0

            for word in word_flag:
                word_flag[word] = 1
        print(len(article_number))