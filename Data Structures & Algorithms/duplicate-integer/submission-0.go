func hasDuplicate(nums []int) bool {
    numMap := make(map[int]bool)
    for _, num := range nums {
        _, exists := numMap[num]
        if exists {
            return true 
        }
        numMap[num] = true
    }
    return false
}
