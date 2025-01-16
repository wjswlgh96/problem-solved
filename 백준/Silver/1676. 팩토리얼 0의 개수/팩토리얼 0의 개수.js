const n = Number(require('fs').readFileSync('dev/stdin').toString().trim());

let sum = 1;
for(let i = 1; i <= n; i++) {
    sum = BigInt(sum) * BigInt(i);
}

sum = sum.toString();

let result = 0;
for(let i = sum.length - 1; i >= 0; i--) {
    if(sum[i] == "0") {
        result++;
    } else {
        break;
    }
}

console.log(result);