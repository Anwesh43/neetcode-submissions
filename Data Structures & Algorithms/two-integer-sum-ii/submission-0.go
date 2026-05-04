func twoSum(numbers []int, target int) []int {
    l := 0
    h := len(numbers) - 1
    for l < h {
        sum := numbers[l] + numbers[h]
        if sum > target {
            h--
        }
        if (sum < target) {
            l++
        }
        if (sum == target) {
            return []int{l + 1, h + 1}
        }
    }
    return []int{-1, -1}
}
