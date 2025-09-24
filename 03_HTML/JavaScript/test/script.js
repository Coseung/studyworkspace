
//====== 전역 변수 ========
let bills = JSON.parse(localStorage.getItem('bills')) || [];
let filterState = 'all';
let typeState ='';


// ====== DOM 요소 ========
const todoList = document.getElementById('todo-list'); //내역목록 ul
const clearCompletedBtn = document.getElementById('clear-completed-btn'); //완료목록삭제버튼
const todoInput = document.getElementById('todo-input'); //todo입력창
const filterBtns = document.querySelectorAll('.filter-buttons button'); //필터 버튼 목록
const inputBtns = document.querySelectorAll('.input-buttons button')
const todoInput2 = document.getElementById('todo-input2')
// ===== 초기화 함수 ========
//웹이 시작될 때 실행되는 기본함수
//이벤트 등록과 화면 렌더링을 담당
function init() {
    bindEvents();
    render();
    
}

function bindEvents() {
    const addBtn = document.getElementById('todo-add-btn');
    
    addBtn.addEventListener('click', function() {
            addTodo();
        
    });
    

    todoInput.addEventListener('keydown', function(e){
        if(e.key === 'Enter'){
            addTodo();
            
        }
    })
    todoInput2.addEventListener('keydown', function(e){
        if(e.key === 'Enter'){
            addTodo();
            
        }
    })
    todoInput2.addEventListener('change',function(e){
        
    })


    //필터 버튼들을 가져와서 이벤트를 등록
    filterBtns.forEach(function(btn){
        btn.addEventListener('click', function(ev){
            setFilter(ev.target.dataset.filter);
            console.log('필터클릭 : '+ev.target.dataset.filter)
        })
    })

    inputBtns.forEach(function(btn){
        btn.addEventListener('click', function(e){
            inputtype(e.target.dataset.filter);
        })
    })
    balance()
}

//새로운 내역 추가하는 함수
function addTodo() {
    const text = todoInput.value.trim();
    const won = todoInput2.value.trim();
    const type = typeState;
    
    if (!text || !won) return; 

    const bill = {
        id: Date.now(), 
        description: text,
        amount: won,
        type: type,
        date: new Date().toLocaleDateString(), //생성시간
    }

    bills.push(bill); //새로운 내역을 목록에 추가
    todoInput.value = "";
    todoInput2.value ="";
    saveTodos();
    balance()
    render(); //내역목록을 기준으로 UI에 적용
}

function deleteTodo(id){
    //해당 ID를 목록에서 제거.
    let newbills = [];
    for(let bill of bills){
        if(bill.id === id)
            continue;

        newbills.push(bill);
    }

    bills = newbills;
    saveTodos();
    balance()
    render(); //내역목록을 기준으로 UI에 적용
}




function getFilteredTodos(){
    const filteredbills = [];
    if(filterState === 'incomes'){
        
        for(let bill of bills){
            if(bill.type =='income'){
                filteredbills.push(bill);
            }
        }
    } else if(filterState === 'expends'){
        
        for(let bill of bills){
            if(bill.type =='expend'){
                filteredbills.push(bill);
            }
        }
    } else{
        return bills;
    }

    return filteredbills;
}

//내역목록을 로컬스토리지영역에 저장하는 함수
function saveTodos(){
    localStorage.setItem('bills', JSON.stringify(bills));
}

//=========== 화면 렌더링을 위한 함수 ====================
//메인 렌더링 함수
function render() {
    todoList.innerHTML = ""; //기존 UI 제거

    //현재 필터에 맞는 내역만 목록으로 가져오기
    const filteredTodos = getFilteredTodos();
    console.log("filteredTodos"+filteredTodos)
    if (filteredTodos.length === 0) { //내역목록이 비어있다면
        emptyStateRender();
    } else { //내역 목록이 있는 경우
        filteredTodos.forEach(function (bill) {
            todoItemRender(bill);
        })
    }
    
    
    // updateClearButton();
}

function emptyStateRender(){
   const emptyEl = document.createElement('div');
    emptyEl.className = 'empty-state';
    emptyEl.innerHTML = '내역이 없습니다.'
    todoList.appendChild(emptyEl);
}

function todoItemRender(bill) {
    const todoItem = document.createElement('li');
    todoItem.className = 'todo-item' //+ (bill.completed ? ' completed' : '');

    todoItem.innerHTML = `<div class="todo-checkbox "></div>
                            <div class ="item-name">
                            <p style="font-size:10px; font-weight:200; color:grey">${bill.date}</p>
                            <span>${bill.description}</span>
                            </div>
                            <span class="amount ${bill.type}">${bill.amount}원</span>
                            <button class="delete-btn">삭제</button>`;

    //새로 생성된 요소들 중에서 이벤트가 필요한 부분만 가져오기.
    const checkBox = todoItem.querySelector('.todo-checkbox'); //todoItem내부에 있는 checkbox요소
    checkBox.addEventListener('click', function(){
        toggleTodo(bill.id);
    })

    const deleteBtn = todoItem.querySelector('.delete-btn'); //todoItem내부에 있는 deleteBtn요소
    deleteBtn.addEventListener('click', function(){
        deleteTodo(bill.id);
    })
    const inCome = todoItem.querySelector('.income');
    const exPend = todoItem.querySelector('.expend');
    if(inCome){
        inCome.innerText= "+ " + bill.amount.toLocaleString()+"원"
    }else{
        exPend.innerText ="- " + bill.amount.toLocaleString()+"원"
    }
    
    
    todoList.appendChild(todoItem);
}


//======== 필터관련 함수 ==============
//필터를 설정하고 UI를 업데이트
function setFilter(filter){
    filterState = filter; //전역상태에 필터상태를 변경

    //모든 필터버튼의 active클래스를 조회해서 수정
    filterBtns.forEach(function(btn){
        btn.className = (btn.dataset.filter === filter ? "active" : "");
    });

    render();
}

function inputtype(type){
    typeState = type;

    inputBtns.forEach(function(btn){
        btn.className =btn.dataset.filter +(btn.dataset.filter === type? " actived" : "");
    })
    render();
}

function balance(){
    let balances  =0;
    let incomes =0;
    let expends =0;
    const balancesId =document.querySelectorAll('#balance');
    
    bills.forEach(function(bill){
        const amount = Number(bill.amount); 
        if(bill.type=='income'){
            console.log(bill.amount,bill.type);
            balances += amount;
            incomes +=amount;
        }else if(bill.type =='expend'){
            balances -= amount;
            expends +=amount;
        }
    })
    console.log(balances);
    balancesId.forEach(function(bal){
        bal.innerText = balances.toLocaleString()+"원";
    })
    const incomeshtml =document.getElementById('greencol')
    const expendshtml =document.getElementById('redcol')
    incomeshtml.innerText = incomes.toLocaleString() + "원"
    expendshtml.innerText = expends.toLocaleString() + "원"
    render();

}

document.addEventListener('DOMContentLoaded', init);