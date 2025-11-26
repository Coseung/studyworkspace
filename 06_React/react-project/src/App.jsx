import { useState } from 'react'

import './App.css'

import UseStateTest from './components/UseStateTest'
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <UseStateTest></UseStateTest>
    </>
  )
}

export default App
