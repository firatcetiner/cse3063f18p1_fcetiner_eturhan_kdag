class TermFrequencyList:

    @staticmethod
    def write_tp_file(tf_list_sorted):
        with open("tf_list.csv", "wb") as file:
            for i in range(53):
                file.write(tf_list_sorted[i][0] + ',' + str(tf_list_sorted[i][1]))
                file.write('\n')