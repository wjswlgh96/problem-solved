function solution(arr1, arr2) {
    let result = Array.from({length: arr1.length}, () => []);
    
    for(let i = 0; i < arr1.length; i++) {
        for(let j = 0; j < arr2[0].length; j++) {
            let sum = 0;
            
            for(let k = 0; k < arr2.length; k++) {
                sum += arr1[i][k] * arr2[k][j];    
            }

            result[i].push(sum);
        }
    }
    
    return result;
}