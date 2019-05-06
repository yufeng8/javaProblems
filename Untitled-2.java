// For each abbreviation A of word[startIndex:] (i.e. the substring of word starting at startIndex), 
// add sb + A to results
//
// For example, abbrev("word", 2, "11", results) will append
//  "11rd"
//  "11r1"
//  "111d"
//  "112"
void abbrev(String word, int startIndex, StringBuilder sb, List<String> results) {
    if (startIndex >= word.length()) {
        results.add(sb.toString());
        return;
    }

    sb.append(word.charAt(startIndex));
    abbrev(word, startIndex+1, sb, results);
    sb.deleteCharAt(sb.length()-1);

    for (int i=1; startIndex+i<=word.length(); i++) {
        sb.append(i);
        abbrev(word, startIndex+i, sb, results);
        sb.deleteCharAt(sb.length()-1);
    }
}


