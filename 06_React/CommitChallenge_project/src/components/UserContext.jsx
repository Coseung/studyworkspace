import React, { useState, createContext, useContext } from 'react';

const AuthContext = createContext();

export const UserProvider = ({children}) => {
  const [currentUser, setCurrentUser] =useState(()=>{
    const user =localStorage.getItem('currentUser');
    return user ? JSON.parse(user) : null;
  });
  const signup = async (userData) =>{
    try{
      const response = await fetch( "http://localhost:8888/member/signup",{
        method : "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(userData)
      })
      if(!response.ok){
        const error = await response.text();
        throw new Error(error || "회원가입 실패")
      }

      const result = await response.json();
      console.log(result);
      return result

    }catch(e){
      console.error("회원가입에러: ", e.massage);
      return null;

    }
  }

  const login = (userId, password) =>{
    const users = JSON.parse(localStorage.getItem('users')|| '[]')
    const user = users.find(data => data.userId === userId && data.password ===password);
    if(user){
      //유저 비밀번호 빼고 저장 하기 로컬스토리지에
      const {password, ...userWitoutPassword} =user;
      setCurrentUser(userWitoutPassword);
      localStorage.setItem('currentUser', JSON.stringify(userWitoutPassword));
      return true;

    }
    return false;
  }
   const logout = () => {
    setCurrentUser(null);
    localStorage.removeItem('currentUser');
  };


   const value = {
    currentUser,
    signup,
    login,
    logout,
  };
  
  return (
    <AuthContext.Provider value={value}>
      {children}
    </AuthContext.Provider>
  )
}

export const useAuth = () => {
  const context = useContext(AuthContext);
  return context;
};
