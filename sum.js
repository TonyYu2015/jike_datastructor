let numArr = [];
let sum = 10;

function getIndex(arr, target) {
  let tmpObj = {};
  let resArr = [];
  for(let i = 0, n = arr.length; i < n; i++) {
    let m = target - arr[i];
    if(tmpObj[m] !== undefined) {
      resArr = [tmpObj[m], i];
      break;
    }
    tmpObj[arr[i]] = i;
  }
  return resArr;
}

console.log(getIndex([2,3,4,5,6,7], 11));