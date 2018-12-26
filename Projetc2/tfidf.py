import math
import operator


class TermFrequencyIDF:

    @staticmethod
    def write_to_file(tfidf, articles, total_term_number, article_number):

        print("a")
        for word in article_number:
            tfidf[word] = total_term_number[word] * math.log(len(articles) / article_number[word])

        sorted_tfidf_list = sorted(tfidf.items(), key=operator.itemgetter(1), reverse=True)

        with open("tfidf_list.csv",'wb') as file:
            for i in range(53):
                file.write(sorted_tfidf_list[i][0] + ',' + str(sorted_tfidf_list[i][1]))
                file.write('\n')

       