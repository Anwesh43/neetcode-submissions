
type Solution struct{}

const SEP string = "${++}"
func (s *Solution) Encode(strs []string) string {
    return fmt.Sprintf("%d%s%s",len(strs), SEP, strings.Join(strs, SEP))
}

func (s *Solution) Decode(str string) []string {
    l := str[0]
    fmt.Println("L", l)
    if l == '0' {
        return []string{}
    }
    actualStrArray :=  strings.Split(str, SEP)
    result := make([]string, 0)
    for i, r := range actualStrArray {
        if i == 0 {
            continue 
        }
        result = append(result, r)
    }
    return result
}
