const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");
const n = input.shift();

input.sort((a, b) => {
    const [age, name] = a.split(" ");
    const [bAge, bName] = b.split(" ");
    
    if(Number(age) != Number(bAge)) {
        return age - bAge;
    }
    
    return;
});

console.log(input.join("\n"));