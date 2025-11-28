// UserDetail.jsx
import React from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import { useUser } from '../components/UserContext'

const UserDetail = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { users } = useUser();

  const userId = parseInt(id);
  const user = users[userId];

  return (
    <div>
      <h1>유저 상세 정보</h1>
      <div>
        <h2>유저 #{id}</h2>
        <p><strong>이름:</strong> {user.name}</p>
        <p><strong>나이:</strong> {user.age}</p>
        <p><strong>상태:</strong> {user.isOnline}</p>
      </div>
      
      <button onClick={() => navigate('/')}>
        ← 목록으로 돌아가기
      </button>
    </div>
  )
}

export default UserDetail