import { useEffect, useState } from 'react'
import './App.css'
import { GithubProvider } from './components/GithubContext.jsx'
import { UserProvider } from './components/UserContext.jsx'
import  AppRoutes  from './routes/routes.jsx'
function App() {
  
  return (
    <UserProvider>
      <GithubProvider>
        <AppRoutes />
      </GithubProvider>
    </UserProvider>
  )
}

export default App