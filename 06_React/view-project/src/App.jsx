import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProfileCard from './component/ProfileCard'


function App() {
  const [count, setCount] = useState(0)

  const profilelist = [
    {name : '박명수', age: 54, isOnline: true },
    {name : '홍길동', age: 34, isOnline: true },
    {name : '아이유', age: 34, isOnline: false },
    {name : '김숙', age: 64, isOnline: true },
    {name : '연예인', age: 35, isOnline: false }
  ]

  return (
    <>
      {profilelist.map((props, index) => (
        <ProfileCard key ={index} name={props.name} age={props.age} isOnline={props.isOnline}/>
      ))}
      
    </>
  )
}

export default App
