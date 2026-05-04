
func checkInclusion(s1 string, s2 string) bool {
    defer func() {
        if r := recover(); r != nil {
            fmt.Println("Error", r)
        }
    }()
    s1Arr := []rune(s1)
    s2Arr := []rune(s2)
    s1Map := make(map[rune]int) 
    total := 0
    for _, ch := range s1Arr {
        if _, exists := s1Map[ch]; !exists {
            s1Map[ch] = 0
            total++
        }
        s1Map[ch]++
    }
    s2Map := make(map[rune]int)
    
    for i := 0; i < len(s1Arr); i++ {
        ch2 := s2Arr[i]
        if _, exists := s2Map[ch2]; !exists {
            s2Map[ch2] = 0
        }
        s2Map[ch2]++
        noteq := true 
        for key, value := range s1Map {
            if _, exists := s2Map[key]; !(exists && value == s2Map[key]) {
                noteq = false 
                break 
            }
        }
        if noteq {
            return true 
        }
    }
    //fmt.Println("TOTAL", total, "CURR", curr)
    start := 0 
    for i := len(s1Arr); i < len(s2Arr); i++ {
        chStart := s2Arr[start]
        if s2Map[chStart] > 0 {
            s2Map[chStart]--
        }


        ch2 := s2Arr[i]
        if _, exists := s2Map[ch2]; !exists {
            s2Map[ch2] = 0
        }
        s2Map[ch2]++
        noteq := true 
        for key, value := range s1Map {
            if _, exists := s2Map[key]; !(exists && value == s2Map[key]) {
                noteq = false 
                break 
            }
        }
        if noteq {
            return true 
        }
        start++
    } 
    return false
}

