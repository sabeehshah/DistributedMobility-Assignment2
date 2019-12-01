import time
import re
import sklearn

from collections import Counter
from sklearn.feature_extraction.stop_words import ENGLISH_STOP_WORDS

start_time = time.time()
dataSet = open("C:\\Users\\Victor\\Documents\\Mobile Computing - Sem6\\Distributed Mobility\\Assignment_2_3\\input.txt", "r")

def clean_word(word):
    return re.sub(r'[^\w\s]','',word).lower()
    
def word_not_in_stopwords(word):
    return word not in ENGLISH_STOP_WORDS and word and word.isalpha()

def find_top_words(dataSet):
    cnt = Counter()
    for text in dataSet:
        tokens_in_text = text.split(',')
        tokens_in_text = map(clean_word, tokens_in_text)
        tokens_in_text = filter(word_not_in_stopwords, tokens_in_text)
        cnt.update(tokens_in_text)

    return cnt.most_common(10)

print(find_top_words(dataSet))

print("--- %s seconds ---" % (time.time() - start_time))