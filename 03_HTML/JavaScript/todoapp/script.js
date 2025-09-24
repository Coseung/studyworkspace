let todos =[]

function init(){
     bindEvents();
     render();
}

const todoInput = document.getElementById('todo-input');
const todoList= document.querySelector('.todo-list')
function bindEvents(){
  // 버튼 or 엔터 을 누르면 addTodo 함수로 
  const addBtn = document.getElementById('todo-add-btn');
  addBtn.addEventListener('click', addTodo);

  todoInput.addEventListener('keydown', function(e){
    if(e.key =='Enter'){
      addTodo();
    }
  })

}

function addTodo(){
  // 투두리스트에 항목 추가 
  const text = todoInput.value.trim();
  if(!text) return;

  const todo ={
    id: Date.now(),
    content: text,
    completed : false,
    createdAt: new Date().toLocaleString(),
  }

  todos.push(todo);
  todoInput.value =""

  render()

}

function render(){
  todoList.innerHTML="";
  
  
  if(todos.length === 0){
    emptyStateRender();
  }else{
    todos.forEach(function(todo){
      todoItemRender(todo);
      console.log(todo);
    })
    
  }


}

function emptyStateRender(){
  const emptyEl = document.createElement('div');
  emptyEl.className='todo-list';
  emptyEl.style = 'margin-left:20px; padding: 30px 0'
  emptyEl.innerHTML ='할일이 없습니다.';
  todoList.appendChild(emptyEl)
}

function todoItemRender(todo){
  const todoEl = document.createElement('li');
  todoEl.className ='todo-item';
  todoEl.innerHTML= `
                <input type="checkbox" name="checkbox-test" class="todo-checkbox"${todo.completed ? 'checked': ''}> 
                <span class="${todo.completed ? 'chck' : '' }"> ${todo.content} </span>
                <button class="delete-btn" > 삭제 </button>
                `

  const chckbtn = todoEl.querySelector('.todo-checkbox');
  chckbtn.addEventListener('change',function(e){
    chck(todo.id, e.target.checked);
    console.log(e.target.checked)
  })
  
  const delBtn =todoEl.querySelector('.delete-btn');
  delBtn.addEventListener('click', function(){
    deleteTodo(todo.id)
  })
  todoList.appendChild(todoEl);
}

function deleteTodo(todoId){
  let newTodo =[]
  for(let todo of todos){
    if(todo.id == todoId){
      continue;
    }
    else{
      newTodo.push(todo);
    }
  }
  todos = newTodo;
  render()
}

function chck(todoId, checked){
  for(let todo of todos){
    if(todo.id == todoId){
      todo.completed = checked
    }
  }
    render()

}


document.addEventListener('DOMContentLoaded',init)