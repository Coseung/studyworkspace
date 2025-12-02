import { useEffect, useState } from 'react'
import './App.css'
import { GithubProvider } from './components/GithubContext.jsx'
import PushResult from './pages/PushResult.jsx'

function App() {
  

  return (
    <GithubProvider>
      <PushResult></PushResult>
    </GithubProvider>
  )
}

export default App