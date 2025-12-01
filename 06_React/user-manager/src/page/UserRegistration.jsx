import React, { useState } from 'react'
import useInput from '../components/useInput'
import { useUser } from '../components/UserContext'
import { useNavigate } from "react-router-dom";
const UserRegist = () => {
  const navigate = useNavigate();

  const name = useInput('')
  const age = useInput(20)
  const isOnline = useInput(false)

  const {addUser} = useUser();
  const handleSubmit = (e) => {
        e.preventDefault();
        alert(`이름 : ${name.value}, 나이 : ${age.value}, 온라인 여부:${isOnline.value}`);

        const newUser = {
          name : name.value,
          age : age.value,
          isOnline : isOnline.value ? '🟢 온라인 상태입니다.' :  '🔴 오프라인 상태입니다.'
        }

        addUser(newUser);
        navigate("/");
    }
    // const handleChangeName = (ev) =>{setName(ev.target.value)}

    

  return (
    <>
    <div>유저 등록 페이지입니다.</div>
    <form onSubmit={handleSubmit}>
      이름 :<input type="text" {...name}/>
      <br />
      나이 : <input type="number" {...age}/>
      <br />
      온라인 여부 : 
      <select name="" id="" {...isOnline}>
        <option value="true">온라인</option>
        <option value="false">오프라인</option>
        </select>

        <button type='submit'>제출</button>
    </form>
    </>
  )
}

export default UserRegist