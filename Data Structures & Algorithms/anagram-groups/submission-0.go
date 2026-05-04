func groupAnagrams(strs []string) [][]string {
    anagramMap := make(map[string][]string)

    for _, str := range strs {
        inpr := []rune(str)
        sort.Slice(inpr, func(i1, i2 int) bool { return inpr[i1] < inpr[i2]})
        key := string(inpr)
        if _, exists := anagramMap[key]; !exists {
            anagramMap[key] = make([]string, 0)
        }
        anagramMap[key] = append(anagramMap[key],  str)
    }
    result := make([][]string, 0)
    for _, strArr := range anagramMap {
        result = append(result, strArr)
    }
    return result
}
