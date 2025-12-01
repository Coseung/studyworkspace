import React from 'react'
import { useUser } from '../components/UserContext'
const UserList = () => {
  const {users} = useUser(); 

  return (
    <div>
      <h1>유저 목록</h1>
      {users.map((user, index) => (
        <div key={index}>
          <h2>유저 정보</h2>
          <p>이름: {user.name}</p>
          <p>나이: {user.age}</p>
          <p>상태: {user.isOnline}</p>
        </div>
      ))}

      
    </div>
  )
}

export default UserList