import { useState } from 'react'
import './App.css'
import { Link } from 'react-router-dom'
import UserList from './page/UserList'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import UserDetail from './page/UserDetail'
import UserRegistration from './page/UserRegistration'
import NotFound from './page/NotFound'
import { UserProvider } from './components/UserContext'
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <BrowserRouter>
    <UserProvider> 
      <nav>
        <Link to="/" style={{ marginRight: "10px" }}>
          회원 목록
        </Link>

        <Link to="/user/0" style={{ marginRight: "10px" }}>
          회원 상세
        </Link>

        <Link to="/user">
          회원 등록
        </Link>
      </nav>
      <Routes>
        <Route path='/' element={<UserList />}/>
        <Route path='/user/:id' element={<UserDetail />}/>
        <Route path='/user' element={<UserRegistration />}/>
        <Route path='*' element={<NotFound />}/>
      </Routes>

      </UserProvider>
    </BrowserRouter>

    </>
  )
}

export default App
