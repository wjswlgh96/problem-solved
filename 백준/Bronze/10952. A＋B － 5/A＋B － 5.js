const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

for(let i = 0; i < input.length; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    if(a + b == 0) break;
    
    console.log(a + b);
}