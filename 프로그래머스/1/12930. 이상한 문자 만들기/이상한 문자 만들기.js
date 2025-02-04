function solution(s) {
    let temp = s.split(" ");
    let answer = [];
    
    for(let i = 0; i < temp.length; i++) {
        let str = '';
        
        for(let j = 0; j < temp[i].length; j++) {
            if(j % 2 == 0) {
                str += temp[i][j].toUpperCase();
            } else {
                str += temp[i][j].toLowerCase();
            }
        }
        
        answer.push(str);
    }
    
    return answer.join(" ");
}