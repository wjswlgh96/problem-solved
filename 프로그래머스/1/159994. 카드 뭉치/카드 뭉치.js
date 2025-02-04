function solution(cards1, cards2, goal) {
    let result = "Yes";
    let i = 0;
    
    while(goal.length) {
        const curr = goal[0];
        const head = [cards1[0], cards2[0]];
        
        if(head.includes(curr)) {
            const target = goal.shift();
            
            if(cards1.includes(target)) {
                cards1.shift();               
            } else {
                cards2.shift();
            }
        } else {
            return "No";
        }
        
    }
    
    return result;
}