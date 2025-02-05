function solution(players, callings) {
    let result = players;
    let obj = {};
    players.forEach((e, i) => {
        obj[e] = i;
    });
    
    callings.forEach(e => {
        const idx = obj[e];
        const target = idx - 1;
        
        obj[e]--;
        obj[result[target]]++;
        
        const temp = result[idx];
        result[idx] = result[target];
        result[target] = temp;
    }) 
    
    return result;
}