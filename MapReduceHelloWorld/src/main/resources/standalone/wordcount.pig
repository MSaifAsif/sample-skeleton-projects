/* 
 * wordcount.pig -- script to sum up the number of words in the input file  
 * Author : Saif Asif
 */

-- Load the input file
input_file = LOAD '/test_data/file';

-- Tokenize the sentences on the basis of words
tokens = FOREACH input_file GENERATE flatten(TOKENIZE((chararray)$0)) AS word;

-- Group similar tokens together
grouped_tokens = GROUP tokens BY word;

-- count the grouped tokens to get actual number of unique tokens that are similar
result = FOREACH grouped_tokens GENERATE COUNT(tokens), GROUP;

-- Store the result
STORE result INTO '/output/result';