import React, { useDebugValue, useState } from 'react'

const UseEffectTest =()  =>{
  const [name, setName] = useState("김홍길동");
  const [num, setNum] = useState(0);

  const handleChangeName = (ev) => setName(ev.target.value);
  const handleChangeNum = (ev) => setNum(prev => prev +1);
  

  return (
    <div>
      <h2>UseEffectTest</h2>
      <p>안녕하세요. <strong>{name}</strong> 입니다</p>
    
      <input type="text" 
      onChange={handleChangeName}
      value={name}
      placeholder='이름 입력'
      />

      <p>버튼을 <strong>{num}</strong>번 클릭하였습니다</p>
      <button onClick={handleChangeNum}> +1 </button>
    </div>
  )
}


export default UseEffectTest