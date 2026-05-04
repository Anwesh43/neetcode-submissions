func maxProfit(prices []int) int {
    minTillNow := prices[0]
    maxProfit := 0 
    for i, price := range prices {
        if i == 0 {
            continue 
        }
        if (price < minTillNow) {
            minTillNow = price 
        } else {
            profit := price - minTillNow 
            if profit > maxProfit {
                maxProfit = profit 
            }
        }
    }
    return maxProfit 
}
