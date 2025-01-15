let num = Number(require("fs").readFileSync("/dev/stdin").toString().trim());
let i = 2;

const result = [];

while(num != 1) {
    if(num % i == 0) {
        result.push(i);
        num = num / i;
        continue;
    }
    
    i++;
}

console.log(result.join("\n"));