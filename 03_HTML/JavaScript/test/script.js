
//====== 전역 변수 ========
let bills = JSON.parse(localStorage.getItem('bills')) || [];
let filterState = 'all';
let typeState ='';


// ====== DOM 요소 ========
const billList = document.getElementById('bill-list'); 
// const clearCompletedBtn = document.getElementById('clear-completed-btn'); //
const billInput = document.getElementById('bill-input'); // 내용입력 칸 
const filterBtns = document.querySelectorAll('.filter-buttons button'); //전치, 수입, 지출
const inputBtns = document.querySelectorAll('.input-buttons button');//수입 지출 버튼(입력시에)
const billInputamount = document.getElementById('bill-input-amount'); // 금액 입력칸
const incomeshtml =document.getElementById('greencol');// 수입
const expendshtml =document.getElementById('redcol'); // 지출
const balancesId =document.querySelectorAll('.bal'); // 잔액

// ===== 초기화 함수 ========
function init() {
    bindEvents();
    render();
    
}

function bindEvents() {
    const addBtn = document.getElementById('bill-add-btn');
    
    addBtn.addEventListener('click', function() {
            addbill();
    });
    

    billInput.addEventListener('keydown', function(e){
        if(e.key === 'Enter'){
            addbill();
            
        }
    })
    billInputamount.addEventListener('keydown', function(e){
        if(e.key === 'Enter'){
            addbill();
            
        }
    })    

    
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

//새로운 내역 추가 함수
function addbill() {
    const text = billInput.value.trim();
    const won = billInputamount.value.trim();
    const type = typeState;
    
    if (!text || !won) return; 

    const bill = {
        id: Date.now(), 
        description: text,
        amount: won,
        type: type,
        date: new Date().toLocaleDateString(), //생성 일 까지만 시간 안나옴
    }

    bills.push(bill); 
    billInput.value = "";
    billInputamount.value ="";
    savebills();
    balance()
    render(); 
}

function deletebill(id){
    
    let newbills = [];
    for(let bill of bills){
        if(bill.id === id)
            continue;

        newbills.push(bill);
    }

    bills = newbills;
    savebills();
    balance()
    render(); 
}




function getFilteredbills(){
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
function savebills(){
    localStorage.setItem('bills', JSON.stringify(bills));
}

//=========== 화면 렌더링을 위한 함수 ====================
//메인 렌더링 함수
function render() {
    billList.innerHTML = ""; 

    const filteredbills = getFilteredbills();
    console.log("filteredbills"+filteredbills)
    if (filteredbills.length === 0) { 
        emptyStateRender();
    } else { 
        filteredbills.forEach(function (bill) {
            billItemRender(bill);
        })
    }
    
    
  
}

function emptyStateRender(){
   const emptyEl = document.createElement('div');
    emptyEl.className = 'empty-state';
    emptyEl.innerHTML = '내역이 없습니다.'
    billList.appendChild(emptyEl);
}

function billItemRender(bill) {
    const billItem = document.createElement('li');
    billItem.className = 'bill-item' 

    billItem.innerHTML = `<div class="bill-checkbox"></div>
                            <div class ="item-name">
                            <p style="font-size:10px; font-weight:200; color:grey">${bill.date}</p>
                            <span>${bill.description}</span>
                            </div>
                            <span class="amount ${bill.type}">${bill.amount}원</span>
                            <button class="delete-btn">삭제</button>
                            <button class="change-btn">수정</button>
                            `;

    //새로 생성된 요소들 중에서 이벤트가 필요한 부분만 가져오기.
    const checkBox = billItem.querySelector('.bill-checkbox'); 
    checkBox.addEventListener('click', function(){
        togglebill(bill.id);
    })

    const deleteBtn = billItem.querySelector('.delete-btn'); 
    deleteBtn.addEventListener('click', function(){
        deletebill(bill.id);
    })
    const inCome = billItem.querySelector('.income');
    const exPend = billItem.querySelector('.expend');
    if(inCome){
        inCome.innerText= "+ " + bill.amount.toLocaleString()+"원"
    }else{
        exPend.innerText ="- " + bill.amount.toLocaleString()+"원"
    }
    
    const changeBtn = billItem.querySelector()
    
    billList.appendChild(billItem);
}


//======== 필터관련 함수 ==============

function setFilter(filter){
    filterState = filter; 


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

//잔액 
function balance(){
    let balances  =0;
    let incomes =0;
    let expends =0;
    
    
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
    
    incomeshtml.innerText = incomes.toLocaleString() + "원"
    expendshtml.innerText = expends.toLocaleString() + "원"
    render();

}

document.addEventListener('DOMContentLoaded', init);