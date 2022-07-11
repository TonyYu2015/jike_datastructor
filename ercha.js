// 生成一个二叉树
function genEr(n) {
  if(isNaN(n) || n < 1) return;
  let count = Math.pow(2, n-1);
  let m = 0;
  let dotArr = [], anDotArr = [];

  while(count > 1) {
    let tmpDotArr = Array.prototype.slice.call(dotArr, 0);
    dotArr = [];
    for(let i = 0; i < count; i++) {
      dotArr[i] = {};
      m ++;
      dotArr[i].val = m;
      dotArr[i].left = tmpDotArr[0] || null;
      dotArr[i].right = tmpDotArr[1] || null;
      console.log("=======>>>>", dotArr[i]);
      if(tmpDotArr.length > 0) {
        tmpDotArr.splice(0, 2);
      }
    }
    count /= 2;
  }

  return {val: ++m, left: dotArr[0], right: dotArr[1]};
}

let d = genEr(3);
console.log("+++++++++++++++", d);

function produer(root) {
  if(!root) return;
  produer(root.left);
  produer(root.right);
  console.log("------->>>>>", root.val);
}

produer(d);