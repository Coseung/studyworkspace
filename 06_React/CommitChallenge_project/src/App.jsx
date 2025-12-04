import { useEffect, useState } from 'react'
import './App.css'
import { GithubProvider } from './components/GithubContext.jsx'
import { UserProvider } from './components/UserContext.jsx'
import  AppRoutes  from './routes/routes.jsx'
import { MemoProvider } from './components/MemoContext.jsx'
function App() {
  
  return (
    <MemoProvider>
      <UserProvider>
        <GithubProvider>
          <AppRoutes />
        </GithubProvider>
      </UserProvider>
    </MemoProvider>
  )
}

export default App