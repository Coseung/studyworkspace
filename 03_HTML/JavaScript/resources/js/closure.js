/*
    클로저란?
    클로저는 함수와, 그함수가 선언된 시점의 렉시컬 환경의 조합
    즉, 내부함수의 선언 시점에 외부함수의 변수를 함께 저장해서 사용하는 것을 클로저라고함
    콜백/ 이벤트 핸들러/ 모듈패턴에서 핵심적인 역할을 함
*/
function getCounter(){
    

    let count =0;

    function increase(){
        count ++;
        return count;

    }
    return increase; // 내부함수를 반환 -> 외부에서도 count접근 가능 
}

const run = getCounter()
console.log(run())
console.log(run())